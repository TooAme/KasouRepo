package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Thermistors;
import com.chenhy.repository.commonEntity.ThermistorsRepository;
import com.chenhy.service.commonEntity.ThermistorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Thermistors}.
 */
@Service
@Transactional
public class ThermistorsServiceImpl implements ThermistorsService {

    private static final Logger LOG = LoggerFactory.getLogger(ThermistorsServiceImpl.class);

    private final ThermistorsRepository ThermistorsRepository;

    public ThermistorsServiceImpl(ThermistorsRepository ThermistorsRepository) {
        this.ThermistorsRepository = ThermistorsRepository;
    }

    @Override
    public Thermistors save(Thermistors Thermistors) {
        LOG.debug("Request to save Thermistors : {}", Thermistors);
        return ThermistorsRepository.save(Thermistors);
    }

    @Override
    public Thermistors update(Thermistors Thermistors) {
        LOG.debug("Request to update Thermistors : {}", Thermistors);
        return ThermistorsRepository.save(Thermistors);
    }

    @Override
    public Optional<Thermistors> partialUpdate(Thermistors Thermistors) {
        LOG.debug("Request to partially update Thermistors : {}", Thermistors);

        return ThermistorsRepository
            .findById(Thermistors.getId())
            .map(existingThermistors -> {
                if (Thermistors.getId() != null) {
                    existingThermistors.setId(Thermistors.getId());
                }
                if (Thermistors.getPartNumber() != null) {
                    existingThermistors.setPartNumber(Thermistors.getPartNumber());
                }
                if (Thermistors.getPartType() != null) {
                    existingThermistors.setPartType(Thermistors.getPartType());
                }
                if (Thermistors.getValue() != null) {
                    existingThermistors.setValue(Thermistors.getValue());
                }
                if (Thermistors.getSchematicPart() != null) {
                    existingThermistors.setSchematicPart(Thermistors.getSchematicPart());
                }
                if (Thermistors.getRatingVoltage() != null) {
                    existingThermistors.setRatingVoltage(Thermistors.getRatingVoltage());
                }
                if (Thermistors.getRatingElectricity() != null) {
                    existingThermistors.setRatingElectricity(Thermistors.getRatingElectricity());
                }
                if (Thermistors.getCharacteristics() != null) {
                    existingThermistors.setCharacteristics(Thermistors.getCharacteristics());
                }
                if (Thermistors.getTolerance() != null) {
                    existingThermistors.setTolerance(Thermistors.getTolerance());
                }
                if (Thermistors.getManufacture() != null) {
                    existingThermistors.setManufacture(Thermistors.getManufacture());
                }
                if (Thermistors.getbCode() != null) {
                    existingThermistors.setbCode(Thermistors.getbCode());
                }
                if (Thermistors.getPartsName() != null) {
                    existingThermistors.setPartsName(Thermistors.getPartsName());
                }
                if (Thermistors.getItemRegistrationClassification() != null) {
                    existingThermistors.setItemRegistrationClassification(Thermistors.getItemRegistrationClassification());
                }
                if (Thermistors.getSpiceModel() != null) {
                    existingThermistors.setSpiceModel(Thermistors.getSpiceModel());
                }
                if (Thermistors.getPcbFootPrint() != null) {
                    existingThermistors.setPcbFootPrint(Thermistors.getPcbFootPrint());
                }
                if (Thermistors.getDelFlag() != null) {
                    existingThermistors.setDelFlag(Thermistors.getDelFlag());
                }
                if (Thermistors.getRemark() != null) {
                    existingThermistors.setRemark(Thermistors.getRemark());
                }
                if (Thermistors.getCreateBy() != null) {
                    existingThermistors.setCreateBy(Thermistors.getCreateBy());
                }
                if (Thermistors.getCreateTime() != null) {
                    existingThermistors.setCreateTime(Thermistors.getCreateTime());
                }
                if (Thermistors.getUpdateBy() != null) {
                    existingThermistors.setUpdateBy(Thermistors.getUpdateBy());
                }
                if (Thermistors.getUpdateTime() != null) {
                    existingThermistors.setUpdateTime(Thermistors.getUpdateTime());
                }

                return existingThermistors;
            })
            .map(ThermistorsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Thermistors> findAll(Pageable pageable) {
        LOG.debug("Request to get all Thermistorss");
        return ThermistorsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Thermistors> findOne(String id) {
        LOG.debug("Request to get Thermistors : {}", id);
        return ThermistorsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Thermistors : {}", id);
        ThermistorsRepository.deleteById(id);
    }
}
