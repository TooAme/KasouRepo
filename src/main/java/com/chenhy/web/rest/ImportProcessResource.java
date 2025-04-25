package com.chenhy.web.rest;

import static java.lang.Long.valueOf;

import com.chenhy.domain.ImportTable;
import com.chenhy.repository.ImportTableRepository;
import com.chenhy.service.ImportHistoryDetailService;
import com.chenhy.service.ImportHistoryService;
import com.chenhy.service.ImportTableService;
import jakarta.persistence.criteria.CriteriaBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Instant;
import java.util.*;
import java.util.regex.*;
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
        //System.out.println(filePath);
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
            //System.out.println("Processing normalFile");
            processNormalFile(file);
        }
        for (File file : ssListFile) {
            //System.out.println("Processing ssListFile");
            processSsListFile(file);
        }
    }

    private void processNormalFile(File file) {
        System.out.println("普通単品ファイルの取り扱いでいます: " + file.getName());

        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(1); // 获取第二个工作表
            Row characteristicRow = workbook.getSheetAt(1).getRow(2);

            String mattanName = getCellValue(sheet.getRow(2).getCell(11));
            // 遍历第 11 行到最后一行的数据
            for (int rowIndex = 10; rowIndex <= sheet.getLastRowNum(); rowIndex++) { // 第 11 行的索引为 10
                Row row = sheet.getRow(rowIndex);
                if (row == null) {
                    continue; // 跳过空行
                }

                if ("DEL".equals(getCellValue(row.getCell(13)))) { // flag为DEL删除该行重来
                    sheet.removeRow(row); // 物理删除
                    Optional<ImportTable> existingTable = importTableRepository.findByBCode(
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(APP004)管理番号")))
                    );
                    // 实体数据删除
                    existingTable.ifPresent(importTable -> importTableService.delete(importTable.getId()));
                    rowIndex--;
                    continue;
                }

                // 获取 bcode 値
                String bcode = getCellValue(row.getCell(getCellPos(characteristicRow, "(APP004)管理番号")));
                if (bcode == null || bcode.isEmpty()) {
                    continue; // 如果 bcode 为空，跳过当前行
                }

                // 检查数据是否存在
                Optional<ImportTable> existingTable = importTableRepository.findByBCode(bcode);
                ImportTable importTable;
                if (existingTable.isPresent()) {
                    // 如果数据已存在，更新该条记录
                    importTable = existingTable.get();
                    System.out.println("管理番号に従ってデータを更新中: " + bcode);
                    importTable.setUpdateBy(System.getProperty("user.name"));
                    importTable.setUpdateTime(Instant.now());

                    if (
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(APP078)型番（新）"))).equals("N/A")
                    ) importTable.setPartNumber(getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE010)型番"))));
                    else importTable.setPartNumber(getCellValue(row.getCell(getCellPos(characteristicRow, "(APP078)型番（新）")))); // 型番
                } else {
                    // 如果数据不存在，创建新记录
                    importTable = new ImportTable();
                    System.out.println("管理番号から新しいデータを作成中: " + bcode);

                    UUID uuid = UUID.randomUUID();
                    importTable.setUuid(uuid); // uuid

                    importTable.setbCode(bcode);

                    importTable.setDelFlag(true);
                    importTable.setItemRegistrationClassification(3);

                    if (
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(APP078)型番（新）"))).equals("N/A")
                    ) importTable.setPartNumber(getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE010)型番"))));
                    else importTable.setPartNumber(getCellValue(row.getCell(getCellPos(characteristicRow, "(APP078)型番（新）")))); // 型番

                    if (
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(APP079)メーカ(新)"))).equals("N/A")
                    ) importTable.setManufacture(getCellValue(row.getCell(getCellPos(characteristicRow, "(APP001)メーカ"))));
                    else importTable.setManufacture(getCellValue(row.getCell(getCellPos(characteristicRow, "(APP079)メーカ(新)")))); // manufacture

                    importTable.setCreateBy(System.getProperty("user.name"));
                    importTable.setCreateTime(Instant.now());
                    importTable.setUpdateBy(System.getProperty("user.name"));
                    importTable.setUpdateTime(Instant.now()); // 创建同时也是更新

                    System.out.println("末端分類名: " + mattanName);
                    importTable.setPartType(mattanName);
                    int attributeRow = 0;
                    attributeRow = findRow2(mattanName);
                    System.out.println("属性項目対応表に対応行: Row" + attributeRow);
                    FileInputStream fis2 = new FileInputStream("属性項目対応表.xlsx");
                    Workbook attributeWorkbook = new XSSFWorkbook(fis2);
                    Sheet attributeSheet = attributeWorkbook.getSheetAt(0);

                    String valueFlag = String.valueOf(attributeSheet.getRow(attributeRow - 2).getCell(6)); // Value栏日语在上一行所以减一
                    switch (valueFlag) {
                        case "定数" -> {
                            String value =
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(APP085)定数"))) +
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(APP085)定数_単位")));
                            importTable.setValue(
                                value.isEmpty()
                                    ? ""
                                    : (int) Double.parseDouble(getCellValue(row.getCell(getCellPos(characteristicRow, "(APP085)定数")))) +
                                    getCellValue(row.getCell(getCellPos(characteristicRow, "(APP085)定数_単位")))
                            );
                        }
                        case "なし" -> importTable.setValue("");
                        case "型番" -> {
                            if (getCellValue(row.getCell(getCellPos(characteristicRow, "(APP078)型番（新）"))).equals("N/A")) {
                                String value = getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE010)型番")));
                                importTable.setValue(value.isEmpty() ? "" : value);
                            } else {
                                String value = getCellValue(row.getCell(getCellPos(characteristicRow, "(APP078)型番（新）")));
                                importTable.setValue(value.isEmpty() ? "" : value); // 型番;
                            }
                        }
                        case "公称電圧" -> {
                            String value =
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJL551)公称電圧"))) +
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJL551)公称電圧_単位")));
                            importTable.setValue(
                                value.isEmpty()
                                    ? ""
                                    : (int) Double.parseDouble(
                                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJL551)公称電圧")))
                                    ) +
                                    getCellValue(row.getCell(getCellPos(characteristicRow, "(XJL551)公称電圧_単位")))
                            );
                        }
                        case "定格電流" -> {
                            String value =
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJF003)定格電流"))) +
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJF003)定格電流_単位")));
                            importTable.setValue(
                                value.isEmpty()
                                    ? ""
                                    : (int) Double.parseDouble(
                                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJF003)定格電流")))
                                    ) +
                                    getCellValue(row.getCell(getCellPos(characteristicRow, "(XJF003)定格電流_単位")))
                            );
                        }
                        case "端子の種類" -> {
                            String value = getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK943)端子の種類")));
                            importTable.setValue(value.isEmpty() ? "" : value);
                        }
                        case "動作温度（ヒューズ）" -> {
                            String value =
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJF892)動作温度（ヒューズ）"))) +
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJF892)動作温度（ヒューズ）_単位")));
                            importTable.setValue(
                                value.isEmpty()
                                    ? ""
                                    : (int) Double.parseDouble(
                                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJF892)動作温度（ヒューズ）")))
                                    ) +
                                    getCellValue(row.getCell(getCellPos(characteristicRow, "(XJF892)動作温度（ヒューズ）_単位")))
                            );
                        }
                        case "適合DIMM種別" -> {
                            String value = getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK257)適合DIMM種別")));
                            importTable.setValue(value.isEmpty() ? "" : value);
                        }
                        case "サイズ" -> {
                            String value = getCellValue(row.getCell(getCellPos(characteristicRow, "(APP010)サイズ")));
                            importTable.setValue(value.isEmpty() ? "" : value);
                        }
                        case "発信周波数" -> {
                            String value =
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK413)発振周波数"))) +
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK413)発振周波数_単位")));
                            importTable.setValue(
                                value.isEmpty()
                                    ? ""
                                    : (int) Double.parseDouble(
                                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK413)発振周波数")))
                                    ) +
                                    getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK413)発振周波数_単位")))
                            );
                        }
                        case "公称周波数" -> {
                            String value =
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE386)公称周波数"))) +
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE386)公称周波数_単位")));
                            importTable.setValue(
                                value.isEmpty()
                                    ? ""
                                    : (int) Double.parseDouble(
                                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE386)公称周波数")))
                                    ) +
                                    getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE386)公称周波数_単位")))
                            );
                        }
                        case "最大静電容量(公称値)" -> {
                            String value =
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE331)最大静電容量（公称値）"))) +
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE331)最大静電容量（公称値）_単位")));
                            importTable.setValue(
                                value.isEmpty()
                                    ? ""
                                    : (int) Double.parseDouble(
                                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE331)最大静電容量（公称値）")))
                                    ) +
                                    getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE331)最大静電容量（公称値）_単位")))
                            );
                        }
                        case "公称ゼロ負荷抵抗値" -> {
                            String value =
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJG661)公称ゼロ負荷抵抗値"))) +
                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJG661)公称ゼロ負荷抵抗値_単位")));
                            importTable.setValue(
                                value.isEmpty()
                                    ? ""
                                    : (int) Double.parseDouble(
                                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJG661)公称ゼロ負荷抵抗値")))
                                    ) +
                                    getCellValue(row.getCell(getCellPos(characteristicRow, "(XJG661)公称ゼロ負荷抵抗値_単位")))
                            );
                        }
                    }

                    if (String.valueOf(attributeSheet.getRow(attributeRow - 2).getCell(9)).equals("定格電圧")) importTable.setRatingVoltage(
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJG930)定格電圧"))) +
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJG930)定格電圧_単位")))
                    );
                    if (
                        String.valueOf(attributeSheet.getRow(attributeRow - 2).getCell(11)).equals("定格電力")
                    ) importTable.setRatingElectricity(
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJF711)定格電力"))) +
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJF711)定格電力_単位")))
                    );
                    if (
                        String.valueOf(attributeSheet.getRow(attributeRow - 2).getCell(12)).equals("温度特性")
                    ) importTable.setCharacteristics(getCellValue(row.getCell(getCellPos(characteristicRow, "(XJF420)温度特性"))));
                    if (
                        String.valueOf(attributeSheet.getRow(attributeRow - 2).getCell(12)).equals("周波数温度特性")
                    ) importTable.setCharacteristics(
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE388)周波数温度特性"))) +
                        " " +
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE388)周波数温度特性_単位")))
                    );
                    if (
                        String.valueOf(attributeSheet.getRow(attributeRow - 2).getCell(13)).equals("抵抗値の許容差(+-)")
                    ) importTable.setTolerance(
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJF713)抵抗値の許容差(+-)"))) +
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJF713)抵抗値の許容差(+-)_単位")))
                    );
                    if (
                        String.valueOf(attributeSheet.getRow(attributeRow - 2).getCell(13)).equals("公称ゼロ負荷抵抗値の許容差")
                    ) importTable.setTolerance(
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJG662)公称ゼロ負荷抵抗値の許容差"))) +
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJG662)公称ゼロ負荷抵抗値の許容差_単位")))
                    );
                    if (
                        String.valueOf(attributeSheet.getRow(attributeRow - 2).getCell(13)).equals(
                            "インダクタンス許容差(最小値),インダクタンス許容差(最大値)"
                        )
                    ) importTable.setTolerance(
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE228)インダクタンス許容差（最小値）"))) +
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE228)インダクタンス許容差(最小値)_単位"))) +
                        "," +
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE228)インダクタンス許容差（最大値）"))) +
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE228)インダクタンス許容差(最大値)_単位")))
                    );
                    if (
                        String.valueOf(attributeSheet.getRow(attributeRow - 2).getCell(13)).equals(
                            "定格静電容量許容差(最小値),定格静電容量許容差(最大値)"
                        )
                    ) importTable.setTolerance(
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE261)定格静電容量許容差（最小値）"))) +
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE261)定格静電容量許容差（最小値）_単位"))) +
                        "," +
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE261)定格静電容量許容差（最大値）"))) +
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJE261)定格静電容量許容差（最大値）_単位")))
                    );
                    if (
                        String.valueOf(attributeSheet.getRow(attributeRow - 2).getCell(13)).equals(
                            "周波数許容差(最小値),周波数許容差(最大値)"
                        )
                    ) importTable.setTolerance(
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK452)周波数許容差（最小値）"))) +
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK452)周波数許容差（最小値）_単位"))) +
                        "," +
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK452)周波数許容差（最大値）"))) +
                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK452)周波数許容差（最大値）_単位")))
                    );

                    importTable.setPartsName(String.valueOf(attributeSheet.getRow(attributeRow - 2).getCell(17)));
                    if (String.valueOf(attributeSheet.getRow(attributeRow - 2).getCell(17)).equals("なし")) importTable.setPartsName("");

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
                        } else {
                            LW = 0;
                        }
                    }

                    //                    if (mattanName.contains("コンデンサ") || mattanName.contains("抵抗器")) {
                    //                        if (!getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK639)本体長さ（代表値）"))).isEmpty()) {
                    //                            if (!getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK640)本体幅（代表値）"))).isEmpty()) LW =
                    //                                (int) (Double.parseDouble(
                    //                                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK639)本体長さ（代表値）")))
                    //                                    ) *
                    //                                    1000) +
                    //                                (int) (Double.parseDouble(
                    //                                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK640)本体幅（代表値）")))
                    //                                    ) *
                    //                                    10);
                    //                            else if (
                    //                                getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK640)本体幅（代表値）"))).isEmpty()
                    //                            ) {
                    //                                LW =
                    //                                    (int) (Double.parseDouble(
                    //                                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK639)本体長さ（代表値）")))
                    //                                        ) *
                    //                                        1000) +
                    //                                    (int) (Double.parseDouble(
                    //                                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK640)本体幅（最大値）")))
                    //                                        ) *
                    //                                        10);
                    //                            }
                    //                        } else {
                    //                            if (
                    //                                !getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK640)本体幅（代表値）"))).isEmpty() &&
                    //                                !getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK639)本体長さ（最大値）"))).isEmpty()
                    //                            ) LW =
                    //                                (int) (Double.parseDouble(
                    //                                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK639)本体長さ（最大値）")))
                    //                                    ) *
                    //                                    1000) +
                    //                                (int) (Double.parseDouble(
                    //                                        getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK640)本体幅（代表値）")))
                    //                                    ) *
                    //                                    10);
                    //                            else if (
                    //                                !getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK640)本体幅（最大値）"))).isEmpty() &&
                    //                                !getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK639)本体長さ（代表値）"))).isEmpty()
                    //                            ) {
                    //                                LW =
                    //                                    (int) (Double.parseDouble(
                    //                                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK639)本体長さ（代表値）")))
                    //                                        ) *
                    //                                        1000) +
                    //                                    (int) (Double.parseDouble(
                    //                                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK640)本体幅（最大値）")))
                    //                                        ) *
                    //                                        10);
                    //                            } else if (
                    //                                !getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK640)本体幅（最大値）"))).isEmpty() &&
                    //                                !getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK639)本体長さ（最大値）"))).isEmpty()
                    //                            ) {
                    //                                LW =
                    //                                    (int) (Double.parseDouble(
                    //                                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK639)本体長さ（最大値）")))
                    //                                        ) *
                    //                                        1000) +
                    //                                    (int) (Double.parseDouble(
                    //                                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK640)本体幅（最大値）")))
                    //                                        ) *
                    //                                        10);
                    //                            }
                    //                        }
                    //                        if (
                    //                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK639)本体長さ（代表値）"))).isEmpty() &&
                    //                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK639)本体長さ（最大値）"))).isEmpty()
                    //                        ) LW = 0;
                    //                        if (
                    //                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK640)本体幅（代表値）"))).isEmpty() &&
                    //                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJK640)本体幅（最大値）"))).isEmpty()
                    //                        ) LW = 0;
                    //                    }

                    if (mattanName.contains("電解コンデンサ")) { //Schematic Part & Pcb FootPrint
                        importTable.setSchematicPart("CE");

                        if (
                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJL582)実装方法※1"))).equals("基板挿入")
                        ) importTable.setPcbFootPrint("CE_" + LW + "_DIP");
                        else importTable.setPcbFootPrint("CE_" + LW);
                    } else if (mattanName.contains("コンデンサ") && !mattanName.contains("電解コンデンサ")) {
                        importTable.setSchematicPart("C");

                        //                        LW =
                        //                            (int) Double.parseDouble(getCellValue(row.getCell(42))) * 1000 +
                        //                            (int) Double.parseDouble(getCellValue(row.getCell(46))) * 10;
                        if (
                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJL582)実装方法※1"))).equals("基板挿入")
                        ) importTable.setPcbFootPrint("C_" + LW + "_DIP");
                        else importTable.setPcbFootPrint("C_" + LW);
                    } else if (mattanName.contains("固定抵抗器")) {
                        importTable.setSchematicPart("R");

                        //                        LW =
                        //                            (int) Double.parseDouble(getCellValue(row.getCell(42))) * 1000 +
                        //                            (int) Double.parseDouble(getCellValue(row.getCell(46))) * 10;
                        if (
                            getCellValue(row.getCell(getCellPos(characteristicRow, "(XJL582)実装方法※1"))).equals("基板挿入")
                        ) importTable.setPcbFootPrint("R_" + LW + "_DIP");
                        else importTable.setPcbFootPrint("R_" + LW);
                    } else if (mattanName.contains("可変抵抗器")) {
                        importTable.setSchematicPart("VR");

                        //                        LW =
                        //                            (int) Double.parseDouble(getCellValue(row.getCell(42))) * 1000 +
                        //                            (int) Double.parseDouble(getCellValue(row.getCell(46))) * 10;
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
                    if (LW == 0) importTable.setPcbFootPrint("");
                }

                // 调用服务保存或更新记录
                importTableService.save(importTable);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取单元格字符串
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
        System.out.println("SSリストファイル処理中:" + file.getName());
        // ss清单文件处理
    }

    public String getMiddlePart(String fileName) { // 从文件名获取parttype
        String nameWithoutExt = fileName.replaceFirst("\\.[^.]+$", "");

        // 使用正则表达式匹配最后一个下划线后的非版本号部分
        Pattern pattern = Pattern.compile(".*_(?!v\\d+$)([^_]+)(?:_v\\d+)?$");
        Matcher matcher = pattern.matcher(nameWithoutExt);

        if (matcher.find()) {
            return matcher.group(1);
        }

        // 如果没有找到匹配的模式，尝试另一种简单分割方式
        String[] parts = nameWithoutExt.split("_");
        if (parts.length > 1) {
            // 检查最后一部分是否是版本号（如v3）
            if (parts[parts.length - 1].matches("v\\d+")) {
                return parts[parts.length - 2];
            } else {
                return parts[parts.length - 1];
            }
        }

        // 如果都不匹配，返回整个文件名（不含扩展名）
        return nameWithoutExt;
    }

    public static int findRow(String targetString) { // 查找parttype在属性項目対応表.xlsx中の行数
        try (FileInputStream fis = new FileInputStream("属性項目対応表.xlsx"); Workbook workbook = new XSSFWorkbook(fis)) {
            // 获取第一个Sheet
            Sheet sheet = workbook.getSheetAt(0);
            // 从第11行开始查找（行号从0开始，第11行对应索引10）
            for (int i = 10; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    // 只检查B、C、D三列（列号从0开始，B列对应索引1，C列对应索引2，D列对应索引3）
                    for (int colIndex = 1; colIndex <= 3; colIndex++) {
                        Cell cell = row.getCell(colIndex);
                        if (cell != null) {
                            String cellValue = cell.toString();
                            if (targetString.equals(cellValue)) {
                                // 返回行号（从1开始计数）
                                return i + 1;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 如果没有找到，返回-1
        return -1;
    }

    public int findRow2(String searchString) throws IOException {
        List<Integer> matchingRows = new ArrayList<>();

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

    private static String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }

    private Integer getCellPos(Row row, String searchString) {
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
}
