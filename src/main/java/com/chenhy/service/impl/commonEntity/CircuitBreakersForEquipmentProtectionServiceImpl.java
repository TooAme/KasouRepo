package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.CircuitBreakersForEquipmentProtection;
import com.chenhy.repository.commonEntity.CircuitBreakersForEquipmentProtectionRepository;
import com.chenhy.service.commonEntity.CircuitBreakersForEquipmentProtectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CircuitBreakersForEquipmentProtection}.
 */
@Service
@Transactional
public class CircuitBreakersForEquipmentProtectionServiceImpl implements CircuitBreakersForEquipmentProtectionService {

    private static final Logger LOG = LoggerFactory.getLogger(CircuitBreakersForEquipmentProtectionServiceImpl.class);

    private final CircuitBreakersForEquipmentProtectionRepository CircuitBreakersForEquipmentProtectionRepository;

    public CircuitBreakersForEquipmentProtectionServiceImpl(CircuitBreakersForEquipmentProtectionRepository CircuitBreakersForEquipmentProtectionRepository) {
        this.CircuitBreakersForEquipmentProtectionRepository = CircuitBreakersForEquipmentProtectionRepository;
    }

    @Override
    public CircuitBreakersForEquipmentProtection save(CircuitBreakersForEquipmentProtection CircuitBreakersForEquipmentProtection) {
        LOG.debug("Request to save CircuitBreakersForEquipmentProtection : {}", CircuitBreakersForEquipmentProtection);
        return CircuitBreakersForEquipmentProtectionRepository.save(CircuitBreakersForEquipmentProtection);
    }

    @Override
    public CircuitBreakersForEquipmentProtection update(CircuitBreakersForEquipmentProtection CircuitBreakersForEquipmentProtection) {
        LOG.debug("Request to update CircuitBreakersForEquipmentProtection : {}", CircuitBreakersForEquipmentProtection);
        return CircuitBreakersForEquipmentProtectionRepository.save(CircuitBreakersForEquipmentProtection);
    }

