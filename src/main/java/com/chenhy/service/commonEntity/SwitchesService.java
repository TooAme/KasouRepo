package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Switches;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Switches}.
 */
public interface SwitchesService {
    /**
     * Save a Switches.
     *
     * @param Switches the entity to save.
     * @return the persisted entity.
     */
    Switches save(Switches Switches);

    /**
     * Updates a Switches.
     *
     * @param Switches the entity to update.
     * @return the persisted entity.
     */
    Switches update(Switches Switches);

    /**
     * Partially updates a Switches.
     *
     * @param Switches the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Switches> partialUpdate(Switches Switches);

    /**
     * Get all the Switchess.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Switches> findAll(Pageable pageable);

    /**
     * Get the "id" Switches.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Switches> findOne(String id);

    /**
     * Delete the "id" Switches.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
