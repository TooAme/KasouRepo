package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Fuses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Fuses}.
 */
public interface FusesService {
    /**
     * Save a Fuses.
     *
     * @param Fuses the entity to save.
     * @return the persisted entity.
     */
    Fuses save(Fuses Fuses);

    /**
     * Updates a Fuses.
     *
     * @param Fuses the entity to update.
     * @return the persisted entity.
     */
    Fuses update(Fuses Fuses);

    /**
     * Partially updates a Fuses.
     *
     * @param Fuses the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Fuses> partialUpdate(Fuses Fuses);

    /**
     * Get all the Fusess.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Fuses> findAll(Pageable pageable);

    /**
     * Get the "id" Fuses.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Fuses> findOne(String id);

    /**
     * Delete the "id" Fuses.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
