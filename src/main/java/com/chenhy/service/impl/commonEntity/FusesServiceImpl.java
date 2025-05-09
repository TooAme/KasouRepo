package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Fuses;
import com.chenhy.repository.commonEntity.FusesRepository;
import com.chenhy.service.commonEntity.FusesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Fuses}.
 */
@Service
@Transactional
public class FusesServiceImpl implements FusesService {

    private static final Logger LOG = LoggerFactory.getLogger(FusesServiceImpl.class);

    private final FusesRepository FusesRepository;

    public FusesServiceImpl(FusesRepository FusesRepository) {
        this.FusesRepository = FusesRepository;
    }

    @Override
    public Fuses save(Fuses Fuses) {
        LOG.debug("Request to save Fuses : {}", Fuses);
        return FusesRepository.save(Fuses);
    }

    @Override
    public Fuses update(Fuses Fuses) {
        LOG.debug("Request to update Fuses : {}", Fuses);
        return FusesRepository.save(Fuses);
    }

    @Override
    public Optional<Fuses> partialUpdate(Fuses Fuses) {
        LOG.debug("Request to partially update Fuses : {}", Fuses);

        return FusesRepository
            .findById(Fuses.getId())
            .map(existingFuses -> {
                if (Fuses.getId() != null) {
                    existingFuses.setId(Fuses.getId());
                }
                if (Fuses.getPartNumber() != null) {
                    existingFuses.setPartNumber(Fuses.getPartNumber());
                }
                if (Fuses.getPartType() != null) {
                    existingFuses.setPartType(Fuses.getPartType());
                }
                if (Fuses.getValue() != null) {
                    existingFuses.setValue(Fuses.getValue());
                }
                if (Fuses.getSchematicPart() != null) {
                    existingFuses.setSchematicPart(Fuses.getSchematicPart());
                }
                if (Fuses.getRatingVoltage() != null) {
                    existingFuses.setRatingVoltage(Fuses.getRatingVoltage());
                }
                if (Fuses.getRatingElectricity() != null) {
                    existingFuses.setRatingElectricity(Fuses.getRatingElectricity());
                }
                if (Fuses.getCharacteristics() != null) {
                    existingFuses.setCharacteristics(Fuses.getCharacteristics());
                }
                if (Fuses.getTolerance() != null) {
                    existingFuses.setTolerance(Fuses.getTolerance());
                }
                if (Fuses.getManufacture() != null) {
                    existingFuses.setManufacture(Fuses.getManufacture());
                }
                if (Fuses.getbCode() != null) {
                    existingFuses.setbCode(Fuses.getbCode());
                }
                if (Fuses.getPartsName() != null) {
                    existingFuses.setPartsName(Fuses.getPartsName());
                }
                if (Fuses.getItemRegistrationClassification() != null) {
                    existingFuses.setItemRegistrationClassification(Fuses.getItemRegistrationClassification());
                }
                if (Fuses.getSpiceModel() != null) {
                    existingFuses.setSpiceModel(Fuses.getSpiceModel());
                }
                if (Fuses.getPcbFootPrint() != null) {
                    existingFuses.setPcbFootPrint(Fuses.getPcbFootPrint());
                }
                if (Fuses.getDelFlag() != null) {
                    existingFuses.setDelFlag(Fuses.getDelFlag());
                }
                if (Fuses.getRemark() != null) {
                    existingFuses.setRemark(Fuses.getRemark());
                }
                if (Fuses.getCreateBy() != null) {
                    existingFuses.setCreateBy(Fuses.getCreateBy());
                }
                if (Fuses.getCreateTime() != null) {
                    existingFuses.setCreateTime(Fuses.getCreateTime());
                }
                if (Fuses.getUpdateBy() != null) {
                    existingFuses.setUpdateBy(Fuses.getUpdateBy());
                }
                if (Fuses.getUpdateTime() != null) {
                    existingFuses.setUpdateTime(Fuses.getUpdateTime());
                }

                return existingFuses;
            })
            .map(FusesRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Fuses> findAll(Pageable pageable) {
        LOG.debug("Request to get all Fusess");
        return FusesRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Fuses> findOne(String id) {
        LOG.debug("Request to get Fuses : {}", id);
        return FusesRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Fuses : {}", id);
        FusesRepository.deleteById(id);
    }
}
