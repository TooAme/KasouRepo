package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.VacuumFluorescentDisplayVfd;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link VacuumFluorescentDisplayVfd}.
 */
public interface VacuumFluorescentDisplayVfdService {
    /**
     * Save a VacuumFluorescentDisplayVfd.
     *
     * @param VacuumFluorescentDisplayVfd the entity to save.
     * @return the persisted entity.
     */
    VacuumFluorescentDisplayVfd save(VacuumFluorescentDisplayVfd VacuumFluorescentDisplayVfd);

    /**
     * Updates a VacuumFluorescentDisplayVfd.
     *
     * @param VacuumFluorescentDisplayVfd the entity to update.
     * @return the persisted entity.
     */
    VacuumFluorescentDisplayVfd update(VacuumFluorescentDisplayVfd VacuumFluorescentDisplayVfd);

    /**
     * Partially updates a VacuumFluorescentDisplayVfd.
     *
     * @param VacuumFluorescentDisplayVfd the entity to update partially.
     * @return the persisted entity.
     */
    Optional<VacuumFluorescentDisplayVfd> partialUpdate(VacuumFluorescentDisplayVfd VacuumFluorescentDisplayVfd);

    /**
     * Get all the VacuumFluorescentDisplayVfds.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<VacuumFluorescentDisplayVfd> findAll(Pageable pageable);

    /**
     * Get the "id" VacuumFluorescentDisplayVfd.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<VacuumFluorescentDisplayVfd> findOne(String id);

    /**
     * Delete the "id" VacuumFluorescentDisplayVfd.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
