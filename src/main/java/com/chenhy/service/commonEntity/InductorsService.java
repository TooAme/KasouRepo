package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Inductors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Inductors}.
 */
public interface InductorsService {
    /**
     * Save a Inductors.
     *
     * @param Inductors the entity to save.
     * @return the persisted entity.
     */
    Inductors save(Inductors Inductors);

    /**
     * Updates a Inductors.
     *
     * @param Inductors the entity to update.
     * @return the persisted entity.
     */
    Inductors update(Inductors Inductors);

    /**
     * Partially updates a Inductors.
     *
     * @param Inductors the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Inductors> partialUpdate(Inductors Inductors);

    /**
     * Get all the Inductorss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Inductors> findAll(Pageable pageable);

    /**
     * Get the "id" Inductors.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Inductors> findOne(String id);

    /**
     * Delete the "id" Inductors.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
