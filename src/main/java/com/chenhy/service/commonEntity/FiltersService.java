package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Filters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Filters}.
 */
public interface FiltersService {
    /**
     * Save a Filters.
     *
     * @param Filters the entity to save.
     * @return the persisted entity.
     */
    Filters save(Filters Filters);

    /**
     * Updates a Filters.
     *
     * @param Filters the entity to update.
     * @return the persisted entity.
     */
    Filters update(Filters Filters);

    /**
     * Partially updates a Filters.
     *
     * @param Filters the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Filters> partialUpdate(Filters Filters);

    /**
     * Get all the Filterss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Filters> findAll(Pageable pageable);

    /**
     * Get the "id" Filters.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Filters> findOne(String id);

    /**
     * Delete the "id" Filters.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
