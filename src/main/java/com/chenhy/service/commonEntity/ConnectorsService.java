package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Connectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Connectors}.
 */
public interface ConnectorsService {
    /**
     * Save a Connectors.
     *
     * @param Connectors the entity to save.
     * @return the persisted entity.
     */
    Connectors save(Connectors Connectors);

    /**
     * Updates a Connectors.
     *
     * @param Connectors the entity to update.
     * @return the persisted entity.
     */
    Connectors update(Connectors Connectors);

    /**
     * Partially updates a Connectors.
     *
     * @param Connectors the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Connectors> partialUpdate(Connectors Connectors);

    /**
     * Get all the Connectorss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Connectors> findAll(Pageable pageable);

    /**
     * Get the "id" Connectors.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Connectors> findOne(String id);

    /**
     * Delete the "id" Connectors.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
