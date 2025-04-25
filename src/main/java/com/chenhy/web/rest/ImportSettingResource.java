package com.chenhy.web.rest;

import com.chenhy.domain.ImportSetting;
import com.chenhy.repository.ImportSettingRepository;
import com.chenhy.service.ImportSettingService;
import com.chenhy.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.chenhy.domain.ImportSetting}.
 */
@RestController
@RequestMapping("/api/import-settings")
public class ImportSettingResource {

    private static final Logger LOG = LoggerFactory.getLogger(ImportSettingResource.class);

    private static final String ENTITY_NAME = "importSetting";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ImportSettingService importSettingService;

    private final ImportSettingRepository importSettingRepository;

    public ImportSettingResource(ImportSettingService importSettingService, ImportSettingRepository importSettingRepository) {
        this.importSettingService = importSettingService;
        this.importSettingRepository = importSettingRepository;
    }

    /**
     * {@code POST  /import-settings} : Create a new importSetting.
     *
     * @param importSetting the importSetting to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new importSetting, or with status {@code 400 (Bad Request)} if the importSetting has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ImportSetting> createImportSetting(@RequestBody ImportSetting importSetting) throws URISyntaxException {
        LOG.debug("REST request to save ImportSetting : {}", importSetting);
        if (importSetting.getId() != null) {
            throw new BadRequestAlertException("A new importSetting cannot already have an ID", ENTITY_NAME, "idexists");
        }
        importSetting = importSettingService.save(importSetting);
        return ResponseEntity.created(new URI("/api/import-settings/" + importSetting.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, importSetting.getId().toString()))
            .body(importSetting);
    }

    /**
     * {@code PUT  /import-settings/:id} : Updates an existing importSetting.
     *
     * @param id the id of the importSetting to save.
     * @param importSetting the importSetting to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated importSetting,
     * or with status {@code 400 (Bad Request)} if the importSetting is not valid,
     * or with status {@code 500 (Internal Server Error)} if the importSetting couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ImportSetting> updateImportSetting(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ImportSetting importSetting
    ) throws URISyntaxException {
        LOG.debug("REST request to update ImportSetting : {}, {}", id, importSetting);
        if (importSetting.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, importSetting.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!importSettingRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        importSetting = importSettingService.update(importSetting);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, importSetting.getId().toString()))
            .body(importSetting);
    }

    /**
     * {@code PATCH  /import-settings/:id} : Partial updates given fields of an existing importSetting, field will ignore if it is null
     *
     * @param id the id of the importSetting to save.
     * @param importSetting the importSetting to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated importSetting,
     * or with status {@code 400 (Bad Request)} if the importSetting is not valid,
     * or with status {@code 404 (Not Found)} if the importSetting is not found,
     * or with status {@code 500 (Internal Server Error)} if the importSetting couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ImportSetting> partialUpdateImportSetting(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ImportSetting importSetting
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update ImportSetting partially : {}, {}", id, importSetting);
        if (importSetting.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, importSetting.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!importSettingRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ImportSetting> result = importSettingService.partialUpdate(importSetting);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, importSetting.getId().toString())
        );
    }

    /**
     * {@code GET  /import-settings} : get all the importSettings.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of importSettings in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ImportSetting>> getAllImportSettings(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of ImportSettings");
        Page<ImportSetting> page = importSettingService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /import-settings/:id} : get the "id" importSetting.
     *
     * @param id the id of the importSetting to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the importSetting, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ImportSetting> getImportSetting(@PathVariable("id") Long id) {
        LOG.debug("REST request to get ImportSetting : {}", id);
        Optional<ImportSetting> importSetting = importSettingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(importSetting);
    }

    /**
     * {@code DELETE  /import-settings/:id} : delete the "id" importSetting.
     *
     * @param id the id of the importSetting to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImportSetting(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete ImportSetting : {}", id);
        importSettingService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
