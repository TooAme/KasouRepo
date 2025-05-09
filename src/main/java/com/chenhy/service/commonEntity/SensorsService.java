package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Sensors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Sensors}.
 */
public interface SensorsService {
    /**
     * Save a Sensors.
     *
     * @param Sensors the entity to save.
     * @return the persisted entity.
     */
    Sensors save(Sensors Sensors);

    /**
     * Updates a Sensors.
     *
     * @param Sensors the entity to update.
     * @return the persisted entity.
     */
    Sensors update(Sensors Sensors);

    /**
     * Partially updates a Sensors.
     *
     * @param Sensors the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Sensors> partialUpdate(Sensors Sensors);

    /**
     * Get all the Sensorss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Sensors> findAll(Pageable pageable);

    /**
     * Get the "id" Sensors.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Sensors> findOne(String id);

    /**
     * Delete the "id" Sensors.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
