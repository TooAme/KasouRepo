package com.chenhy.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class SSImportTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static SSImport getSSImportSample1() {
        return new SSImport()
            .id(1L)
            .uuid(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .ssCreateBy("ssCreateBy1")
            .ssFilename("ssFilename1")
            .ssBCode("ssBCode1")
            .ssSubBCode("ssSubBCode1")
            .createBy("createBy1")
            .updateBy("updateBy1")
            .remark("remark1");
    }

    public static SSImport getSSImportSample2() {
        return new SSImport()
            .id(2L)
            .uuid(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .ssCreateBy("ssCreateBy2")
            .ssFilename("ssFilename2")
            .ssBCode("ssBCode2")
            .ssSubBCode("ssSubBCode2")
            .createBy("createBy2")
            .updateBy("updateBy2")
            .remark("remark2");
    }

    public static SSImport getSSImportRandomSampleGenerator() {
        return new SSImport()
            .id(longCount.incrementAndGet())
            .uuid(UUID.randomUUID())
            .ssCreateBy(UUID.randomUUID().toString())
            .ssFilename(UUID.randomUUID().toString())
            .ssBCode(UUID.randomUUID().toString())
            .ssSubBCode(UUID.randomUUID().toString())
            .createBy(UUID.randomUUID().toString())
            .updateBy(UUID.randomUUID().toString())
            .remark(UUID.randomUUID().toString());
    }
}
