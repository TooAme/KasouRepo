package com.chenhy.domain;

import static com.chenhy.domain.ImportHistoryTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.chenhy.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ImportHistoryTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ImportHistory.class);
        ImportHistory importHistory1 = getImportHistorySample1();
        ImportHistory importHistory2 = new ImportHistory();
        assertThat(importHistory1).isNotEqualTo(importHistory2);

        importHistory2.setId(importHistory1.getId());
        assertThat(importHistory1).isEqualTo(importHistory2);

        importHistory2 = getImportHistorySample2();
        assertThat(importHistory1).isNotEqualTo(importHistory2);
    }
}
