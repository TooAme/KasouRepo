package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Varistors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Varistors}.
 */
public interface VaristorsService {
    /**
     * Save a Varistors.
     *
     * @param Varistors the entity to save.
     * @return the persisted entity.
     */
    Varistors save(Varistors Varistors);

    /**
     * Updates a Varistors.
     *
     * @param Varistors the entity to update.
     * @return the persisted entity.
     */
    Varistors update(Varistors Varistors);

    /**
     * Partially updates a Varistors.
     *
     * @param Varistors the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Varistors> partialUpdate(Varistors Varistors);

    /**
     * Get all the Varistorss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Varistors> findAll(Pageable pageable);

    /**
     * Get the "id" Varistors.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Varistors> findOne(String id);

    /**
     * Delete the "id" Varistors.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
