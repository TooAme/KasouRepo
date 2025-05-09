package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Oscillators;
import com.chenhy.repository.commonEntity.OscillatorsRepository;
import com.chenhy.service.commonEntity.OscillatorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Oscillators}.
 */
@Service
@Transactional
public class OscillatorsServiceImpl implements OscillatorsService {

    private static final Logger LOG = LoggerFactory.getLogger(OscillatorsServiceImpl.class);

    private final OscillatorsRepository OscillatorsRepository;

    public OscillatorsServiceImpl(OscillatorsRepository OscillatorsRepository) {
        this.OscillatorsRepository = OscillatorsRepository;
    }

    @Override
    public Oscillators save(Oscillators Oscillators) {
        LOG.debug("Request to save Oscillators : {}", Oscillators);
        return OscillatorsRepository.save(Oscillators);
    }

    @Override
    public Oscillators update(Oscillators Oscillators) {
        LOG.debug("Request to update Oscillators : {}", Oscillators);
        return OscillatorsRepository.save(Oscillators);
    }

    @Override
    public Optional<Oscillators> partialUpdate(Oscillators Oscillators) {
        LOG.debug("Request to partially update Oscillators : {}", Oscillators);

        return OscillatorsRepository
            .findById(Oscillators.getId())
            .map(existingOscillators -> {
                if (Oscillators.getId() != null) {
                    existingOscillators.setId(Oscillators.getId());
                }
                if (Oscillators.getPartNumber() != null) {
                    existingOscillators.setPartNumber(Oscillators.getPartNumber());
                }
                if (Oscillators.getPartType() != null) {
                    existingOscillators.setPartType(Oscillators.getPartType());
                }
                if (Oscillators.getValue() != null) {
                    existingOscillators.setValue(Oscillators.getValue());
                }
                if (Oscillators.getSchematicPart() != null) {
                    existingOscillators.setSchematicPart(Oscillators.getSchematicPart());
                }
                if (Oscillators.getRatingVoltage() != null) {
                    existingOscillators.setRatingVoltage(Oscillators.getRatingVoltage());
                }
                if (Oscillators.getRatingElectricity() != null) {
                    existingOscillators.setRatingElectricity(Oscillators.getRatingElectricity());
                }
                if (Oscillators.getCharacteristics() != null) {
                    existingOscillators.setCharacteristics(Oscillators.getCharacteristics());
                }
                if (Oscillators.getTolerance() != null) {
                    existingOscillators.setTolerance(Oscillators.getTolerance());
                }
                if (Oscillators.getManufacture() != null) {
                    existingOscillators.setManufacture(Oscillators.getManufacture());
                }
                if (Oscillators.getbCode() != null) {
                    existingOscillators.setbCode(Oscillators.getbCode());
                }
                if (Oscillators.getPartsName() != null) {
                    existingOscillators.setPartsName(Oscillators.getPartsName());
                }
                if (Oscillators.getItemRegistrationClassification() != null) {
                    existingOscillators.setItemRegistrationClassification(Oscillators.getItemRegistrationClassification());
                }
                if (Oscillators.getSpiceModel() != null) {
                    existingOscillators.setSpiceModel(Oscillators.getSpiceModel());
                }
                if (Oscillators.getPcbFootPrint() != null) {
                    existingOscillators.setPcbFootPrint(Oscillators.getPcbFootPrint());
                }
                if (Oscillators.getDelFlag() != null) {
                    existingOscillators.setDelFlag(Oscillators.getDelFlag());
                }
                if (Oscillators.getRemark() != null) {
                    existingOscillators.setRemark(Oscillators.getRemark());
                }
                if (Oscillators.getCreateBy() != null) {
                    existingOscillators.setCreateBy(Oscillators.getCreateBy());
                }
                if (Oscillators.getCreateTime() != null) {
                    existingOscillators.setCreateTime(Oscillators.getCreateTime());
                }
                if (Oscillators.getUpdateBy() != null) {
                    existingOscillators.setUpdateBy(Oscillators.getUpdateBy());
                }
                if (Oscillators.getUpdateTime() != null) {
                    existingOscillators.setUpdateTime(Oscillators.getUpdateTime());
                }

                return existingOscillators;
            })
            .map(OscillatorsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Oscillators> findAll(Pageable pageable) {
        LOG.debug("Request to get all Oscillatorss");
        return OscillatorsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Oscillators> findOne(String id) {
        LOG.debug("Request to get Oscillators : {}", id);
        return OscillatorsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Oscillators : {}", id);
        OscillatorsRepository.deleteById(id);
    }
}
