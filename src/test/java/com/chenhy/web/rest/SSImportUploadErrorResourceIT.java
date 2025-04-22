package com.chenhy.web.rest;

import static com.chenhy.domain.SSImportAsserts.*;
import static com.chenhy.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.chenhy.IntegrationTest;
import com.chenhy.domain.SSImport;
import com.chenhy.repository.SSImportRepository;
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
 * Integration tests for the {@link SSImportResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class SSImportUploadErrorResourceIT {

    private static final UUID DEFAULT_UUID = UUID.randomUUID();
    private static final UUID UPDATED_UUID = UUID.randomUUID();

    private static final String DEFAULT_SS_CREATE_BY = "AAAAAAAAAA";
    private static final String UPDATED_SS_CREATE_BY = "BBBBBBBBBB";

    private static final String DEFAULT_SS_FILENAME = "AAAAAAAAAA";
    private static final String UPDATED_SS_FILENAME = "BBBBBBBBBB";

    private static final String DEFAULT_SS_B_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SS_B_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SS_SUB_B_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SS_SUB_B_CODE = "BBBBBBBBBB";

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

    private static final String ENTITY_API_URL = "/api/ss-imports";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private SSImportRepository sSImportRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSSImportMockMvc;

    private SSImport sSImport;

    private SSImport insertedSSImport;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SSImport createEntity() {
        return new SSImport()
            .uuid(DEFAULT_UUID)
            .ssCreateBy(DEFAULT_SS_CREATE_BY)
            .ssFilename(DEFAULT_SS_FILENAME)
            .ssBCode(DEFAULT_SS_B_CODE)
            .ssSubBCode(DEFAULT_SS_SUB_B_CODE)
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
    public static SSImport createUpdatedEntity() {
        return new SSImport()
            .uuid(UPDATED_UUID)
            .ssCreateBy(UPDATED_SS_CREATE_BY)
            .ssFilename(UPDATED_SS_FILENAME)
            .ssBCode(UPDATED_SS_B_CODE)
            .ssSubBCode(UPDATED_SS_SUB_B_CODE)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .updateTime(UPDATED_UPDATE_TIME)
            .delFlag(UPDATED_DEL_FLAG)
            .remark(UPDATED_REMARK);
    }

    @BeforeEach
    public void initTest() {
        sSImport = createEntity();
    }

    @AfterEach
    public void cleanup() {
        if (insertedSSImport != null) {
            sSImportRepository.delete(insertedSSImport);
            insertedSSImport = null;
        }
    }

    @Test
    @Transactional
    void createSSImport() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the SSImport
        var returnedSSImport = om.readValue(
            restSSImportMockMvc
                .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(sSImport)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            SSImport.class
        );

        // Validate the SSImport in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertSSImportUpdatableFieldsEquals(returnedSSImport, getPersistedSSImport(returnedSSImport));

        insertedSSImport = returnedSSImport;
    }

    @Test
    @Transactional
    void createSSImportWithExistingId() throws Exception {
        // Create the SSImport with an existing ID
        sSImport.setId(1L);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restSSImportMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(sSImport)))
            .andExpect(status().isBadRequest());

        // Validate the SSImport in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkUuidIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        sSImport.setUuid(null);

        // Create the SSImport, which fails.

        restSSImportMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(sSImport)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllSSImports() throws Exception {
        // Initialize the database
        insertedSSImport = sSImportRepository.saveAndFlush(sSImport);

        // Get all the sSImportList
        restSSImportMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sSImport.getId().intValue())))
            .andExpect(jsonPath("$.[*].uuid").value(hasItem(DEFAULT_UUID.toString())))
            .andExpect(jsonPath("$.[*].ssCreateBy").value(hasItem(DEFAULT_SS_CREATE_BY)))
            .andExpect(jsonPath("$.[*].ssFilename").value(hasItem(DEFAULT_SS_FILENAME)))
            .andExpect(jsonPath("$.[*].ssBCode").value(hasItem(DEFAULT_SS_B_CODE)))
            .andExpect(jsonPath("$.[*].ssSubBCode").value(hasItem(DEFAULT_SS_SUB_B_CODE)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG)))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK)));
    }

    @Test
    @Transactional
    void getSSImport() throws Exception {
        // Initialize the database
        insertedSSImport = sSImportRepository.saveAndFlush(sSImport);

        // Get the sSImport
        restSSImportMockMvc
            .perform(get(ENTITY_API_URL_ID, sSImport.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sSImport.getId().intValue()))
            .andExpect(jsonPath("$.uuid").value(DEFAULT_UUID.toString()))
            .andExpect(jsonPath("$.ssCreateBy").value(DEFAULT_SS_CREATE_BY))
            .andExpect(jsonPath("$.ssFilename").value(DEFAULT_SS_FILENAME))
            .andExpect(jsonPath("$.ssBCode").value(DEFAULT_SS_B_CODE))
            .andExpect(jsonPath("$.ssSubBCode").value(DEFAULT_SS_SUB_B_CODE))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.toString()))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK));
    }

    @Test
    @Transactional
    void getNonExistingSSImport() throws Exception {
        // Get the sSImport
        restSSImportMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingSSImport() throws Exception {
        // Initialize the database
        insertedSSImport = sSImportRepository.saveAndFlush(sSImport);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the sSImport
        SSImport updatedSSImport = sSImportRepository.findById(sSImport.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedSSImport are not directly saved in db
        em.detach(updatedSSImport);
        updatedSSImport
            .uuid(UPDATED_UUID)
            .ssCreateBy(UPDATED_SS_CREATE_BY)
            .ssFilename(UPDATED_SS_FILENAME)
            .ssBCode(UPDATED_SS_B_CODE)
            .ssSubBCode(UPDATED_SS_SUB_B_CODE)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .updateTime(UPDATED_UPDATE_TIME)
            .delFlag(UPDATED_DEL_FLAG)
            .remark(UPDATED_REMARK);

        restSSImportMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedSSImport.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedSSImport))
            )
            .andExpect(status().isOk());

        // Validate the SSImport in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedSSImportToMatchAllProperties(updatedSSImport);
    }

    @Test
    @Transactional
    void putNonExistingSSImport() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        sSImport.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSSImportMockMvc
            .perform(
                put(ENTITY_API_URL_ID, sSImport.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(sSImport))
            )
            .andExpect(status().isBadRequest());

        // Validate the SSImport in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchSSImport() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        sSImport.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSSImportMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(sSImport))
            )
            .andExpect(status().isBadRequest());

        // Validate the SSImport in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamSSImport() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        sSImport.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSSImportMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(sSImport)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the SSImport in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateSSImportWithPatch() throws Exception {
        // Initialize the database
        insertedSSImport = sSImportRepository.saveAndFlush(sSImport);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the sSImport using partial update
        SSImport partialUpdatedSSImport = new SSImport();
        partialUpdatedSSImport.setId(sSImport.getId());

        partialUpdatedSSImport
            .uuid(UPDATED_UUID)
            .ssBCode(UPDATED_SS_B_CODE)
            .ssSubBCode(UPDATED_SS_SUB_B_CODE)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY);

        restSSImportMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSSImport.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedSSImport))
            )
            .andExpect(status().isOk());

        // Validate the SSImport in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertSSImportUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedSSImport, sSImport), getPersistedSSImport(sSImport));
    }

    @Test
    @Transactional
    void fullUpdateSSImportWithPatch() throws Exception {
        // Initialize the database
        insertedSSImport = sSImportRepository.saveAndFlush(sSImport);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the sSImport using partial update
        SSImport partialUpdatedSSImport = new SSImport();
        partialUpdatedSSImport.setId(sSImport.getId());

        partialUpdatedSSImport
            .uuid(UPDATED_UUID)
            .ssCreateBy(UPDATED_SS_CREATE_BY)
            .ssFilename(UPDATED_SS_FILENAME)
            .ssBCode(UPDATED_SS_B_CODE)
            .ssSubBCode(UPDATED_SS_SUB_B_CODE)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .updateTime(UPDATED_UPDATE_TIME)
            .delFlag(UPDATED_DEL_FLAG)
            .remark(UPDATED_REMARK);

        restSSImportMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSSImport.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedSSImport))
            )
            .andExpect(status().isOk());

        // Validate the SSImport in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertSSImportUpdatableFieldsEquals(partialUpdatedSSImport, getPersistedSSImport(partialUpdatedSSImport));
    }

    @Test
    @Transactional
    void patchNonExistingSSImport() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        sSImport.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSSImportMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, sSImport.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(sSImport))
            )
            .andExpect(status().isBadRequest());

        // Validate the SSImport in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchSSImport() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        sSImport.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSSImportMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(sSImport))
            )
            .andExpect(status().isBadRequest());

        // Validate the SSImport in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamSSImport() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        sSImport.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSSImportMockMvc
            .perform(patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(sSImport)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the SSImport in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteSSImport() throws Exception {
        // Initialize the database
        insertedSSImport = sSImportRepository.saveAndFlush(sSImport);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the sSImport
        restSSImportMockMvc
            .perform(delete(ENTITY_API_URL_ID, sSImport.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return sSImportRepository.count();
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

    protected SSImport getPersistedSSImport(SSImport sSImport) {
        return sSImportRepository.findById(sSImport.getId()).orElseThrow();
    }

    protected void assertPersistedSSImportToMatchAllProperties(SSImport expectedSSImport) {
        assertSSImportAllPropertiesEquals(expectedSSImport, getPersistedSSImport(expectedSSImport));
    }

    protected void assertPersistedSSImportToMatchUpdatableProperties(SSImport expectedSSImport) {
        assertSSImportAllUpdatablePropertiesEquals(expectedSSImport, getPersistedSSImport(expectedSSImport));
    }
}
