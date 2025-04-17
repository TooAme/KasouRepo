package com.chenhy.web.rest;

import com.chenhy.domain.ImportHistory;
import com.chenhy.domain.ImportHistoryDetail;
import com.chenhy.service.ImportHistoryDetailService;
import com.chenhy.service.ImportHistoryService;
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
public class ImportResource {

    private final Logger log = LoggerFactory.getLogger(ImportResource.class);

    private final ImportHistoryService importHistoryService;
    private final ImportHistoryDetailService importHistoryDetailService;

    private final String uploadDirectory = "file";

    @Autowired
    public ImportResource(ImportHistoryService importHistoryService, ImportHistoryDetailService importHistoryDetailService) {
        this.importHistoryService = importHistoryService;
        this.importHistoryDetailService = importHistoryDetailService;

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
            response.put("message", "请选择一个文件上传");
            return ResponseEntity.badRequest().body(response);
        }

        // 验证文件类型
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || (!originalFilename.endsWith(".xlsx") && !originalFilename.endsWith(".xls"))) {
            response.put("success", false);
            response.put("message", "只支持Excel文件格式 (.xlsx, .xls)");
            return ResponseEntity.badRequest().body(response);
        }

        try {
            // 生成唯一的代码和UUID
            String code = generateFileCode();
            UUID uuid = UUID.randomUUID();

            // 保存文件
            String savedFileName = code + "_" + originalFilename;
            Path targetLocation = Paths.get(uploadDirectory).resolve(savedFileName);
            Files.copy(file.getInputStream(), targetLocation);

            // 检查文件内容
            FileValidationResult validationResult = validateExcelFile(targetLocation.toString());

            // 创建导入历史记录
            ImportHistory importHistory = new ImportHistory();
            importHistory.setUuid(uuid);
            importHistory.setTcihCode(code);
            importHistory.setTcihFilename(savedFileName);
            importHistory.setTcihImporttime(Instant.now());
            importHistory.setTcihStatus(!validationResult.hasError);
            importHistory.setCreateBy("system");
            importHistory.setCreateTime(Instant.now());
            importHistory.setDelFlag(false);

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
                detail.setCreateBy("system");
                detail.setCreateTime(Instant.now());
                detail.setDelFlag(false);
                importHistoryDetailService.save(detail);

                // 删除上传的文件
                Files.deleteIfExists(targetLocation);
            }

            // 构建响应
            response.put("success", true);
            response.put("message", validationResult.hasError ? "文件验证失败" : "文件验证成功");
            response.put("data", savedHistory);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error during file upload and validation", e);
            response.put("success", false);
            response.put("message", "文件处理过程中发生错误: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    private static class FileValidationResult {

        boolean hasError;
        StringBuilder errorMessage;
        StringBuilder errorLine;

        FileValidationResult() {
            this.hasError = false;
            this.errorMessage = new StringBuilder();
            this.errorLine = new StringBuilder();
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
    }

    private FileValidationResult validateExcelFile(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {
            FileValidationResult result = new FileValidationResult();

            Sheet sheet = workbook.getSheetAt(1); // 获取第二个sheet
            if (sheet == null) {
                result.addError("ERR001_ファイルが存在しません。（The file does not exist.）", "N/A");
                return result;
            }

            // 检查第一个sheet的A2单元格是否为管理番号（SS報部品）
            Sheet sheet1 = workbook.getSheetAt(0);
            Cell cellA2 = sheet1.getRow(1) != null ? sheet1.getRow(1).getCell(0) : null;
            if (cellA2 == null || !cellA2.toString().equals("管理番号（SS報部品）")) {
                result.addError("ERR002_ファイルフォーマットが不正です。（The file format is invalid.）", "A2");
            }

            // 检查第二个sheet的J3单元格是否为空
            Row row3 = sheet.getRow(2);
            if (row3 != null) {
                Cell cellJ3 = row3.getCell(9); // J列是索引9
                if (cellJ3 != null && !cellJ3.toString().trim().isEmpty()) {
                    result.addError(
                        "ERR003_インポートファイルの末端分類コードが空白です。（The import file's terminal classification code is blank.）",
                        "J3"
                    );
                }
            }

            // 检查第二个sheet的L3单元格是否为空
            if (row3 != null) {
                Cell cellL3 = row3.getCell(11); // L列是索引11
                if (cellL3 != null && !cellL3.toString().trim().isEmpty()) {
                    result.addError(
                        "ERR004_インポートファイルの末端分類名称が空白です。（The import file's terminal classification name is blank.）",
                        "L3"
                    );
                }
            }

            // 检查第二个sheet的E3单元格是否存在于导入对象表中
            if (row3 != null) {
                Cell cellE3 = row3.getCell(4); // E列是索引4
                if (cellE3 == null || cellE3.toString().trim().isEmpty()) {
                    result.addError(
                        "ERR010_インポートファイルの大分類はインポート対象外です。（The import file's classification code is not exists.）",
                        "E3"
                    );
                }
                // TODO: 这里需要添加检查E3的值是否存在于导入对象表中的逻辑
            }

            // 检查第二个sheet的L3单元格是否在导入设置表中定义了Parts Name
            if (row3 != null) {
                Cell cellL3 = row3.getCell(11); // L列是索引11
                // TODO: 这里需要添加检查L3是否在导入设置表中定义了Parts Name的逻辑
                // 如果未定义：
                // result.addError("ERR_011: シート2のセル(L3)により、インポート設定テーブルにParts Nameが未定義です", "L3");
            }

            return result;
        }
    }

    /**
     * 生成唯一的文件代码
     */
    private String generateFileCode() {
        return "XJ" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }
}
