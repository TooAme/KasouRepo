package com.chenhy.service;

import com.chenhy.domain.ImportSetting;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.chenhy.domain.ImportSetting}.
 */
public interface ImportSettingService {
    /**
     * Save a importSetting.
     *
     * @param importSetting the entity to save.
     * @return the persisted entity.
     */
    ImportSetting save(ImportSetting importSetting);

    /**
     * Updates a importSetting.
     *
     * @param importSetting the entity to update.
     * @return the persisted entity.
     */
    ImportSetting update(ImportSetting importSetting);

    /**
     * Partially updates a importSetting.
     *
     * @param importSetting the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ImportSetting> partialUpdate(ImportSetting importSetting);

    /**
     * Get all the importSettings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ImportSetting> findAll(Pageable pageable);

    /**
     * Get the "id" importSetting.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ImportSetting> findOne(Long id);

    /**
     * Delete the "id" importSetting.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    Optional<ImportSetting> findOneByTcisCodeAndTcisType(String settingCharacter1, String settingCharacter2);
}
