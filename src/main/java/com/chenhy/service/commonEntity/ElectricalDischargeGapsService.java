package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.ElectricalDischargeGaps;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link ElectricalDischargeGaps}.
 */
public interface ElectricalDischargeGapsService {
    /**
     * Save a ElectricalDischargeGaps.
     *
     * @param ElectricalDischargeGaps the entity to save.
     * @return the persisted entity.
     */
    ElectricalDischargeGaps save(ElectricalDischargeGaps ElectricalDischargeGaps);

    /**
     * Updates a ElectricalDischargeGaps.
     *
     * @param ElectricalDischargeGaps the entity to update.
     * @return the persisted entity.
     */
    ElectricalDischargeGaps update(ElectricalDischargeGaps ElectricalDischargeGaps);

    /**
     * Partially updates a ElectricalDischargeGaps.
     *
     * @param ElectricalDischargeGaps the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ElectricalDischargeGaps> partialUpdate(ElectricalDischargeGaps ElectricalDischargeGaps);

    /**
     * Get all the ElectricalDischargeGapss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ElectricalDischargeGaps> findAll(Pageable pageable);

    /**
     * Get the "id" ElectricalDischargeGaps.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ElectricalDischargeGaps> findOne(String id);

    /**
     * Delete the "id" ElectricalDischargeGaps.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
