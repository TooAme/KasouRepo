package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Thermistors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Thermistors}.
 */
public interface ThermistorsService {
    /**
     * Save a Thermistors.
     *
     * @param Thermistors the entity to save.
     * @return the persisted entity.
     */
    Thermistors save(Thermistors Thermistors);

    /**
     * Updates a Thermistors.
     *
     * @param Thermistors the entity to update.
     * @return the persisted entity.
     */
    Thermistors update(Thermistors Thermistors);

    /**
     * Partially updates a Thermistors.
     *
     * @param Thermistors the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Thermistors> partialUpdate(Thermistors Thermistors);

    /**
     * Get all the Thermistorss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Thermistors> findAll(Pageable pageable);

    /**
     * Get the "id" Thermistors.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Thermistors> findOne(String id);

    /**
     * Delete the "id" Thermistors.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
