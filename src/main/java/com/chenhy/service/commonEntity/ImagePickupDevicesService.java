package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.ImagePickupDevices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link ImagePickupDevices}.
 */
public interface ImagePickupDevicesService {
    /**
     * Save a ImagePickupDevices.
     *
     * @param ImagePickupDevices the entity to save.
     * @return the persisted entity.
     */
    ImagePickupDevices save(ImagePickupDevices ImagePickupDevices);

    /**
     * Updates a ImagePickupDevices.
     *
     * @param ImagePickupDevices the entity to update.
     * @return the persisted entity.
     */
    ImagePickupDevices update(ImagePickupDevices ImagePickupDevices);

    /**
     * Partially updates a ImagePickupDevices.
     *
     * @param ImagePickupDevices the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ImagePickupDevices> partialUpdate(ImagePickupDevices ImagePickupDevices);

    /**
     * Get all the ImagePickupDevicess.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ImagePickupDevices> findAll(Pageable pageable);

    /**
     * Get the "id" ImagePickupDevices.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ImagePickupDevices> findOne(String id);

    /**
     * Delete the "id" ImagePickupDevices.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
