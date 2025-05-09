package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.LiquidCrystalDisplay;
import com.chenhy.repository.commonEntity.LiquidCrystalDisplayRepository;
import com.chenhy.service.commonEntity.LiquidCrystalDisplayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link LiquidCrystalDisplay}.
 */
@Service
@Transactional
public class LiquidCrystalDisplayServiceImpl implements LiquidCrystalDisplayService {

    private static final Logger LOG = LoggerFactory.getLogger(LiquidCrystalDisplayServiceImpl.class);

    private final LiquidCrystalDisplayRepository LiquidCrystalDisplayRepository;

    public LiquidCrystalDisplayServiceImpl(LiquidCrystalDisplayRepository LiquidCrystalDisplayRepository) {
        this.LiquidCrystalDisplayRepository = LiquidCrystalDisplayRepository;
    }

    @Override
    public LiquidCrystalDisplay save(LiquidCrystalDisplay LiquidCrystalDisplay) {
        LOG.debug("Request to save LiquidCrystalDisplay : {}", LiquidCrystalDisplay);
        return LiquidCrystalDisplayRepository.save(LiquidCrystalDisplay);
    }

    @Override
    public LiquidCrystalDisplay update(LiquidCrystalDisplay LiquidCrystalDisplay) {
        LOG.debug("Request to update LiquidCrystalDisplay : {}", LiquidCrystalDisplay);
        return LiquidCrystalDisplayRepository.save(LiquidCrystalDisplay);
    }

    @Override
    public Optional<LiquidCrystalDisplay> partialUpdate(LiquidCrystalDisplay LiquidCrystalDisplay) {
        LOG.debug("Request to partially update LiquidCrystalDisplay : {}", LiquidCrystalDisplay);

        return LiquidCrystalDisplayRepository
            .findById(LiquidCrystalDisplay.getId())
            .map(existingLiquidCrystalDisplay -> {
                if (LiquidCrystalDisplay.getId() != null) {
                    existingLiquidCrystalDisplay.setId(LiquidCrystalDisplay.getId());
                }
                if (LiquidCrystalDisplay.getPartNumber() != null) {
                    existingLiquidCrystalDisplay.setPartNumber(LiquidCrystalDisplay.getPartNumber());
                }
                if (LiquidCrystalDisplay.getPartType() != null) {
                    existingLiquidCrystalDisplay.setPartType(LiquidCrystalDisplay.getPartType());
                }
                if (LiquidCrystalDisplay.getValue() != null) {
                    existingLiquidCrystalDisplay.setValue(LiquidCrystalDisplay.getValue());
                }
                if (LiquidCrystalDisplay.getSchematicPart() != null) {
                    existingLiquidCrystalDisplay.setSchematicPart(LiquidCrystalDisplay.getSchematicPart());
                }
                if (LiquidCrystalDisplay.getRatingVoltage() != null) {
                    existingLiquidCrystalDisplay.setRatingVoltage(LiquidCrystalDisplay.getRatingVoltage());
                }
                if (LiquidCrystalDisplay.getRatingElectricity() != null) {
                    existingLiquidCrystalDisplay.setRatingElectricity(LiquidCrystalDisplay.getRatingElectricity());
                }
                if (LiquidCrystalDisplay.getCharacteristics() != null) {
                    existingLiquidCrystalDisplay.setCharacteristics(LiquidCrystalDisplay.getCharacteristics());
                }
                if (LiquidCrystalDisplay.getTolerance() != null) {
                    existingLiquidCrystalDisplay.setTolerance(LiquidCrystalDisplay.getTolerance());
                }
                if (LiquidCrystalDisplay.getManufacture() != null) {
                    existingLiquidCrystalDisplay.setManufacture(LiquidCrystalDisplay.getManufacture());
                }
                if (LiquidCrystalDisplay.getbCode() != null) {
                    existingLiquidCrystalDisplay.setbCode(LiquidCrystalDisplay.getbCode());
                }
                if (LiquidCrystalDisplay.getPartsName() != null) {
                    existingLiquidCrystalDisplay.setPartsName(LiquidCrystalDisplay.getPartsName());
                }
                if (LiquidCrystalDisplay.getItemRegistrationClassification() != null) {
                    existingLiquidCrystalDisplay.setItemRegistrationClassification(LiquidCrystalDisplay.getItemRegistrationClassification());
                }
                if (LiquidCrystalDisplay.getSpiceModel() != null) {
                    existingLiquidCrystalDisplay.setSpiceModel(LiquidCrystalDisplay.getSpiceModel());
                }
                if (LiquidCrystalDisplay.getPcbFootPrint() != null) {
                    existingLiquidCrystalDisplay.setPcbFootPrint(LiquidCrystalDisplay.getPcbFootPrint());
                }
                if (LiquidCrystalDisplay.getDelFlag() != null) {
                    existingLiquidCrystalDisplay.setDelFlag(LiquidCrystalDisplay.getDelFlag());
                }
                if (LiquidCrystalDisplay.getRemark() != null) {
                    existingLiquidCrystalDisplay.setRemark(LiquidCrystalDisplay.getRemark());
                }
                if (LiquidCrystalDisplay.getCreateBy() != null) {
                    existingLiquidCrystalDisplay.setCreateBy(LiquidCrystalDisplay.getCreateBy());
                }
                if (LiquidCrystalDisplay.getCreateTime() != null) {
                    existingLiquidCrystalDisplay.setCreateTime(LiquidCrystalDisplay.getCreateTime());
                }
                if (LiquidCrystalDisplay.getUpdateBy() != null) {
                    existingLiquidCrystalDisplay.setUpdateBy(LiquidCrystalDisplay.getUpdateBy());
                }
                if (LiquidCrystalDisplay.getUpdateTime() != null) {
                    existingLiquidCrystalDisplay.setUpdateTime(LiquidCrystalDisplay.getUpdateTime());
                }

                return existingLiquidCrystalDisplay;
            })
            .map(LiquidCrystalDisplayRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<LiquidCrystalDisplay> findAll(Pageable pageable) {
        LOG.debug("Request to get all LiquidCrystalDisplays");
        return LiquidCrystalDisplayRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LiquidCrystalDisplay> findOne(String id) {
        LOG.debug("Request to get LiquidCrystalDisplay : {}", id);
        return LiquidCrystalDisplayRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete LiquidCrystalDisplay : {}", id);
        LiquidCrystalDisplayRepository.deleteById(id);
    }
}
