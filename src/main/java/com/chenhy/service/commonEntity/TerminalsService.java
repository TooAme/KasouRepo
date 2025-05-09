package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Terminals;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Terminals}.
 */
public interface TerminalsService {
    /**
     * Save a Terminals.
     *
     * @param Terminals the entity to save.
     * @return the persisted entity.
     */
    Terminals save(Terminals Terminals);

    /**
     * Updates a Terminals.
     *
     * @param Terminals the entity to update.
     * @return the persisted entity.
     */
    Terminals update(Terminals Terminals);

    /**
     * Partially updates a Terminals.
     *
     * @param Terminals the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Terminals> partialUpdate(Terminals Terminals);

    /**
     * Get all the Terminalss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Terminals> findAll(Pageable pageable);

    /**
     * Get the "id" Terminals.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Terminals> findOne(String id);

    /**
     * Delete the "id" Terminals.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
