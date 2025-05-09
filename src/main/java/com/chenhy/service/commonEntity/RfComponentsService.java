package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.RfComponents;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link RfComponents}.
 */
public interface RfComponentsService {
    /**
     * Save a RfComponents.
     *
     * @param RfComponents the entity to save.
     * @return the persisted entity.
     */
    RfComponents save(RfComponents RfComponents);

    /**
     * Updates a RfComponents.
     *
     * @param RfComponents the entity to update.
     * @return the persisted entity.
     */
    RfComponents update(RfComponents RfComponents);

    /**
     * Partially updates a RfComponents.
     *
     * @param RfComponents the entity to update partially.
     * @return the persisted entity.
     */
    Optional<RfComponents> partialUpdate(RfComponents RfComponents);

    /**
     * Get all the RfComponentss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<RfComponents> findAll(Pageable pageable);

    /**
     * Get the "id" RfComponents.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<RfComponents> findOne(String id);

    /**
     * Delete the "id" RfComponents.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
