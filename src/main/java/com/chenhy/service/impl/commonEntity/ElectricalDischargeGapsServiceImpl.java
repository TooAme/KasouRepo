package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.ElectricalDischargeGaps;
import com.chenhy.repository.commonEntity.ElectricalDischargeGapsRepository;
import com.chenhy.service.commonEntity.ElectricalDischargeGapsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ElectricalDischargeGaps}.
 */
@Service
@Transactional
public class ElectricalDischargeGapsServiceImpl implements ElectricalDischargeGapsService {

    private static final Logger LOG = LoggerFactory.getLogger(ElectricalDischargeGapsServiceImpl.class);

    private final ElectricalDischargeGapsRepository ElectricalDischargeGapsRepository;

    public ElectricalDischargeGapsServiceImpl(ElectricalDischargeGapsRepository ElectricalDischargeGapsRepository) {
        this.ElectricalDischargeGapsRepository = ElectricalDischargeGapsRepository;
    }

    @Override
    public ElectricalDischargeGaps save(ElectricalDischargeGaps ElectricalDischargeGaps) {
        LOG.debug("Request to save ElectricalDischargeGaps : {}", ElectricalDischargeGaps);
        return ElectricalDischargeGapsRepository.save(ElectricalDischargeGaps);
    }

    @Override
    public ElectricalDischargeGaps update(ElectricalDischargeGaps ElectricalDischargeGaps) {
        LOG.debug("Request to update ElectricalDischargeGaps : {}", ElectricalDischargeGaps);
        return ElectricalDischargeGapsRepository.save(ElectricalDischargeGaps);
    }

    @Override
    public Optional<ElectricalDischargeGaps> partialUpdate(ElectricalDischargeGaps ElectricalDischargeGaps) {
        LOG.debug("Request to partially update ElectricalDischargeGaps : {}", ElectricalDischargeGaps);

        return ElectricalDischargeGapsRepository
            .findById(ElectricalDischargeGaps.getId())
            .map(existingElectricalDischargeGaps -> {
                if (ElectricalDischargeGaps.getId() != null) {
                    existingElectricalDischargeGaps.setId(ElectricalDischargeGaps.getId());
                }
                if (ElectricalDischargeGaps.getPartNumber() != null) {
                    existingElectricalDischargeGaps.setPartNumber(ElectricalDischargeGaps.getPartNumber());
                }
                if (ElectricalDischargeGaps.getPartType() != null) {
                    existingElectricalDischargeGaps.setPartType(ElectricalDischargeGaps.getPartType());
                }
                if (ElectricalDischargeGaps.getValue() != null) {
                    existingElectricalDischargeGaps.setValue(ElectricalDischargeGaps.getValue());
                }
                if (ElectricalDischargeGaps.getSchematicPart() != null) {
                    existingElectricalDischargeGaps.setSchematicPart(ElectricalDischargeGaps.getSchematicPart());
                }
                if (ElectricalDischargeGaps.getRatingVoltage() != null) {
                    existingElectricalDischargeGaps.setRatingVoltage(ElectricalDischargeGaps.getRatingVoltage());
                }
                if (ElectricalDischargeGaps.getRatingElectricity() != null) {
                    existingElectricalDischargeGaps.setRatingElectricity(ElectricalDischargeGaps.getRatingElectricity());
                }
                if (ElectricalDischargeGaps.getCharacteristics() != null) {
                    existingElectricalDischargeGaps.setCharacteristics(ElectricalDischargeGaps.getCharacteristics());
                }
                if (ElectricalDischargeGaps.getTolerance() != null) {
                    existingElectricalDischargeGaps.setTolerance(ElectricalDischargeGaps.getTolerance());
                }
                if (ElectricalDischargeGaps.getManufacture() != null) {
                    existingElectricalDischargeGaps.setManufacture(ElectricalDischargeGaps.getManufacture());
                }
                if (ElectricalDischargeGaps.getbCode() != null) {
                    existingElectricalDischargeGaps.setbCode(ElectricalDischargeGaps.getbCode());
                }
                if (ElectricalDischargeGaps.getPartsName() != null) {
                    existingElectricalDischargeGaps.setPartsName(ElectricalDischargeGaps.getPartsName());
                }
                if (ElectricalDischargeGaps.getItemRegistrationClassification() != null) {
                    existingElectricalDischargeGaps.setItemRegistrationClassification(ElectricalDischargeGaps.getItemRegistrationClassification());
                }
                if (ElectricalDischargeGaps.getSpiceModel() != null) {
                    existingElectricalDischargeGaps.setSpiceModel(ElectricalDischargeGaps.getSpiceModel());
                }
                if (ElectricalDischargeGaps.getPcbFootPrint() != null) {
                    existingElectricalDischargeGaps.setPcbFootPrint(ElectricalDischargeGaps.getPcbFootPrint());
                }
                if (ElectricalDischargeGaps.getDelFlag() != null) {
                    existingElectricalDischargeGaps.setDelFlag(ElectricalDischargeGaps.getDelFlag());
                }
                if (ElectricalDischargeGaps.getRemark() != null) {
                    existingElectricalDischargeGaps.setRemark(ElectricalDischargeGaps.getRemark());
                }
                if (ElectricalDischargeGaps.getCreateBy() != null) {
                    existingElectricalDischargeGaps.setCreateBy(ElectricalDischargeGaps.getCreateBy());
                }
                if (ElectricalDischargeGaps.getCreateTime() != null) {
                    existingElectricalDischargeGaps.setCreateTime(ElectricalDischargeGaps.getCreateTime());
                }
                if (ElectricalDischargeGaps.getUpdateBy() != null) {
                    existingElectricalDischargeGaps.setUpdateBy(ElectricalDischargeGaps.getUpdateBy());
                }
                if (ElectricalDischargeGaps.getUpdateTime() != null) {
                    existingElectricalDischargeGaps.setUpdateTime(ElectricalDischargeGaps.getUpdateTime());
                }

                return existingElectricalDischargeGaps;
            })
            .map(ElectricalDischargeGapsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ElectricalDischargeGaps> findAll(Pageable pageable) {
        LOG.debug("Request to get all ElectricalDischargeGapss");
        return ElectricalDischargeGapsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ElectricalDischargeGaps> findOne(String id) {
        LOG.debug("Request to get ElectricalDischargeGaps : {}", id);
        return ElectricalDischargeGapsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete ElectricalDischargeGaps : {}", id);
        ElectricalDischargeGapsRepository.deleteById(id);
    }
}
