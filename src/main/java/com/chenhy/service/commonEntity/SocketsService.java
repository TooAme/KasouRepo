package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.Sockets;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Sockets}.
 */
public interface SocketsService {
    /**
     * Save a Sockets.
     *
     * @param Sockets the entity to save.
     * @return the persisted entity.
     */
    Sockets save(Sockets Sockets);

    /**
     * Updates a Sockets.
     *
     * @param Sockets the entity to update.
     * @return the persisted entity.
     */
    Sockets update(Sockets Sockets);

    /**
     * Partially updates a Sockets.
     *
     * @param Sockets the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Sockets> partialUpdate(Sockets Sockets);

    /**
     * Get all the Socketss.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Sockets> findAll(Pageable pageable);

    /**
     * Get the "id" Sockets.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Sockets> findOne(String id);

    /**
     * Delete the "id" Sockets.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
