package com.chenhy.web.rest;

import com.chenhy.domain.SSImport;
import com.chenhy.repository.SSImportRepository;
import com.chenhy.service.SSImportService;
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
 * REST controller for managing {@link com.chenhy.domain.SSImport}.
 */
@RestController
@RequestMapping("/api/ss-imports")
public class SSImportResource {

    private static final Logger LOG = LoggerFactory.getLogger(SSImportResource.class);

    private static final String ENTITY_NAME = "sSImport";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SSImportService sSImportService;

    private final SSImportRepository sSImportRepository;

    public SSImportResource(SSImportService sSImportService, SSImportRepository sSImportRepository) {
        this.sSImportService = sSImportService;
        this.sSImportRepository = sSImportRepository;
    }

    /**
     * {@code POST  /ss-imports} : Create a new sSImport.
     *
     * @param sSImport the sSImport to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sSImport, or with status {@code 400 (Bad Request)} if the sSImport has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<SSImport> createSSImport(@Valid @RequestBody SSImport sSImport) throws URISyntaxException {
        LOG.debug("REST request to save SSImport : {}", sSImport);
        if (sSImport.getId() != null) {
            throw new BadRequestAlertException("A new sSImport cannot already have an ID", ENTITY_NAME, "idexists");
        }
        sSImport = sSImportService.save(sSImport);
        return ResponseEntity.created(new URI("/api/ss-imports/" + sSImport.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, sSImport.getId().toString()))
            .body(sSImport);
    }

    /**
     * {@code PUT  /ss-imports/:id} : Updates an existing sSImport.
     *
     * @param id the id of the sSImport to save.
     * @param sSImport the sSImport to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sSImport,
     * or with status {@code 400 (Bad Request)} if the sSImport is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sSImport couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<SSImport> updateSSImport(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody SSImport sSImport
    ) throws URISyntaxException {
        LOG.debug("REST request to update SSImport : {}, {}", id, sSImport);
        if (sSImport.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, sSImport.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!sSImportRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        sSImport = sSImportService.update(sSImport);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sSImport.getId().toString()))
            .body(sSImport);
    }

    /**
     * {@code PATCH  /ss-imports/:id} : Partial updates given fields of an existing sSImport, field will ignore if it is null
     *
     * @param id the id of the sSImport to save.
     * @param sSImport the sSImport to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sSImport,
     * or with status {@code 400 (Bad Request)} if the sSImport is not valid,
     * or with status {@code 404 (Not Found)} if the sSImport is not found,
     * or with status {@code 500 (Internal Server Error)} if the sSImport couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<SSImport> partialUpdateSSImport(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody SSImport sSImport
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update SSImport partially : {}, {}", id, sSImport);
        if (sSImport.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, sSImport.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!sSImportRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<SSImport> result = sSImportService.partialUpdate(sSImport);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sSImport.getId().toString())
        );
    }

    /**
     * {@code GET  /ss-imports} : get all the sSImports.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sSImports in body.
     */
    @GetMapping("")
    public ResponseEntity<List<SSImport>> getAllSSImports(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of SSImports");
        Page<SSImport> page = sSImportService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ss-imports/:id} : get the "id" sSImport.
     *
     * @param id the id of the sSImport to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sSImport, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SSImport> getSSImport(@PathVariable("id") Long id) {
        LOG.debug("REST request to get SSImport : {}", id);
        Optional<SSImport> sSImport = sSImportService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sSImport);
    }

    /**
     * {@code DELETE  /ss-imports/:id} : delete the "id" sSImport.
     *
     * @param id the id of the sSImport to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSSImport(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete SSImport : {}", id);
        sSImportService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
