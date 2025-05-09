package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.DelayLines;
import com.chenhy.repository.commonEntity.DelayLinesRepository;
import com.chenhy.service.commonEntity.DelayLinesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link DelayLines}.
 */
@Service
@Transactional
public class DelayLinesServiceImpl implements DelayLinesService {

    private static final Logger LOG = LoggerFactory.getLogger(DelayLinesServiceImpl.class);

    private final DelayLinesRepository DelayLinesRepository;

    public DelayLinesServiceImpl(DelayLinesRepository DelayLinesRepository) {
        this.DelayLinesRepository = DelayLinesRepository;
    }

    @Override
    public DelayLines save(DelayLines DelayLines) {
        LOG.debug("Request to save DelayLines : {}", DelayLines);
        return DelayLinesRepository.save(DelayLines);
    }

    @Override
    public DelayLines update(DelayLines DelayLines) {
        LOG.debug("Request to update DelayLines : {}", DelayLines);
        return DelayLinesRepository.save(DelayLines);
    }

    @Override
    public Optional<DelayLines> partialUpdate(DelayLines DelayLines) {
        LOG.debug("Request to partially update DelayLines : {}", DelayLines);

        return DelayLinesRepository
            .findById(DelayLines.getId())
            .map(existingDelayLines -> {
                if (DelayLines.getId() != null) {
                    existingDelayLines.setId(DelayLines.getId());
                }
                if (DelayLines.getPartNumber() != null) {
                    existingDelayLines.setPartNumber(DelayLines.getPartNumber());
                }
                if (DelayLines.getPartType() != null) {
                    existingDelayLines.setPartType(DelayLines.getPartType());
                }
                if (DelayLines.getValue() != null) {
                    existingDelayLines.setValue(DelayLines.getValue());
                }
                if (DelayLines.getSchematicPart() != null) {
                    existingDelayLines.setSchematicPart(DelayLines.getSchematicPart());
                }
                if (DelayLines.getRatingVoltage() != null) {
                    existingDelayLines.setRatingVoltage(DelayLines.getRatingVoltage());
                }
                if (DelayLines.getRatingElectricity() != null) {
                    existingDelayLines.setRatingElectricity(DelayLines.getRatingElectricity());
                }
                if (DelayLines.getCharacteristics() != null) {
                    existingDelayLines.setCharacteristics(DelayLines.getCharacteristics());
                }
                if (DelayLines.getTolerance() != null) {
                    existingDelayLines.setTolerance(DelayLines.getTolerance());
                }
                if (DelayLines.getManufacture() != null) {
                    existingDelayLines.setManufacture(DelayLines.getManufacture());
                }
                if (DelayLines.getbCode() != null) {
                    existingDelayLines.setbCode(DelayLines.getbCode());
                }
                if (DelayLines.getPartsName() != null) {
                    existingDelayLines.setPartsName(DelayLines.getPartsName());
                }
                if (DelayLines.getItemRegistrationClassification() != null) {
                    existingDelayLines.setItemRegistrationClassification(DelayLines.getItemRegistrationClassification());
                }
                if (DelayLines.getSpiceModel() != null) {
                    existingDelayLines.setSpiceModel(DelayLines.getSpiceModel());
                }
                if (DelayLines.getPcbFootPrint() != null) {
                    existingDelayLines.setPcbFootPrint(DelayLines.getPcbFootPrint());
                }
                if (DelayLines.getDelFlag() != null) {
                    existingDelayLines.setDelFlag(DelayLines.getDelFlag());
                }
                if (DelayLines.getRemark() != null) {
                    existingDelayLines.setRemark(DelayLines.getRemark());
                }
                if (DelayLines.getCreateBy() != null) {
                    existingDelayLines.setCreateBy(DelayLines.getCreateBy());
                }
                if (DelayLines.getCreateTime() != null) {
                    existingDelayLines.setCreateTime(DelayLines.getCreateTime());
                }
                if (DelayLines.getUpdateBy() != null) {
                    existingDelayLines.setUpdateBy(DelayLines.getUpdateBy());
                }
                if (DelayLines.getUpdateTime() != null) {
                    existingDelayLines.setUpdateTime(DelayLines.getUpdateTime());
                }

                return existingDelayLines;
            })
            .map(DelayLinesRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DelayLines> findAll(Pageable pageable) {
        LOG.debug("Request to get all DelayLiness");
        return DelayLinesRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DelayLines> findOne(String id) {
        LOG.debug("Request to get DelayLines : {}", id);
        return DelayLinesRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete DelayLines : {}", id);
        DelayLinesRepository.deleteById(id);
    }
}
