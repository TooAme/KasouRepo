package com.chenhy.domain;

import static com.chenhy.domain.ImportTableTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.chenhy.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ImportTableTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ImportTable.class);
        ImportTable importTable1 = getImportTableSample1();
        ImportTable importTable2 = new ImportTable();
        assertThat(importTable1).isNotEqualTo(importTable2);

        importTable2.setId(importTable1.getId());
        assertThat(importTable1).isEqualTo(importTable2);

        importTable2 = getImportTableSample2();
        assertThat(importTable1).isNotEqualTo(importTable2);
    }
}
