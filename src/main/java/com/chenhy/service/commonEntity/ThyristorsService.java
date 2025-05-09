package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Thyristors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Thyristors}.
 */
public interface ThyristorsService {
    /**
     * Save a Thyristors.
     *
     * @param Thyristors the entity to save.
     * @return the persisted entity.
     */
    Thyristors save(Thyristors Thyristors);

    /**
     * Updates a Thyristors.
     *
     * @param Thyristors the entity to update.
     * @return the persisted entity.
     */
    Thyristors update(Thyristors Thyristors);

    /**
     * Partially updates a Thyristors.
     *
     * @param Thyristors the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Thyristors> partialUpdate(Thyristors Thyristors);

    /**
     * Get all the Thyristorss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Thyristors> findAll(Pageable pageable);

    /**
     * Get the "id" Thyristors.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Thyristors> findOne(String id);

    /**
     * Delete the "id" Thyristors.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
