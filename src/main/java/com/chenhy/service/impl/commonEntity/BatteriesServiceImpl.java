package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Batteries;
import com.chenhy.repository.commonEntity.BatteriesRepository;
import com.chenhy.service.commonEntity.BatteriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Batteries}.
 */
@Service
@Transactional
public class BatteriesServiceImpl implements BatteriesService {

    private static final Logger LOG = LoggerFactory.getLogger(BatteriesServiceImpl.class);

    private final BatteriesRepository BatteriesRepository;

    public BatteriesServiceImpl(BatteriesRepository BatteriesRepository) {
        this.BatteriesRepository = BatteriesRepository;
    }

    @Override
    public Batteries save(Batteries Batteries) {
        LOG.debug("Request to save Batteries : {}", Batteries);
        return BatteriesRepository.save(Batteries);
    }

    @Override
    public Batteries update(Batteries Batteries) {
        LOG.debug("Request to update Batteries : {}", Batteries);
        return BatteriesRepository.save(Batteries);
    }

    @Override
    public Optional<Batteries> partialUpdate(Batteries Batteries) {
        LOG.debug("Request to partially update Batteries : {}", Batteries);

        return BatteriesRepository
            .findById(Batteries.getId())
            .map(existingBatteries -> {
                if (Batteries.getId() != null) {
                    existingBatteries.setId(Batteries.getId());
                }
                if (Batteries.getPartNumber() != null) {
                    existingBatteries.setPartNumber(Batteries.getPartNumber());
                }
                if (Batteries.getPartType() != null) {
                    existingBatteries.setPartType(Batteries.getPartType());
                }
                if (Batteries.getValue() != null) {
                    existingBatteries.setValue(Batteries.getValue());
                }
                if (Batteries.getSchematicPart() != null) {
                    existingBatteries.setSchematicPart(Batteries.getSchematicPart());
                }
                if (Batteries.getRatingVoltage() != null) {
                    existingBatteries.setRatingVoltage(Batteries.getRatingVoltage());
                }
                if (Batteries.getRatingElectricity() != null) {
                    existingBatteries.setRatingElectricity(Batteries.getRatingElectricity());
                }
                if (Batteries.getCharacteristics() != null) {
                    existingBatteries.setCharacteristics(Batteries.getCharacteristics());
                }
                if (Batteries.getTolerance() != null) {
                    existingBatteries.setTolerance(Batteries.getTolerance());
                }
                if (Batteries.getManufacture() != null) {
                    existingBatteries.setManufacture(Batteries.getManufacture());
                }
                if (Batteries.getbCode() != null) {
                    existingBatteries.setbCode(Batteries.getbCode());
                }
                if (Batteries.getPartsName() != null) {
                    existingBatteries.setPartsName(Batteries.getPartsName());
                }
                if (Batteries.getItemRegistrationClassification() != null) {
                    existingBatteries.setItemRegistrationClassification(Batteries.getItemRegistrationClassification());
                }
                if (Batteries.getSpiceModel() != null) {
                    existingBatteries.setSpiceModel(Batteries.getSpiceModel());
                }
                if (Batteries.getPcbFootPrint() != null) {
                    existingBatteries.setPcbFootPrint(Batteries.getPcbFootPrint());
                }
                if (Batteries.getDelFlag() != null) {
                    existingBatteries.setDelFlag(Batteries.getDelFlag());
                }
                if (Batteries.getRemark() != null) {
                    existingBatteries.setRemark(Batteries.getRemark());
                }
                if (Batteries.getCreateBy() != null) {
                    existingBatteries.setCreateBy(Batteries.getCreateBy());
                }
                if (Batteries.getCreateTime() != null) {
                    existingBatteries.setCreateTime(Batteries.getCreateTime());
                }
                if (Batteries.getUpdateBy() != null) {
                    existingBatteries.setUpdateBy(Batteries.getUpdateBy());
                }
                if (Batteries.getUpdateTime() != null) {
                    existingBatteries.setUpdateTime(Batteries.getUpdateTime());
                }

                return existingBatteries;
            })
            .map(BatteriesRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Batteries> findAll(Pageable pageable) {
        LOG.debug("Request to get all Batteriess");
        return BatteriesRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Batteries> findOne(String id) {
        LOG.debug("Request to get Batteries : {}", id);
        return BatteriesRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Batteries : {}", id);
        BatteriesRepository.deleteById(id);
    }
}
