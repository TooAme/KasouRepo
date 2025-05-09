package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.ElectromechanicalTransducers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link ElectromechanicalTransducers}.
 */
public interface ElectromechanicalTransducersService {
    /**
     * Save a ElectromechanicalTransducers.
     *
     * @param ElectromechanicalTransducers the entity to save.
     * @return the persisted entity.
     */
    ElectromechanicalTransducers save(ElectromechanicalTransducers ElectromechanicalTransducers);

    /**
     * Updates a ElectromechanicalTransducers.
     *
     * @param ElectromechanicalTransducers the entity to update.
     * @return the persisted entity.
     */
    ElectromechanicalTransducers update(ElectromechanicalTransducers ElectromechanicalTransducers);

    /**
     * Partially updates a ElectromechanicalTransducers.
     *
     * @param ElectromechanicalTransducers the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ElectromechanicalTransducers> partialUpdate(ElectromechanicalTransducers ElectromechanicalTransducers);

    /**
     * Get all the ElectromechanicalTransducerss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ElectromechanicalTransducers> findAll(Pageable pageable);

    /**
     * Get the "id" ElectromechanicalTransducers.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ElectromechanicalTransducers> findOne(String id);

    /**
     * Delete the "id" ElectromechanicalTransducers.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
