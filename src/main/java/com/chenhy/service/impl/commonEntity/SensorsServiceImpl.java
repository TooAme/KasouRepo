package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Sensors;
import com.chenhy.repository.commonEntity.SensorsRepository;
import com.chenhy.service.commonEntity.SensorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Sensors}.
 */
@Service
@Transactional
public class SensorsServiceImpl implements SensorsService {

    private static final Logger LOG = LoggerFactory.getLogger(SensorsServiceImpl.class);

    private final SensorsRepository SensorsRepository;

    public SensorsServiceImpl(SensorsRepository SensorsRepository) {
        this.SensorsRepository = SensorsRepository;
    }

    @Override
    public Sensors save(Sensors Sensors) {
        LOG.debug("Request to save Sensors : {}", Sensors);
        return SensorsRepository.save(Sensors);
    }

    @Override
    public Sensors update(Sensors Sensors) {
        LOG.debug("Request to update Sensors : {}", Sensors);
        return SensorsRepository.save(Sensors);
    }

    @Override
    public Optional<Sensors> partialUpdate(Sensors Sensors) {
        LOG.debug("Request to partially update Sensors : {}", Sensors);

        return SensorsRepository
            .findById(Sensors.getId())
            .map(existingSensors -> {
                if (Sensors.getId() != null) {
                    existingSensors.setId(Sensors.getId());
                }
                if (Sensors.getPartNumber() != null) {
                    existingSensors.setPartNumber(Sensors.getPartNumber());
                }
                if (Sensors.getPartType() != null) {
                    existingSensors.setPartType(Sensors.getPartType());
                }
                if (Sensors.getValue() != null) {
                    existingSensors.setValue(Sensors.getValue());
                }
                if (Sensors.getSchematicPart() != null) {
                    existingSensors.setSchematicPart(Sensors.getSchematicPart());
                }
                if (Sensors.getRatingVoltage() != null) {
                    existingSensors.setRatingVoltage(Sensors.getRatingVoltage());
                }
                if (Sensors.getRatingElectricity() != null) {
                    existingSensors.setRatingElectricity(Sensors.getRatingElectricity());
                }
                if (Sensors.getCharacteristics() != null) {
                    existingSensors.setCharacteristics(Sensors.getCharacteristics());
                }
                if (Sensors.getTolerance() != null) {
                    existingSensors.setTolerance(Sensors.getTolerance());
                }
                if (Sensors.getManufacture() != null) {
                    existingSensors.setManufacture(Sensors.getManufacture());
                }
                if (Sensors.getbCode() != null) {
                    existingSensors.setbCode(Sensors.getbCode());
                }
                if (Sensors.getPartsName() != null) {
                    existingSensors.setPartsName(Sensors.getPartsName());
                }
                if (Sensors.getItemRegistrationClassification() != null) {
                    existingSensors.setItemRegistrationClassification(Sensors.getItemRegistrationClassification());
                }
                if (Sensors.getSpiceModel() != null) {
                    existingSensors.setSpiceModel(Sensors.getSpiceModel());
                }
                if (Sensors.getPcbFootPrint() != null) {
                    existingSensors.setPcbFootPrint(Sensors.getPcbFootPrint());
                }
                if (Sensors.getDelFlag() != null) {
                    existingSensors.setDelFlag(Sensors.getDelFlag());
                }
                if (Sensors.getRemark() != null) {
                    existingSensors.setRemark(Sensors.getRemark());
                }
                if (Sensors.getCreateBy() != null) {
                    existingSensors.setCreateBy(Sensors.getCreateBy());
                }
                if (Sensors.getCreateTime() != null) {
                    existingSensors.setCreateTime(Sensors.getCreateTime());
                }
                if (Sensors.getUpdateBy() != null) {
                    existingSensors.setUpdateBy(Sensors.getUpdateBy());
                }
                if (Sensors.getUpdateTime() != null) {
                    existingSensors.setUpdateTime(Sensors.getUpdateTime());
                }

                return existingSensors;
            })
            .map(SensorsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Sensors> findAll(Pageable pageable) {
        LOG.debug("Request to get all Sensorss");
        return SensorsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sensors> findOne(String id) {
        LOG.debug("Request to get Sensors : {}", id);
        return SensorsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Sensors : {}", id);
        SensorsRepository.deleteById(id);
    }
}
