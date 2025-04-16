package com.chenhy.service.impl;

import com.chenhy.domain.SSImport;
import com.chenhy.repository.SSImportRepository;
import com.chenhy.service.SSImportService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.chenhy.domain.SSImport}.
 */
@Service
@Transactional
public class SSImportServiceImpl implements SSImportService {

    private static final Logger LOG = LoggerFactory.getLogger(SSImportServiceImpl.class);

    private final SSImportRepository sSImportRepository;

    public SSImportServiceImpl(SSImportRepository sSImportRepository) {
        this.sSImportRepository = sSImportRepository;
    }

    @Override
    public SSImport save(SSImport sSImport) {
        LOG.debug("Request to save SSImport : {}", sSImport);
        return sSImportRepository.save(sSImport);
    }

    @Override
    public SSImport update(SSImport sSImport) {
        LOG.debug("Request to update SSImport : {}", sSImport);
        return sSImportRepository.save(sSImport);
    }

    @Override
    public Optional<SSImport> partialUpdate(SSImport sSImport) {
        LOG.debug("Request to partially update SSImport : {}", sSImport);

        return sSImportRepository
            .findById(sSImport.getId())
            .map(existingSSImport -> {
                if (sSImport.getUuid() != null) {
                    existingSSImport.setUuid(sSImport.getUuid());
                }
                if (sSImport.getSsCreateBy() != null) {
                    existingSSImport.setSsCreateBy(sSImport.getSsCreateBy());
                }
                if (sSImport.getSsFilename() != null) {
                    existingSSImport.setSsFilename(sSImport.getSsFilename());
                }
                if (sSImport.getSsBCode() != null) {
                    existingSSImport.setSsBCode(sSImport.getSsBCode());
                }
                if (sSImport.getSsSubBCode() != null) {
                    existingSSImport.setSsSubBCode(sSImport.getSsSubBCode());
                }
                if (sSImport.getCreateBy() != null) {
                    existingSSImport.setCreateBy(sSImport.getCreateBy());
                }
                if (sSImport.getCreateTime() != null) {
                    existingSSImport.setCreateTime(sSImport.getCreateTime());
                }
                if (sSImport.getUpdateBy() != null) {
                    existingSSImport.setUpdateBy(sSImport.getUpdateBy());
                }
                if (sSImport.getUpdateTime() != null) {
                    existingSSImport.setUpdateTime(sSImport.getUpdateTime());
                }
                if (sSImport.getDelFlag() != null) {
                    existingSSImport.setDelFlag(sSImport.getDelFlag());
                }
                if (sSImport.getRemark() != null) {
                    existingSSImport.setRemark(sSImport.getRemark());
                }

                return existingSSImport;
            })
            .map(sSImportRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SSImport> findAll(Pageable pageable) {
        LOG.debug("Request to get all SSImports");
        return sSImportRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SSImport> findOne(Long id) {
        LOG.debug("Request to get SSImport : {}", id);
        return sSImportRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete SSImport : {}", id);
        sSImportRepository.deleteById(id);
    }
}
