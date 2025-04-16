package com.chenhy.service.impl;

import com.chenhy.domain.ImportHistoryDetail;
import com.chenhy.repository.ImportHistoryDetailRepository;
import com.chenhy.service.ImportHistoryDetailService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.chenhy.domain.ImportHistoryDetail}.
 */
@Service
@Transactional
public class ImportHistoryDetailServiceImpl implements ImportHistoryDetailService {

    private static final Logger LOG = LoggerFactory.getLogger(ImportHistoryDetailServiceImpl.class);

    private final ImportHistoryDetailRepository importHistoryDetailRepository;

    public ImportHistoryDetailServiceImpl(ImportHistoryDetailRepository importHistoryDetailRepository) {
        this.importHistoryDetailRepository = importHistoryDetailRepository;
    }

    @Override
    public ImportHistoryDetail save(ImportHistoryDetail importHistoryDetail) {
        LOG.debug("Request to save ImportHistoryDetail : {}", importHistoryDetail);
        return importHistoryDetailRepository.save(importHistoryDetail);
    }

    @Override
    public ImportHistoryDetail update(ImportHistoryDetail importHistoryDetail) {
        LOG.debug("Request to update ImportHistoryDetail : {}", importHistoryDetail);
        return importHistoryDetailRepository.save(importHistoryDetail);
    }

    @Override
    public Optional<ImportHistoryDetail> partialUpdate(ImportHistoryDetail importHistoryDetail) {
        LOG.debug("Request to partially update ImportHistoryDetail : {}", importHistoryDetail);

        return importHistoryDetailRepository
            .findById(importHistoryDetail.getId())
            .map(existingImportHistoryDetail -> {
                if (importHistoryDetail.getUuid() != null) {
                    existingImportHistoryDetail.setUuid(importHistoryDetail.getUuid());
                }
                if (importHistoryDetail.getTcihdPid() != null) {
                    existingImportHistoryDetail.setTcihdPid(importHistoryDetail.getTcihdPid());
                }
                if (importHistoryDetail.getTcihdLine() != null) {
                    existingImportHistoryDetail.setTcihdLine(importHistoryDetail.getTcihdLine());
                }
                if (importHistoryDetail.getTcihdError() != null) {
                    existingImportHistoryDetail.setTcihdError(importHistoryDetail.getTcihdError());
                }
                if (importHistoryDetail.getCreateBy() != null) {
                    existingImportHistoryDetail.setCreateBy(importHistoryDetail.getCreateBy());
                }
                if (importHistoryDetail.getCreateTime() != null) {
                    existingImportHistoryDetail.setCreateTime(importHistoryDetail.getCreateTime());
                }
                if (importHistoryDetail.getUpdateBy() != null) {
                    existingImportHistoryDetail.setUpdateBy(importHistoryDetail.getUpdateBy());
                }
                if (importHistoryDetail.getUpdateTime() != null) {
                    existingImportHistoryDetail.setUpdateTime(importHistoryDetail.getUpdateTime());
                }
                if (importHistoryDetail.getDelFlag() != null) {
                    existingImportHistoryDetail.setDelFlag(importHistoryDetail.getDelFlag());
                }
                if (importHistoryDetail.getRemark() != null) {
                    existingImportHistoryDetail.setRemark(importHistoryDetail.getRemark());
                }

                return existingImportHistoryDetail;
            })
            .map(importHistoryDetailRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ImportHistoryDetail> findAll(Pageable pageable) {
        LOG.debug("Request to get all ImportHistoryDetails");
        return importHistoryDetailRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ImportHistoryDetail> findOne(Long id) {
        LOG.debug("Request to get ImportHistoryDetail : {}", id);
        return importHistoryDetailRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete ImportHistoryDetail : {}", id);
        importHistoryDetailRepository.deleteById(id);
    }
}
