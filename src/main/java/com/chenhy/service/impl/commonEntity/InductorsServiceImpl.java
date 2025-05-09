package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Inductors;
import com.chenhy.repository.commonEntity.InductorsRepository;
import com.chenhy.service.commonEntity.InductorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Inductors}.
 */
@Service
@Transactional
public class InductorsServiceImpl implements InductorsService {

    private static final Logger LOG = LoggerFactory.getLogger(InductorsServiceImpl.class);

    private final InductorsRepository InductorsRepository;

    public InductorsServiceImpl(InductorsRepository InductorsRepository) {
        this.InductorsRepository = InductorsRepository;
    }

    @Override
    public Inductors save(Inductors Inductors) {
        LOG.debug("Request to save Inductors : {}", Inductors);
        return InductorsRepository.save(Inductors);
    }

    @Override
    public Inductors update(Inductors Inductors) {
        LOG.debug("Request to update Inductors : {}", Inductors);
        return InductorsRepository.save(Inductors);
    }

    @Override
    public Optional<Inductors> partialUpdate(Inductors Inductors) {
        LOG.debug("Request to partially update Inductors : {}", Inductors);

        return InductorsRepository
            .findById(Inductors.getId())
            .map(existingInductors -> {
                if (Inductors.getId() != null) {
                    existingInductors.setId(Inductors.getId());
                }
                if (Inductors.getPartNumber() != null) {
                    existingInductors.setPartNumber(Inductors.getPartNumber());
                }
                if (Inductors.getPartType() != null) {
                    existingInductors.setPartType(Inductors.getPartType());
                }
                if (Inductors.getValue() != null) {
                    existingInductors.setValue(Inductors.getValue());
                }
                if (Inductors.getSchematicPart() != null) {
                    existingInductors.setSchematicPart(Inductors.getSchematicPart());
                }
                if (Inductors.getRatingVoltage() != null) {
                    existingInductors.setRatingVoltage(Inductors.getRatingVoltage());
                }
                if (Inductors.getRatingElectricity() != null) {
                    existingInductors.setRatingElectricity(Inductors.getRatingElectricity());
                }
                if (Inductors.getCharacteristics() != null) {
                    existingInductors.setCharacteristics(Inductors.getCharacteristics());
                }
                if (Inductors.getTolerance() != null) {
                    existingInductors.setTolerance(Inductors.getTolerance());
                }
                if (Inductors.getManufacture() != null) {
                    existingInductors.setManufacture(Inductors.getManufacture());
                }
                if (Inductors.getbCode() != null) {
                    existingInductors.setbCode(Inductors.getbCode());
                }
                if (Inductors.getPartsName() != null) {
                    existingInductors.setPartsName(Inductors.getPartsName());
                }
                if (Inductors.getItemRegistrationClassification() != null) {
                    existingInductors.setItemRegistrationClassification(Inductors.getItemRegistrationClassification());
                }
                if (Inductors.getSpiceModel() != null) {
                    existingInductors.setSpiceModel(Inductors.getSpiceModel());
                }
                if (Inductors.getPcbFootPrint() != null) {
                    existingInductors.setPcbFootPrint(Inductors.getPcbFootPrint());
                }
                if (Inductors.getDelFlag() != null) {
                    existingInductors.setDelFlag(Inductors.getDelFlag());
                }
                if (Inductors.getRemark() != null) {
                    existingInductors.setRemark(Inductors.getRemark());
                }
                if (Inductors.getCreateBy() != null) {
                    existingInductors.setCreateBy(Inductors.getCreateBy());
                }
                if (Inductors.getCreateTime() != null) {
                    existingInductors.setCreateTime(Inductors.getCreateTime());
                }
                if (Inductors.getUpdateBy() != null) {
                    existingInductors.setUpdateBy(Inductors.getUpdateBy());
                }
                if (Inductors.getUpdateTime() != null) {
                    existingInductors.setUpdateTime(Inductors.getUpdateTime());
                }

                return existingInductors;
            })
            .map(InductorsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Inductors> findAll(Pageable pageable) {
        LOG.debug("Request to get all Inductorss");
        return InductorsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Inductors> findOne(String id) {
        LOG.debug("Request to get Inductors : {}", id);
        return InductorsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Inductors : {}", id);
        InductorsRepository.deleteById(id);
    }
}
