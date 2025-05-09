package com.chenhy.service.commonEntity;

import com.chenhy.domain.commonEntity.FunctionCircuitModules;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link FunctionCircuitModules}.
 */
public interface FunctionCircuitModulesService {
    /**
     * Save a FunctionCircuitModules.
     *
     * @param FunctionCircuitModules the entity to save.
     * @return the persisted entity.
     */
    FunctionCircuitModules save(FunctionCircuitModules FunctionCircuitModules);

    /**
     * Updates a FunctionCircuitModules.
     *
     * @param FunctionCircuitModules the entity to update.
     * @return the persisted entity.
     */
    FunctionCircuitModules update(FunctionCircuitModules FunctionCircuitModules);

    /**
     * Partially updates a FunctionCircuitModules.
     *
     * @param FunctionCircuitModules the entity to update partially.
     * @return the persisted entity.
     */
    Optional<FunctionCircuitModules> partialUpdate(FunctionCircuitModules FunctionCircuitModules);

    /**
     * Get all the FunctionCircuitModuless.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<FunctionCircuitModules> findAll(Pageable pageable);

    /**
     * Get the "id" FunctionCircuitModules.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FunctionCircuitModules> findOne(String id);

    /**
     * Delete the "id" FunctionCircuitModules.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
