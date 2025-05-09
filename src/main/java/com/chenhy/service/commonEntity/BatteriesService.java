package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Batteries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Batteries}.
 */
public interface BatteriesService {
    /**
     * Save a Batteries.
     *
     * @param Batteries the entity to save.
     * @return the persisted entity.
     */
    Batteries save(Batteries Batteries);

    /**
     * Updates a Batteries.
     *
     * @param Batteries the entity to update.
     * @return the persisted entity.
     */
    Batteries update(Batteries Batteries);

    /**
     * Partially updates a Batteries.
     *
     * @param Batteries the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Batteries> partialUpdate(Batteries Batteries);

    /**
     * Get all the Batteriess.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Batteries> findAll(Pageable pageable);

    /**
     * Get the "id" Batteries.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Batteries> findOne(String id);

    /**
     * Delete the "id" Batteries.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
