package com.chenhy.web.rest;

import static com.chenhy.domain.ImportSettingAsserts.*;
import static com.chenhy.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.chenhy.IntegrationTest;
import com.chenhy.domain.ImportSetting;
import com.chenhy.repository.ImportSettingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link ImportSettingResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ImportSettingResourceIT {

    private static final String DEFAULT_TCIS_CODE = "AAAAAAAAAA";
    private static final String UPDATED_TCIS_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_TCIS_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TCIS_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_TCIS_INCOL = "AAAAAAAAAA";
    private static final String UPDATED_TCIS_INCOL = "BBBBBBBBBB";

    private static final String DEFAULT_TCIS_EDITRULE = "AAAAAAAAAA";
    private static final String UPDATED_TCIS_EDITRULE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/import-settings";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ImportSettingRepository importSettingRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restImportSettingMockMvc;

    private ImportSetting importSetting;

    private ImportSetting insertedImportSetting;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ImportSetting createEntity() {
        return new ImportSetting()
            .tcisCode(DEFAULT_TCIS_CODE)
            .tcisType(DEFAULT_TCIS_TYPE)
            .tcisIncol(DEFAULT_TCIS_INCOL)
            .tcisEditrule(DEFAULT_TCIS_EDITRULE);
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ImportSetting createUpdatedEntity() {
        return new ImportSetting()
            .tcisCode(UPDATED_TCIS_CODE)
            .tcisType(UPDATED_TCIS_TYPE)
            .tcisIncol(UPDATED_TCIS_INCOL)
            .tcisEditrule(UPDATED_TCIS_EDITRULE);
    }

    @BeforeEach
    public void initTest() {
        importSetting = createEntity();
    }

    @AfterEach
    public void cleanup() {
        if (insertedImportSetting != null) {
            importSettingRepository.delete(insertedImportSetting);
            insertedImportSetting = null;
        }
    }

    @Test
    @Transactional
    void createImportSetting() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ImportSetting
        var returnedImportSetting = om.readValue(
            restImportSettingMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(importSetting))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ImportSetting.class
        );

        // Validate the ImportSetting in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertImportSettingUpdatableFieldsEquals(returnedImportSetting, getPersistedImportSetting(returnedImportSetting));

        insertedImportSetting = returnedImportSetting;
    }

    @Test
    @Transactional
    void createImportSettingWithExistingId() throws Exception {
        // Create the ImportSetting with an existing ID
        importSetting.setId(1L);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restImportSettingMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(importSetting)))
            .andExpect(status().isBadRequest());

        // Validate the ImportSetting in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllImportSettings() throws Exception {
        // Initialize the database
        insertedImportSetting = importSettingRepository.saveAndFlush(importSetting);

        // Get all the importSettingList
        restImportSettingMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(importSetting.getId().intValue())))
            .andExpect(jsonPath("$.[*].tcisCode").value(hasItem(DEFAULT_TCIS_CODE)))
            .andExpect(jsonPath("$.[*].tcisType").value(hasItem(DEFAULT_TCIS_TYPE)))
            .andExpect(jsonPath("$.[*].tcisIncol").value(hasItem(DEFAULT_TCIS_INCOL)))
            .andExpect(jsonPath("$.[*].tcisEditrule").value(hasItem(DEFAULT_TCIS_EDITRULE)));
    }

    @Test
    @Transactional
    void getImportSetting() throws Exception {
        // Initialize the database
        insertedImportSetting = importSettingRepository.saveAndFlush(importSetting);

        // Get the importSetting
        restImportSettingMockMvc
            .perform(get(ENTITY_API_URL_ID, importSetting.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(importSetting.getId().intValue()))
            .andExpect(jsonPath("$.tcisCode").value(DEFAULT_TCIS_CODE))
            .andExpect(jsonPath("$.tcisType").value(DEFAULT_TCIS_TYPE))
            .andExpect(jsonPath("$.tcisIncol").value(DEFAULT_TCIS_INCOL))
            .andExpect(jsonPath("$.tcisEditrule").value(DEFAULT_TCIS_EDITRULE));
    }

    @Test
    @Transactional
    void getNonExistingImportSetting() throws Exception {
        // Get the importSetting
        restImportSettingMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingImportSetting() throws Exception {
        // Initialize the database
        insertedImportSetting = importSettingRepository.saveAndFlush(importSetting);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the importSetting
        ImportSetting updatedImportSetting = importSettingRepository.findById(importSetting.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedImportSetting are not directly saved in db
        em.detach(updatedImportSetting);
        updatedImportSetting
            .tcisCode(UPDATED_TCIS_CODE)
            .tcisType(UPDATED_TCIS_TYPE)
            .tcisIncol(UPDATED_TCIS_INCOL)
            .tcisEditrule(UPDATED_TCIS_EDITRULE);

        restImportSettingMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedImportSetting.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedImportSetting))
            )
            .andExpect(status().isOk());

        // Validate the ImportSetting in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedImportSettingToMatchAllProperties(updatedImportSetting);
    }

    @Test
    @Transactional
    void putNonExistingImportSetting() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importSetting.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restImportSettingMockMvc
            .perform(
                put(ENTITY_API_URL_ID, importSetting.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(importSetting))
            )
            .andExpect(status().isBadRequest());

        // Validate the ImportSetting in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchImportSetting() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importSetting.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restImportSettingMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(importSetting))
            )
            .andExpect(status().isBadRequest());

        // Validate the ImportSetting in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamImportSetting() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importSetting.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restImportSettingMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(importSetting)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ImportSetting in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateImportSettingWithPatch() throws Exception {
        // Initialize the database
        insertedImportSetting = importSettingRepository.saveAndFlush(importSetting);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the importSetting using partial update
        ImportSetting partialUpdatedImportSetting = new ImportSetting();
        partialUpdatedImportSetting.setId(importSetting.getId());

        partialUpdatedImportSetting.tcisIncol(UPDATED_TCIS_INCOL).tcisEditrule(UPDATED_TCIS_EDITRULE);

        restImportSettingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedImportSetting.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedImportSetting))
            )
            .andExpect(status().isOk());

        // Validate the ImportSetting in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertImportSettingUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedImportSetting, importSetting),
            getPersistedImportSetting(importSetting)
        );
    }

    @Test
    @Transactional
    void fullUpdateImportSettingWithPatch() throws Exception {
        // Initialize the database
        insertedImportSetting = importSettingRepository.saveAndFlush(importSetting);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the importSetting using partial update
        ImportSetting partialUpdatedImportSetting = new ImportSetting();
        partialUpdatedImportSetting.setId(importSetting.getId());

        partialUpdatedImportSetting
            .tcisCode(UPDATED_TCIS_CODE)
            .tcisType(UPDATED_TCIS_TYPE)
            .tcisIncol(UPDATED_TCIS_INCOL)
            .tcisEditrule(UPDATED_TCIS_EDITRULE);

        restImportSettingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedImportSetting.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedImportSetting))
            )
            .andExpect(status().isOk());

        // Validate the ImportSetting in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertImportSettingUpdatableFieldsEquals(partialUpdatedImportSetting, getPersistedImportSetting(partialUpdatedImportSetting));
    }

    @Test
    @Transactional
    void patchNonExistingImportSetting() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importSetting.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restImportSettingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, importSetting.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(importSetting))
            )
            .andExpect(status().isBadRequest());

        // Validate the ImportSetting in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchImportSetting() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importSetting.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restImportSettingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(importSetting))
            )
            .andExpect(status().isBadRequest());

        // Validate the ImportSetting in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamImportSetting() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importSetting.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restImportSettingMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(importSetting))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ImportSetting in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteImportSetting() throws Exception {
        // Initialize the database
        insertedImportSetting = importSettingRepository.saveAndFlush(importSetting);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the importSetting
        restImportSettingMockMvc
            .perform(delete(ENTITY_API_URL_ID, importSetting.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return importSettingRepository.count();
    }

    protected void assertIncrementedRepositoryCount(long countBefore) {
        assertThat(countBefore + 1).isEqualTo(getRepositoryCount());
    }

    protected void assertDecrementedRepositoryCount(long countBefore) {
        assertThat(countBefore - 1).isEqualTo(getRepositoryCount());
    }

    protected void assertSameRepositoryCount(long countBefore) {
        assertThat(countBefore).isEqualTo(getRepositoryCount());
    }

    protected ImportSetting getPersistedImportSetting(ImportSetting importSetting) {
        return importSettingRepository.findById(importSetting.getId()).orElseThrow();
    }

    protected void assertPersistedImportSettingToMatchAllProperties(ImportSetting expectedImportSetting) {
        assertImportSettingAllPropertiesEquals(expectedImportSetting, getPersistedImportSetting(expectedImportSetting));
    }

    protected void assertPersistedImportSettingToMatchUpdatableProperties(ImportSetting expectedImportSetting) {
        assertImportSettingAllUpdatablePropertiesEquals(expectedImportSetting, getPersistedImportSetting(expectedImportSetting));
    }
}
