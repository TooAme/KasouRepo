package com.chenhy.web.rest;

import com.chenhy.service.ImportHistoryDetailService;
import com.chenhy.service.ImportHistoryService;
import com.chenhy.service.ImportTableService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 文件导入后处理所有文件夹内的文件。
 */
@Component
public class ImportProcessResource {

    private final ImportHistoryService importHistoryService;
    private final ImportHistoryDetailService importHistoryDetailService;
    private final ImportTableService importTableService;

    @Autowired
    public ImportProcessResource(
        ImportHistoryService importHistoryService,
        ImportHistoryDetailService importHistoryDetailService,
        ImportTableService importTableService
    ) {
        this.importHistoryService = importHistoryService;
        this.importHistoryDetailService = importHistoryDetailService;
        this.importTableService = importTableService;
    }

    public static void processAllFiles(Path filePath) {
        // 获取文件列表
        System.out.println(filePath);
        List<File> ssListFile = new ArrayList<>();
        List<File> normalFile = new ArrayList<>();

        File directory = new File(String.valueOf(filePath.getParent()));
        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));

        if (files != null) {
            for (File file : files) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    Workbook workbook = new XSSFWorkbook(fis);
                    Sheet sheet = workbook.getSheetAt(0); // 获取第一个工作表
                    Row row = sheet.getRow(1); // 获取第二行
                    if (row != null) {
                        Cell cell = row.getCell(0); // 获取A2单元格
                        if (cell != null) {
                            String value = cell.toString();
                            if (value.equals("管理番号（SS親部品）")) {
                                ssListFile.add(file);
                            } else {
                                normalFile.add(file);
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 排序，先处理非ss
        for (File file : normalFile) {
            System.out.println("Processing normalFile");
            processNormalFile(file);
        }
        for (File file : ssListFile) {
            System.out.println("Processing ssListFile");
            processSsListFile(file);
        }
    }

    private static void processSsListFile(File file) {
        System.out.println("Processing file: " + file.getName());
        // 在这里添加具体的文件处理逻辑
        // 例如：读取文件内容、修改数据、保存等
    }

    private static void processNormalFile(File file) {
        System.out.println("Processing file: " + file.getName());
        // 在这里添加具体的文件处理逻辑
        // 例如：读取文件内容、修改数据、保存等
    }
}
