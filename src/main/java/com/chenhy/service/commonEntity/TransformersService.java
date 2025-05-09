package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Transformers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Transformers}.
 */
public interface TransformersService {
    /**
     * Save a Transformers.
     *
     * @param Transformers the entity to save.
     * @return the persisted entity.
     */
    Transformers save(Transformers Transformers);

    /**
     * Updates a Transformers.
     *
     * @param Transformers the entity to update.
     * @return the persisted entity.
     */
    Transformers update(Transformers Transformers);

    /**
     * Partially updates a Transformers.
     *
     * @param Transformers the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Transformers> partialUpdate(Transformers Transformers);

    /**
     * Get all the Transformerss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Transformers> findAll(Pageable pageable);

    /**
     * Get the "id" Transformers.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Transformers> findOne(String id);

    /**
     * Delete the "id" Transformers.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
