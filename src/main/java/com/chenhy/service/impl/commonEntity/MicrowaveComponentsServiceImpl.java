package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.MicrowaveComponents;
import com.chenhy.repository.commonEntity.MicrowaveComponentsRepository;
import com.chenhy.service.commonEntity.MicrowaveComponentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MicrowaveComponents}.
 */
@Service
@Transactional
public class MicrowaveComponentsServiceImpl implements MicrowaveComponentsService {

    private static final Logger LOG = LoggerFactory.getLogger(MicrowaveComponentsServiceImpl.class);

    private final MicrowaveComponentsRepository MicrowaveComponentsRepository;

    public MicrowaveComponentsServiceImpl(MicrowaveComponentsRepository MicrowaveComponentsRepository) {
        this.MicrowaveComponentsRepository = MicrowaveComponentsRepository;
    }

    @Override
    public MicrowaveComponents save(MicrowaveComponents MicrowaveComponents) {
        LOG.debug("Request to save MicrowaveComponents : {}", MicrowaveComponents);
        return MicrowaveComponentsRepository.save(MicrowaveComponents);
    }

    @Override
    public MicrowaveComponents update(MicrowaveComponents MicrowaveComponents) {
        LOG.debug("Request to update MicrowaveComponents : {}", MicrowaveComponents);
        return MicrowaveComponentsRepository.save(MicrowaveComponents);
    }

    @Override
    public Optional<MicrowaveComponents> partialUpdate(MicrowaveComponents MicrowaveComponents) {
        LOG.debug("Request to partially update MicrowaveComponents : {}", MicrowaveComponents);

        return MicrowaveComponentsRepository
            .findById(MicrowaveComponents.getId())
            .map(existingMicrowaveComponents -> {
                if (MicrowaveComponents.getId() != null) {
                    existingMicrowaveComponents.setId(MicrowaveComponents.getId());
                }
                if (MicrowaveComponents.getPartNumber() != null) {
                    existingMicrowaveComponents.setPartNumber(MicrowaveComponents.getPartNumber());
                }
                if (MicrowaveComponents.getPartType() != null) {
                    existingMicrowaveComponents.setPartType(MicrowaveComponents.getPartType());
                }
                if (MicrowaveComponents.getValue() != null) {
                    existingMicrowaveComponents.setValue(MicrowaveComponents.getValue());
                }
                if (MicrowaveComponents.getSchematicPart() != null) {
                    existingMicrowaveComponents.setSchematicPart(MicrowaveComponents.getSchematicPart());
                }
                if (MicrowaveComponents.getRatingVoltage() != null) {
                    existingMicrowaveComponents.setRatingVoltage(MicrowaveComponents.getRatingVoltage());
                }
                if (MicrowaveComponents.getRatingElectricity() != null) {
                    existingMicrowaveComponents.setRatingElectricity(MicrowaveComponents.getRatingElectricity());
                }
                if (MicrowaveComponents.getCharacteristics() != null) {
                    existingMicrowaveComponents.setCharacteristics(MicrowaveComponents.getCharacteristics());
                }
                if (MicrowaveComponents.getTolerance() != null) {
                    existingMicrowaveComponents.setTolerance(MicrowaveComponents.getTolerance());
                }
                if (MicrowaveComponents.getManufacture() != null) {
                    existingMicrowaveComponents.setManufacture(MicrowaveComponents.getManufacture());
                }
                if (MicrowaveComponents.getbCode() != null) {
                    existingMicrowaveComponents.setbCode(MicrowaveComponents.getbCode());
                }
                if (MicrowaveComponents.getPartsName() != null) {
                    existingMicrowaveComponents.setPartsName(MicrowaveComponents.getPartsName());
                }
                if (MicrowaveComponents.getItemRegistrationClassification() != null) {
                    existingMicrowaveComponents.setItemRegistrationClassification(MicrowaveComponents.getItemRegistrationClassification());
                }
                if (MicrowaveComponents.getSpiceModel() != null) {
                    existingMicrowaveComponents.setSpiceModel(MicrowaveComponents.getSpiceModel());
                }
                if (MicrowaveComponents.getPcbFootPrint() != null) {
                    existingMicrowaveComponents.setPcbFootPrint(MicrowaveComponents.getPcbFootPrint());
                }
                if (MicrowaveComponents.getDelFlag() != null) {
                    existingMicrowaveComponents.setDelFlag(MicrowaveComponents.getDelFlag());
                }
                if (MicrowaveComponents.getRemark() != null) {
                    existingMicrowaveComponents.setRemark(MicrowaveComponents.getRemark());
                }
                if (MicrowaveComponents.getCreateBy() != null) {
                    existingMicrowaveComponents.setCreateBy(MicrowaveComponents.getCreateBy());
                }
                if (MicrowaveComponents.getCreateTime() != null) {
                    existingMicrowaveComponents.setCreateTime(MicrowaveComponents.getCreateTime());
                }
                if (MicrowaveComponents.getUpdateBy() != null) {
                    existingMicrowaveComponents.setUpdateBy(MicrowaveComponents.getUpdateBy());
                }
                if (MicrowaveComponents.getUpdateTime() != null) {
                    existingMicrowaveComponents.setUpdateTime(MicrowaveComponents.getUpdateTime());
                }

                return existingMicrowaveComponents;
            })
            .map(MicrowaveComponentsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MicrowaveComponents> findAll(Pageable pageable) {
        LOG.debug("Request to get all MicrowaveComponentss");
        return MicrowaveComponentsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MicrowaveComponents> findOne(String id) {
        LOG.debug("Request to get MicrowaveComponents : {}", id);
        return MicrowaveComponentsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete MicrowaveComponents : {}", id);
        MicrowaveComponentsRepository.deleteById(id);
    }
}
