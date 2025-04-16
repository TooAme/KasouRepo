package com.chenhy.web.rest;

import static com.chenhy.domain.ImportHistoryAsserts.*;
import static com.chenhy.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.chenhy.IntegrationTest;
import com.chenhy.domain.ImportHistory;
import com.chenhy.repository.ImportHistoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.UUID;
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
 * Integration tests for the {@link ImportHistoryResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ImportHistoryResourceIT {

    private static final UUID DEFAULT_UUID = UUID.randomUUID();
    private static final UUID UPDATED_UUID = UUID.randomUUID();

    private static final String DEFAULT_TCIH_CODE = "AAAAAAAAAA";
    private static final String UPDATED_TCIH_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_TCIH_FILENAME = "AAAAAAAAAA";
    private static final String UPDATED_TCIH_FILENAME = "BBBBBBBBBB";

    private static final Instant DEFAULT_TCIH_IMPORTTIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_TCIH_IMPORTTIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_TCIH_STATUS = false;
    private static final Boolean UPDATED_TCIH_STATUS = true;

    private static final String DEFAULT_CREATE_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_UPDATE_BY = "AAAAAAAAAA";
    private static final String UPDATED_UPDATE_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_UPDATE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_DEL_FLAG = false;
    private static final Boolean UPDATED_DEL_FLAG = true;

    private static final String DEFAULT_REMARK = "AAAAAAAAAA";
    private static final String UPDATED_REMARK = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/import-histories";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ImportHistoryRepository importHistoryRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restImportHistoryMockMvc;

    private ImportHistory importHistory;

    private ImportHistory insertedImportHistory;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ImportHistory createEntity() {
        return new ImportHistory()
            .uuid(DEFAULT_UUID)
            .tcihCode(DEFAULT_TCIH_CODE)
            .tcihFilename(DEFAULT_TCIH_FILENAME)
            .tcihImporttime(DEFAULT_TCIH_IMPORTTIME)
            .tcihStatus(DEFAULT_TCIH_STATUS)
            .createBy(DEFAULT_CREATE_BY)
            .createTime(DEFAULT_CREATE_TIME)
            .updateBy(DEFAULT_UPDATE_BY)
            .updateTime(DEFAULT_UPDATE_TIME)
            .delFlag(DEFAULT_DEL_FLAG)
            .remark(DEFAULT_REMARK);
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ImportHistory createUpdatedEntity() {
        return new ImportHistory()
            .uuid(UPDATED_UUID)
            .tcihCode(UPDATED_TCIH_CODE)
            .tcihFilename(UPDATED_TCIH_FILENAME)
            .tcihImporttime(UPDATED_TCIH_IMPORTTIME)
            .tcihStatus(UPDATED_TCIH_STATUS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .updateTime(UPDATED_UPDATE_TIME)
            .delFlag(UPDATED_DEL_FLAG)
            .remark(UPDATED_REMARK);
    }

    @BeforeEach
    public void initTest() {
        importHistory = createEntity();
    }

    @AfterEach
    public void cleanup() {
        if (insertedImportHistory != null) {
            importHistoryRepository.delete(insertedImportHistory);
            insertedImportHistory = null;
        }
    }

    @Test
    @Transactional
    void createImportHistory() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ImportHistory
        var returnedImportHistory = om.readValue(
            restImportHistoryMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(importHistory))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ImportHistory.class
        );

        // Validate the ImportHistory in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertImportHistoryUpdatableFieldsEquals(returnedImportHistory, getPersistedImportHistory(returnedImportHistory));

        insertedImportHistory = returnedImportHistory;
    }

    @Test
    @Transactional
    void createImportHistoryWithExistingId() throws Exception {
        // Create the ImportHistory with an existing ID
        importHistory.setId(1L);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restImportHistoryMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(importHistory)))
            .andExpect(status().isBadRequest());

        // Validate the ImportHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkUuidIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        importHistory.setUuid(null);

        // Create the ImportHistory, which fails.

        restImportHistoryMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(importHistory)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllImportHistories() throws Exception {
        // Initialize the database
        insertedImportHistory = importHistoryRepository.saveAndFlush(importHistory);

        // Get all the importHistoryList
        restImportHistoryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(importHistory.getId().intValue())))
            .andExpect(jsonPath("$.[*].uuid").value(hasItem(DEFAULT_UUID.toString())))
            .andExpect(jsonPath("$.[*].tcihCode").value(hasItem(DEFAULT_TCIH_CODE)))
            .andExpect(jsonPath("$.[*].tcihFilename").value(hasItem(DEFAULT_TCIH_FILENAME)))
            .andExpect(jsonPath("$.[*].tcihImporttime").value(hasItem(DEFAULT_TCIH_IMPORTTIME.toString())))
            .andExpect(jsonPath("$.[*].tcihStatus").value(hasItem(DEFAULT_TCIH_STATUS)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG)))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK)));
    }

    @Test
    @Transactional
    void getImportHistory() throws Exception {
        // Initialize the database
        insertedImportHistory = importHistoryRepository.saveAndFlush(importHistory);

        // Get the importHistory
        restImportHistoryMockMvc
            .perform(get(ENTITY_API_URL_ID, importHistory.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(importHistory.getId().intValue()))
            .andExpect(jsonPath("$.uuid").value(DEFAULT_UUID.toString()))
            .andExpect(jsonPath("$.tcihCode").value(DEFAULT_TCIH_CODE))
            .andExpect(jsonPath("$.tcihFilename").value(DEFAULT_TCIH_FILENAME))
            .andExpect(jsonPath("$.tcihImporttime").value(DEFAULT_TCIH_IMPORTTIME.toString()))
            .andExpect(jsonPath("$.tcihStatus").value(DEFAULT_TCIH_STATUS))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.toString()))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK));
    }

    @Test
    @Transactional
    void getNonExistingImportHistory() throws Exception {
        // Get the importHistory
        restImportHistoryMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingImportHistory() throws Exception {
        // Initialize the database
        insertedImportHistory = importHistoryRepository.saveAndFlush(importHistory);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the importHistory
        ImportHistory updatedImportHistory = importHistoryRepository.findById(importHistory.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedImportHistory are not directly saved in db
        em.detach(updatedImportHistory);
        updatedImportHistory
            .uuid(UPDATED_UUID)
            .tcihCode(UPDATED_TCIH_CODE)
            .tcihFilename(UPDATED_TCIH_FILENAME)
            .tcihImporttime(UPDATED_TCIH_IMPORTTIME)
            .tcihStatus(UPDATED_TCIH_STATUS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .updateTime(UPDATED_UPDATE_TIME)
            .delFlag(UPDATED_DEL_FLAG)
            .remark(UPDATED_REMARK);

        restImportHistoryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedImportHistory.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedImportHistory))
            )
            .andExpect(status().isOk());

        // Validate the ImportHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedImportHistoryToMatchAllProperties(updatedImportHistory);
    }

    @Test
    @Transactional
    void putNonExistingImportHistory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importHistory.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restImportHistoryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, importHistory.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(importHistory))
            )
            .andExpect(status().isBadRequest());

        // Validate the ImportHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchImportHistory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importHistory.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restImportHistoryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(importHistory))
            )
            .andExpect(status().isBadRequest());

        // Validate the ImportHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamImportHistory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importHistory.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restImportHistoryMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(importHistory)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ImportHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateImportHistoryWithPatch() throws Exception {
        // Initialize the database
        insertedImportHistory = importHistoryRepository.saveAndFlush(importHistory);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the importHistory using partial update
        ImportHistory partialUpdatedImportHistory = new ImportHistory();
        partialUpdatedImportHistory.setId(importHistory.getId());

        partialUpdatedImportHistory
            .tcihFilename(UPDATED_TCIH_FILENAME)
            .tcihImporttime(UPDATED_TCIH_IMPORTTIME)
            .tcihStatus(UPDATED_TCIH_STATUS)
            .updateBy(UPDATED_UPDATE_BY)
            .delFlag(UPDATED_DEL_FLAG)
            .remark(UPDATED_REMARK);

        restImportHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedImportHistory.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedImportHistory))
            )
            .andExpect(status().isOk());

        // Validate the ImportHistory in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertImportHistoryUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedImportHistory, importHistory),
            getPersistedImportHistory(importHistory)
        );
    }

    @Test
    @Transactional
    void fullUpdateImportHistoryWithPatch() throws Exception {
        // Initialize the database
        insertedImportHistory = importHistoryRepository.saveAndFlush(importHistory);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the importHistory using partial update
        ImportHistory partialUpdatedImportHistory = new ImportHistory();
        partialUpdatedImportHistory.setId(importHistory.getId());

        partialUpdatedImportHistory
            .uuid(UPDATED_UUID)
            .tcihCode(UPDATED_TCIH_CODE)
            .tcihFilename(UPDATED_TCIH_FILENAME)
            .tcihImporttime(UPDATED_TCIH_IMPORTTIME)
            .tcihStatus(UPDATED_TCIH_STATUS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .updateTime(UPDATED_UPDATE_TIME)
            .delFlag(UPDATED_DEL_FLAG)
            .remark(UPDATED_REMARK);

        restImportHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedImportHistory.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedImportHistory))
            )
            .andExpect(status().isOk());

        // Validate the ImportHistory in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertImportHistoryUpdatableFieldsEquals(partialUpdatedImportHistory, getPersistedImportHistory(partialUpdatedImportHistory));
    }

    @Test
    @Transactional
    void patchNonExistingImportHistory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importHistory.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restImportHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, importHistory.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(importHistory))
            )
            .andExpect(status().isBadRequest());

        // Validate the ImportHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchImportHistory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importHistory.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restImportHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(importHistory))
            )
            .andExpect(status().isBadRequest());

        // Validate the ImportHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamImportHistory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importHistory.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restImportHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(importHistory))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ImportHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteImportHistory() throws Exception {
        // Initialize the database
        insertedImportHistory = importHistoryRepository.saveAndFlush(importHistory);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the importHistory
        restImportHistoryMockMvc
            .perform(delete(ENTITY_API_URL_ID, importHistory.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return importHistoryRepository.count();
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

    protected ImportHistory getPersistedImportHistory(ImportHistory importHistory) {
        return importHistoryRepository.findById(importHistory.getId()).orElseThrow();
    }

    protected void assertPersistedImportHistoryToMatchAllProperties(ImportHistory expectedImportHistory) {
        assertImportHistoryAllPropertiesEquals(expectedImportHistory, getPersistedImportHistory(expectedImportHistory));
    }

    protected void assertPersistedImportHistoryToMatchUpdatableProperties(ImportHistory expectedImportHistory) {
        assertImportHistoryAllUpdatablePropertiesEquals(expectedImportHistory, getPersistedImportHistory(expectedImportHistory));
    }
}
