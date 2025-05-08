package com.chenhy.service.impl;

import com.chenhy.domain.ImportTable;
import com.chenhy.repository.ImportTableRepository;
import com.chenhy.service.ImportTableService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.chenhy.domain.ImportTable}.
 */
@Service
@Transactional
public class ImportTableServiceImpl implements ImportTableService {

    private static final Logger LOG = LoggerFactory.getLogger(ImportTableServiceImpl.class);

    private final ImportTableRepository importTableRepository;

    public ImportTableServiceImpl(ImportTableRepository importTableRepository) {
        this.importTableRepository = importTableRepository;
    }

    @Override
    public ImportTable save(ImportTable importTable) {
        LOG.debug("Request to save ImportTable : {}", importTable);
        return importTableRepository.save(importTable);
    }

    @Override
    public ImportTable update(ImportTable importTable) {
        LOG.debug("Request to update ImportTable : {}", importTable);
        return importTableRepository.save(importTable);
    }

    @Override
    public Optional<ImportTable> partialUpdate(ImportTable importTable) {
        LOG.debug("Request to partially update ImportTable : {}", importTable);

        return importTableRepository
            .findById(importTable.getId())
            .map(existingImportTable -> {
                if (importTable.getId() != null) {
                    existingImportTable.setId(importTable.getId());
                }
                if (importTable.getPartNumber() != null) {
                    existingImportTable.setPartNumber(importTable.getPartNumber());
                }
                if (importTable.getPartType() != null) {
                    existingImportTable.setPartType(importTable.getPartType());
                }
                if (importTable.getValue() != null) {
                    existingImportTable.setValue(importTable.getValue());
                }
                if (importTable.getSchematicPart() != null) {
                    existingImportTable.setSchematicPart(importTable.getSchematicPart());
                }
                if (importTable.getRatingVoltage() != null) {
                    existingImportTable.setRatingVoltage(importTable.getRatingVoltage());
                }
                if (importTable.getRatingElectricity() != null) {
                    existingImportTable.setRatingElectricity(importTable.getRatingElectricity());
                }
                if (importTable.getCharacteristics() != null) {
                    existingImportTable.setCharacteristics(importTable.getCharacteristics());
                }
                if (importTable.getTolerance() != null) {
                    existingImportTable.setTolerance(importTable.getTolerance());
                }
                if (importTable.getManufacture() != null) {
                    existingImportTable.setManufacture(importTable.getManufacture());
                }
                if (importTable.getbCode() != null) {
                    existingImportTable.setbCode(importTable.getbCode());
                }
                if (importTable.getPartsName() != null) {
                    existingImportTable.setPartsName(importTable.getPartsName());
                }
                if (importTable.getItemRegistrationClassification() != null) {
                    existingImportTable.setItemRegistrationClassification(importTable.getItemRegistrationClassification());
                }
                if (importTable.getSpiceModel() != null) {
                    existingImportTable.setSpiceModel(importTable.getSpiceModel());
                }
                if (importTable.getPcbFootPrint() != null) {
                    existingImportTable.setPcbFootPrint(importTable.getPcbFootPrint());
                }
                if (importTable.getDelFlag() != null) {
                    existingImportTable.setDelFlag(importTable.getDelFlag());
                }
                if (importTable.getRemark() != null) {
                    existingImportTable.setRemark(importTable.getRemark());
                }
                if (importTable.getCreateBy() != null) {
                    existingImportTable.setCreateBy(importTable.getCreateBy());
                }
                if (importTable.getCreateTime() != null) {
                    existingImportTable.setCreateTime(importTable.getCreateTime());
                }
                if (importTable.getUpdateBy() != null) {
                    existingImportTable.setUpdateBy(importTable.getUpdateBy());
                }
                if (importTable.getUpdateTime() != null) {
                    existingImportTable.setUpdateTime(importTable.getUpdateTime());
                }

                return existingImportTable;
            })
            .map(importTableRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ImportTable> findAll(Pageable pageable) {
        LOG.debug("Request to get all ImportTables");
        return importTableRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ImportTable> findOne(String id) {
        LOG.debug("Request to get ImportTable : {}", id);
        return importTableRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete ImportTable : {}", id);
        importTableRepository.deleteById(id);
    }
}
