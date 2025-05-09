package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.OpticalParts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link OpticalParts}.
 */
public interface OpticalPartsService {
    /**
     * Save a OpticalParts.
     *
     * @param OpticalParts the entity to save.
     * @return the persisted entity.
     */
    OpticalParts save(OpticalParts OpticalParts);

    /**
     * Updates a OpticalParts.
     *
     * @param OpticalParts the entity to update.
     * @return the persisted entity.
     */
    OpticalParts update(OpticalParts OpticalParts);

    /**
     * Partially updates a OpticalParts.
     *
     * @param OpticalParts the entity to update partially.
     * @return the persisted entity.
     */
    Optional<OpticalParts> partialUpdate(OpticalParts OpticalParts);

    /**
     * Get all the OpticalPartss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<OpticalParts> findAll(Pageable pageable);

    /**
     * Get the "id" OpticalParts.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OpticalParts> findOne(String id);

    /**
     * Delete the "id" OpticalParts.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
