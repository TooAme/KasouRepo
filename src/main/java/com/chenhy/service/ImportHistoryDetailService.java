package com.chenhy.service;

import com.chenhy.domain.ImportHistoryDetail;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.chenhy.domain.ImportHistoryDetail}.
 */
public interface ImportHistoryDetailService {
    /**
     * Save a importHistoryDetail.
     *
     * @param importHistoryDetail the entity to save.
     * @return the persisted entity.
     */
    ImportHistoryDetail save(ImportHistoryDetail importHistoryDetail);

    /**
     * Updates a importHistoryDetail.
     *
     * @param importHistoryDetail the entity to update.
     * @return the persisted entity.
     */
    ImportHistoryDetail update(ImportHistoryDetail importHistoryDetail);

    /**
     * Partially updates a importHistoryDetail.
     *
     * @param importHistoryDetail the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ImportHistoryDetail> partialUpdate(ImportHistoryDetail importHistoryDetail);

    /**
     * Get all the importHistoryDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ImportHistoryDetail> findAll(Pageable pageable);

    /**
     * Get the "id" importHistoryDetail.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ImportHistoryDetail> findOne(Long id);

    /**
     * Delete the "id" importHistoryDetail.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
