package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.OptoElectronicDevices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link OptoElectronicDevices}.
 */
public interface OptoElectronicDevicesService {
    /**
     * Save a OptoElectronicDevices.
     *
     * @param OptoElectronicDevices the entity to save.
     * @return the persisted entity.
     */
    OptoElectronicDevices save(OptoElectronicDevices OptoElectronicDevices);

    /**
     * Updates a OptoElectronicDevices.
     *
     * @param OptoElectronicDevices the entity to update.
     * @return the persisted entity.
     */
    OptoElectronicDevices update(OptoElectronicDevices OptoElectronicDevices);

    /**
     * Partially updates a OptoElectronicDevices.
     *
     * @param OptoElectronicDevices the entity to update partially.
     * @return the persisted entity.
     */
    Optional<OptoElectronicDevices> partialUpdate(OptoElectronicDevices OptoElectronicDevices);

    /**
     * Get all the OptoElectronicDevicess.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<OptoElectronicDevices> findAll(Pageable pageable);

    /**
     * Get the "id" OptoElectronicDevices.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OptoElectronicDevices> findOne(String id);

    /**
     * Delete the "id" OptoElectronicDevices.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
