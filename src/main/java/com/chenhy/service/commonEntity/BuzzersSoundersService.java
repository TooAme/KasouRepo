package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.BuzzersSounders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link BuzzersSounders}.
 */
public interface BuzzersSoundersService {
    /**
     * Save a BuzzersSounders.
     *
     * @param BuzzersSounders the entity to save.
     * @return the persisted entity.
     */
    BuzzersSounders save(BuzzersSounders BuzzersSounders);

    /**
     * Updates a BuzzersSounders.
     *
     * @param BuzzersSounders the entity to update.
     * @return the persisted entity.
     */
    BuzzersSounders update(BuzzersSounders BuzzersSounders);

    /**
     * Partially updates a BuzzersSounders.
     *
     * @param BuzzersSounders the entity to update partially.
     * @return the persisted entity.
     */
    Optional<BuzzersSounders> partialUpdate(BuzzersSounders BuzzersSounders);

    /**
     * Get all the BuzzersSounderss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BuzzersSounders> findAll(Pageable pageable);

    /**
     * Get the "id" BuzzersSounders.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BuzzersSounders> findOne(String id);

    /**
     * Delete the "id" BuzzersSounders.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
