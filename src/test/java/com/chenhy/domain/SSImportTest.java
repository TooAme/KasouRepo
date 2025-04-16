package com.chenhy.domain;

import static com.chenhy.domain.SSImportTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.chenhy.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SSImportTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SSImport.class);
        SSImport sSImport1 = getSSImportSample1();
        SSImport sSImport2 = new SSImport();
        assertThat(sSImport1).isNotEqualTo(sSImport2);

        sSImport2.setId(sSImport1.getId());
        assertThat(sSImport1).isEqualTo(sSImport2);

        sSImport2 = getSSImportSample2();
        assertThat(sSImport1).isNotEqualTo(sSImport2);
    }
}
