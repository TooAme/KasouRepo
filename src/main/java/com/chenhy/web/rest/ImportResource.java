package com.chenhy.web.rest;

import com.chenhy.domain.ImportHistory;
import com.chenhy.service.ImportHistoryService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
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

    private final String uploadDirectory = "file";

    @Autowired
    public ImportResource(ImportHistoryService importHistoryService) {
        this.importHistoryService = importHistoryService;

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
            // 生成唯一的代码
            String code = generateFileCode();

            // 保存文件
            String savedFileName = code + "_" + originalFilename;
            Path targetLocation = Paths.get(uploadDirectory).resolve(savedFileName);
            Files.copy(file.getInputStream(), targetLocation);

            // 创建导入历史记录
            ImportHistory importHistory = new ImportHistory();
            importHistory.setUuid(UUID.randomUUID());
            importHistory.setTcihCode(code);
            importHistory.setTcihFilename(code + "_" + originalFilename);
            importHistory.setTcihImporttime(Instant.now());
            importHistory.setTcihStatus(true);
            importHistory.setCreateBy("system"); // 或者从认证上下文中获取

            // 保存记录
            ImportHistory savedHistory = importHistoryService.save(importHistory);

            // 触发异步导入处理（这里只是示例，实际实现可能需要更复杂的逻辑）
            processImportFile(targetLocation.toString(), savedHistory.getId());

            // 构建响应
            response.put("success", true);
            response.put("message", "文件上传成功，正在处理");
            response.put("data", savedHistory);

            return ResponseEntity.ok().body(response);
        } catch (IOException e) {
            log.error("Failed to save the file", e);
            response.put("success", false);
            response.put("message", "文件保存失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            log.error("Error during file upload", e);
            response.put("success", false);
            response.put("message", "文件上传过程中发生错误: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * 生成唯一的文件代码
     */
    private String generateFileCode() {
        // 简单实现，使用UUID前6位并转为大写
        return "XJ" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }

    /**
     * 处理导入文件（异步）
     *
     * 注意：这是一个简化的实现。在实际生产环境中，
     * 你可能需要使用更复杂的异步处理方式，如Spring的@Async或消息队列
     */
    private void processImportFile(String filePath, Long importHistoryId) {
        // 模拟异步处理，实际应用中应该使用线程池或消息队列
        new Thread(() -> {
            try {
                // 模拟处理时间
                Thread.sleep(5000);

                // 随机决定成功或失败（仅用于演示）
                boolean success = Math.random() > 0.3;

                // 更新导入历史状态
                ImportHistory history = importHistoryService.findOne(importHistoryId).orElse(null);
                if (history != null) {
                    history.setTcihStatus(success ? true : false);
                    importHistoryService.save(history);
                }

                log.info("File import completed: {} with status {}", filePath, success ? "SUCCESS" : "FAILURE");
            } catch (InterruptedException e) {
                log.error("Import processing interrupted", e);
            } catch (Exception e) {
                log.error("Error processing import file", e);
            }
        }).start();
    }
}
