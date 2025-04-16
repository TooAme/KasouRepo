package com.chenhy.web.rest;

import static com.chenhy.domain.ImportHistoryDetailAsserts.*;
import static com.chenhy.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.chenhy.IntegrationTest;
import com.chenhy.domain.ImportHistoryDetail;
import com.chenhy.repository.ImportHistoryDetailRepository;
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
 * Integration tests for the {@link ImportHistoryDetailResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ImportHistoryDetailResourceIT {

    private static final UUID DEFAULT_UUID = UUID.randomUUID();
    private static final UUID UPDATED_UUID = UUID.randomUUID();

    private static final String DEFAULT_TCIHD_PID = "AAAAAAAAAA";
    private static final String UPDATED_TCIHD_PID = "BBBBBBBBBB";

    private static final String DEFAULT_TCIHD_LINE = "AAAAAAAAAA";
    private static final String UPDATED_TCIHD_LINE = "BBBBBBBBBB";

    private static final String DEFAULT_TCIHD_ERROR = "AAAAAAAAAA";
    private static final String UPDATED_TCIHD_ERROR = "BBBBBBBBBB";

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

    private static final String ENTITY_API_URL = "/api/import-history-details";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ImportHistoryDetailRepository importHistoryDetailRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restImportHistoryDetailMockMvc;

    private ImportHistoryDetail importHistoryDetail;

    private ImportHistoryDetail insertedImportHistoryDetail;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ImportHistoryDetail createEntity() {
        return new ImportHistoryDetail()
            .uuid(DEFAULT_UUID)
            .tcihdPid(DEFAULT_TCIHD_PID)
            .tcihdLine(DEFAULT_TCIHD_LINE)
            .tcihdError(DEFAULT_TCIHD_ERROR)
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
    public static ImportHistoryDetail createUpdatedEntity() {
        return new ImportHistoryDetail()
            .uuid(UPDATED_UUID)
            .tcihdPid(UPDATED_TCIHD_PID)
            .tcihdLine(UPDATED_TCIHD_LINE)
            .tcihdError(UPDATED_TCIHD_ERROR)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .updateTime(UPDATED_UPDATE_TIME)
            .delFlag(UPDATED_DEL_FLAG)
            .remark(UPDATED_REMARK);
    }

    @BeforeEach
    public void initTest() {
        importHistoryDetail = createEntity();
    }

    @AfterEach
    public void cleanup() {
        if (insertedImportHistoryDetail != null) {
            importHistoryDetailRepository.delete(insertedImportHistoryDetail);
            insertedImportHistoryDetail = null;
        }
    }

    @Test
    @Transactional
    void createImportHistoryDetail() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ImportHistoryDetail
        var returnedImportHistoryDetail = om.readValue(
            restImportHistoryDetailMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(importHistoryDetail))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ImportHistoryDetail.class
        );

        // Validate the ImportHistoryDetail in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertImportHistoryDetailUpdatableFieldsEquals(
            returnedImportHistoryDetail,
            getPersistedImportHistoryDetail(returnedImportHistoryDetail)
        );

        insertedImportHistoryDetail = returnedImportHistoryDetail;
    }

    @Test
    @Transactional
    void createImportHistoryDetailWithExistingId() throws Exception {
        // Create the ImportHistoryDetail with an existing ID
        importHistoryDetail.setId(1L);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restImportHistoryDetailMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(importHistoryDetail))
            )
            .andExpect(status().isBadRequest());

        // Validate the ImportHistoryDetail in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkUuidIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        importHistoryDetail.setUuid(null);

        // Create the ImportHistoryDetail, which fails.

        restImportHistoryDetailMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(importHistoryDetail))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllImportHistoryDetails() throws Exception {
        // Initialize the database
        insertedImportHistoryDetail = importHistoryDetailRepository.saveAndFlush(importHistoryDetail);

        // Get all the importHistoryDetailList
        restImportHistoryDetailMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(importHistoryDetail.getId().intValue())))
            .andExpect(jsonPath("$.[*].uuid").value(hasItem(DEFAULT_UUID.toString())))
            .andExpect(jsonPath("$.[*].tcihdPid").value(hasItem(DEFAULT_TCIHD_PID)))
            .andExpect(jsonPath("$.[*].tcihdLine").value(hasItem(DEFAULT_TCIHD_LINE)))
            .andExpect(jsonPath("$.[*].tcihdError").value(hasItem(DEFAULT_TCIHD_ERROR)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG)))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK)));
    }

    @Test
    @Transactional
    void getImportHistoryDetail() throws Exception {
        // Initialize the database
        insertedImportHistoryDetail = importHistoryDetailRepository.saveAndFlush(importHistoryDetail);

        // Get the importHistoryDetail
        restImportHistoryDetailMockMvc
            .perform(get(ENTITY_API_URL_ID, importHistoryDetail.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(importHistoryDetail.getId().intValue()))
            .andExpect(jsonPath("$.uuid").value(DEFAULT_UUID.toString()))
            .andExpect(jsonPath("$.tcihdPid").value(DEFAULT_TCIHD_PID))
            .andExpect(jsonPath("$.tcihdLine").value(DEFAULT_TCIHD_LINE))
            .andExpect(jsonPath("$.tcihdError").value(DEFAULT_TCIHD_ERROR))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.toString()))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK));
    }

    @Test
    @Transactional
    void getNonExistingImportHistoryDetail() throws Exception {
        // Get the importHistoryDetail
        restImportHistoryDetailMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingImportHistoryDetail() throws Exception {
        // Initialize the database
        insertedImportHistoryDetail = importHistoryDetailRepository.saveAndFlush(importHistoryDetail);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the importHistoryDetail
        ImportHistoryDetail updatedImportHistoryDetail = importHistoryDetailRepository.findById(importHistoryDetail.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedImportHistoryDetail are not directly saved in db
        em.detach(updatedImportHistoryDetail);
        updatedImportHistoryDetail
            .uuid(UPDATED_UUID)
            .tcihdPid(UPDATED_TCIHD_PID)
            .tcihdLine(UPDATED_TCIHD_LINE)
            .tcihdError(UPDATED_TCIHD_ERROR)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .updateTime(UPDATED_UPDATE_TIME)
            .delFlag(UPDATED_DEL_FLAG)
            .remark(UPDATED_REMARK);

        restImportHistoryDetailMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedImportHistoryDetail.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedImportHistoryDetail))
            )
            .andExpect(status().isOk());

        // Validate the ImportHistoryDetail in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedImportHistoryDetailToMatchAllProperties(updatedImportHistoryDetail);
    }

    @Test
    @Transactional
    void putNonExistingImportHistoryDetail() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importHistoryDetail.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restImportHistoryDetailMockMvc
            .perform(
                put(ENTITY_API_URL_ID, importHistoryDetail.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(importHistoryDetail))
            )
            .andExpect(status().isBadRequest());

        // Validate the ImportHistoryDetail in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchImportHistoryDetail() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importHistoryDetail.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restImportHistoryDetailMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(importHistoryDetail))
            )
            .andExpect(status().isBadRequest());

        // Validate the ImportHistoryDetail in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamImportHistoryDetail() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importHistoryDetail.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restImportHistoryDetailMockMvc
            .perform(
                put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(importHistoryDetail))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ImportHistoryDetail in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateImportHistoryDetailWithPatch() throws Exception {
        // Initialize the database
        insertedImportHistoryDetail = importHistoryDetailRepository.saveAndFlush(importHistoryDetail);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the importHistoryDetail using partial update
        ImportHistoryDetail partialUpdatedImportHistoryDetail = new ImportHistoryDetail();
        partialUpdatedImportHistoryDetail.setId(importHistoryDetail.getId());

        partialUpdatedImportHistoryDetail
            .uuid(UPDATED_UUID)
            .tcihdPid(UPDATED_TCIHD_PID)
            .tcihdLine(UPDATED_TCIHD_LINE)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .remark(UPDATED_REMARK);

        restImportHistoryDetailMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedImportHistoryDetail.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedImportHistoryDetail))
            )
            .andExpect(status().isOk());

        // Validate the ImportHistoryDetail in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertImportHistoryDetailUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedImportHistoryDetail, importHistoryDetail),
            getPersistedImportHistoryDetail(importHistoryDetail)
        );
    }

    @Test
    @Transactional
    void fullUpdateImportHistoryDetailWithPatch() throws Exception {
        // Initialize the database
        insertedImportHistoryDetail = importHistoryDetailRepository.saveAndFlush(importHistoryDetail);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the importHistoryDetail using partial update
        ImportHistoryDetail partialUpdatedImportHistoryDetail = new ImportHistoryDetail();
        partialUpdatedImportHistoryDetail.setId(importHistoryDetail.getId());

        partialUpdatedImportHistoryDetail
            .uuid(UPDATED_UUID)
            .tcihdPid(UPDATED_TCIHD_PID)
            .tcihdLine(UPDATED_TCIHD_LINE)
            .tcihdError(UPDATED_TCIHD_ERROR)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .updateTime(UPDATED_UPDATE_TIME)
            .delFlag(UPDATED_DEL_FLAG)
            .remark(UPDATED_REMARK);

        restImportHistoryDetailMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedImportHistoryDetail.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedImportHistoryDetail))
            )
            .andExpect(status().isOk());

        // Validate the ImportHistoryDetail in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertImportHistoryDetailUpdatableFieldsEquals(
            partialUpdatedImportHistoryDetail,
            getPersistedImportHistoryDetail(partialUpdatedImportHistoryDetail)
        );
    }

    @Test
    @Transactional
    void patchNonExistingImportHistoryDetail() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importHistoryDetail.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restImportHistoryDetailMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, importHistoryDetail.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(importHistoryDetail))
            )
            .andExpect(status().isBadRequest());

        // Validate the ImportHistoryDetail in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchImportHistoryDetail() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importHistoryDetail.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restImportHistoryDetailMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(importHistoryDetail))
            )
            .andExpect(status().isBadRequest());

        // Validate the ImportHistoryDetail in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamImportHistoryDetail() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        importHistoryDetail.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restImportHistoryDetailMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(importHistoryDetail))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ImportHistoryDetail in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteImportHistoryDetail() throws Exception {
        // Initialize the database
        insertedImportHistoryDetail = importHistoryDetailRepository.saveAndFlush(importHistoryDetail);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the importHistoryDetail
        restImportHistoryDetailMockMvc
            .perform(delete(ENTITY_API_URL_ID, importHistoryDetail.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return importHistoryDetailRepository.count();
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

    protected ImportHistoryDetail getPersistedImportHistoryDetail(ImportHistoryDetail importHistoryDetail) {
        return importHistoryDetailRepository.findById(importHistoryDetail.getId()).orElseThrow();
    }

    protected void assertPersistedImportHistoryDetailToMatchAllProperties(ImportHistoryDetail expectedImportHistoryDetail) {
        assertImportHistoryDetailAllPropertiesEquals(
            expectedImportHistoryDetail,
            getPersistedImportHistoryDetail(expectedImportHistoryDetail)
        );
    }

    protected void assertPersistedImportHistoryDetailToMatchUpdatableProperties(ImportHistoryDetail expectedImportHistoryDetail) {
        assertImportHistoryDetailAllUpdatablePropertiesEquals(
            expectedImportHistoryDetail,
            getPersistedImportHistoryDetail(expectedImportHistoryDetail)
        );
    }
}