    @Override
    public Optional<CircuitBreakersForEquipmentProtection> partialUpdate(CircuitBreakersForEquipmentProtection CircuitBreakersForEquipmentProtection) {
        LOG.debug("Request to partially update CircuitBreakersForEquipmentProtection : {}", CircuitBreakersForEquipmentProtection);

        return CircuitBreakersForEquipmentProtectionRepository
            .findById(CircuitBreakersForEquipmentProtection.getId())
            .map(existingCircuitBreakersForEquipmentProtection -> {
                if (CircuitBreakersForEquipmentProtection.getId() != null) {
                    existingCircuitBreakersForEquipmentProtection.setId(CircuitBreakersForEquipmentProtection.getId());
                }
                if (CircuitBreakersForEquipmentProtection.getPartNumber() != null) {
                    existingCircuitBreakersForEquipmentProtection.setPartNumber(CircuitBreakersForEquipmentProtection.getPartNumber());
                }
                if (CircuitBreakersForEquipmentProtection.getPartType() != null) {
                    existingCircuitBreakersForEquipmentProtection.setPartType(CircuitBreakersForEquipmentProtection.getPartType());
                }
                if (CircuitBreakersForEquipmentProtection.getValue() != null) {
                    existingCircuitBreakersForEquipmentProtection.setValue(CircuitBreakersForEquipmentProtection.getValue());
                }
                if (CircuitBreakersForEquipmentProtection.getSchematicPart() != null) {
                    existingCircuitBreakersForEquipmentProtection.setSchematicPart(CircuitBreakersForEquipmentProtection.getSchematicPart());
                }
                if (CircuitBreakersForEquipmentProtection.getRatingVoltage() != null) {
                    existingCircuitBreakersForEquipmentProtection.setRatingVoltage(CircuitBreakersForEquipmentProtection.getRatingVoltage());
                }
                if (CircuitBreakersForEquipmentProtection.getRatingElectricity() != null) {
                    existingCircuitBreakersForEquipmentProtection.setRatingElectricity(CircuitBreakersForEquipmentProtection.getRatingElectricity());
                }
                if (CircuitBreakersForEquipmentProtection.getCharacteristics() != null) {
                    existingCircuitBreakersForEquipmentProtection.setCharacteristics(CircuitBreakersForEquipmentProtection.getCharacteristics());
                }
                if (CircuitBreakersForEquipmentProtection.getTolerance() != null) {
                    existingCircuitBreakersForEquipmentProtection.setTolerance(CircuitBreakersForEquipmentProtection.getTolerance());
                }
                if (CircuitBreakersForEquipmentProtection.getManufacture() != null) {
                    existingCircuitBreakersForEquipmentProtection.setManufacture(CircuitBreakersForEquipmentProtection.getManufacture());
                }
                if (CircuitBreakersForEquipmentProtection.getbCode() != null) {
                    existingCircuitBreakersForEquipmentProtection.setbCode(CircuitBreakersForEquipmentProtection.getbCode());
                }
                if (CircuitBreakersForEquipmentProtection.getPartsName() != null) {
                    existingCircuitBreakersForEquipmentProtection.setPartsName(CircuitBreakersForEquipmentProtection.getPartsName());
                }
                if (CircuitBreakersForEquipmentProtection.getItemRegistrationClassification() != null) {
                    existingCircuitBreakersForEquipmentProtection.setItemRegistrationClassification(CircuitBreakersForEquipmentProtection.getItemRegistrationClassification());
                }
                if (CircuitBreakersForEquipmentProtection.getSpiceModel() != null) {
                    existingCircuitBreakersForEquipmentProtection.setSpiceModel(CircuitBreakersForEquipmentProtection.getSpiceModel());
                }
                if (CircuitBreakersForEquipmentProtection.getPcbFootPrint() != null) {
                    existingCircuitBreakersForEquipmentProtection.setPcbFootPrint(CircuitBreakersForEquipmentProtection.getPcbFootPrint());
                }
                if (CircuitBreakersForEquipmentProtection.getDelFlag() != null) {
                    existingCircuitBreakersForEquipmentProtection.setDelFlag(CircuitBreakersForEquipmentProtection.getDelFlag());
                }
                if (CircuitBreakersForEquipmentProtection.getRemark() != null) {
                    existingCircuitBreakersForEquipmentProtection.setRemark(CircuitBreakersForEquipmentProtection.getRemark());
                }
                if (CircuitBreakersForEquipmentProtection.getCreateBy() != null) {
                    existingCircuitBreakersForEquipmentProtection.setCreateBy(CircuitBreakersForEquipmentProtection.getCreateBy());
                }
                if (CircuitBreakersForEquipmentProtection.getCreateTime() != null) {
                    existingCircuitBreakersForEquipmentProtection.setCreateTime(CircuitBreakersForEquipmentProtection.getCreateTime());
                }
                if (CircuitBreakersForEquipmentProtection.getUpdateBy() != null) {
                    existingCircuitBreakersForEquipmentProtection.setUpdateBy(CircuitBreakersForEquipmentProtection.getUpdateBy());
                }
                if (CircuitBreakersForEquipmentProtection.getUpdateTime() != null) {
                    existingCircuitBreakersForEquipmentProtection.setUpdateTime(CircuitBreakersForEquipmentProtection.getUpdateTime());
                }

                return existingCircuitBreakersForEquipmentProtection;
            })
            .map(CircuitBreakersForEquipmentProtectionRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CircuitBreakersForEquipmentProtection> findAll(Pageable pageable) {
        LOG.debug("Request to get all CircuitBreakersForEquipmentProtections");
        return CircuitBreakersForEquipmentProtectionRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CircuitBreakersForEquipmentProtection> findOne(String id) {
        LOG.debug("Request to get CircuitBreakersForEquipmentProtection : {}", id);
        return CircuitBreakersForEquipmentProtectionRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete CircuitBreakersForEquipmentProtection : {}", id);
        CircuitBreakersForEquipmentProtectionRepository.deleteById(id);
    }
}
