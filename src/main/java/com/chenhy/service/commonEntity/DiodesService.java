package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Diodes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Diodes}.
 */
public interface DiodesService {
    /**
     * Save a Diodes.
     *
     * @param Diodes the entity to save.
     * @return the persisted entity.
     */
    Diodes save(Diodes Diodes);

    /**
     * Updates a Diodes.
     *
     * @param Diodes the entity to update.
     * @return the persisted entity.
     */
    Diodes update(Diodes Diodes);

    /**
     * Partially updates a Diodes.
     *
     * @param Diodes the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Diodes> partialUpdate(Diodes Diodes);

    /**
     * Get all the Diodess.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Diodes> findAll(Pageable pageable);

    /**
     * Get the "id" Diodes.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Diodes> findOne(String id);

    /**
     * Delete the "id" Diodes.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
