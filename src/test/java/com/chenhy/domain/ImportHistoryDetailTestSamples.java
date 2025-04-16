package com.chenhy.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class ImportHistoryDetailTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static ImportHistoryDetail getImportHistoryDetailSample1() {
        return new ImportHistoryDetail()
            .id(1L)
            .uuid(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .tcihdPid("tcihdPid1")
            .tcihdLine("tcihdLine1")
            .tcihdError("tcihdError1")
            .createBy("createBy1")
            .updateBy("updateBy1")
            .remark("remark1");
    }

    public static ImportHistoryDetail getImportHistoryDetailSample2() {
        return new ImportHistoryDetail()
            .id(2L)
            .uuid(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .tcihdPid("tcihdPid2")
            .tcihdLine("tcihdLine2")
            .tcihdError("tcihdError2")
            .createBy("createBy2")
            .updateBy("updateBy2")
            .remark("remark2");
    }

    public static ImportHistoryDetail getImportHistoryDetailRandomSampleGenerator() {
        return new ImportHistoryDetail()
            .id(longCount.incrementAndGet())
            .uuid(UUID.randomUUID())
            .tcihdPid(UUID.randomUUID().toString())
            .tcihdLine(UUID.randomUUID().toString())
            .tcihdError(UUID.randomUUID().toString())
            .createBy(UUID.randomUUID().toString())
            .updateBy(UUID.randomUUID().toString())
            .remark(UUID.randomUUID().toString());
    }
}
