package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.PlasmaDisplayDevice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link PlasmaDisplayDevice}.
 */
public interface PlasmaDisplayDeviceService {
    /**
     * Save a PlasmaDisplayDevice.
     *
     * @param PlasmaDisplayDevice the entity to save.
     * @return the persisted entity.
     */
    PlasmaDisplayDevice save(PlasmaDisplayDevice PlasmaDisplayDevice);

    /**
     * Updates a PlasmaDisplayDevice.
     *
     * @param PlasmaDisplayDevice the entity to update.
     * @return the persisted entity.
     */
    PlasmaDisplayDevice update(PlasmaDisplayDevice PlasmaDisplayDevice);

    /**
     * Partially updates a PlasmaDisplayDevice.
     *
     * @param PlasmaDisplayDevice the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PlasmaDisplayDevice> partialUpdate(PlasmaDisplayDevice PlasmaDisplayDevice);

    /**
     * Get all the PlasmaDisplayDevices.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PlasmaDisplayDevice> findAll(Pageable pageable);

    /**
     * Get the "id" PlasmaDisplayDevice.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PlasmaDisplayDevice> findOne(String id);

    /**
     * Delete the "id" PlasmaDisplayDevice.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
