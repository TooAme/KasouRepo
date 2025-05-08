package com.chenhy.web.rest;

import com.chenhy.domain.ImportTable;
import com.chenhy.repository.ImportTableRepository;
import com.chenhy.service.ImportTableService;
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
 * REST controller for managing {@link com.chenhy.domain.ImportTable}.
 */
@RestController
@RequestMapping("/api/import-tables")
public class ImportTableResource {

    private static final Logger LOG = LoggerFactory.getLogger(ImportTableResource.class);

    private static final String ENTITY_NAME = "importTable";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ImportTableService importTableService;

    private final ImportTableRepository importTableRepository;

    public ImportTableResource(ImportTableService importTableService, ImportTableRepository importTableRepository) {
        this.importTableService = importTableService;
        this.importTableRepository = importTableRepository;
    }

    /**
     * {@code POST  /import-tables} : Create a new importTable.
     *
     * @param importTable the importTable to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new importTable, or with status {@code 400 (Bad Request)} if the importTable has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ImportTable> createImportTable(@Valid @RequestBody ImportTable importTable) throws URISyntaxException {
        LOG.debug("REST request to save ImportTable : {}", importTable);
        if (importTable.getId() != null) {
            throw new BadRequestAlertException("A new importTable cannot already have an ID", ENTITY_NAME, "idexists");
        }
        importTable = importTableService.save(importTable);
        return ResponseEntity.created(new URI("/api/import-tables/" + importTable.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, importTable.getId().toString()))
            .body(importTable);
    }

    /**
     * {@code PUT  /import-tables/:id} : Updates an existing importTable.
     *
     * @param id the id of the importTable to save.
     * @param importTable the importTable to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated importTable,
     * or with status {@code 400 (Bad Request)} if the importTable is not valid,
     * or with status {@code 500 (Internal Server Error)} if the importTable couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ImportTable> updateImportTable(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ImportTable importTable
    ) throws URISyntaxException {
        LOG.debug("REST request to update ImportTable : {}, {}", id, importTable);
        if (importTable.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, importTable.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!importTableRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        importTable = importTableService.update(importTable);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, importTable.getId().toString()))
            .body(importTable);
    }

    /**
     * {@code PATCH  /import-tables/:id} : Partial updates given fields of an existing importTable, field will ignore if it is null
     *
     * @param id the id of the importTable to save.
     * @param importTable the importTable to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated importTable,
     * or with status {@code 400 (Bad Request)} if the importTable is not valid,
     * or with status {@code 404 (Not Found)} if the importTable is not found,
     * or with status {@code 500 (Internal Server Error)} if the importTable couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ImportTable> partialUpdateImportTable(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ImportTable importTable
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update ImportTable partially : {}, {}", id, importTable);
        if (importTable.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, importTable.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!importTableRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ImportTable> result = importTableService.partialUpdate(importTable);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, importTable.getId().toString())
        );
    }

    /**
     * {@code GET  /import-tables} : get all the importTables.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of importTables in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ImportTable>> getAllImportTables(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of ImportTables");
        Page<ImportTable> page = importTableService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /import-tables/:id} : get the "id" importTable.
     *
     * @param id the id of the importTable to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the importTable, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ImportTable> getImportTable(@PathVariable("id") String id) {
        LOG.debug("REST request to get ImportTable : {}", id);
        Optional<ImportTable> importTable = importTableService.findOne(id);
        return ResponseUtil.wrapOrNotFound(importTable);
    }

    /**
     * {@code DELETE  /import-tables/:id} : delete the "id" importTable.
     *
     * @param id the id of the importTable to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    // 修改方法参数类型，从 Long 改为 String
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImportTable(@PathVariable("id") String id) {
        LOG.debug("REST request to delete ImportTable : {}", id);
        importTableService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, String.valueOf(id)))
            .build();
    }
    // 修改其他涉及 id 的方法，将参数类型从 Long 改为 String
}
