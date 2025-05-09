package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.EmiEmcCountermeasureParts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link EmiEmcCountermeasureParts}.
 */
public interface EmiEmcCountermeasurePartsService {
    /**
     * Save a EmiEmcCountermeasureParts.
     *
     * @param EmiEmcCountermeasureParts the entity to save.
     * @return the persisted entity.
     */
    EmiEmcCountermeasureParts save(EmiEmcCountermeasureParts EmiEmcCountermeasureParts);

    /**
     * Updates a EmiEmcCountermeasureParts.
     *
     * @param EmiEmcCountermeasureParts the entity to update.
     * @return the persisted entity.
     */
    EmiEmcCountermeasureParts update(EmiEmcCountermeasureParts EmiEmcCountermeasureParts);

    /**
     * Partially updates a EmiEmcCountermeasureParts.
     *
     * @param EmiEmcCountermeasureParts the entity to update partially.
     * @return the persisted entity.
     */
    Optional<EmiEmcCountermeasureParts> partialUpdate(EmiEmcCountermeasureParts EmiEmcCountermeasureParts);

    /**
     * Get all the EmiEmcCountermeasurePartss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<EmiEmcCountermeasureParts> findAll(Pageable pageable);

    /**
     * Get the "id" EmiEmcCountermeasureParts.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<EmiEmcCountermeasureParts> findOne(String id);

    /**
     * Delete the "id" EmiEmcCountermeasureParts.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
