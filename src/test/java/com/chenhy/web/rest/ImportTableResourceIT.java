package com.chenhy.web.rest;

import static com.chenhy.domain.ImportTableAsserts.*;
import static com.chenhy.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.chenhy.IntegrationTest;
import com.chenhy.domain.ImportTable;
import com.chenhy.repository.ImportTableRepository;
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
 * Integration tests for the {@link ImportTableResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ImportTableResourceIT {

    private static final String DEFAULT_ID = UUID.randomUUID().toString();
    private static final String UPDATED_ID = UUID.randomUUID().toString();

    private static final String DEFAULT_PART_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PART_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_PART_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_PART_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_VALUE = "AAAAAAAAAA";
    private static final String UPDATED_VALUE = "BBBBBBBBBB";

    private static final String DEFAULT_SCHEMATIC_PART = "AAAAAAAAAA";
    private static final String UPDATED_SCHEMATIC_PART = "BBBBBBBBBB";

    private static final String DEFAULT_RATING_VOLTAGE = "AAAAAAAAAA";
    private static final String UPDATED_RATING_VOLTAGE = "BBBBBBBBBB";

    private static final String DEFAULT_RATING_ELECTRICITY = "AAAAAAAAAA";
    private static final String UPDATED_RATING_ELECTRICITY = "BBBBBBBBBB";

    private static final String DEFAULT_CHARACTERISTICS = "AAAAAAAAAA";
    private static final String UPDATED_CHARACTERISTICS = "BBBBBBBBBB";

    private static final String DEFAULT_TOLERANCE = "AAAAAAAAAA";
    private static final String UPDATED_TOLERANCE = "BBBBBBBBBB";

    private static final String DEFAULT_MANUFACTURE = "AAAAAAAAAA";
    private static final String UPDATED_MANUFACTURE = "BBBBBBBBBB";

    private static final String DEFAULT_B_CODE = "AAAAAAAAAA";
    private static final String UPDATED_B_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PARTS_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PARTS_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ITEM_REGISTRATION_CLASSIFICATION = "3";
    private static final String UPDATED_ITEM_REGISTRATION_CLASSIFICATION = "3";

    private static final String DEFAULT_SPICE_MODEL = "AAAAAAAAAA";
    private static final String UPDATED_SPICE_MODEL = "BBBBBBBBBB";

    private static final String DEFAULT_PCB_FOOT_PRINT = "AAAAAAAAAA";
    private static final String UPDATED_PCB_FOOT_PRINT = "BBBBBBBBBB";

    private static final Boolean DEFAULT_DEL_FLAG = false;
    private static final Boolean UPDATED_DEL_FLAG = true;

    private static final String DEFAULT_REMARK = "AAAAAAAAAA";
    private static final String UPDATED_REMARK = "BBBBBBBBBB";

    private static final String DEFAULT_CREATE_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_UPDATE_BY = "AAAAAAAAAA";
    private static final String UPDATED_UPDATE_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_UPDATE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String ENTITY_API_URL = "/api/import-tables";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ImportTableRepository importTableRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restImportTableMockMvc;

    private ImportTable importTable;

    private ImportTable insertedImportTable;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ImportTable createEntity() {
        return new ImportTable()
            .id(DEFAULT_ID)
            .partNumber(DEFAULT_PART_NUMBER)
            .partType(DEFAULT_PART_TYPE)
            .value(DEFAULT_VALUE)
            .schematicPart(DEFAULT_SCHEMATIC_PART)
            .ratingVoltage(DEFAULT_RATING_VOLTAGE)
            .ratingElectricity(DEFAULT_RATING_ELECTRICITY)
            .characteristics(DEFAULT_CHARACTERISTICS)
            .tolerance(DEFAULT_TOLERANCE)
            .manufacture(DEFAULT_MANUFACTURE)
            .bCode(DEFAULT_B_CODE)
            .partsName(DEFAULT_PARTS_NAME)
            .itemRegistrationClassification(DEFAULT_ITEM_REGISTRATION_CLASSIFICATION)
            .spiceModel(DEFAULT_SPICE_MODEL)
            .pcbFootPrint(DEFAULT_PCB_FOOT_PRINT)
            .delFlag(DEFAULT_DEL_FLAG)
            .remark(DEFAULT_REMARK)
            .createBy(DEFAULT_CREATE_BY)
            .createTime(DEFAULT_CREATE_TIME)
            .updateBy(DEFAULT_UPDATE_BY)
            .updateTime(DEFAULT_UPDATE_TIME);
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ImportTable createUpdatedEntity() {
        return new ImportTable()
            .id(UPDATED_ID)
            .partNumber(UPDATED_PART_NUMBER)
            .partType(UPDATED_PART_TYPE)
            .value(UPDATED_VALUE)
            .schematicPart(UPDATED_SCHEMATIC_PART)
            .ratingVoltage(UPDATED_RATING_VOLTAGE)
            .ratingElectricity(UPDATED_RATING_ELECTRICITY)
            .characteristics(UPDATED_CHARACTERISTICS)
            .tolerance(UPDATED_TOLERANCE)
            .manufacture(UPDATED_MANUFACTURE)
            .bCode(UPDATED_B_CODE)
            .partsName(UPDATED_PARTS_NAME)
            .itemRegistrationClassification(UPDATED_ITEM_REGISTRATION_CLASSIFICATION)
            .spiceModel(UPDATED_SPICE_MODEL)
            .pcbFootPrint(UPDATED_PCB_FOOT_PRINT)
            .delFlag(UPDATED_DEL_FLAG)
            .remark(UPDATED_REMARK)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .updateTime(UPDATED_UPDATE_TIME);
    }

    @BeforeEach
    public void initTest() {
        importTable = createEntity();
    }

    @AfterEach
    public void cleanup() {
        if (insertedImportTable != null) {
            importTableRepository.delete(insertedImportTable);
            insertedImportTable = null;
        }
    }

    @Test
    @Transactional
    void createImportTable() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ImportTable
        var returnedImportTable = om.readValue(
            restImportTableMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(importTable))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ImportTable.class
        );

        // Validate the ImportTable in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertImportTableUpdatableFieldsEquals(returnedImportTable, getPersistedImportTable(returnedImportTable));

        insertedImportTable = returnedImportTable;
    }

    @Test
    @Transactional
    void createImportTableWithExistingId() throws Exception {
        // Create the ImportTable with an existing ID
        importTable.setId(UUID.randomUUID().toString());

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restImportTableMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(importTable)))
            .andExpect(status().isBadRequest());

        // Validate the ImportTable in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkUuidIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        importTable.setId(null);

        // Create the ImportTable, which fails.

        restImportTableMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(importTable)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPartNumberIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        importTable.setPartNumber(null);

        // Create the ImportTable, which fails.

        restImportTableMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(importTable)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllImportTables() throws Exception {
        // Initialize the database
        insertedImportTable = importTableRepository.saveAndFlush(importTable);

        // Get all the importTableList
        restImportTableMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(DEFAULT_ID.toString())))
            .andExpect(jsonPath("$.[*].partNumber").value(hasItem(DEFAULT_PART_NUMBER)))
            .andExpect(jsonPath("$.[*].partType").value(hasItem(DEFAULT_PART_TYPE)))
            .andExpect(jsonPath("$.[*].value").value(hasItem(DEFAULT_VALUE)))
            .andExpect(jsonPath("$.[*].schematicPart").value(hasItem(DEFAULT_SCHEMATIC_PART)))
            .andExpect(jsonPath("$.[*].ratingVoltage").value(hasItem(DEFAULT_RATING_VOLTAGE)))
            .andExpect(jsonPath("$.[*].ratingElectricity").value(hasItem(DEFAULT_RATING_ELECTRICITY)))
            .andExpect(jsonPath("$.[*].characteristics").value(hasItem(DEFAULT_CHARACTERISTICS)))
            .andExpect(jsonPath("$.[*].tolerance").value(hasItem(DEFAULT_TOLERANCE)))
            .andExpect(jsonPath("$.[*].manufacture").value(hasItem(DEFAULT_MANUFACTURE)))
            .andExpect(jsonPath("$.[*].bCode").value(hasItem(DEFAULT_B_CODE)))
            .andExpect(jsonPath("$.[*].partsName").value(hasItem(DEFAULT_PARTS_NAME)))
            .andExpect(jsonPath("$.[*].itemRegistrationClassification").value(hasItem(DEFAULT_ITEM_REGISTRATION_CLASSIFICATION)))
            .andExpect(jsonPath("$.[*].spiceModel").value(hasItem(DEFAULT_SPICE_MODEL)))
            .andExpect(jsonPath("$.[*].pcbFootPrint").value(hasItem(DEFAULT_PCB_FOOT_PRINT)))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG)))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.toString())));
    }

    @Test
    @Transactional
    void getImportTable() throws Exception {
        // Initialize the database
        insertedImportTable = importTableRepository.saveAndFlush(importTable);

        // Get the importTable
        restImportTableMockMvc
            .perform(get(ENTITY_API_URL_ID, importTable.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(DEFAULT_ID.toString()))
            .andExpect(jsonPath("$.partNumber").value(DEFAULT_PART_NUMBER))
            .andExpect(jsonPath("$.partType").value(DEFAULT_PART_TYPE))
            .andExpect(jsonPath("$.value").value(DEFAULT_VALUE))
            .andExpect(jsonPath("$.schematicPart").value(DEFAULT_SCHEMATIC_PART))
            .andExpect(jsonPath("$.ratingVoltage").value(DEFAULT_RATING_VOLTAGE))
            .andExpect(jsonPath("$.ratingElectricity").value(DEFAULT_RATING_ELECTRICITY))
            .andExpect(jsonPath("$.characteristics").value(DEFAULT_CHARACTERISTICS))
            .andExpect(jsonPath("$.tolerance").value(DEFAULT_TOLERANCE))
            .andExpect(jsonPath("$.manufacture").value(DEFAULT_MANUFACTURE))
            .andExpect(jsonPath("$.bCode").value(DEFAULT_B_CODE))
            .andExpect(jsonPath("$.partsName").value(DEFAULT_PARTS_NAME))
            .andExpect(jsonPath("$.itemRegistrationClassification").value(DEFAULT_ITEM_REGISTRATION_CLASSIFICATION))
            .andExpect(jsonPath("$.spiceModel").value(DEFAULT_SPICE_MODEL))
            .andExpect(jsonPath("$.pcbFootPrint").value(DEFAULT_PCB_FOOT_PRINT))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.toString()));
    }

    @Test
    @Transactional
    void getNonExistingImportTable() throws Exception {
        // Get the importTable
        restImportTableMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingImportTable() throws Exception {
        // Initialize the database
        insertedImportTable = importTableRepository.saveAndFlush(importTable);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the importTable
        ImportTable updatedImportTable = importTableRepository.findById(importTable.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedImportTable are not directly saved in db
        em.detach(updatedImportTable);
        updatedImportTable
            .id(UPDATED_ID)
            .partNumber(UPDATED_PART_NUMBER)
            .partType(UPDATED_PART_TYPE)
            .value(UPDATED_VALUE)
            .schematicPart(UPDATED_SCHEMATIC_PART)
            .ratingVoltage(UPDATED_RATING_VOLTAGE)
            .ratingElectricity(UPDATED_RATING_ELECTRICITY)
            .characteristics(UPDATED_CHARACTERISTICS)
            .tolerance(UPDATED_TOLERANCE)
            .manufacture(UPDATED_MANUFACTURE)
            .bCode(UPDATED_B_CODE)
            .partsName(UPDATED_PARTS_NAME)
            .itemRegistrationClassification(UPDATED_ITEM_REGISTRATION_CLASSIFICATION)
            .spiceModel(UPDATED_SPICE_MODEL)
            .pcbFootPrint(UPDATED_PCB_FOOT_PRINT)
            .delFlag(UPDATED_DEL_FLAG)
            .remark(UPDATED_REMARK)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .updateTime(UPDATED_UPDATE_TIME);

        restImportTableMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedImportTable.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedImportTable))
            )
            .andExpect(status().isOk());

        // Validate the ImportTable in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedImportTableToMatchAllProperties(updatedImportTable);
    }

    @Test
    @Transactional
    void partialUpdateImportTableWithPatch() throws Exception {
        // Initialize the database
        insertedImportTable = importTableRepository.saveAndFlush(importTable);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the importTable using partial update
        ImportTable partialUpdatedImportTable = new ImportTable();
        partialUpdatedImportTable.setId(importTable.getId());

        partialUpdatedImportTable
            .id(UPDATED_ID)
            .partNumber(UPDATED_PART_NUMBER)
            .partType(UPDATED_PART_TYPE)
            .value(UPDATED_VALUE)
            .ratingVoltage(UPDATED_RATING_VOLTAGE)
            .manufacture(UPDATED_MANUFACTURE)
            .bCode(UPDATED_B_CODE)
            .itemRegistrationClassification(UPDATED_ITEM_REGISTRATION_CLASSIFICATION)
            .pcbFootPrint(UPDATED_PCB_FOOT_PRINT)
            .updateBy(UPDATED_UPDATE_BY);

        restImportTableMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedImportTable.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedImportTable))
            )
            .andExpect(status().isOk());

        // Validate the ImportTable in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertImportTableUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedImportTable, importTable),
            getPersistedImportTable(importTable)
        );
    }

    @Test
    @Transactional
    void fullUpdateImportTableWithPatch() throws Exception {
        // Initialize the database
        insertedImportTable = importTableRepository.saveAndFlush(importTable);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the importTable using partial update
        ImportTable partialUpdatedImportTable = new ImportTable();
        partialUpdatedImportTable.setId(importTable.getId());

        partialUpdatedImportTable
            .id(UPDATED_ID)
            .partNumber(UPDATED_PART_NUMBER)
            .partType(UPDATED_PART_TYPE)
            .value(UPDATED_VALUE)
            .schematicPart(UPDATED_SCHEMATIC_PART)
            .ratingVoltage(UPDATED_RATING_VOLTAGE)
            .ratingElectricity(UPDATED_RATING_ELECTRICITY)
            .characteristics(UPDATED_CHARACTERISTICS)
            .tolerance(UPDATED_TOLERANCE)
            .manufacture(UPDATED_MANUFACTURE)
            .bCode(UPDATED_B_CODE)
            .partsName(UPDATED_PARTS_NAME)
            .itemRegistrationClassification(UPDATED_ITEM_REGISTRATION_CLASSIFICATION)
            .spiceModel(UPDATED_SPICE_MODEL)
            .pcbFootPrint(UPDATED_PCB_FOOT_PRINT)
            .delFlag(UPDATED_DEL_FLAG)
            .remark(UPDATED_REMARK)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .updateTime(UPDATED_UPDATE_TIME);

        restImportTableMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedImportTable.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedImportTable))
            )
            .andExpect(status().isOk());

        // Validate the ImportTable in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertImportTableUpdatableFieldsEquals(partialUpdatedImportTable, getPersistedImportTable(partialUpdatedImportTable));
    }

    @Test
    @Transactional
    void deleteImportTable() throws Exception {
        // Initialize the database
        insertedImportTable = importTableRepository.saveAndFlush(importTable);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the importTable
        restImportTableMockMvc
            .perform(delete(ENTITY_API_URL_ID, importTable.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return importTableRepository.count();
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

    protected ImportTable getPersistedImportTable(ImportTable importTable) {
        return importTableRepository.findById(importTable.getId()).orElseThrow();
    }

    protected void assertPersistedImportTableToMatchAllProperties(ImportTable expectedImportTable) {
        assertImportTableAllPropertiesEquals(expectedImportTable, getPersistedImportTable(expectedImportTable));
    }

    protected void assertPersistedImportTableToMatchUpdatableProperties(ImportTable expectedImportTable) {
        assertImportTableAllUpdatablePropertiesEquals(expectedImportTable, getPersistedImportTable(expectedImportTable));
    }
}
