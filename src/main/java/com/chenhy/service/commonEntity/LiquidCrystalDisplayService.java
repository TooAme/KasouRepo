package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.LiquidCrystalDisplay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link LiquidCrystalDisplay}.
 */
public interface LiquidCrystalDisplayService {
    /**
     * Save a LiquidCrystalDisplay.
     *
     * @param LiquidCrystalDisplay the entity to save.
     * @return the persisted entity.
     */
    LiquidCrystalDisplay save(LiquidCrystalDisplay LiquidCrystalDisplay);

    /**
     * Updates a LiquidCrystalDisplay.
     *
     * @param LiquidCrystalDisplay the entity to update.
     * @return the persisted entity.
     */
    LiquidCrystalDisplay update(LiquidCrystalDisplay LiquidCrystalDisplay);

    /**
     * Partially updates a LiquidCrystalDisplay.
     *
     * @param LiquidCrystalDisplay the entity to update partially.
     * @return the persisted entity.
     */
    Optional<LiquidCrystalDisplay> partialUpdate(LiquidCrystalDisplay LiquidCrystalDisplay);

    /**
     * Get all the LiquidCrystalDisplays.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<LiquidCrystalDisplay> findAll(Pageable pageable);

    /**
     * Get the "id" LiquidCrystalDisplay.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<LiquidCrystalDisplay> findOne(String id);

    /**
     * Delete the "id" LiquidCrystalDisplay.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
