package com.chenhy.web.rest;

import com.chenhy.domain.ImportSetting;
import com.chenhy.domain.ImportTable;
import com.chenhy.domain.SSImport;
import com.chenhy.repository.ImportTableRepository;
import com.chenhy.repository.SSImportRepository;
import com.chenhy.service.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 文件导入后处理所有文件夹内的文件。
 * 更新：跳过已经处理过的相同的文件。
 */
@Component
public class ImportProcessResource {

    private final ImportSettingService importSettingService;
    private final ImportTableService importTableService;
    private final ImportTableRepository importTableRepository;
    private final SSImportRepository sSImportRepository;
    private final SSImportService sSImportService;
    private final Set<String> processedFiles = new HashSet<>();
    Logger log = LoggerFactory.getLogger(ImportProcessResource.class);

    @Autowired
    public ImportProcessResource(
        ImportSettingService importSettingService,
        ImportTableService importTableService,
        ImportTableRepository importTableRepository,
        SSImportRepository sSImportRepository,
        SSImportService sSImportService
    ) {
        this.importSettingService = importSettingService;
        this.importTableService = importTableService;
        this.importTableRepository = importTableRepository;
        this.sSImportRepository = sSImportRepository;
        this.sSImportService = sSImportService;
    }

    public void processAllFiles(Path filePath) {
        // 获取文件列表
        List<File> ssListFile = new ArrayList<>();
        List<File> normalFile = new ArrayList<>();

        File directory = filePath != null ? new File(String.valueOf(filePath.getParent())) : null;
        File[] files = directory != null ? directory.listFiles((dir, name) -> name != null && name.toLowerCase().endsWith(".xlsx")) : null;

        if (files != null) {
            for (File file : files) {
                if (processedFiles.contains(file.getAbsolutePath())) {
                    log.info("文件已处理过，跳过: " + file.getName());
                    continue;
                }
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
                    log.error(e.getMessage(), e);
                }
            }
        }

        // 获取所有 partNumber 为 "-" 的 ImportTable 数据并删除
        List<ImportTable> importTablesToDelete = importTableRepository.findByPartNumber("-");
        for (ImportTable importTable : importTablesToDelete) importTableService.delete(importTable.getId());
        System.out.println("partNumber が '-' の ImportTable データが削除されました。");

