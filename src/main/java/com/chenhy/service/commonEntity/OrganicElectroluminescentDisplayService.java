package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.OrganicElectroluminescentDisplay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link OrganicElectroluminescentDisplay}.
 */
public interface OrganicElectroluminescentDisplayService {
    /**
     * Save a OrganicElectroluminescentDisplay.
     *
     * @param OrganicElectroluminescentDisplay the entity to save.
     * @return the persisted entity.
     */
    OrganicElectroluminescentDisplay save(OrganicElectroluminescentDisplay OrganicElectroluminescentDisplay);

    /**
     * Updates a OrganicElectroluminescentDisplay.
     *
     * @param OrganicElectroluminescentDisplay the entity to update.
     * @return the persisted entity.
     */
    OrganicElectroluminescentDisplay update(OrganicElectroluminescentDisplay OrganicElectroluminescentDisplay);

    /**
     * Partially updates a OrganicElectroluminescentDisplay.
     *
     * @param OrganicElectroluminescentDisplay the entity to update partially.
     * @return the persisted entity.
     */
    Optional<OrganicElectroluminescentDisplay> partialUpdate(OrganicElectroluminescentDisplay OrganicElectroluminescentDisplay);

    /**
     * Get all the OrganicElectroluminescentDisplays.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<OrganicElectroluminescentDisplay> findAll(Pageable pageable);

    /**
     * Get the "id" OrganicElectroluminescentDisplay.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OrganicElectroluminescentDisplay> findOne(String id);

    /**
     * Delete the "id" OrganicElectroluminescentDisplay.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
