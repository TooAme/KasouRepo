package com.chenhy.web.rest;

import com.chenhy.domain.ImportHistoryDetail;
import com.chenhy.repository.ImportHistoryDetailRepository;
import com.chenhy.service.ImportHistoryDetailService;
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
 * REST controller for managing {@link com.chenhy.domain.ImportHistoryDetail}.
 */
@RestController
@RequestMapping("/api/import-history-details")
public class ImportHistoryDetailResource {

    private static final Logger LOG = LoggerFactory.getLogger(ImportHistoryDetailResource.class);

    private static final String ENTITY_NAME = "importHistoryDetail";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ImportHistoryDetailService importHistoryDetailService;

    private final ImportHistoryDetailRepository importHistoryDetailRepository;

    public ImportHistoryDetailResource(
        ImportHistoryDetailService importHistoryDetailService,
        ImportHistoryDetailRepository importHistoryDetailRepository
    ) {
        this.importHistoryDetailService = importHistoryDetailService;
        this.importHistoryDetailRepository = importHistoryDetailRepository;
    }

    /**
     * {@code POST  /import-history-details} : Create a new importHistoryDetail.
     *
     * @param importHistoryDetail the importHistoryDetail to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new importHistoryDetail, or with status {@code 400 (Bad Request)} if the importHistoryDetail has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ImportHistoryDetail> createImportHistoryDetail(@Valid @RequestBody ImportHistoryDetail importHistoryDetail)
        throws URISyntaxException {
        LOG.debug("REST request to save ImportHistoryDetail : {}", importHistoryDetail);
        if (importHistoryDetail.getId() != null) {
            throw new BadRequestAlertException("A new importHistoryDetail cannot already have an ID", ENTITY_NAME, "idexists");
        }
        importHistoryDetail = importHistoryDetailService.save(importHistoryDetail);
        return ResponseEntity.created(new URI("/api/import-history-details/" + importHistoryDetail.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, importHistoryDetail.getId().toString()))
            .body(importHistoryDetail);
    }

    /**
     * {@code PUT  /import-history-details/:id} : Updates an existing importHistoryDetail.
     *
     * @param id the id of the importHistoryDetail to save.
     * @param importHistoryDetail the importHistoryDetail to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated importHistoryDetail,
     * or with status {@code 400 (Bad Request)} if the importHistoryDetail is not valid,
     * or with status {@code 500 (Internal Server Error)} if the importHistoryDetail couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ImportHistoryDetail> updateImportHistoryDetail(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ImportHistoryDetail importHistoryDetail
    ) throws URISyntaxException {
        LOG.debug("REST request to update ImportHistoryDetail : {}, {}", id, importHistoryDetail);
        if (importHistoryDetail.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, importHistoryDetail.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!importHistoryDetailRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        importHistoryDetail = importHistoryDetailService.update(importHistoryDetail);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, importHistoryDetail.getId().toString()))
            .body(importHistoryDetail);
    }

    /**
     * {@code PATCH  /import-history-details/:id} : Partial updates given fields of an existing importHistoryDetail, field will ignore if it is null
     *
     * @param id the id of the importHistoryDetail to save.
     * @param importHistoryDetail the importHistoryDetail to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated importHistoryDetail,
     * or with status {@code 400 (Bad Request)} if the importHistoryDetail is not valid,
     * or with status {@code 404 (Not Found)} if the importHistoryDetail is not found,
     * or with status {@code 500 (Internal Server Error)} if the importHistoryDetail couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ImportHistoryDetail> partialUpdateImportHistoryDetail(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ImportHistoryDetail importHistoryDetail
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update ImportHistoryDetail partially : {}, {}", id, importHistoryDetail);
        if (importHistoryDetail.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, importHistoryDetail.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!importHistoryDetailRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ImportHistoryDetail> result = importHistoryDetailService.partialUpdate(importHistoryDetail);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, importHistoryDetail.getId().toString())
        );
    }

    /**
     * {@code GET  /import-history-details} : get all the importHistoryDetails.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of importHistoryDetails in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ImportHistoryDetail>> getAllImportHistoryDetails(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of ImportHistoryDetails");
        Page<ImportHistoryDetail> page = importHistoryDetailService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /import-history-details/:id} : get the "id" importHistoryDetail.
     *
     * @param id the id of the importHistoryDetail to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the importHistoryDetail, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ImportHistoryDetail> getImportHistoryDetail(@PathVariable("id") Long id) {
        LOG.debug("REST request to get ImportHistoryDetail : {}", id);
        Optional<ImportHistoryDetail> importHistoryDetail = importHistoryDetailService.findOne(id);
        return ResponseUtil.wrapOrNotFound(importHistoryDetail);
    }

    /**
     * {@code DELETE  /import-history-details/:id} : delete the "id" importHistoryDetail.
     *
     * @param id the id of the importHistoryDetail to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImportHistoryDetail(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete ImportHistoryDetail : {}", id);
        importHistoryDetailService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
