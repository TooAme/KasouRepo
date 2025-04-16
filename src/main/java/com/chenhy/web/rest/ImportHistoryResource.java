package com.chenhy.web.rest;

import com.chenhy.domain.ImportHistory;
import com.chenhy.repository.ImportHistoryRepository;
import com.chenhy.service.ImportHistoryService;
import com.chenhy.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
 * REST controller for managing {@link com.chenhy.domain.ImportHistory}.
 */
@RestController
@RequestMapping("/api")
public class ImportHistoryResource {

    private static final Logger LOG = LoggerFactory.getLogger(ImportHistoryResource.class);

    private static final String ENTITY_NAME = "importHistory";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ImportHistoryService importHistoryService;

    private final ImportHistoryRepository importHistoryRepository;

    public ImportHistoryResource(ImportHistoryService importHistoryService, ImportHistoryRepository importHistoryRepository) {
        this.importHistoryService = importHistoryService;
        this.importHistoryRepository = importHistoryRepository;
    }

    /**
     * {@code POST  /import-histories} : Create a new importHistory.
     *
     * @param importHistory the importHistory to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new importHistory, or with status {@code 400 (Bad Request)} if the importHistory has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/import-histories")
    public ResponseEntity<ImportHistory> createImportHistory(@Valid @RequestBody ImportHistory importHistory) throws URISyntaxException {
        LOG.debug("REST request to save ImportHistory : {}", importHistory);
        if (importHistory.getId() != null) {
            throw new BadRequestAlertException("A new importHistory cannot already have an ID", ENTITY_NAME, "idexists");
        }
        importHistory = importHistoryService.save(importHistory);
        return ResponseEntity.created(new URI("/api/import-histories/" + importHistory.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, importHistory.getId().toString()))
            .body(importHistory);
    }

    /**
     * {@code PUT  /import-histories/:id} : Updates an existing importHistory.
     *
     * @param id the id of the importHistory to save.
     * @param importHistory the importHistory to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated importHistory,
     * or with status {@code 400 (Bad Request)} if the importHistory is not valid,
     * or with status {@code 500 (Internal Server Error)} if the importHistory couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/import-histories/{id}")
    public ResponseEntity<ImportHistory> updateImportHistory(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ImportHistory importHistory
    ) throws URISyntaxException {
        LOG.debug("REST request to update ImportHistory : {}, {}", id, importHistory);
        if (importHistory.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, importHistory.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!importHistoryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        importHistory = importHistoryService.update(importHistory);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, importHistory.getId().toString()))
            .body(importHistory);
    }

    /**
     * {@code PATCH  /import-histories/:id} : Partial updates given fields of an existing importHistory, field will ignore if it is null
     *
     * @param id the id of the importHistory to save.
     * @param importHistory the importHistory to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated importHistory,
     * or with status {@code 400 (Bad Request)} if the importHistory is not valid,
     * or with status {@code 404 (Not Found)} if the importHistory is not found,
     * or with status {@code 500 (Internal Server Error)} if the importHistory couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/import-histories/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ImportHistory> partialUpdateImportHistory(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ImportHistory importHistory
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update ImportHistory partially : {}, {}", id, importHistory);
        if (importHistory.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, importHistory.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!importHistoryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ImportHistory> result = importHistoryService.partialUpdate(importHistory);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, importHistory.getId().toString())
        );
    }

    /**
     * {@code GET  /import-histories} : get all the importHistories.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of importHistories in body.
     */
    @GetMapping("/import-histories")
    public ResponseEntity<List<ImportHistory>> getAllImportHistories(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of ImportHistories");
        Page<ImportHistory> page = importHistoryService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /import-histories/:id} : get the "id" importHistory.
     *
     * @param id the id of the importHistory to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the importHistory, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/import-histories/{id}")
    public ResponseEntity<ImportHistory> getImportHistory(@PathVariable Long id) {
        LOG.debug("REST request to get ImportHistory : {}", id);
        Optional<ImportHistory> importHistory = importHistoryService.findOne(id);
        return importHistory.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * {@code DELETE  /import-histories/:id} : delete the "id" importHistory.
     *
     * @param id the id of the importHistory to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/import-histories/{id}")
    public ResponseEntity<Void> deleteImportHistory(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete ImportHistory : {}", id);
        importHistoryService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
