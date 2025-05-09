package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.CircuitBreakersForEquipmentProtection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link CircuitBreakersForEquipmentProtection}.
 */
public interface CircuitBreakersForEquipmentProtectionService {
    /**
     * Save a CircuitBreakersForEquipmentProtection.
     *
     * @param CircuitBreakersForEquipmentProtection the entity to save.
     * @return the persisted entity.
     */
    CircuitBreakersForEquipmentProtection save(CircuitBreakersForEquipmentProtection CircuitBreakersForEquipmentProtection);

    /**
     * Updates a CircuitBreakersForEquipmentProtection.
     *
     * @param CircuitBreakersForEquipmentProtection the entity to update.
     * @return the persisted entity.
     */
    CircuitBreakersForEquipmentProtection update(CircuitBreakersForEquipmentProtection CircuitBreakersForEquipmentProtection);

    /**
     * Partially updates a CircuitBreakersForEquipmentProtection.
     *
     * @param CircuitBreakersForEquipmentProtection the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CircuitBreakersForEquipmentProtection> partialUpdate(CircuitBreakersForEquipmentProtection CircuitBreakersForEquipmentProtection);

    /**
     * Get all the CircuitBreakersForEquipmentProtections.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CircuitBreakersForEquipmentProtection> findAll(Pageable pageable);

    /**
     * Get the "id" CircuitBreakersForEquipmentProtection.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CircuitBreakersForEquipmentProtection> findOne(String id);

    /**
     * Delete the "id" CircuitBreakersForEquipmentProtection.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
