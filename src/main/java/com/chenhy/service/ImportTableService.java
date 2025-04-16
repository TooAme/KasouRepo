package com.chenhy.service;

import com.chenhy.domain.ImportTable;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.chenhy.domain.ImportTable}.
 */
public interface ImportTableService {
    /**
     * Save a importTable.
     *
     * @param importTable the entity to save.
     * @return the persisted entity.
     */
    ImportTable save(ImportTable importTable);

    /**
     * Updates a importTable.
     *
     * @param importTable the entity to update.
     * @return the persisted entity.
     */
    ImportTable update(ImportTable importTable);

    /**
     * Partially updates a importTable.
     *
     * @param importTable the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ImportTable> partialUpdate(ImportTable importTable);

    /**
     * Get all the importTables.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ImportTable> findAll(Pageable pageable);

    /**
     * Get the "id" importTable.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ImportTable> findOne(Long id);

    /**
     * Delete the "id" importTable.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
