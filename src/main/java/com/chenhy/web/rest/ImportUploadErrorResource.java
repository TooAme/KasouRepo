package com.chenhy.web.rest;

import com.chenhy.domain.ImportHistory;
import com.chenhy.domain.ImportHistoryDetail;
import com.chenhy.repository.ImportSettingRepository;
import com.chenhy.repository.ImportTableRepository;
import com.chenhy.service.ImportHistoryDetailService;
import com.chenhy.service.ImportHistoryService;
import io.micrometer.common.util.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.Instant;
import java.util.*;
import jakarta.persistence.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;

/**
 * REST controller for managing file imports.
 */
@RestController
@RequestMapping("/api")
public class ImportUploadErrorResource {

    private final Logger log = LoggerFactory.getLogger(ImportUploadErrorResource.class);

    private final ImportHistoryService importHistoryService;
    private final ImportHistoryDetailService importHistoryDetailService;
    private final ImportProcessResource importProcessResource;
    private final ImportTableRepository importTableRepository;
    private final ImportSettingRepository importSettingRepository;


    private final ApplicationContext applicationContext;
    private final String uploadDirectory = "file";
    private final Map<String, String> processedFileHashes = new HashMap<>();

    @Autowired
    public ImportUploadErrorResource(
        ImportHistoryService importHistoryService,
        ImportHistoryDetailService importHistoryDetailService,
        ImportProcessResource importProcessResource,
        ImportTableRepository importTableRepository,
        ImportSettingRepository importSettingRepository, ApplicationContext applicationContext) {
        this.importHistoryService = importHistoryService;
        this.importHistoryDetailService = importHistoryDetailService;
        this.importProcessResource = importProcessResource;
        this.importTableRepository = importTableRepository;
        this.importSettingRepository = importSettingRepository;
        this.applicationContext = applicationContext;

        // 创建上传目录
        File directory = new File(uploadDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    @PostMapping("/import/upload")
    public ResponseEntity<Map<String, Object>> uploadFile(@RequestParam("file") MultipartFile file) {
        log.debug("REST request to upload file : {}", file.getOriginalFilename());

        Map<String, Object> response = new HashMap<>();

        if (file.isEmpty()) {
            response.put("success", false);
            response.put("message", "アップロードするファイルを一つ選びます");
            return ResponseEntity.badRequest().body(response);
        }
        // 验证文件类型
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || (!originalFilename.endsWith(".xlsx"))) {
            response.put("success", false);
            response.put("message", "Excelファイル形式のみサポートします(.xlsx)");
            return ResponseEntity.badRequest().body(response);
        }

        try {
            // 从文件名前6位获取code，生成唯一的UUID
            String delimiter = "_";
            String code = originalFilename.split(delimiter)[0];
            if (code.length() != 6) {
                code = "";
            }
            UUID uuid = UUID.randomUUID();

            // 保存文件
            String savedFileName = originalFilename;
            Path targetLocation = Paths.get(uploadDirectory).resolve(savedFileName);

            // 如果目标路径已存在同名文件，则删除它
            if (Files.exists(targetLocation)) {
                Files.delete(targetLocation);
                log.info("Deleted existing file: {}", targetLocation);
            }
            Files.copy(file.getInputStream(), targetLocation);



            // 检查文件内容
            FileValidationResult validationResult = validateExcelFile(targetLocation.toString());

            // 创建importHistory记录
            ImportHistory importHistory = new ImportHistory();
            importHistory.setUuid(uuid);
            importHistory.setTcihCode(code);
            importHistory.setTcihFilename(savedFileName);
            importHistory.setTcihImporttime(Instant.now());
            importHistory.setTcihStatus(!validationResult.hasError);
            importHistory.setCreateBy(importProcessResource.getCurrentUsername());
            importHistory.setCreateTime(Instant.now());
            importHistory.setDelFlag(true);
            // 保存记录
            ImportHistory savedHistory = importHistoryService.save(importHistory);
            // 如果有错误，创建importHistoryDetail记录
            if (validationResult.hasError) {
                ImportHistoryDetail detail = new ImportHistoryDetail();
                detail.setTcihdPid(String.valueOf(uuid));
                uuid = UUID.randomUUID();
                detail.setUuid(uuid);
                detail.setTcihdLine(validationResult.getErrorLine());
                detail.setTcihdError(validationResult.getErrorMessage());
                detail.setCreateBy(importProcessResource.getCurrentUsername());
                detail.setCreateTime(Instant.now());
                detail.setDelFlag(false);
                importHistoryDetailService.save(detail);

                if (validationResult.isSsListFlag()) {
//                    importProcessResource.injectSSIntoImportTable();
//                    importProcessResource.processAllFiles(targetLocation);
                } else Files.deleteIfExists(targetLocation); // 物理删除上传的文件
            } else {
                //importProcessResource.processAllFiles(targetLocation);
            }

            response.put("success", true);
            response.put("message", validationResult.hasError ? "ファイル検証に失敗しました" : "ファイル検証に成功しました");
            response.put("data", savedHistory);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error during file upload and validation", e);
            response.put("success", false);
            response.put("message", "ファイル処理プロセス中にエラーが発生しました: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/import/process-all-files")
    public void processUploadedFiles() {
        importProcessResource.processAllFiles();
    }

    private static class FileValidationResult {

        boolean hasError;
        StringBuilder errorMessage;
        StringBuilder errorLine;
        boolean ss_list_flag; // 新增字段，用于存储ss_list_flag

        FileValidationResult() {
            this.hasError = false;
            this.errorMessage = new StringBuilder();
            this.errorLine = new StringBuilder();
            this.ss_list_flag = false; // 初始化为false
        }

        void addError(String message, String line) {
            this.hasError = true;
            if (!errorMessage.isEmpty()) {
                errorMessage.append(",");
                errorLine.append(",");
            }
            errorMessage.append(message);
            errorLine.append(line);
        }

        void clearError() {
            this.hasError = false;
            this.errorMessage.setLength(0);
            this.errorLine.setLength(0);
        }

        String getErrorMessage() {
            return errorMessage.toString();
        }

        String getErrorLine() {
            return errorLine.toString();
        }

        boolean isSsListFlag() { // 新增方法，用于获取ss_list_flag
            return ss_list_flag;
        }
    }

    private FileValidationResult validateExcelFile(String filePath) throws IOException {
        try {
            File file = new File(filePath);
            FileValidationResult result = new FileValidationResult();
            String currentHash = calculateFileHash(file);

            // 检查是否已处理过该文件且内容未变
            if (processedFileHashes.containsKey(file.getAbsolutePath()) &&
                processedFileHashes.get(file.getAbsolutePath()).equals(currentHash)) {
                log.info("文件内容未变化，跳过处理: {}", file.getName());
                return result;
            }

            // 正常处理文件...
            log.info("正在处理文件: {}", file.getName());

            // 处理完成后更新哈希值
            processedFileHashes.put(file.getAbsolutePath(), currentHash);

        } catch (Exception e) {
            log.error("文件哈希计算失败或处理异常", e);
        }
        try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {
            FileValidationResult result = new FileValidationResult();

            result.ss_list_flag = false;
            // 判断表是否存在
            if (workbook.getNumberOfSheets() < 1) {
                result.addError("ERR001_ファイルが存在しません。（The file does not exist.）", "N/A");
                return result;
            }
            if (workbook.getNumberOfSheets() < 2) {
                // 如果只有一张表，检查表一的A2单元格是否为管理番号（SS報部品）
                Sheet sheet1 = workbook.getSheetAt(0);
                Row row1 = sheet1.getRow(1);
                Cell cellA2 = row1.getCell(0);
                //log.info(cellA2.toString());
                if (cellA2 == null || !cellA2.toString().equals("管理番号（SS親部品）")) {
                    result.addError("ERR002_ファイルフォーマットが不正です。（The file format is invalid.）", "2");
                } else if (cellA2.toString().equals("管理番号（SS親部品）")) {
                    result.ss_list_flag = true;
                    result.clearError();
                    for (int i = 2; i < sheet1.getLastRowNum() + 1; i++) { // 从第3行開始遍历
                        //log.info("ラインを読み込む中:　" + i + " 総ライン数: " + sheet1.getLastRowNum());
                        Row row = sheet1.getRow(i);
                        if (isRowEmpty(row)) break;
                        if (
                            row != null &&
                                row.getCell(0) != null &&
                                row.getCell(1) == null &&
                                sheet1.getRow(i + 1) != null &&
                                sheet1.getRow(i + 1).getCell(1) != null
                        ) {
                            Cell cell0 = row.getCell(0);
                            Row nextRow = sheet1.getRow(i + 1);
                            Cell nextCell1 = nextRow.getCell(1);
                            if (
                                cell0 != null && !getCellValue(cell0).isEmpty() && nextCell1 != null && !getCellValue(nextCell1).isEmpty()
                            ) {
                                if (nextRow != null) {
                                    if (nextCell1 != null && !getCellValue(nextCell1).isEmpty()) {
                                        if (importTableRepository.findByBCodeContaining(getCellValue(nextCell1)).isEmpty()) {
                                            if (result.errorMessage.length() < 4800 && result.errorLine.length() < 240) result.addError(
                                                // 错误信息超长截断
                                                "ERR009_SS子部品の管理番号(" +
                                                    getCellValue(nextCell1) +
                                                    ")が存在しません。（The SS sub part code does not exist.）",
                                                String.valueOf(i + 1)
                                            );
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return result;
            }

            // 检查表二的J3单元格是否为空
            Sheet sheet = workbook.getSheetAt(1);
            Row row3 = sheet.getRow(2);
            if (row3 != null) {
                Cell cellJ3 = row3.getCell(9); // J列
                if (cellJ3 == null || cellJ3.toString().trim().isEmpty()) {
                    result.addError(
                        "ERR003_インポートファイルの末端分類コードが空白です。（The import file's terminal classification code is blank.）",
                        "3"
                    );
                }
            } else {
                result.addError(
                    "ERR003_インポートファイルの末端分類コードが空白です。（The import file's terminal classification code is blank.）",
                    "3"
                );
            }
            // 检查表二的L3单元格是否为空
            if (row3 != null) {
                Cell cellL3 = row3.getCell(11); // L列
                if (cellL3 == null || cellL3.toString().trim().isEmpty()) {
                    result.addError(
                        "ERR004_インポートファイルの末端分類名称が空白です。（The import file's terminal classification name is blank.）",
                        "3"
                    );
                }
            } else {
                result.addError(
                    "ERR004_インポートファイルの末端分類名称が空白です。（The import file's terminal classification name is blank.）",
                    "3"
                );
            }
            // 检查表二的E3单元格是否存在于导入对象表中
            if (row3 != null) {
                Cell cellE3 = row3.getCell(4); // E列
                String classifyName = importProcessResource.convertAfterFirstUppercase(importProcessResource.getCellValueBeforeNewline(cellE3).replaceAll("[^a-zA-Z0-9]", "_"));
                String commonEntityPath = "src/main/java/com/chenhy/domain/commonEntity";
                log.info("route: " + getFileNames(commonEntityPath));
                if (cellE3 == null || cellE3.toString().trim().isEmpty()) {
                    result.addError(
                        "ERR010_インポートファイルの大分類はインポート対象外です。（The import file's classification code is not exists.）",
                        "3"
                    );
                } else if (!Objects.requireNonNull(getFileNames(commonEntityPath)).toString().contains(classifyName)) {
                    result.addError(
                        "ERR010_インポートファイルの大分類はインポート対象外です。（The import file's classification code is not exists.）",
                        "3"
                    );
                }
            } else {
                result.addError(
                    "ERR010_インポートファイルの大分類はインポート対象外です。（The import file's classification code is not exists.）",
                    "3"
                );
            }
            // 检查表二的L3单元格是否在导入設定表中定義了Parts Name
            if (row3 != null) {
                Cell cellL3 = row3.getCell(11); // L列 mattanName
                if (cellL3 == null || cellL3.toString().trim().isEmpty()) {
                    result.addError("ERR011_インポートファイルはインポート対象外です。（The import file is not in input list.）", "3");
                }
                    else if (importSettingRepository.findAllByTcisCode(getCellValue(cellL3)).isEmpty())
                    {
                        log.info("findByTcisCode(1): " + importSettingRepository.findAllByTcisCode(getCellValue(cellL3)).toString());
                        result.addError("ERR011_インポートファイルはインポート対象外です。（The import file is not in input list.）", "3");
                    }
                        else if (!importSettingRepository.findAllByTcisCode(getCellValue(cellL3)).toString().contains("PARTS_NAME"))
                        {
                            log.info("findByTcisCode(2): " + importSettingRepository.findAllByTcisCode(cellL3.toString()).toString());
                            result.addError("ERR011_インポートファイルはインポート対象外です。（The import file is not in input list.）", "3");
                        }
            } else {
                result.addError("ERR011_インポートファイルはインポート対象外です。（The import file is not in input list.）", "3");
            }

            for (int i = 10; i < sheet.getLastRowNum() + 1; i++) { // 从第11行开始遍历
                //log.info("ラインを読み込む中:　" + i + " 総ライン数: " + sheet.getLastRowNum());
                Row row = sheet.getRow(i);
                if (isRowEmpty(row)) break; // 解决getLastRow方法不准确问题

                Cell cellN = row.getCell(13); // N列
                if (
                    cellN != null &&
                        !cellN.toString().trim().isEmpty() &&
                        !cellN.toString().trim().equals("DEL") &&
                        !cellN.toString().trim().equals("SS")
                ) {
                    result.addError(
                        "ERR005_インポートファイルのOrCADパーツDB作成アプリ用フラグが不正です。（The import file's flag for the OrCAD parts database creation application is invalid.）",
                        String.valueOf(i + 1)
                    );
                }
                Cell cellT = row.getCell(19);
                if (cellT == null || cellT.toString().trim().isEmpty()) {
                    result.addError(
                        "ERR006_インポートファイルの型番が空白です。（The import file's model number is blank.）",
                        String.valueOf(i + 1)
                    );
                }
            }

            return result;
        }
//        catch (Exception e) {
//            FileValidationResult result = new FileValidationResult();
//            result.addError("インポート中、異常が発生しました。（An error occurred during the import process.）", "");
//            return result;
//        }
    }

    /**
     * 判断excel空行（整行都为空时，停止遍历取值）
     *
     * @param row excel行
     * @return 是否为空
     */
    public static boolean isRowEmpty(Row row) {
        if (null == row) {
            return true;
        }
        int firstCellNum = row.getFirstCellNum(); // 第一列位置
        int lastCellNum = row.getLastCellNum(); // 最后一列位置
        int nullCellNum = 0; // 空列数量
        for (int c = firstCellNum; c < lastCellNum; c++) {
            Cell cell = row.getCell(c);
            if (null == cell || cell.getCellType().equals(CellType.BLANK)) {
                nullCellNum++;
                continue;
            }
            cell.setCellType(CellType.STRING);
            String cellValue = cell.getStringCellValue().trim();
            if (StringUtils.isEmpty(cellValue)) {
                nullCellNum++;
            }
        }
        // 所有列都为空
        if (nullCellNum == (lastCellNum - firstCellNum)) {
            return true;
        }
        return false;
    }

    /**
     * 获取单元格字符串
     *
     * @param cell 单元格（cell格式）
     * @return 单元格字符串（字符串）
     */
    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue().trim();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> "";
        };
    }

    /**
     * 得到文件名称
     *
     * @param path 路径
     * @return {@link List}<{@link String}>
     */
    public List<String> getFileNames(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        List<String> fileNames = new ArrayList<>();
        return getFileNames(file, fileNames);
    }
    /**
     * 得到文件名称
     *
     * @param file      文件
     * @param fileNames 文件名
     * @return {@link List}<{@link String}>
     */
    private List<String> getFileNames(File file, List<String> fileNames) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                getFileNames(f, fileNames);
            } else {
                fileNames.add(f.getName());
            }
        }
        return fileNames;
    }

    /**
     * 计算文件的哈希值
     *
     * @param file 文件
     * @return 文件哈希值
     * @throws IOException               IO异常
     * @throws NoSuchAlgorithmException  没有此算法异常
     */
    private String calculateFileHash(File file) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] byteArray = new byte[1024];
            int bytesCount;
            while ((bytesCount = fis.read(byteArray)) != -1) {
                digest.update(byteArray, 0, bytesCount);
            }
        }
        byte[] hashBytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
