package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Relays;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Relays}.
 */
public interface RelaysService {
    /**
     * Save a Relays.
     *
     * @param Relays the entity to save.
     * @return the persisted entity.
     */
    Relays save(Relays Relays);

    /**
     * Updates a Relays.
     *
     * @param Relays the entity to update.
     * @return the persisted entity.
     */
    Relays update(Relays Relays);

    /**
     * Partially updates a Relays.
     *
     * @param Relays the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Relays> partialUpdate(Relays Relays);

    /**
     * Get all the Relayss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Relays> findAll(Pageable pageable);

    /**
     * Get the "id" Relays.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Relays> findOne(String id);

    /**
     * Delete the "id" Relays.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
