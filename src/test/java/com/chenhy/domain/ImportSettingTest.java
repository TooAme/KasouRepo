package com.chenhy.domain;

import static com.chenhy.domain.ImportSettingTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.chenhy.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ImportSettingTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ImportSetting.class);
        ImportSetting importSetting1 = getImportSettingSample1();
        ImportSetting importSetting2 = new ImportSetting();
        assertThat(importSetting1).isNotEqualTo(importSetting2);

        importSetting2.setId(importSetting1.getId());
        assertThat(importSetting1).isEqualTo(importSetting2);

        importSetting2 = getImportSettingSample2();
        assertThat(importSetting1).isNotEqualTo(importSetting2);
    }
}
