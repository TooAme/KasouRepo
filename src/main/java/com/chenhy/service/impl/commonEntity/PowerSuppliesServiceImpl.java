package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.PowerSupplies;
import com.chenhy.repository.commonEntity.PowerSuppliesRepository;
import com.chenhy.service.commonEntity.PowerSuppliesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link PowerSupplies}.
 */
@Service
@Transactional
public class PowerSuppliesServiceImpl implements PowerSuppliesService {

    private static final Logger LOG = LoggerFactory.getLogger(PowerSuppliesServiceImpl.class);

    private final PowerSuppliesRepository PowerSuppliesRepository;

    public PowerSuppliesServiceImpl(PowerSuppliesRepository PowerSuppliesRepository) {
        this.PowerSuppliesRepository = PowerSuppliesRepository;
    }

    @Override
    public PowerSupplies save(PowerSupplies PowerSupplies) {
        LOG.debug("Request to save PowerSupplies : {}", PowerSupplies);
        return PowerSuppliesRepository.save(PowerSupplies);
    }

    @Override
    public PowerSupplies update(PowerSupplies PowerSupplies) {
        LOG.debug("Request to update PowerSupplies : {}", PowerSupplies);
        return PowerSuppliesRepository.save(PowerSupplies);
    }

    @Override
    public Optional<PowerSupplies> partialUpdate(PowerSupplies PowerSupplies) {
        LOG.debug("Request to partially update PowerSupplies : {}", PowerSupplies);

        return PowerSuppliesRepository
            .findById(PowerSupplies.getId())
            .map(existingPowerSupplies -> {
                if (PowerSupplies.getId() != null) {
                    existingPowerSupplies.setId(PowerSupplies.getId());
                }
                if (PowerSupplies.getPartNumber() != null) {
                    existingPowerSupplies.setPartNumber(PowerSupplies.getPartNumber());
                }
                if (PowerSupplies.getPartType() != null) {
                    existingPowerSupplies.setPartType(PowerSupplies.getPartType());
                }
                if (PowerSupplies.getValue() != null) {
                    existingPowerSupplies.setValue(PowerSupplies.getValue());
                }
                if (PowerSupplies.getSchematicPart() != null) {
                    existingPowerSupplies.setSchematicPart(PowerSupplies.getSchematicPart());
                }
                if (PowerSupplies.getRatingVoltage() != null) {
                    existingPowerSupplies.setRatingVoltage(PowerSupplies.getRatingVoltage());
                }
                if (PowerSupplies.getRatingElectricity() != null) {
                    existingPowerSupplies.setRatingElectricity(PowerSupplies.getRatingElectricity());
                }
                if (PowerSupplies.getCharacteristics() != null) {
                    existingPowerSupplies.setCharacteristics(PowerSupplies.getCharacteristics());
                }
                if (PowerSupplies.getTolerance() != null) {
                    existingPowerSupplies.setTolerance(PowerSupplies.getTolerance());
                }
                if (PowerSupplies.getManufacture() != null) {
                    existingPowerSupplies.setManufacture(PowerSupplies.getManufacture());
                }
                if (PowerSupplies.getbCode() != null) {
                    existingPowerSupplies.setbCode(PowerSupplies.getbCode());
                }
                if (PowerSupplies.getPartsName() != null) {
                    existingPowerSupplies.setPartsName(PowerSupplies.getPartsName());
                }
                if (PowerSupplies.getItemRegistrationClassification() != null) {
                    existingPowerSupplies.setItemRegistrationClassification(PowerSupplies.getItemRegistrationClassification());
                }
                if (PowerSupplies.getSpiceModel() != null) {
                    existingPowerSupplies.setSpiceModel(PowerSupplies.getSpiceModel());
                }
                if (PowerSupplies.getPcbFootPrint() != null) {
                    existingPowerSupplies.setPcbFootPrint(PowerSupplies.getPcbFootPrint());
                }
                if (PowerSupplies.getDelFlag() != null) {
                    existingPowerSupplies.setDelFlag(PowerSupplies.getDelFlag());
                }
                if (PowerSupplies.getRemark() != null) {
                    existingPowerSupplies.setRemark(PowerSupplies.getRemark());
                }
                if (PowerSupplies.getCreateBy() != null) {
                    existingPowerSupplies.setCreateBy(PowerSupplies.getCreateBy());
                }
                if (PowerSupplies.getCreateTime() != null) {
                    existingPowerSupplies.setCreateTime(PowerSupplies.getCreateTime());
                }
                if (PowerSupplies.getUpdateBy() != null) {
                    existingPowerSupplies.setUpdateBy(PowerSupplies.getUpdateBy());
                }
                if (PowerSupplies.getUpdateTime() != null) {
                    existingPowerSupplies.setUpdateTime(PowerSupplies.getUpdateTime());
                }

                return existingPowerSupplies;
            })
            .map(PowerSuppliesRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PowerSupplies> findAll(Pageable pageable) {
        LOG.debug("Request to get all PowerSuppliess");
        return PowerSuppliesRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PowerSupplies> findOne(String id) {
        LOG.debug("Request to get PowerSupplies : {}", id);
        return PowerSuppliesRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete PowerSupplies : {}", id);
        PowerSuppliesRepository.deleteById(id);
    }
}
