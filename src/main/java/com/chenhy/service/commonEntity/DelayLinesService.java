package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.DelayLines;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link DelayLines}.
 */
public interface DelayLinesService {
    /**
     * Save a DelayLines.
     *
     * @param DelayLines the entity to save.
     * @return the persisted entity.
     */
    DelayLines save(DelayLines DelayLines);

    /**
     * Updates a DelayLines.
     *
     * @param DelayLines the entity to update.
     * @return the persisted entity.
     */
    DelayLines update(DelayLines DelayLines);

    /**
     * Partially updates a DelayLines.
     *
     * @param DelayLines the entity to update partially.
     * @return the persisted entity.
     */
    Optional<DelayLines> partialUpdate(DelayLines DelayLines);

    /**
     * Get all the DelayLiness.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DelayLines> findAll(Pageable pageable);

    /**
     * Get the "id" DelayLines.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DelayLines> findOne(String id);

    /**
     * Delete the "id" DelayLines.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