        for (File file : normalFile) {
            if (processedFiles.contains(file.getAbsolutePath())) {
                log.info("処理済み单品ファイル、スキップします: " + file.getName());
                System.out.println("処理済み单品ファイル、スキップします: " + file.getName());
                continue;
            }
            processNormalFile(file);
            injectSSIntoImportTable();
            processedFiles.add(file.getAbsolutePath());
        }
        for (File file : ssListFile) {
            if (processedFiles.contains(file.getAbsolutePath())) {
                log.info("処理済みSSリストファイル、スキップします:" + file.getName());
                System.out.println("処理済みSSリストファイル、スキップします:" + file.getName());
                continue;
            }
            processSsListFile(file);
            injectSSIntoImportTable();
            processedFiles.add(file.getAbsolutePath());
        }
    }

    private void processNormalFile(File file) {
        if (file == null) return;

        System.out.println("普通単品ファイルの取り扱いでいます: " + file.getName());

        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(1); // 获取第二个工作表
            Row characteristicRow = workbook.getSheetAt(1).getRow(2);
            String mattanName = getCellValue(sheet.getRow(2).getCell(11));
            // 遍历第 11 行到最后一行的数据
            for (int rowIndex = 10; rowIndex <= sheet.getLastRowNum(); rowIndex++) { // 第 11 行的索引为 10
                Row row = sheet.getRow(rowIndex);
                if (row == null) continue; // 跳过空行
                if ("DEL".equals(getCellValue(row.getCell(13)))) {
                    sheet.removeRow(row); // 物理删除
                    String delBCode = getCellValue(row.getCell(28));
                    if (delBCode != null && !delBCode.isEmpty()) {
                        importTableRepository
                            .findByBCode(delBCode)
                            .ifPresent(importTable -> importTableService.delete(importTable.getId()));
                    } // 实体数据删除
                    rowIndex--;
                    continue;
                }
                // 获取 bCode 値
                String bCode = getCellValue(row.getCell(28));
                if (bCode == null || bCode.isEmpty()) continue;
                // 如果 bCode 为空，跳过当前行
                // 检查数据是否存在
                Optional<ImportTable> existingTable = importTableRepository.findByBCode(bCode);
                ImportTable importTable;
                if (existingTable.isPresent()) { // 如果数据已存在，更新该条记录
                    importTable = existingTable.get();
                    System.out.println("管理番号に従ってデータを更新中: " + bCode);
                    importTable.setUpdateBy(System.getProperty("user.name"));
                    importTable.setUpdateTime(Instant.now());
                } else { // 如果数据不存在，创建新记录
                    importTable = new ImportTable();
                    System.out.println("管理番号から新しいデータを作成中: " + bCode);

                    UUID uuid = UUID.randomUUID();
                    importTable.setUuid(uuid);
                    importTable.setPartType(mattanName);
                    importTable.setCreateBy(System.getProperty("user.name"));
                    importTable.setCreateTime(Instant.now());
                    importTable.setUpdateBy(System.getProperty("user.name"));
                    importTable.setUpdateTime(Instant.now()); // 创建同时也是更新
                    System.out.println("末端分類名: " + mattanName);
                    int attributeRow = 0;
                    attributeRow = findRow2(mattanName);
                    System.out.println("属性項目対応表に対応行: Row" + attributeRow);
                    FileInputStream fis2 = new FileInputStream("属性項目対応表.xlsx");
                    Workbook attributeWorkbook = new XSSFWorkbook(fis2);
                    Sheet attributeSheet = attributeWorkbook.getSheetAt(0);

                    setTableCharacter(importTable, row, "COMMON", "SCHEMATIC_PART");
                    setTableCharacter(importTable, row, "COMMON", "PART_NUMBER");
                    setTableCharacter(importTable, row, "COMMON", "MANUFACTURE");
                    setTableCharacter(importTable, row, "COMMON", "B_CODE");
                    setTableCharacter(importTable, row, "COMMON", "ITEM_REGISTRATION_CLASSFICATION");
                    setTableCharacter(importTable, row, "COMMON", "SPICE_MODEL");
                    setTableCharacter(importTable, row, "COMMON", "DEL");
                    setTableCharacter(importTable, row, mattanName, "VALUE");
                    setTableCharacter(importTable, row, mattanName, "CHARACTERISTICS");
                    setTableCharacter(importTable, row, mattanName, "TOLERANCE");
                    setTableCharacter(importTable, row, mattanName, "RATING_VOLTAGE");
                    setTableCharacter(importTable, row, mattanName, "RATING_ELECTRICITY");
                    setTableCharacter(importTable, row, mattanName, "SCHEMATIC_PART");
                    setTableCharacter(importTable, row, mattanName, "PARTS_NAME");

                    // 获取Schematic Part & Pcb FootPrint
                    int LW = 0;
                    if (mattanName.contains("コンデンサ") || mattanName.contains("抵抗器")) {
                        String L = getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK639)本体長さ（代表値）")));
                        String LM = getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK639)本体長さ（最大値）")));
                        String W = getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK640)本体幅（代表値）")));
                        String WM = getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK640)本体幅（最大値）")));
                        if (!L.isEmpty() && !W.isEmpty()) {
                            LW = (int) (Double.parseDouble(L) * 1000) + (int) (Double.parseDouble(W) * 10);
                        } else if (!LM.isEmpty() && !WM.isEmpty()) {
                            LW = (int) (Double.parseDouble(LM) * 1000) + (int) (Double.parseDouble(WM) * 10);
                        } else if (!L.isEmpty() && !WM.isEmpty()) {
                            LW = (int) (Double.parseDouble(L) * 1000) + (int) (Double.parseDouble(WM) * 10);
                        } else if (!LM.isEmpty() && !W.isEmpty()) {
                            LW = (int) (Double.parseDouble(LM) * 1000) + (int) (Double.parseDouble(W) * 10);
                        } // 否则为初始值的0
                    }
                    if (mattanName.contains("電解コンデンサ")) {
                        importTable.setSchematicPart("CE");

                        if (
                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJL582)実装方法※1"))).equals("基板挿入")
                        ) importTable.setPcbFootPrint("CE_" + LW + "_DIP");
                        else importTable.setPcbFootPrint("CE_" + LW);
                    } else if (mattanName.contains("コンデンサ") && !mattanName.contains("電解コンデンサ")) {
                        importTable.setSchematicPart("C");
                        if (
                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJL582)実装方法※1"))).equals("基板挿入")
                        ) importTable.setPcbFootPrint("C_" + LW + "_DIP");
                        else importTable.setPcbFootPrint("C_" + LW);
                    } else if (mattanName.contains("固定抵抗器")) {
                        importTable.setSchematicPart("R");
                        if (
                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJL582)実装方法※1"))).equals("基板挿入")
                        ) importTable.setPcbFootPrint("R_" + LW + "_DIP");
                        else importTable.setPcbFootPrint("R_" + LW);
                    } else if (mattanName.contains("可変抵抗器")) {
                        importTable.setSchematicPart("VR");
                        if (
                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJL582)実装方法※1"))).equals("基板挿入")
                        ) importTable.setPcbFootPrint("VR_" + LW + "_DIP");
                        else importTable.setPcbFootPrint("VR_" + LW);
                    } else {
                        if (getCellValue(row.getCell(getCellPos(characteristicRow, "(APP078)型番（新）"))).equals("N/A")) {
                            importTable.setSchematicPart(getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE010)型番"))));
                            importTable.setPcbFootPrint(getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE010)型番"))));
                        } else {
                            importTable.setSchematicPart(getCellValue(row.getCell(getCellPos(characteristicRow, "(APP078)型番（新）"))));
                            importTable.setPcbFootPrint(getCellValue(row.getCell(getCellPos(characteristicRow, "(APP078)型番（新）"))));
                        }
                    }
                    if (LW == 0) {
                        importTable.setPcbFootPrint("");
                        setTableCharacter(importTable, row, mattanName, "PACKAGE_TYPE");
                    }
                }
                // 保存或更新记录
                importTableService.save(importTable);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    private void processSsListFile(File file) {
        System.out.println("SSリストファイル処理中:" + file.getName());
        sSImportRepository.deleteAll(); // 删除 ssImport 临时数据库的所有数据
        // ss清单文件处理
        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook ssworkbook = new XSSFWorkbook(fis);
            Sheet sheetSs = ssworkbook.getSheetAt(0); // 获取第一个工作表
            // 遍历第 3 行到最后一行的数据
            for (int rowIndex = 2; rowIndex <= sheetSs.getLastRowNum(); rowIndex++) {
                Row row = sheetSs.getRow(rowIndex);
                if (row == null) {
                    continue; // 跳过空行
                }
                if (!getCellValue(row.getCell(0)).isEmpty()) { // 添加亲部品到ssImport临时表
                    // 找他右下角的代表部品，没有则不添加
                    if (
                        getCellValue(sheetSs.getRow(rowIndex + 1).getCell(1)).isEmpty() ||
                        getCellValue(sheetSs.getRow(rowIndex + 1).getCell(1)) == null
                    ) {
                        continue;
                    } else {
                        SSImport ssImport = new SSImport();
                        UUID uuid = UUID.randomUUID();
                        ssImport.setUuid(uuid);
                        ssImport.setSsBCode(getCellValue(row.getCell(0)));
                        ssImport.setSsSubBCode(getCellValue(sheetSs.getRow(rowIndex + 1).getCell(1)));
                        ssImport.setSsCreateBy(System.getProperty("user.name"));
                        ssImport.setSsFilename(getCellValue(row.getCell(2))); //写的是文件名，但是获取不到
                        ssImport.setCreateBy(System.getProperty("user.name"));
                        ssImport.setCreateTime(Instant.now());
                        ssImport.setUpdateBy(System.getProperty("user.name"));
                        ssImport.setUpdateTime(Instant.now());
                        ssImport.setDelFlag(true);
                        System.out.println("SS親部品新規作成中: " + getCellValue(row.getCell(0)));
                        sSImportService.save(ssImport);
                    }
                }
                if (!getCellValue(row.getCell(1)).isEmpty()) { // 添加子部品到ssImport临时表
                    SSImport ssImport = new SSImport();
                    UUID uuid = UUID.randomUUID();
                    ssImport.setUuid(uuid);
                    for (int j = 0; j < sheetSs.getLastRowNum(); j++) if (
                        sheetSs.getRow(rowIndex - j).getCell(0) != null && rowIndex - j > 2
                    ) { // 向上寻找亲部品管理番号
                        ssImport.setSsBCode(getCellValue(sheetSs.getRow(rowIndex - j).getCell(0)));
                        break;
                    }
                    ssImport.setSsSubBCode(getCellValue(row.getCell(1)));
                    ssImport.setSsCreateBy(System.getProperty("user.name"));
                    ssImport.setSsFilename(getCellValue(row.getCell(2))); // 写的是文件名，但是获取不到
                    ssImport.setCreateBy(System.getProperty("user.name"));
                    ssImport.setCreateTime(Instant.now());
                    ssImport.setUpdateBy(System.getProperty("user.name"));
                    ssImport.setUpdateTime(Instant.now());
                    ssImport.setDelFlag(true);
                    System.out.println("SS子部品新規作成中: " + getCellValue(row.getCell(1)));
                    sSImportService.save(ssImport);
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
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
     * 在属性表格中查找目标所在行号（旧方法）
     *
     * @param searchString 搜索对象字符串
     * @return 行号
     * @throws IOException IO异常
     */
    public int findRow2(String searchString) throws IOException {
        try (FileInputStream fis = new FileInputStream("属性項目対応表.xlsx"); Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet not found");
            }
            // 从第11行开始（0-based索引为10）
            for (int rowNum = 10; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                if (row == null) continue;
                // 检查B、C、D列（0-based索引为1,2,3）
                for (int colNum = 0; colNum < 5; colNum++) {
                    Cell cell = row.getCell(colNum);
                    //System.out.println(rowNum + " " + colNum);
                    if (cell != null) {
                        String cellValue = getCellValue(cell);
                        //System.out.println("cellvalue:" + cellValue + "," + "searching string:" + searchString);
                        if (searchString.equals(cellValue)) {
                            return rowNum + 1; // 转换为1-based行号
                        }
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 在行中查找指定字符串，并返回其列索引。
     *
     * @param row excel行
     * @param searchString 搜索对象字符串
     * @return 所在的列索引
     */
    private int getCellPos(Row row, String searchString) {
        // 去除搜索字符串中的所有空白字符
        searchString = searchString.replaceAll("\\s+", "");

        for (int i = 0; i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null) {
                // 获取单元格的字符串值并去除所有空白字符
                String cellValue = getCellValue(cell).replaceAll("\\s+", "");
                if (cellValue.equals(searchString)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 根据设定表中的列数，从第二行开始，设置 ImportTable 的 tcisIncol 或 tcisEditrule 对应属性。
     *
     * @param importTable 对象
     * @param row excel行
     * @param settingCharacter1 设定表中的分类 "COMMON" "抵抗器"等
     * @param settingCharacter2 设定表中的字段 "VALUE" "Parts Name"等
     */
    public void setTableCharacter(ImportTable importTable, Row row, String settingCharacter1, String settingCharacter2) {
        // 查询 ImportSetting 表中同时包含 settingCharacter1 和 settingCharacter2 的记录
        Optional<ImportSetting> setting = importSettingService.findOneByTcisCodeAndTcisType(settingCharacter1, settingCharacter2);
        if (setting.isPresent()) {
            String tcisIncol = setting.get().getTcisIncol();
            String tcisEditrule = setting.get().getTcisEditrule();
            System.out.println(
                settingCharacter2 +
                "が見つかりました in " +
                setting.get().getId() +
                " tcisIncol:" +
                tcisIncol +
                ", tcisEditrule:" +
                tcisEditrule
            );
            // 动态值
            if ((tcisEditrule == null || tcisEditrule.isEmpty()) && (tcisIncol != null && !tcisIncol.isEmpty())) {
                switch (settingCharacter2) {
                    case "SCHEMATIC_PART":
                        importTable.setSchematicPart(getComplexCellValue(row, cvt(tcisIncol)));
                        break;
                    case "DEL":
                        {
                            if (getComplexCellValue(row, cvt(tcisIncol)).isEmpty()) {
                                importTable.setDelFlag(true);
                            } else if (getComplexCellValue(row, cvt(tcisIncol)).equals("DEL")) {
                                importTable.setDelFlag(false);
                            }
                        }
                        break;
                    //                    case "PART_TYPE":
                    //                        importTable.setPartType(getComplexCellValue(row, cvt(tcisIncol)));
                    //                        break;
                    case "PART_NUMBER":
                        {
                            if (getCellValue(row.getCell(Integer.parseInt(cvt(tcisIncol)) + 1)).equals("N/A")) importTable.setPartNumber(
                                getComplexCellValue(row, cvt(tcisIncol))
                            );
                            else importTable.setPartNumber(getCellValue(row.getCell(Integer.parseInt(cvt(tcisIncol)) + 1)));
                        }
                        break;
                    case "MANUFACTURE":
                        {
                            if (getCellValue(row.getCell(Integer.parseInt(cvt(tcisIncol)) + 1)).equals("N/A")) importTable.setManufacture(
                                getComplexCellValue(row, cvt(tcisIncol))
                            );
                            else importTable.setManufacture(getCellValue(row.getCell(Integer.parseInt(cvt(tcisIncol)) + 1)));
                        }
                        break;
                    case "B_CODE":
                        importTable.setbCode(getComplexCellValue(row, cvt(tcisIncol)));
                        break;
                    case "ITEM_REGISTRATION_CLASSFICATION":
                        importTable.setItemRegistrationClassification(Integer.parseInt(getComplexCellValue(row, cvt(tcisIncol))));
                        break;
                    case "SPICE_MODEL":
                        importTable.setSpiceModel(getComplexCellValue(row, cvt(tcisIncol)));
                        break;
                    case "VALUE":
                        importTable.setValue(getComplexCellValue(row, cvt(tcisIncol)));
                        break;
                    case "PARTS_NAME":
                        importTable.setPartsName(getComplexCellValue(row, cvt(tcisIncol)));
                        break;
                    case "PART_TYPE":
                        {
                            if (row.getCell(Integer.parseInt(cvt(tcisIncol))) == null) importTable.setPartType(importTable.getPartNumber());
                        }
                        break;
                    case "TOLERANCE":
                        importTable.setTolerance(getComplexCellValue(row, cvt(tcisIncol)));
                        break;
                    case "RATING_VOLTAGE":
                        importTable.setRatingVoltage(getComplexCellValue(row, cvt(tcisIncol)));
                        break;
                    case "CHARACTERISTICS":
                        importTable.setCharacteristics(getComplexCellValue(row, cvt(tcisIncol)));
                        break;
                    case "RATING_ELECTRICITY":
                        importTable.setRatingElectricity(getComplexCellValue(row, cvt(tcisIncol)));
                        break;
                    case "PACKAGE_TYPE":
                        importTable.setPcbFootPrint(getComplexCellValue(row, cvt(tcisIncol))); // 仅在无pcb时调用
                        break;
                }
            }
            // 定值
            if ((tcisIncol == null || tcisIncol.isEmpty()) && (tcisEditrule != null && !tcisEditrule.isEmpty())) {
                switch (settingCharacter2) {
                    case "SCHEMATIC_PART":
                        importTable.setSchematicPart(tcisEditrule);
                        break;
                    case "DEL":
                        {}
                        break;
                    //                    case "PART_TYPE":
                    //                        importTable.setPartType(tcisEditrule);
                    //                        break;
                    case "PART_NUMBER":
                        importTable.setPartNumber(tcisEditrule);
                        break;
                    case "MANUFACTURE":
                        importTable.setManufacture(tcisEditrule);
                        break;
                    case "B_CODE":
                        importTable.setbCode(tcisEditrule);
                        break;
                    case "VALUE":
                        importTable.setValue(tcisEditrule);
                        break;
                    case "ITEM_REGISTRATION_CLASSFICATION":
                        importTable.setItemRegistrationClassification(Integer.parseInt(tcisEditrule));
                        break;
                    case "SPICE_MODEL":
                        importTable.setSpiceModel(tcisEditrule);
                        break;
                    case "PARTS_NAME":
                        importTable.setPartsName(tcisEditrule);
                        break;
                    case "PART_TYPE": {}
                    case "TOLERANCE":
                        importTable.setTolerance(tcisEditrule);
                        break;
                    case "RATING_VOLTAGE":
                        importTable.setRatingVoltage(tcisEditrule);
                        break;
                    case "CHARACTERISTICS":
                        importTable.setCharacteristics(tcisEditrule);
                        break;
                    case "RATING_ELECTRICITY":
                        importTable.setRatingElectricity(tcisEditrule);
                        break;
                    case "PACKAGE_TYPE":
                        importTable.setPcbFootPrint(tcisEditrule); // 仅在无pcb时调用
                        break;
                }
            }
        }
    }

    /**
     * 转换字符串中的excel列英文字母为数字
     *
     * @param columnLetters 列字母串 "A,B,C”
     * @return 数字格式（字符串） "0,1,2"
     */
    public String cvt(String columnLetters) {
        List<String> lettersList = Arrays.asList(columnLetters.split(","));
        List<Integer> numbersList = lettersList.stream().map(this::convertSingleColumnLetterToNumber).toList();

        return numbersList.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    /**
     * 将单个Excel列字母转换为数字格式
     *
     * @param columnLetter Excel列字母 "A"
     * @return 数字格式 0
     */
    private int convertSingleColumnLetterToNumber(String columnLetter) {
        int length = columnLetter.length();
        int num = 0;
        for (int i = 0; i < length; i++) {
            num = num * 26 + (columnLetter.charAt(i) - 'A' + 1);
        }
        return num - 1; // Excel列从1开始，而我们希望从0开始
    }

    /**
     * 获得用逗号隔开的全部列数的单元格内容（单个也能获取）
     *
     * @param row,columnIndices 行对象，列索引
     * @return 全部单元格内容或无逗号的单个单元格内容（字符串）
     */
    private String getComplexCellValue(Row row, String columnIndices) {
        if (columnIndices == null || columnIndices.isEmpty()) {
            return "";
        }
        // 检查是否为单个数字字符串
        if (!columnIndices.contains(",")) {
            try {
                int cellIndex = Integer.parseInt(columnIndices);
                Cell cell = row.getCell(cellIndex);
                return cell != null ? cell.toString() : "";
            } catch (NumberFormatException e) {
                return "";
            }
        }
        // 处理多个数字字符串的情况
        StringBuilder result = new StringBuilder();
        String[] indices = columnIndices.split(",");
        List<String> values = new ArrayList<>();

        for (String index : indices) {
            try {
                int cellIndex = Integer.parseInt(index.trim());
                Cell cell = row.getCell(cellIndex);
                if (cell != null) {
                    String cellValue = cell.toString();
                    // 新增逻辑：如果字符串以 ".0" 结尾，替换为 ""
                    if (cellValue.endsWith(".0")) {
                        cellValue = cellValue.replace(".0", "");
                    }
                    values.add(cellValue);
                }
            } catch (NumberFormatException e) {
                // 忽略无效的索引
            }
        }
        // 当有四个字符串时，返回特定格式（范围）
        if (values.size() == 4) {
            return values.get(0) + "-" + values.get(2) + values.get(3);
        }
        // 去掉末尾多余的空格
        return String.join("", values).trim();
    }

    /**
     *  在ssImport数据库中找到所有ssSubBCode与自身下一条数据的ssSubBCode相等的数据
     *  如果该数据的ssSubBCode与某一条importTable数据库中数据的bCode字段相等，则执行：
     *  生成一条新的importTable数据，这条数据的bCode字段为ssImport那条数据的ssBCode
     *  其它均与找到的importTable数据相同
     *  在 ssImport 数据库中找到所有 ssSubBCode 与自身下一条数据的 ssSubBCode 相等的数据
     */
    public void injectSSIntoImportTable() {
        System.out.println("SSインポートテーブルに子部品が存在するSS親部品をインポートテーブルに注入します...");
        List<SSImport> ssImports = sSImportRepository.findAll();
        Map<String, List<SSImport>> ssSubBCodeMap = new HashMap<>();
        for (int i = 0; i < ssImports.size() - 1; i++) {
            SSImport current = ssImports.get(i);
            SSImport next = ssImports.get(i + 1);

            if (current.getSsSubBCode() != null && current.getSsSubBCode().equals(next.getSsSubBCode())) {
                ssSubBCodeMap.computeIfAbsent(current.getSsSubBCode(), k -> new ArrayList<>()).add(current);
            }
        }
        // 检查这些编号是否存在于 ImportTable 数据库中
        List<String> ssSubBCodeList = new ArrayList<>(ssSubBCodeMap.keySet());
        List<ImportTable> matchingImportTables = importTableRepository.findByBCodeIn(ssSubBCodeList);
        // 如果存在对应的管理编号
        for (ImportTable importTable : matchingImportTables) {
            String ssSubBCode = importTable.getbCode();
            List<SSImport> ssImportsWithMatchingSubBCode = ssSubBCodeMap.get(ssSubBCode);
            for (SSImport ssImport : ssImportsWithMatchingSubBCode) {
                // 生成一条新的 importTable 数据，这条数据的 bCode 字段为 ssImport 数据的 ssBCode，其他均与找到的 importTable 数据相同
                ImportTable newImportTable = new ImportTable();
                newImportTable.setUuid(UUID.randomUUID());
                newImportTable.setbCode(ssImport.getSsBCode());
                newImportTable.setPartNumber("-");
                newImportTable.setManufacture(importTable.getManufacture());
                newImportTable.setCreateBy(importTable.getCreateBy());
                newImportTable.setCreateTime(importTable.getCreateTime());
                newImportTable.setUpdateBy(System.getProperty("user.name"));
                newImportTable.setUpdateTime(Instant.now());
                newImportTable.setDelFlag(importTable.getDelFlag());
                newImportTable.setItemRegistrationClassification(importTable.getItemRegistrationClassification());
                newImportTable.setSpiceModel(importTable.getSpiceModel());
                newImportTable.setValue(importTable.getValue());
                newImportTable.setPartType(importTable.getPartType());
                newImportTable.setTolerance(importTable.getTolerance());
                newImportTable.setRatingVoltage(importTable.getRatingVoltage());
                newImportTable.setCharacteristics(importTable.getCharacteristics());
                newImportTable.setRatingElectricity(importTable.getRatingElectricity());
                newImportTable.setSchematicPart(importTable.getSchematicPart());
                newImportTable.setPcbFootPrint(importTable.getPcbFootPrint());
                newImportTable.setPartsName(importTable.getPartsName());

                importTableService.save(newImportTable);
                System.out.println("新しい SS データがインポートテーブルに作成されました: " + newImportTable.getbCode());
            }
        }
    }
}
