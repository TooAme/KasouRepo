package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Resistors;
import com.chenhy.repository.commonEntity.ResistorsRepository;
import com.chenhy.service.commonEntity.ResistorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Resistors}.
 */
@Service
@Transactional
public class PlasmaDisplayDeviceServiceImpl implements ResistorsService {

    private static final Logger LOG = LoggerFactory.getLogger(PlasmaDisplayDeviceServiceImpl.class);

    private final ResistorsRepository ResistorsRepository;

    public PlasmaDisplayDeviceServiceImpl(ResistorsRepository ResistorsRepository) {
        this.ResistorsRepository = ResistorsRepository;
    }

    @Override
    public Resistors save(Resistors Resistors) {
        LOG.debug("Request to save Resistors : {}", Resistors);
        return ResistorsRepository.save(Resistors);
    }

    @Override
    public Resistors update(Resistors Resistors) {
        LOG.debug("Request to update Resistors : {}", Resistors);
        return ResistorsRepository.save(Resistors);
    }

    @Override
    public Optional<Resistors> partialUpdate(Resistors Resistors) {
        LOG.debug("Request to partially update Resistors : {}", Resistors);

        return ResistorsRepository
            .findById(Resistors.getId())
            .map(existingResistors -> {
                if (Resistors.getId() != null) {
                    existingResistors.setId(Resistors.getId());
                }
                if (Resistors.getPartNumber() != null) {
                    existingResistors.setPartNumber(Resistors.getPartNumber());
                }
                if (Resistors.getPartType() != null) {
                    existingResistors.setPartType(Resistors.getPartType());
                }
                if (Resistors.getValue() != null) {
                    existingResistors.setValue(Resistors.getValue());
                }
                if (Resistors.getSchematicPart() != null) {
                    existingResistors.setSchematicPart(Resistors.getSchematicPart());
                }
                if (Resistors.getRatingVoltage() != null) {
                    existingResistors.setRatingVoltage(Resistors.getRatingVoltage());
                }
                if (Resistors.getRatingElectricity() != null) {
                    existingResistors.setRatingElectricity(Resistors.getRatingElectricity());
                }
                if (Resistors.getCharacteristics() != null) {
                    existingResistors.setCharacteristics(Resistors.getCharacteristics());
                }
                if (Resistors.getTolerance() != null) {
                    existingResistors.setTolerance(Resistors.getTolerance());
                }
                if (Resistors.getManufacture() != null) {
                    existingResistors.setManufacture(Resistors.getManufacture());
                }
                if (Resistors.getbCode() != null) {
                    existingResistors.setbCode(Resistors.getbCode());
                }
                if (Resistors.getPartsName() != null) {
                    existingResistors.setPartsName(Resistors.getPartsName());
                }
                if (Resistors.getItemRegistrationClassification() != null) {
                    existingResistors.setItemRegistrationClassification(Resistors.getItemRegistrationClassification());
                }
                if (Resistors.getSpiceModel() != null) {
                    existingResistors.setSpiceModel(Resistors.getSpiceModel());
                }
                if (Resistors.getPcbFootPrint() != null) {
                    existingResistors.setPcbFootPrint(Resistors.getPcbFootPrint());
                }
                if (Resistors.getDelFlag() != null) {
                    existingResistors.setDelFlag(Resistors.getDelFlag());
                }
                if (Resistors.getRemark() != null) {
                    existingResistors.setRemark(Resistors.getRemark());
                }
                if (Resistors.getCreateBy() != null) {
                    existingResistors.setCreateBy(Resistors.getCreateBy());
                }
                if (Resistors.getCreateTime() != null) {
                    existingResistors.setCreateTime(Resistors.getCreateTime());
                }
                if (Resistors.getUpdateBy() != null) {
                    existingResistors.setUpdateBy(Resistors.getUpdateBy());
                }
                if (Resistors.getUpdateTime() != null) {
                    existingResistors.setUpdateTime(Resistors.getUpdateTime());
                }

                return existingResistors;
            })
            .map(ResistorsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Resistors> findAll(Pageable pageable) {
        LOG.debug("Request to get all Resistorss");
        return ResistorsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Resistors> findOne(String id) {
        LOG.debug("Request to get Resistors : {}", id);
        return ResistorsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Resistors : {}", id);
        ResistorsRepository.deleteById(id);
    }
}
