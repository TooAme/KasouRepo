package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Capacitors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Capacitors}.
 */
public interface CapacitorsService {
    /**
     * Save a Capacitors.
     *
     * @param Capacitors the entity to save.
     * @return the persisted entity.
     */
    Capacitors save(Capacitors Capacitors);

    /**
     * Updates a Capacitors.
     *
     * @param Capacitors the entity to update.
     * @return the persisted entity.
     */
    Capacitors update(Capacitors Capacitors);

    /**
     * Partially updates a Capacitors.
     *
     * @param Capacitors the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Capacitors> partialUpdate(Capacitors Capacitors);

    /**
     * Get all the Capacitorss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Capacitors> findAll(Pageable pageable);

    /**
     * Get the "id" Capacitors.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Capacitors> findOne(String id);

    /**
     * Delete the "id" Capacitors.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
