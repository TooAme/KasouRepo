package com.chenhy.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class ImportSettingTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static ImportSetting getImportSettingSample1() {
        return new ImportSetting().id(1L).tcisCode("tcisCode1").tcisType("tcisType1").tcisIncol("tcisIncol1").tcisEditrule("tcisEditrule1");
    }

    public static ImportSetting getImportSettingSample2() {
        return new ImportSetting().id(2L).tcisCode("tcisCode2").tcisType("tcisType2").tcisIncol("tcisIncol2").tcisEditrule("tcisEditrule2");
    }

    public static ImportSetting getImportSettingRandomSampleGenerator() {
        return new ImportSetting()
            .id(longCount.incrementAndGet())
            .tcisCode(UUID.randomUUID().toString())
            .tcisType(UUID.randomUUID().toString())
            .tcisIncol(UUID.randomUUID().toString())
            .tcisEditrule(UUID.randomUUID().toString());
    }
}
