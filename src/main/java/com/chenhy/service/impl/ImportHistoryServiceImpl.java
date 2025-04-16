package com.chenhy.service.impl;

import com.chenhy.domain.ImportHistory;
import com.chenhy.repository.ImportHistoryRepository;
import com.chenhy.service.ImportHistoryService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ImportHistory}.
 */
@Service
@Transactional
public class ImportHistoryServiceImpl implements ImportHistoryService {

    private final Logger log = LoggerFactory.getLogger(ImportHistoryServiceImpl.class);

    private final ImportHistoryRepository importHistoryRepository;

    public ImportHistoryServiceImpl(ImportHistoryRepository importHistoryRepository) {
        this.importHistoryRepository = importHistoryRepository;
    }

    @Override
    public ImportHistory save(ImportHistory importHistory) {
        log.debug("Request to save ImportHistory : {}", importHistory);
        return importHistoryRepository.save(importHistory);
    }

    @Override
    public ImportHistory update(ImportHistory importHistory) {
        log.debug("Request to update ImportHistory : {}", importHistory);
        return importHistoryRepository.save(importHistory);
    }

    @Override
    public Optional<ImportHistory> partialUpdate(ImportHistory importHistory) {
        log.debug("Request to partially update ImportHistory : {}", importHistory);

        return importHistoryRepository
            .findById(importHistory.getId())
            .map(existingImportHistory -> {
                if (importHistory.getUuid() != null) {
                    existingImportHistory.setUuid(importHistory.getUuid());
                }
                if (importHistory.getTcihCode() != null) {
                    existingImportHistory.setTcihCode(importHistory.getTcihCode());
                }
                if (importHistory.getTcihFilename() != null) {
                    existingImportHistory.setTcihFilename(importHistory.getTcihFilename());
                }
                if (importHistory.getTcihImporttime() != null) {
                    existingImportHistory.setTcihImporttime(importHistory.getTcihImporttime());
                }
                if (importHistory.getTcihStatus() != null) {
                    existingImportHistory.setTcihStatus(importHistory.getTcihStatus());
                }
                if (importHistory.getCreateBy() != null) {
                    existingImportHistory.setCreateBy(importHistory.getCreateBy());
                }
                if (importHistory.getCreateTime() != null) {
                    existingImportHistory.setCreateTime(importHistory.getCreateTime());
                }
                if (importHistory.getUpdateBy() != null) {
                    existingImportHistory.setUpdateBy(importHistory.getUpdateBy());
                }
                if (importHistory.getUpdateTime() != null) {
                    existingImportHistory.setUpdateTime(importHistory.getUpdateTime());
                }
                if (importHistory.getDelFlag() != null) {
                    existingImportHistory.setDelFlag(importHistory.getDelFlag());
                }
                if (importHistory.getRemark() != null) {
                    existingImportHistory.setRemark(importHistory.getRemark());
                }

                return existingImportHistory;
            })
            .map(importHistoryRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ImportHistory> findAll() {
        log.debug("Request to get all ImportHistories");
        return importHistoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ImportHistory> findAll(Pageable pageable) {
        log.debug("Request to get a page of ImportHistories");
        return importHistoryRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ImportHistory> findOne(Long id) {
        log.debug("Request to get ImportHistory : {}", id);
        return importHistoryRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ImportHistory : {}", id);
        importHistoryRepository.deleteById(id);
    }
}
