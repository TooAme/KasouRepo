package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Thyristors;
import com.chenhy.repository.commonEntity.ThyristorsRepository;
import com.chenhy.service.commonEntity.ThyristorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Thyristors}.
 */
@Service
@Transactional
public class ThyristorsServiceImpl implements ThyristorsService {

    private static final Logger LOG = LoggerFactory.getLogger(ThyristorsServiceImpl.class);

    private final ThyristorsRepository ThyristorsRepository;

    public ThyristorsServiceImpl(ThyristorsRepository ThyristorsRepository) {
        this.ThyristorsRepository = ThyristorsRepository;
    }

    @Override
    public Thyristors save(Thyristors Thyristors) {
        LOG.debug("Request to save Thyristors : {}", Thyristors);
        return ThyristorsRepository.save(Thyristors);
    }

    @Override
    public Thyristors update(Thyristors Thyristors) {
        LOG.debug("Request to update Thyristors : {}", Thyristors);
        return ThyristorsRepository.save(Thyristors);
    }

    @Override
    public Optional<Thyristors> partialUpdate(Thyristors Thyristors) {
        LOG.debug("Request to partially update Thyristors : {}", Thyristors);

        return ThyristorsRepository
            .findById(Thyristors.getId())
            .map(existingThyristors -> {
                if (Thyristors.getId() != null) {
                    existingThyristors.setId(Thyristors.getId());
                }
                if (Thyristors.getPartNumber() != null) {
                    existingThyristors.setPartNumber(Thyristors.getPartNumber());
                }
                if (Thyristors.getPartType() != null) {
                    existingThyristors.setPartType(Thyristors.getPartType());
                }
                if (Thyristors.getValue() != null) {
                    existingThyristors.setValue(Thyristors.getValue());
                }
                if (Thyristors.getSchematicPart() != null) {
                    existingThyristors.setSchematicPart(Thyristors.getSchematicPart());
                }
                if (Thyristors.getRatingVoltage() != null) {
                    existingThyristors.setRatingVoltage(Thyristors.getRatingVoltage());
                }
                if (Thyristors.getRatingElectricity() != null) {
                    existingThyristors.setRatingElectricity(Thyristors.getRatingElectricity());
                }
                if (Thyristors.getCharacteristics() != null) {
                    existingThyristors.setCharacteristics(Thyristors.getCharacteristics());
                }
                if (Thyristors.getTolerance() != null) {
                    existingThyristors.setTolerance(Thyristors.getTolerance());
                }
                if (Thyristors.getManufacture() != null) {
                    existingThyristors.setManufacture(Thyristors.getManufacture());
                }
                if (Thyristors.getbCode() != null) {
                    existingThyristors.setbCode(Thyristors.getbCode());
                }
                if (Thyristors.getPartsName() != null) {
                    existingThyristors.setPartsName(Thyristors.getPartsName());
                }
                if (Thyristors.getItemRegistrationClassification() != null) {
                    existingThyristors.setItemRegistrationClassification(Thyristors.getItemRegistrationClassification());
                }
                if (Thyristors.getSpiceModel() != null) {
                    existingThyristors.setSpiceModel(Thyristors.getSpiceModel());
                }
                if (Thyristors.getPcbFootPrint() != null) {
                    existingThyristors.setPcbFootPrint(Thyristors.getPcbFootPrint());
                }
                if (Thyristors.getDelFlag() != null) {
                    existingThyristors.setDelFlag(Thyristors.getDelFlag());
                }
                if (Thyristors.getRemark() != null) {
                    existingThyristors.setRemark(Thyristors.getRemark());
                }
                if (Thyristors.getCreateBy() != null) {
                    existingThyristors.setCreateBy(Thyristors.getCreateBy());
                }
                if (Thyristors.getCreateTime() != null) {
                    existingThyristors.setCreateTime(Thyristors.getCreateTime());
                }
                if (Thyristors.getUpdateBy() != null) {
                    existingThyristors.setUpdateBy(Thyristors.getUpdateBy());
                }
                if (Thyristors.getUpdateTime() != null) {
                    existingThyristors.setUpdateTime(Thyristors.getUpdateTime());
                }

                return existingThyristors;
            })
            .map(ThyristorsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Thyristors> findAll(Pageable pageable) {
        LOG.debug("Request to get all Thyristorss");
        return ThyristorsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Thyristors> findOne(String id) {
        LOG.debug("Request to get Thyristors : {}", id);
        return ThyristorsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Thyristors : {}", id);
        ThyristorsRepository.deleteById(id);
    }
}
