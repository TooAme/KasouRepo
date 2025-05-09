package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Transistors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Transistors}.
 */
public interface TransistorsService {
    /**
     * Save a Transistors.
     *
     * @param Transistors the entity to save.
     * @return the persisted entity.
     */
    Transistors save(Transistors Transistors);

    /**
     * Updates a Transistors.
     *
     * @param Transistors the entity to update.
     * @return the persisted entity.
     */
    Transistors update(Transistors Transistors);

    /**
     * Partially updates a Transistors.
     *
     * @param Transistors the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Transistors> partialUpdate(Transistors Transistors);

    /**
     * Get all the Transistorss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Transistors> findAll(Pageable pageable);

    /**
     * Get the "id" Transistors.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Transistors> findOne(String id);

    /**
     * Delete the "id" Transistors.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
