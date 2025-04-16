package com.chenhy.service;

import com.chenhy.domain.SSImport;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.chenhy.domain.SSImport}.
 */
public interface SSImportService {
    /**
     * Save a sSImport.
     *
     * @param sSImport the entity to save.
     * @return the persisted entity.
     */
    SSImport save(SSImport sSImport);

    /**
     * Updates a sSImport.
     *
     * @param sSImport the entity to update.
     * @return the persisted entity.
     */
    SSImport update(SSImport sSImport);

    /**
     * Partially updates a sSImport.
     *
     * @param sSImport the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SSImport> partialUpdate(SSImport sSImport);

    /**
     * Get all the sSImports.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SSImport> findAll(Pageable pageable);

    /**
     * Get the "id" sSImport.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SSImport> findOne(Long id);

    /**
     * Delete the "id" sSImport.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
