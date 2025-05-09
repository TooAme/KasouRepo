package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Diodes;
import com.chenhy.repository.commonEntity.DiodesRepository;
import com.chenhy.service.commonEntity.DiodesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Diodes}.
 */
@Service
@Transactional
public class DiodesServiceImpl implements DiodesService {

    private static final Logger LOG = LoggerFactory.getLogger(DiodesServiceImpl.class);

    private final DiodesRepository DiodesRepository;

    public DiodesServiceImpl(DiodesRepository DiodesRepository) {
        this.DiodesRepository = DiodesRepository;
    }

    @Override
    public Diodes save(Diodes Diodes) {
        LOG.debug("Request to save Diodes : {}", Diodes);
        return DiodesRepository.save(Diodes);
    }

    @Override
    public Diodes update(Diodes Diodes) {
        LOG.debug("Request to update Diodes : {}", Diodes);
        return DiodesRepository.save(Diodes);
    }

    @Override
    public Optional<Diodes> partialUpdate(Diodes Diodes) {
        LOG.debug("Request to partially update Diodes : {}", Diodes);

        return DiodesRepository
            .findById(Diodes.getId())
            .map(existingDiodes -> {
                if (Diodes.getId() != null) {
                    existingDiodes.setId(Diodes.getId());
                }
                if (Diodes.getPartNumber() != null) {
                    existingDiodes.setPartNumber(Diodes.getPartNumber());
                }
                if (Diodes.getPartType() != null) {
                    existingDiodes.setPartType(Diodes.getPartType());
                }
                if (Diodes.getValue() != null) {
                    existingDiodes.setValue(Diodes.getValue());
                }
                if (Diodes.getSchematicPart() != null) {
                    existingDiodes.setSchematicPart(Diodes.getSchematicPart());
                }
                if (Diodes.getRatingVoltage() != null) {
                    existingDiodes.setRatingVoltage(Diodes.getRatingVoltage());
                }
                if (Diodes.getRatingElectricity() != null) {
                    existingDiodes.setRatingElectricity(Diodes.getRatingElectricity());
                }
                if (Diodes.getCharacteristics() != null) {
                    existingDiodes.setCharacteristics(Diodes.getCharacteristics());
                }
                if (Diodes.getTolerance() != null) {
                    existingDiodes.setTolerance(Diodes.getTolerance());
                }
                if (Diodes.getManufacture() != null) {
                    existingDiodes.setManufacture(Diodes.getManufacture());
                }
                if (Diodes.getbCode() != null) {
                    existingDiodes.setbCode(Diodes.getbCode());
                }
                if (Diodes.getPartsName() != null) {
                    existingDiodes.setPartsName(Diodes.getPartsName());
                }
                if (Diodes.getItemRegistrationClassification() != null) {
                    existingDiodes.setItemRegistrationClassification(Diodes.getItemRegistrationClassification());
                }
                if (Diodes.getSpiceModel() != null) {
                    existingDiodes.setSpiceModel(Diodes.getSpiceModel());
                }
                if (Diodes.getPcbFootPrint() != null) {
                    existingDiodes.setPcbFootPrint(Diodes.getPcbFootPrint());
                }
                if (Diodes.getDelFlag() != null) {
                    existingDiodes.setDelFlag(Diodes.getDelFlag());
                }
                if (Diodes.getRemark() != null) {
                    existingDiodes.setRemark(Diodes.getRemark());
                }
                if (Diodes.getCreateBy() != null) {
                    existingDiodes.setCreateBy(Diodes.getCreateBy());
                }
                if (Diodes.getCreateTime() != null) {
                    existingDiodes.setCreateTime(Diodes.getCreateTime());
                }
                if (Diodes.getUpdateBy() != null) {
                    existingDiodes.setUpdateBy(Diodes.getUpdateBy());
                }
                if (Diodes.getUpdateTime() != null) {
                    existingDiodes.setUpdateTime(Diodes.getUpdateTime());
                }

                return existingDiodes;
            })
            .map(DiodesRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Diodes> findAll(Pageable pageable) {
        LOG.debug("Request to get all Diodess");
        return DiodesRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Diodes> findOne(String id) {
        LOG.debug("Request to get Diodes : {}", id);
        return DiodesRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Diodes : {}", id);
        DiodesRepository.deleteById(id);
    }
}
