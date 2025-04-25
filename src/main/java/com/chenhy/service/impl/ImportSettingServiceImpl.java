package com.chenhy.service.impl;

import com.chenhy.domain.ImportSetting;
import com.chenhy.repository.ImportSettingRepository;
import com.chenhy.service.ImportSettingService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.chenhy.domain.ImportSetting}.
 */
@Service
@Transactional
public class ImportSettingServiceImpl implements ImportSettingService {

    private static final Logger LOG = LoggerFactory.getLogger(ImportSettingServiceImpl.class);

    private final ImportSettingRepository importSettingRepository;

    public ImportSettingServiceImpl(ImportSettingRepository importSettingRepository) {
        this.importSettingRepository = importSettingRepository;
    }

    @Override
    public ImportSetting save(ImportSetting importSetting) {
        LOG.debug("Request to save ImportSetting : {}", importSetting);
        return importSettingRepository.save(importSetting);
    }

    @Override
    public ImportSetting update(ImportSetting importSetting) {
        LOG.debug("Request to update ImportSetting : {}", importSetting);
        return importSettingRepository.save(importSetting);
    }

    @Override
    public Optional<ImportSetting> partialUpdate(ImportSetting importSetting) {
        LOG.debug("Request to partially update ImportSetting : {}", importSetting);

        return importSettingRepository
            .findById(importSetting.getId())
            .map(existingImportSetting -> {
                if (importSetting.getTcisCode() != null) {
                    existingImportSetting.setTcisCode(importSetting.getTcisCode());
                }
                if (importSetting.getTcisType() != null) {
                    existingImportSetting.setTcisType(importSetting.getTcisType());
                }
                if (importSetting.getTcisIncol() != null) {
                    existingImportSetting.setTcisIncol(importSetting.getTcisIncol());
                }
                if (importSetting.getTcisEditrule() != null) {
                    existingImportSetting.setTcisEditrule(importSetting.getTcisEditrule());
                }

                return existingImportSetting;
            })
            .map(importSettingRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ImportSetting> findAll(Pageable pageable) {
        LOG.debug("Request to get all ImportSettings");
        return importSettingRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ImportSetting> findOne(Long id) {
        LOG.debug("Request to get ImportSetting : {}", id);
        return importSettingRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete ImportSetting : {}", id);
        importSettingRepository.deleteById(id);
    }

    @Override
    public Optional<ImportSetting> findOneByTcisCodeAndTcisType(String settingCharacter1, String settingCharacter2) {
        return importSettingRepository.findOneByTcisCodeAndTcisType(settingCharacter1, settingCharacter2);
    }
}
