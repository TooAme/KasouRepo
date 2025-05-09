package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Resonators;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Resonators}.
 */
public interface ResonatorsService {
    /**
     * Save a Resonators.
     *
     * @param Resonators the entity to save.
     * @return the persisted entity.
     */
    Resonators save(Resonators Resonators);

    /**
     * Updates a Resonators.
     *
     * @param Resonators the entity to update.
     * @return the persisted entity.
     */
    Resonators update(Resonators Resonators);

    /**
     * Partially updates a Resonators.
     *
     * @param Resonators the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Resonators> partialUpdate(Resonators Resonators);

    /**
     * Get all the Resonatorss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Resonators> findAll(Pageable pageable);

    /**
     * Get the "id" Resonators.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Resonators> findOne(String id);

    /**
     * Delete the "id" Resonators.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
