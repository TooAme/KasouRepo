package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Lamps;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Lamps}.
 */
public interface LampsService {
    /**
     * Save a Lamps.
     *
     * @param Lamps the entity to save.
     * @return the persisted entity.
     */
    Lamps save(Lamps Lamps);

    /**
     * Updates a Lamps.
     *
     * @param Lamps the entity to update.
     * @return the persisted entity.
     */
    Lamps update(Lamps Lamps);

    /**
     * Partially updates a Lamps.
     *
     * @param Lamps the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Lamps> partialUpdate(Lamps Lamps);

    /**
     * Get all the Lampss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Lamps> findAll(Pageable pageable);

    /**
     * Get the "id" Lamps.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Lamps> findOne(String id);

    /**
     * Delete the "id" Lamps.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
