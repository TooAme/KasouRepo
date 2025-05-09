package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.MultiChipDiscreteDevices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link MultiChipDiscreteDevices}.
 */
public interface MultiChipDiscreteDevicesService {
    /**
     * Save a MultiChipDiscreteDevices.
     *
     * @param MultiChipDiscreteDevices the entity to save.
     * @return the persisted entity.
     */
    MultiChipDiscreteDevices save(MultiChipDiscreteDevices MultiChipDiscreteDevices);

    /**
     * Updates a MultiChipDiscreteDevices.
     *
     * @param MultiChipDiscreteDevices the entity to update.
     * @return the persisted entity.
     */
    MultiChipDiscreteDevices update(MultiChipDiscreteDevices MultiChipDiscreteDevices);

    /**
     * Partially updates a MultiChipDiscreteDevices.
     *
     * @param MultiChipDiscreteDevices the entity to update partially.
     * @return the persisted entity.
     */
    Optional<MultiChipDiscreteDevices> partialUpdate(MultiChipDiscreteDevices MultiChipDiscreteDevices);

    /**
     * Get all the MultiChipDiscreteDevicess.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<MultiChipDiscreteDevices> findAll(Pageable pageable);

    /**
     * Get the "id" MultiChipDiscreteDevices.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MultiChipDiscreteDevices> findOne(String id);

    /**
     * Delete the "id" MultiChipDiscreteDevices.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
