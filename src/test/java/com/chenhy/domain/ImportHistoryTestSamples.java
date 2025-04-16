package com.chenhy.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class ImportHistoryTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static ImportHistory getImportHistorySample1() {
        return new ImportHistory()
            .id(1L)
            .uuid(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .tcihCode("tcihCode1")
            .tcihFilename("tcihFilename1")
            .createBy("createBy1")
            .updateBy("updateBy1")
            .remark("remark1");
    }

    public static ImportHistory getImportHistorySample2() {
        return new ImportHistory()
            .id(2L)
            .uuid(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .tcihCode("tcihCode2")
            .tcihFilename("tcihFilename2")
            .createBy("createBy2")
            .updateBy("updateBy2")
            .remark("remark2");
    }

    public static ImportHistory getImportHistoryRandomSampleGenerator() {
        return new ImportHistory()
            .id(longCount.incrementAndGet())
            .uuid(UUID.randomUUID())
            .tcihCode(UUID.randomUUID().toString())
            .tcihFilename(UUID.randomUUID().toString())
            .createBy(UUID.randomUUID().toString())
            .updateBy(UUID.randomUUID().toString())
            .remark(UUID.randomUUID().toString());
    }
}
