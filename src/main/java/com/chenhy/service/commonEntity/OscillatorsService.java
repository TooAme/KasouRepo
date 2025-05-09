package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Oscillators;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Oscillators}.
 */
public interface OscillatorsService {
    /**
     * Save a Oscillators.
     *
     * @param Oscillators the entity to save.
     * @return the persisted entity.
     */
    Oscillators save(Oscillators Oscillators);

    /**
     * Updates a Oscillators.
     *
     * @param Oscillators the entity to update.
     * @return the persisted entity.
     */
    Oscillators update(Oscillators Oscillators);

    /**
     * Partially updates a Oscillators.
     *
     * @param Oscillators the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Oscillators> partialUpdate(Oscillators Oscillators);

    /**
     * Get all the Oscillatorss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Oscillators> findAll(Pageable pageable);

    /**
     * Get the "id" Oscillators.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Oscillators> findOne(String id);

    /**
     * Delete the "id" Oscillators.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
