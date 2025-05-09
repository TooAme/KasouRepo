package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Lamps;
import com.chenhy.repository.commonEntity.LampsRepository;
import com.chenhy.service.commonEntity.LampsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Lamps}.
 */
@Service
@Transactional
public class LampsServiceImpl implements LampsService {

    private static final Logger LOG = LoggerFactory.getLogger(LampsServiceImpl.class);

    private final LampsRepository LampsRepository;

    public LampsServiceImpl(LampsRepository LampsRepository) {
        this.LampsRepository = LampsRepository;
    }

    @Override
    public Lamps save(Lamps Lamps) {
        LOG.debug("Request to save Lamps : {}", Lamps);
        return LampsRepository.save(Lamps);
    }

    @Override
    public Lamps update(Lamps Lamps) {
        LOG.debug("Request to update Lamps : {}", Lamps);
        return LampsRepository.save(Lamps);
    }

    @Override
    public Optional<Lamps> partialUpdate(Lamps Lamps) {
        LOG.debug("Request to partially update Lamps : {}", Lamps);

        return LampsRepository
            .findById(Lamps.getId())
            .map(existingLamps -> {
                if (Lamps.getId() != null) {
                    existingLamps.setId(Lamps.getId());
                }
                if (Lamps.getPartNumber() != null) {
                    existingLamps.setPartNumber(Lamps.getPartNumber());
                }
                if (Lamps.getPartType() != null) {
                    existingLamps.setPartType(Lamps.getPartType());
                }
                if (Lamps.getValue() != null) {
                    existingLamps.setValue(Lamps.getValue());
                }
                if (Lamps.getSchematicPart() != null) {
                    existingLamps.setSchematicPart(Lamps.getSchematicPart());
                }
                if (Lamps.getRatingVoltage() != null) {
                    existingLamps.setRatingVoltage(Lamps.getRatingVoltage());
                }
                if (Lamps.getRatingElectricity() != null) {
                    existingLamps.setRatingElectricity(Lamps.getRatingElectricity());
                }
                if (Lamps.getCharacteristics() != null) {
                    existingLamps.setCharacteristics(Lamps.getCharacteristics());
                }
                if (Lamps.getTolerance() != null) {
                    existingLamps.setTolerance(Lamps.getTolerance());
                }
                if (Lamps.getManufacture() != null) {
                    existingLamps.setManufacture(Lamps.getManufacture());
                }
                if (Lamps.getbCode() != null) {
                    existingLamps.setbCode(Lamps.getbCode());
                }
                if (Lamps.getPartsName() != null) {
                    existingLamps.setPartsName(Lamps.getPartsName());
                }
                if (Lamps.getItemRegistrationClassification() != null) {
                    existingLamps.setItemRegistrationClassification(Lamps.getItemRegistrationClassification());
                }
                if (Lamps.getSpiceModel() != null) {
                    existingLamps.setSpiceModel(Lamps.getSpiceModel());
                }
                if (Lamps.getPcbFootPrint() != null) {
                    existingLamps.setPcbFootPrint(Lamps.getPcbFootPrint());
                }
                if (Lamps.getDelFlag() != null) {
                    existingLamps.setDelFlag(Lamps.getDelFlag());
                }
                if (Lamps.getRemark() != null) {
                    existingLamps.setRemark(Lamps.getRemark());
                }
                if (Lamps.getCreateBy() != null) {
                    existingLamps.setCreateBy(Lamps.getCreateBy());
                }
                if (Lamps.getCreateTime() != null) {
                    existingLamps.setCreateTime(Lamps.getCreateTime());
                }
                if (Lamps.getUpdateBy() != null) {
                    existingLamps.setUpdateBy(Lamps.getUpdateBy());
                }
                if (Lamps.getUpdateTime() != null) {
                    existingLamps.setUpdateTime(Lamps.getUpdateTime());
                }

                return existingLamps;
            })
            .map(LampsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Lamps> findAll(Pageable pageable) {
        LOG.debug("Request to get all Lampss");
        return LampsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Lamps> findOne(String id) {
        LOG.debug("Request to get Lamps : {}", id);
        return LampsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Lamps : {}", id);
        LampsRepository.deleteById(id);
    }
}
