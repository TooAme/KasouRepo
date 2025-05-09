package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.MicrowaveComponents;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link MicrowaveComponents}.
 */
public interface MicrowaveComponentsService {
    /**
     * Save a MicrowaveComponents.
     *
     * @param MicrowaveComponents the entity to save.
     * @return the persisted entity.
     */
    MicrowaveComponents save(MicrowaveComponents MicrowaveComponents);

    /**
     * Updates a MicrowaveComponents.
     *
     * @param MicrowaveComponents the entity to update.
     * @return the persisted entity.
     */
    MicrowaveComponents update(MicrowaveComponents MicrowaveComponents);

    /**
     * Partially updates a MicrowaveComponents.
     *
     * @param MicrowaveComponents the entity to update partially.
     * @return the persisted entity.
     */
    Optional<MicrowaveComponents> partialUpdate(MicrowaveComponents MicrowaveComponents);

    /**
     * Get all the MicrowaveComponentss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<MicrowaveComponents> findAll(Pageable pageable);

    /**
     * Get the "id" MicrowaveComponents.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MicrowaveComponents> findOne(String id);

    /**
     * Delete the "id" MicrowaveComponents.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
