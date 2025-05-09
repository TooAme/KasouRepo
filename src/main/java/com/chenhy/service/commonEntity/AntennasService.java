package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Antennas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Antennas}.
 */
public interface AntennasService {
    /**
     * Save a Antennas.
     *
     * @param Antennas the entity to save.
     * @return the persisted entity.
     */
    Antennas save(Antennas Antennas);

    /**
     * Updates a Antennas.
     *
     * @param Antennas the entity to update.
     * @return the persisted entity.
     */
    Antennas update(Antennas Antennas);

    /**
     * Partially updates a Antennas.
     *
     * @param Antennas the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Antennas> partialUpdate(Antennas Antennas);

    /**
     * Get all the Antennass.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Antennas> findAll(Pageable pageable);

    /**
     * Get the "id" Antennas.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Antennas> findOne(String id);

    /**
     * Delete the "id" Antennas.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
