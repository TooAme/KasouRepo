package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Switches;
import com.chenhy.repository.commonEntity.SwitchesRepository;
import com.chenhy.service.commonEntity.SwitchesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Switches}.
 */
@Service
@Transactional
public class SwitchesServiceImpl implements SwitchesService {

    private static final Logger LOG = LoggerFactory.getLogger(SwitchesServiceImpl.class);

    private final SwitchesRepository SwitchesRepository;

    public SwitchesServiceImpl(SwitchesRepository SwitchesRepository) {
        this.SwitchesRepository = SwitchesRepository;
    }

    @Override
    public Switches save(Switches Switches) {
        LOG.debug("Request to save Switches : {}", Switches);
        return SwitchesRepository.save(Switches);
    }

    @Override
    public Switches update(Switches Switches) {
        LOG.debug("Request to update Switches : {}", Switches);
        return SwitchesRepository.save(Switches);
    }

    @Override
    public Optional<Switches> partialUpdate(Switches Switches) {
        LOG.debug("Request to partially update Switches : {}", Switches);

        return SwitchesRepository
            .findById(Switches.getId())
            .map(existingSwitches -> {
                if (Switches.getId() != null) {
                    existingSwitches.setId(Switches.getId());
                }
                if (Switches.getPartNumber() != null) {
                    existingSwitches.setPartNumber(Switches.getPartNumber());
                }
                if (Switches.getPartType() != null) {
                    existingSwitches.setPartType(Switches.getPartType());
                }
                if (Switches.getValue() != null) {
                    existingSwitches.setValue(Switches.getValue());
                }
                if (Switches.getSchematicPart() != null) {
                    existingSwitches.setSchematicPart(Switches.getSchematicPart());
                }
                if (Switches.getRatingVoltage() != null) {
                    existingSwitches.setRatingVoltage(Switches.getRatingVoltage());
                }
                if (Switches.getRatingElectricity() != null) {
                    existingSwitches.setRatingElectricity(Switches.getRatingElectricity());
                }
                if (Switches.getCharacteristics() != null) {
                    existingSwitches.setCharacteristics(Switches.getCharacteristics());
                }
                if (Switches.getTolerance() != null) {
                    existingSwitches.setTolerance(Switches.getTolerance());
                }
                if (Switches.getManufacture() != null) {
                    existingSwitches.setManufacture(Switches.getManufacture());
                }
                if (Switches.getbCode() != null) {
                    existingSwitches.setbCode(Switches.getbCode());
                }
                if (Switches.getPartsName() != null) {
                    existingSwitches.setPartsName(Switches.getPartsName());
                }
                if (Switches.getItemRegistrationClassification() != null) {
                    existingSwitches.setItemRegistrationClassification(Switches.getItemRegistrationClassification());
                }
                if (Switches.getSpiceModel() != null) {
                    existingSwitches.setSpiceModel(Switches.getSpiceModel());
                }
                if (Switches.getPcbFootPrint() != null) {
                    existingSwitches.setPcbFootPrint(Switches.getPcbFootPrint());
                }
                if (Switches.getDelFlag() != null) {
                    existingSwitches.setDelFlag(Switches.getDelFlag());
                }
                if (Switches.getRemark() != null) {
                    existingSwitches.setRemark(Switches.getRemark());
                }
                if (Switches.getCreateBy() != null) {
                    existingSwitches.setCreateBy(Switches.getCreateBy());
                }
                if (Switches.getCreateTime() != null) {
                    existingSwitches.setCreateTime(Switches.getCreateTime());
                }
                if (Switches.getUpdateBy() != null) {
                    existingSwitches.setUpdateBy(Switches.getUpdateBy());
                }
                if (Switches.getUpdateTime() != null) {
                    existingSwitches.setUpdateTime(Switches.getUpdateTime());
                }

                return existingSwitches;
            })
            .map(SwitchesRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Switches> findAll(Pageable pageable) {
        LOG.debug("Request to get all Switchess");
        return SwitchesRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Switches> findOne(String id) {
        LOG.debug("Request to get Switches : {}", id);
        return SwitchesRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Switches : {}", id);
        SwitchesRepository.deleteById(id);
    }
}
