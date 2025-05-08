package com.chenhy.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ImportTableTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    // 修改示例方法，移除 id 字段设置，使用新的 id 字段（原 uuid）
    public static ImportTable getImportTableSample1() {
        return new ImportTable()
            // .id(1L) 移除这一行
            .id("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa")
            .partNumber("partNumber1")
            .partType("partType1")
            .value("value1")
            .schematicPart("schematicPart1")
            .ratingVoltage("ratingVoltage1")
            .ratingElectricity("ratingElectricity1")
            .characteristics("characteristics1")
            .tolerance("tolerance1")
            .manufacture("manufacture1")
            .bCode("bCode1")
            .partsName("partsName1")
            .itemRegistrationClassification("3")
            .spiceModel("spiceModel1")
            .pcbFootPrint("pcbFootPrint1")
            .remark("remark1")
            .createBy("createBy1")
            .updateBy("updateBy1");
    }

    public static ImportTable getImportTableSample2() {
        return new ImportTable()
            // .id(2L) 移除这一行
            .id("ad79f240-3727-46c3-b89f-2cf6ebd74367")
            .partNumber("partNumber2")
            .partType("partType2")
            .value("value2")
            .schematicPart("schematicPart2")
            .ratingVoltage("ratingVoltage2")
            .ratingElectricity("ratingElectricity2")
            .characteristics("characteristics2")
            .tolerance("tolerance2")
            .manufacture("manufacture2")
            .bCode("bCode2")
            .partsName("partsName2")
            .itemRegistrationClassification("3")
            .spiceModel("spiceModel2")
            .pcbFootPrint("pcbFootPrint2")
            .remark("remark2")
            .createBy("createBy2")
            .updateBy("updateBy2");
    }

    public static ImportTable getImportTableRandomSampleGenerator() {
        return new ImportTable()
            // .id(longCount.incrementAndGet()) 移除这一行
            .id(UUID.randomUUID().toString())
            .partNumber(UUID.randomUUID().toString())
            .partType(UUID.randomUUID().toString())
            .value(UUID.randomUUID().toString())
            .schematicPart(UUID.randomUUID().toString())
            .ratingVoltage(UUID.randomUUID().toString())
            .ratingElectricity(UUID.randomUUID().toString())
            .characteristics(UUID.randomUUID().toString())
            .tolerance(UUID.randomUUID().toString())
            .manufacture(UUID.randomUUID().toString())
            .bCode(UUID.randomUUID().toString())
            .partsName(UUID.randomUUID().toString())
            .itemRegistrationClassification("3")
            .spiceModel(UUID.randomUUID().toString())
            .pcbFootPrint(UUID.randomUUID().toString())
            .remark(UUID.randomUUID().toString())
            .createBy(UUID.randomUUID().toString())
            .updateBy(UUID.randomUUID().toString());
    }
}
