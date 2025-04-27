package com.chenhy.web.rest;

import com.chenhy.domain.ImportHistory;
import com.chenhy.domain.ImportHistoryDetail;
import com.chenhy.service.ImportHistoryDetailService;
import com.chenhy.service.ImportHistoryService;
import io.micrometer.common.util.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    private final String uploadDirectory = "file";

    @Autowired
    public ImportUploadErrorResource(
        ImportHistoryService importHistoryService,
        ImportHistoryDetailService importHistoryDetailService,
        ImportProcessResource importProcessResource
    ) {
        this.importHistoryService = importHistoryService;
        this.importHistoryDetailService = importHistoryDetailService;
        this.importProcessResource = importProcessResource;

        // 创建上传目录
        File directory = new File(uploadDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    /**
     * POST /import/upload : Upload a file for import.
     *
     * @param file the file to upload
     * @return the ResponseEntity with status 200 (OK) and the result in body
     */
    @PostMapping("/import/upload")
    public ResponseEntity<Map<String, Object>> uploadFile(@RequestParam("file") MultipartFile file) {
        log.debug("REST request to upload file : {}", file.getOriginalFilename());

        Map<String, Object> response = new HashMap<>();

        if (file.isEmpty()) {
            response.put("success", false);
            response.put("message", "アップロードするファイルを一つ選びます");
            return ResponseEntity.badRequest().body(response);
        }

        // 验证ファイルタイプ
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || (!originalFilename.endsWith(".xlsx"))) {
            response.put("success", false);
            response.put("message", "Excelファイル形式のみサポートします(.xlsx)");
            return ResponseEntity.badRequest().body(response);
        }

        try {
            // 生成唯一的コード和UUID
            String delimiter = "_";
            String code = originalFilename.split(delimiter)[0];
            if (code.length() != 6) {
                code = "";
            }
            UUID uuid = UUID.randomUUID();

            // 保存ファイル
            String savedFileName = originalFilename;
            Path targetLocation = Paths.get(uploadDirectory).resolve(savedFileName);

            // 如果目标路径已存在同名ファイル，则删除它
            if (Files.exists(targetLocation)) {
                Files.delete(targetLocation);
                log.info("Deleted existing file: {}", targetLocation);
            }

            Files.copy(file.getInputStream(), targetLocation);

            // 检查ファイル内容
            FileValidationResult validationResult = validateExcelFile(targetLocation.toString());

            // 创建导入历史记录
            ImportHistory importHistory = new ImportHistory();
            importHistory.setUuid(uuid);
            importHistory.setTcihCode(code);
            importHistory.setTcihFilename(savedFileName);
            importHistory.setTcihImporttime(Instant.now());
            importHistory.setTcihStatus(!validationResult.hasError);
            importHistory.setCreateBy(System.getProperty("user.name"));
            importHistory.setCreateTime(Instant.now());
            importHistory.setDelFlag(true);

            // 保存记录
            ImportHistory savedHistory = importHistoryService.save(importHistory);

            // 如果有错误，创建错误详情记录
            if (validationResult.hasError) {
                ImportHistoryDetail detail = new ImportHistoryDetail();
                detail.setTcihdPid(String.valueOf(uuid));
                uuid = UUID.randomUUID();
                detail.setUuid(uuid);
                detail.setTcihdLine(validationResult.getErrorLine());
                detail.setTcihdError(validationResult.getErrorMessage());
                detail.setCreateBy(System.getProperty("user.name"));
                detail.setCreateTime(Instant.now());
                detail.setDelFlag(false);
                importHistoryDetailService.save(detail);

                // 删除上传的ファイル
                Files.deleteIfExists(targetLocation);
            } else {
                importProcessResource.processAllFiles(targetLocation);
            }

            // 构建レスポンス
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
            if (errorMessage.length() > 0) {
                errorMessage.append(",");
                errorLine.append(",");
            }
            errorMessage.append(message);
            errorLine.append(line);
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
        try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {
            FileValidationResult result = new FileValidationResult();

            result.ss_list_flag = true;
            // 判断表是否存在
            if (workbook.getNumberOfSheets() < 1) {
                result.addError("ERR001_ファイルが存在しません。", "N/A");
                return result;
            }
            if (workbook.getNumberOfSheets() < 2) {
                // 如果只有一张表，检查第一个sheetのA2单元格是否为管理番号（SS報部品）
                Sheet sheet1 = workbook.getSheetAt(0);
                Row row1 = sheet1.getRow(1);
                //                if (row1 == null) {
                //                    result.addError("ERR002_ファイルフォーマットが不正です。", "A2");
                //                } else {
                Cell cellA2 = row1.getCell(0);
                //System.out.println(cellA2.toString());
                if (cellA2 == null || !cellA2.toString().equals("管理番号（SS親部品）")) {
                    result.addError("ERR002_ファイルフォーマットが不正です。", "2");
                    //result.addError("ERR002_ファイルフォーマットが不正です。", "A2");
                } else if (cellA2.toString().equals("管理番号（SS親部品）")) {
                    result.ss_list_flag = true;
                }
                //}
                return result;
            }

            // 检查第二个sheetのJ3单元格是否为空
            Sheet sheet = workbook.getSheetAt(1); // 获取第二个sheet
            Row row3 = sheet.getRow(2);
            if (row3 != null) {
                Cell cellJ3 = row3.getCell(9); // J列は索引9
                if (cellJ3 == null || cellJ3.toString().trim().isEmpty()) {
                    result.addError("ERR003_インポートファイルの末端分類コードが空白です。", "3");
                    //result.addError("ERR003_インポートファイルの末端分類コードが空白です。", "J3");
                }
            } else {
                result.addError("ERR003_インポートファイルの末端分類コードが空白です。", "3");
                //result.addError("ERR003_インポートファイルの末端分類コードが空白です。", "J3");
            }

            // 检查第二个sheetのL3单元格是否为空
            if (row3 != null) {
                Cell cellL3 = row3.getCell(11); // L列は索引11
                if (cellL3 == null || cellL3.toString().trim().isEmpty()) {
                    result.addError("ERR004_インポートファイルの末端分類名称が空白です。", "3");
                    //result.addError("ERR004_インポートファイルの末端分類名称が空白です。", "L3");
                }
            } else {
                result.addError("ERR004_インポートファイルの末端分類名称が空白です。", "3");
                //result.addError("ERR004_インポートファイルの末端分類名称が空白です。", "L3");
            }

            // 检查第二个sheetのE3单元格是否存在于导入对象表中
            if (row3 != null) {
                Cell cellE3 = row3.getCell(4); // E列は索引4
                if (cellE3 == null || cellE3.toString().trim().isEmpty()) {
                    result.addError("ERR010_インポートファイルの大分類はインポート対象外です。", "3");
                    //result.addError("ERR010_インポートファイルの大分類はインポート対象外です。", "E3");
                }
            } else {
                result.addError("ERR010_インポートファイルの大分類はインポート対象外です。", "3");
                //result.addError("ERR010_インポートファイルの大分類はインポート対象外です。", "E3");
            }

            // 检查第二个sheetのL3单元格是否在导入設定表中定義了Parts Name
            if (row3 != null) {
                Cell cellL3 = row3.getCell(11); // L列は索引11
                if (cellL3 == null || cellL3.toString().trim().isEmpty()) {
                    result.addError("ERR011_インポートファイルはインポート対象外です。", "3");
                }
                // 未定義の場合：
                // result.addError("ERR_011: シート2のセル(L3)により、インポート設定テーブルにParts Nameが未定義です", "L3");
            } else {
                result.addError("ERR011_インポートファイルはインポート対象外です。", "3");
                //result.addError("ERR011_インポートファイルはインポート対象外です。", "L3");
            }

            // 遍历行，找到最先各列都没有数据的一行
            //            int lineNum = -1; // 初始化为-1，表示未找到
            //            for (int i = 10; i < 1000; i++) { // 从第11行開始遍历
            //                Row row = sheet.getRow(i);
            //                if (row == null) {
            //                    lineNum = i; // 行号从0開始計数
            //                    break;
            //                } else {
            //                    boolean allCellsEmpty = true;
            //                    for (int j = 0; j < row.getLastCellNum(); j++) { // 检查所有列
            //                        Cell cell = row.getCell(j);
            //                        if (cell != null && !cell.toString().trim().isEmpty()) {
            //                            allCellsEmpty = false;
            //                            break;
            //                        }
            //                    }
            //                    if (allCellsEmpty) {
            //                        lineNum = i; // 行号从0開始計数
            //                        break;
            //                    }
            //                }
            //            }
            //System.out.println("lineNum:" + lineNum);
            for (int i = 10; i < sheet.getLastRowNum() + 1; i++) { // 从第11行開始遍历
                System.out.println("ラインを読み込む中:　" + i + " 総ライン数: " + sheet.getLastRowNum());
                Row row = sheet.getRow(i);
                if (isRowEmpty(row)) break; // 解决getLastRow方法不准确问题

                Cell cellN = row.getCell(13); // N列は索引13
                if (
                    cellN != null &&
                    !cellN.toString().trim().isEmpty() &&
                    !cellN.toString().trim().equals("DEL") &&
                    !cellN.toString().trim().equals("SS")
                ) {
                    result.addError("ERR005_インポートファイルのOrCADパーツDB作成アプリ用フラグが不正です。", String.valueOf(i + 1));
                }
                Cell cellT = row.getCell(19);
                if (cellT == null || cellT.toString().trim().isEmpty()) {
                    result.addError("ERR006_インポートファイルの型番が空白です。", String.valueOf(i + 1));
                }
            }

            return result;
        }
    }

    public static boolean isRowEmpty(Row row) { // 附判断excel空行的方法（整行都为空时，停止遍历取值）
        if (null == row) {
            return true;
        }
        int firstCellNum = row.getFirstCellNum(); //第一个列位置
        int lastCellNum = row.getLastCellNum(); //最后一列位置
        int nullCellNum = 0; //空列数量
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
        //所有列都为空
        if (nullCellNum == (lastCellNum - firstCellNum)) {
            return true;
        }
        return false;
    }
    /**
     * 生成唯一的ファイルコード
     */
    //    private String generateFileCode() {
    //        return
    //    }
}
