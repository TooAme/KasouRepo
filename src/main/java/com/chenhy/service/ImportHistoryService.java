package com.chenhy.service;

import com.chenhy.domain.ImportHistory;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link ImportHistory}.
 */
public interface ImportHistoryService {
    /**
     * Save an importHistory.
     *
     * @param importHistory the entity to save.
     * @return the persisted entity.
     */
    ImportHistory save(ImportHistory importHistory);

    /**
     * Updates a importHistory.
     *
     * @param importHistory the entity to update.
     * @return the persisted entity.
     */
    ImportHistory update(ImportHistory importHistory);

    /**
     * Partially updates a importHistory.
     *
     * @param importHistory the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ImportHistory> partialUpdate(ImportHistory importHistory);

    /**
     * Get all the importHistories.
     *
     * @return the list of entities.
     */
    List<ImportHistory> findAll();

    /**
     * Get all the importHistories with pagination.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ImportHistory> findAll(Pageable pageable);

    /**
     * Get the "id" importHistory.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ImportHistory> findOne(Long id);

    /**
     * Delete the "id" importHistory.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
