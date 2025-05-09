package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.PowerSupplies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link PowerSupplies}.
 */
public interface PowerSuppliesService {
    /**
     * Save a PowerSupplies.
     *
     * @param PowerSupplies the entity to save.
     * @return the persisted entity.
     */
    PowerSupplies save(PowerSupplies PowerSupplies);

    /**
     * Updates a PowerSupplies.
     *
     * @param PowerSupplies the entity to update.
     * @return the persisted entity.
     */
    PowerSupplies update(PowerSupplies PowerSupplies);

    /**
     * Partially updates a PowerSupplies.
     *
     * @param PowerSupplies the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PowerSupplies> partialUpdate(PowerSupplies PowerSupplies);

    /**
     * Get all the PowerSuppliess.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PowerSupplies> findAll(Pageable pageable);

    /**
     * Get the "id" PowerSupplies.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PowerSupplies> findOne(String id);

    /**
     * Delete the "id" PowerSupplies.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
