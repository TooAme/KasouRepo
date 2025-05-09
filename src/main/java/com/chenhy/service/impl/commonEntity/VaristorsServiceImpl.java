package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Varistors;
import com.chenhy.repository.commonEntity.VaristorsRepository;
import com.chenhy.service.commonEntity.VaristorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Varistors}.
 */
@Service
@Transactional
public class VaristorsServiceImpl implements VaristorsService {

    private static final Logger LOG = LoggerFactory.getLogger(VaristorsServiceImpl.class);

    private final VaristorsRepository VaristorsRepository;

    public VaristorsServiceImpl(VaristorsRepository VaristorsRepository) {
        this.VaristorsRepository = VaristorsRepository;
    }

    @Override
    public Varistors save(Varistors Varistors) {
        LOG.debug("Request to save Varistors : {}", Varistors);
        return VaristorsRepository.save(Varistors);
    }

    @Override
    public Varistors update(Varistors Varistors) {
        LOG.debug("Request to update Varistors : {}", Varistors);
        return VaristorsRepository.save(Varistors);
    }

    @Override
    public Optional<Varistors> partialUpdate(Varistors Varistors) {
        LOG.debug("Request to partially update Varistors : {}", Varistors);

        return VaristorsRepository
            .findById(Varistors.getId())
            .map(existingVaristors -> {
                if (Varistors.getId() != null) {
                    existingVaristors.setId(Varistors.getId());
                }
                if (Varistors.getPartNumber() != null) {
                    existingVaristors.setPartNumber(Varistors.getPartNumber());
                }
                if (Varistors.getPartType() != null) {
                    existingVaristors.setPartType(Varistors.getPartType());
                }
                if (Varistors.getValue() != null) {
                    existingVaristors.setValue(Varistors.getValue());
                }
                if (Varistors.getSchematicPart() != null) {
                    existingVaristors.setSchematicPart(Varistors.getSchematicPart());
                }
                if (Varistors.getRatingVoltage() != null) {
                    existingVaristors.setRatingVoltage(Varistors.getRatingVoltage());
                }
                if (Varistors.getRatingElectricity() != null) {
                    existingVaristors.setRatingElectricity(Varistors.getRatingElectricity());
                }
                if (Varistors.getCharacteristics() != null) {
                    existingVaristors.setCharacteristics(Varistors.getCharacteristics());
                }
                if (Varistors.getTolerance() != null) {
                    existingVaristors.setTolerance(Varistors.getTolerance());
                }
                if (Varistors.getManufacture() != null) {
                    existingVaristors.setManufacture(Varistors.getManufacture());
                }
                if (Varistors.getbCode() != null) {
                    existingVaristors.setbCode(Varistors.getbCode());
                }
                if (Varistors.getPartsName() != null) {
                    existingVaristors.setPartsName(Varistors.getPartsName());
                }
                if (Varistors.getItemRegistrationClassification() != null) {
                    existingVaristors.setItemRegistrationClassification(Varistors.getItemRegistrationClassification());
                }
                if (Varistors.getSpiceModel() != null) {
                    existingVaristors.setSpiceModel(Varistors.getSpiceModel());
                }
                if (Varistors.getPcbFootPrint() != null) {
                    existingVaristors.setPcbFootPrint(Varistors.getPcbFootPrint());
                }
                if (Varistors.getDelFlag() != null) {
                    existingVaristors.setDelFlag(Varistors.getDelFlag());
                }
                if (Varistors.getRemark() != null) {
                    existingVaristors.setRemark(Varistors.getRemark());
                }
                if (Varistors.getCreateBy() != null) {
                    existingVaristors.setCreateBy(Varistors.getCreateBy());
                }
                if (Varistors.getCreateTime() != null) {
                    existingVaristors.setCreateTime(Varistors.getCreateTime());
                }
                if (Varistors.getUpdateBy() != null) {
                    existingVaristors.setUpdateBy(Varistors.getUpdateBy());
                }
                if (Varistors.getUpdateTime() != null) {
                    existingVaristors.setUpdateTime(Varistors.getUpdateTime());
                }

                return existingVaristors;
            })
            .map(VaristorsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Varistors> findAll(Pageable pageable) {
        LOG.debug("Request to get all Varistorss");
        return VaristorsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Varistors> findOne(String id) {
        LOG.debug("Request to get Varistors : {}", id);
        return VaristorsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Varistors : {}", id);
        VaristorsRepository.deleteById(id);
    }
}
