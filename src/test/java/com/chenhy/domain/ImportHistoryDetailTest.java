package com.chenhy.domain;

import static com.chenhy.domain.ImportHistoryDetailTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.chenhy.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ImportHistoryDetailTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ImportHistoryDetail.class);
        ImportHistoryDetail importHistoryDetail1 = getImportHistoryDetailSample1();
        ImportHistoryDetail importHistoryDetail2 = new ImportHistoryDetail();
        assertThat(importHistoryDetail1).isNotEqualTo(importHistoryDetail2);

        importHistoryDetail2.setId(importHistoryDetail1.getId());
        assertThat(importHistoryDetail1).isEqualTo(importHistoryDetail2);

        importHistoryDetail2 = getImportHistoryDetailSample2();
        assertThat(importHistoryDetail1).isNotEqualTo(importHistoryDetail2);
    }
}
