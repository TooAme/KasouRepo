package com.chenhy.web.rest;

import com.chenhy.domain.ImportTable;
import com.chenhy.repository.ImportTableRepository;
import com.chenhy.service.ImportHistoryDetailService;
import com.chenhy.service.ImportHistoryService;
import com.chenhy.service.ImportTableService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
    private final ImportTableRepository importTableRepository;

    @Autowired
    public ImportProcessResource(
        ImportHistoryService importHistoryService,
        ImportHistoryDetailService importHistoryDetailService,
        ImportTableService importTableService,
        ImportTableRepository importTableRepository
    ) {
        this.importHistoryService = importHistoryService;
        this.importHistoryDetailService = importHistoryDetailService;
        this.importTableService = importTableService;
        this.importTableRepository = importTableRepository;
    }

    public void processAllFiles(Path filePath) {
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

    private void processNormalFile(File file) {
        System.out.println("Processing file: " + file.getName());

        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(1); // 获取第二个工作表

            // 遍历第 11 行到最后一行的数据
            for (int rowIndex = 10; rowIndex <= sheet.getLastRowNum(); rowIndex++) { // 第 11 行的索引为 10
                Row row = sheet.getRow(rowIndex);
                if (row == null) {
                    continue; // 跳过空行
                }

                if ("DEL".equals(getCellValue(row.getCell(13)))) { // flag为DEL删除该行重来
                    sheet.removeRow(row); // 物理删除
                    Optional<ImportTable> existingTable = importTableRepository.findByBCode(getCellValue(row.getCell(28)));
                    if (existingTable.isPresent()) {
                        importTableService.delete(existingTable.get().getId()); // 实体数据删除
                    }
                    rowIndex--;
                    continue;
                }

                // 获取 bcode 値
                String bcode = getCellValue(row.getCell(28));
                if (bcode == null || bcode.isEmpty()) {
                    continue; // 如果 bcode 为空，跳过当前行
                }

                // 检查数据是否存在
                Optional<ImportTable> existingTable = importTableRepository.findByBCode(bcode);
                ImportTable importTable;
                if (existingTable.isPresent()) {
                    // 如果数据已存在，更新该条记录
                    importTable = existingTable.get();
                    System.out.println("Updating existing data with BCode: " + bcode);
                    importTable.setUpdateBy(System.getProperty("user.name"));
                    importTable.setUpdateTime(Instant.now());

                    if (getCellValue(row.getCell(20)).equals("N/A")) importTable.setPartNumber(getCellValue(row.getCell(19)));
                    else importTable.setPartNumber(getCellValue(row.getCell(20))); // 型番
                } else {
                    // 如果数据不存在，创建新记录
                    importTable = new ImportTable();
                    System.out.println("Creating new data with BCode: " + bcode);

                    UUID uuid = UUID.randomUUID();
                    importTable.setUuid(uuid); // uuid

                    importTable.setbCode(bcode);

                    importTable.setDelFlag(true);
                    importTable.setItemRegistrationClassification(3);

                    if (getCellValue(row.getCell(20)).equals("N/A")) importTable.setPartNumber(getCellValue(row.getCell(19)));
                    else importTable.setPartNumber(getCellValue(row.getCell(20))); // 型番

                    String fileName = file.getName();
                    importTable.setPartType(getMiddlePart(fileName));

                    importTable.setCreateBy(System.getProperty("user.name"));
                    importTable.setCreateTime(Instant.now());
                    importTable.setUpdateBy(System.getProperty("user.name"));
                    importTable.setUpdateTime(Instant.now()); // 创建同时也是更新
                }

                // 调用服务保存或更新记录
                importTableService.save(importTable);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 辅助方法：获取单元格的值
    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }

    private void processSsListFile(File file) {
        System.out.println("Processing file: " + file.getName());
        // 在这里添加具体的文件处理逻辑
        // 例如：读取文件内容、修改数据、保存等
    }

    public String getMiddlePart(String input) {
        // 如果输入为空或不包含下划线，则直接返回空字符串
        if (input == null || !input.contains("_")) {
            return "";
        }

        // 找到第一个下划线的位置
        int firstIndex = input.indexOf("_");
        // 找到最后一个下划线的位置
        int lastIndex = input.lastIndexOf("_");

        // 如果只有一个下划线，或者第一个下划线和最后一个下划线是同一个位置
        if (firstIndex == lastIndex) {
            // 返回第一个下划线之后的内容
            return input.substring(firstIndex + 1);
        } else {
            // 返回第一个下划线之后和最后一个下划线之前的内容
            return input.substring(firstIndex + 1, lastIndex);
        }
    }
}
