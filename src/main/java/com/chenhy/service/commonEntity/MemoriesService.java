package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Memories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Memories}.
 */
public interface MemoriesService {
    /**
     * Save a Memories.
     *
     * @param Memories the entity to save.
     * @return the persisted entity.
     */
    Memories save(Memories Memories);

    /**
     * Updates a Memories.
     *
     * @param Memories the entity to update.
     * @return the persisted entity.
     */
    Memories update(Memories Memories);

    /**
     * Partially updates a Memories.
     *
     * @param Memories the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Memories> partialUpdate(Memories Memories);

    /**
     * Get all the Memoriess.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Memories> findAll(Pageable pageable);

    /**
     * Get the "id" Memories.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Memories> findOne(String id);

    /**
     * Delete the "id" Memories.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
