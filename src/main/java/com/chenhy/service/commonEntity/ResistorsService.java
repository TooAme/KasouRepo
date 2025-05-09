package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Resistors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Resistors}.
 */
public interface ResistorsService {
    /**
     * Save a Resistors.
     *
     * @param Resistors the entity to save.
     * @return the persisted entity.
     */
    Resistors save(Resistors Resistors);

    /**
     * Updates a Resistors.
     *
     * @param Resistors the entity to update.
     * @return the persisted entity.
     */
    Resistors update(Resistors Resistors);

    /**
     * Partially updates a Resistors.
     *
     * @param Resistors the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Resistors> partialUpdate(Resistors Resistors);

    /**
     * Get all the Resistorss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Resistors> findAll(Pageable pageable);

    /**
     * Get the "id" Resistors.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Resistors> findOne(String id);

    /**
     * Delete the "id" Resistors.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
