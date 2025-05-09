package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.FunctionCircuitModules;
import com.chenhy.repository.commonEntity.FunctionCircuitModulesRepository;
import com.chenhy.service.commonEntity.FunctionCircuitModulesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link FunctionCircuitModules}.
 */
@Service
@Transactional
public class FunctionCircuitModulesServiceImpl implements FunctionCircuitModulesService {

    private static final Logger LOG = LoggerFactory.getLogger(FunctionCircuitModulesServiceImpl.class);

    private final FunctionCircuitModulesRepository FunctionCircuitModulesRepository;

    public FunctionCircuitModulesServiceImpl(FunctionCircuitModulesRepository FunctionCircuitModulesRepository) {
        this.FunctionCircuitModulesRepository = FunctionCircuitModulesRepository;
    }

    @Override
    public FunctionCircuitModules save(FunctionCircuitModules FunctionCircuitModules) {
        LOG.debug("Request to save FunctionCircuitModules : {}", FunctionCircuitModules);
        return FunctionCircuitModulesRepository.save(FunctionCircuitModules);
    }

    @Override
    public FunctionCircuitModules update(FunctionCircuitModules FunctionCircuitModules) {
        LOG.debug("Request to update FunctionCircuitModules : {}", FunctionCircuitModules);
        return FunctionCircuitModulesRepository.save(FunctionCircuitModules);
    }

    @Override
    public Optional<FunctionCircuitModules> partialUpdate(FunctionCircuitModules FunctionCircuitModules) {
        LOG.debug("Request to partially update FunctionCircuitModules : {}", FunctionCircuitModules);

        return FunctionCircuitModulesRepository
            .findById(FunctionCircuitModules.getId())
            .map(existingFunctionCircuitModules -> {
                if (FunctionCircuitModules.getId() != null) {
                    existingFunctionCircuitModules.setId(FunctionCircuitModules.getId());
                }
                if (FunctionCircuitModules.getPartNumber() != null) {
                    existingFunctionCircuitModules.setPartNumber(FunctionCircuitModules.getPartNumber());
                }
                if (FunctionCircuitModules.getPartType() != null) {
                    existingFunctionCircuitModules.setPartType(FunctionCircuitModules.getPartType());
                }
                if (FunctionCircuitModules.getValue() != null) {
                    existingFunctionCircuitModules.setValue(FunctionCircuitModules.getValue());
                }
                if (FunctionCircuitModules.getSchematicPart() != null) {
                    existingFunctionCircuitModules.setSchematicPart(FunctionCircuitModules.getSchematicPart());
                }
                if (FunctionCircuitModules.getRatingVoltage() != null) {
                    existingFunctionCircuitModules.setRatingVoltage(FunctionCircuitModules.getRatingVoltage());
                }
                if (FunctionCircuitModules.getRatingElectricity() != null) {
                    existingFunctionCircuitModules.setRatingElectricity(FunctionCircuitModules.getRatingElectricity());
                }
                if (FunctionCircuitModules.getCharacteristics() != null) {
                    existingFunctionCircuitModules.setCharacteristics(FunctionCircuitModules.getCharacteristics());
                }
                if (FunctionCircuitModules.getTolerance() != null) {
                    existingFunctionCircuitModules.setTolerance(FunctionCircuitModules.getTolerance());
                }
                if (FunctionCircuitModules.getManufacture() != null) {
                    existingFunctionCircuitModules.setManufacture(FunctionCircuitModules.getManufacture());
                }
                if (FunctionCircuitModules.getbCode() != null) {
                    existingFunctionCircuitModules.setbCode(FunctionCircuitModules.getbCode());
                }
                if (FunctionCircuitModules.getPartsName() != null) {
                    existingFunctionCircuitModules.setPartsName(FunctionCircuitModules.getPartsName());
                }
                if (FunctionCircuitModules.getItemRegistrationClassification() != null) {
                    existingFunctionCircuitModules.setItemRegistrationClassification(FunctionCircuitModules.getItemRegistrationClassification());
                }
                if (FunctionCircuitModules.getSpiceModel() != null) {
                    existingFunctionCircuitModules.setSpiceModel(FunctionCircuitModules.getSpiceModel());
                }
                if (FunctionCircuitModules.getPcbFootPrint() != null) {
                    existingFunctionCircuitModules.setPcbFootPrint(FunctionCircuitModules.getPcbFootPrint());
                }
                if (FunctionCircuitModules.getDelFlag() != null) {
                    existingFunctionCircuitModules.setDelFlag(FunctionCircuitModules.getDelFlag());
                }
                if (FunctionCircuitModules.getRemark() != null) {
                    existingFunctionCircuitModules.setRemark(FunctionCircuitModules.getRemark());
                }
                if (FunctionCircuitModules.getCreateBy() != null) {
                    existingFunctionCircuitModules.setCreateBy(FunctionCircuitModules.getCreateBy());
                }
                if (FunctionCircuitModules.getCreateTime() != null) {
                    existingFunctionCircuitModules.setCreateTime(FunctionCircuitModules.getCreateTime());
                }
                if (FunctionCircuitModules.getUpdateBy() != null) {
                    existingFunctionCircuitModules.setUpdateBy(FunctionCircuitModules.getUpdateBy());
                }
                if (FunctionCircuitModules.getUpdateTime() != null) {
                    existingFunctionCircuitModules.setUpdateTime(FunctionCircuitModules.getUpdateTime());
                }

                return existingFunctionCircuitModules;
            })
            .map(FunctionCircuitModulesRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<FunctionCircuitModules> findAll(Pageable pageable) {
        LOG.debug("Request to get all FunctionCircuitModuless");
        return FunctionCircuitModulesRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FunctionCircuitModules> findOne(String id) {
        LOG.debug("Request to get FunctionCircuitModules : {}", id);
        return FunctionCircuitModulesRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete FunctionCircuitModules : {}", id);
        FunctionCircuitModulesRepository.deleteById(id);
    }
}
