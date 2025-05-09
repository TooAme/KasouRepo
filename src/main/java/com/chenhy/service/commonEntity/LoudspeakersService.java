package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Loudspeakers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Loudspeakers}.
 */
public interface LoudspeakersService {
    /**
     * Save a Loudspeakers.
     *
     * @param Loudspeakers the entity to save.
     * @return the persisted entity.
     */
    Loudspeakers save(Loudspeakers Loudspeakers);

    /**
     * Updates a Loudspeakers.
     *
     * @param Loudspeakers the entity to update.
     * @return the persisted entity.
     */
    Loudspeakers update(Loudspeakers Loudspeakers);

    /**
     * Partially updates a Loudspeakers.
     *
     * @param Loudspeakers the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Loudspeakers> partialUpdate(Loudspeakers Loudspeakers);

    /**
     * Get all the Loudspeakerss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Loudspeakers> findAll(Pageable pageable);

    /**
     * Get the "id" Loudspeakers.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Loudspeakers> findOne(String id);

    /**
     * Delete the "id" Loudspeakers.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
