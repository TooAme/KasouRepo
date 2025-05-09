package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Microphones;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Microphones}.
 */
public interface MicrophonesService {
    /**
     * Save a Microphones.
     *
     * @param Microphones the entity to save.
     * @return the persisted entity.
     */
    Microphones save(Microphones Microphones);

    /**
     * Updates a Microphones.
     *
     * @param Microphones the entity to update.
     * @return the persisted entity.
     */
    Microphones update(Microphones Microphones);

    /**
     * Partially updates a Microphones.
     *
     * @param Microphones the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Microphones> partialUpdate(Microphones Microphones);

    /**
     * Get all the Microphoness.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Microphones> findAll(Pageable pageable);

    /**
     * Get the "id" Microphones.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Microphones> findOne(String id);

    /**
     * Delete the "id" Microphones.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
