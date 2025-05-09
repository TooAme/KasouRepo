package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Ics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Ics}.
 */
public interface IcsService {
    /**
     * Save a Ics.
     *
     * @param Ics the entity to save.
     * @return the persisted entity.
     */
    Ics save(Ics Ics);

    /**
     * Updates a Ics.
     *
     * @param Ics the entity to update.
     * @return the persisted entity.
     */
    Ics update(Ics Ics);

    /**
     * Partially updates a Ics.
     *
     * @param Ics the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Ics> partialUpdate(Ics Ics);

    /**
     * Get all the Icss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Ics> findAll(Pageable pageable);

    /**
     * Get the "id" Ics.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Ics> findOne(String id);

    /**
     * Delete the "id" Ics.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
