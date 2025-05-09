package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.EmiEmcCountermeasureParts;
import com.chenhy.repository.commonEntity.EmiEmcCountermeasurePartsRepository;
import com.chenhy.service.commonEntity.EmiEmcCountermeasurePartsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link EmiEmcCountermeasureParts}.
 */
@Service
@Transactional
public class EmiEmcCountermeasurePartsServiceImpl implements EmiEmcCountermeasurePartsService {

    private static final Logger LOG = LoggerFactory.getLogger(EmiEmcCountermeasurePartsServiceImpl.class);

    private final EmiEmcCountermeasurePartsRepository EmiEmcCountermeasurePartsRepository;

    public EmiEmcCountermeasurePartsServiceImpl(EmiEmcCountermeasurePartsRepository EmiEmcCountermeasurePartsRepository) {
        this.EmiEmcCountermeasurePartsRepository = EmiEmcCountermeasurePartsRepository;
    }

    @Override
    public EmiEmcCountermeasureParts save(EmiEmcCountermeasureParts EmiEmcCountermeasureParts) {
        LOG.debug("Request to save EmiEmcCountermeasureParts : {}", EmiEmcCountermeasureParts);
        return EmiEmcCountermeasurePartsRepository.save(EmiEmcCountermeasureParts);
    }

    @Override
    public EmiEmcCountermeasureParts update(EmiEmcCountermeasureParts EmiEmcCountermeasureParts) {
        LOG.debug("Request to update EmiEmcCountermeasureParts : {}", EmiEmcCountermeasureParts);
        return EmiEmcCountermeasurePartsRepository.save(EmiEmcCountermeasureParts);
    }

    @Override
    public Optional<EmiEmcCountermeasureParts> partialUpdate(EmiEmcCountermeasureParts EmiEmcCountermeasureParts) {
        LOG.debug("Request to partially update EmiEmcCountermeasureParts : {}", EmiEmcCountermeasureParts);

        return EmiEmcCountermeasurePartsRepository
            .findById(EmiEmcCountermeasureParts.getId())
            .map(existingEmiEmcCountermeasureParts -> {
                if (EmiEmcCountermeasureParts.getId() != null) {
                    existingEmiEmcCountermeasureParts.setId(EmiEmcCountermeasureParts.getId());
                }
                if (EmiEmcCountermeasureParts.getPartNumber() != null) {
                    existingEmiEmcCountermeasureParts.setPartNumber(EmiEmcCountermeasureParts.getPartNumber());
                }
                if (EmiEmcCountermeasureParts.getPartType() != null) {
                    existingEmiEmcCountermeasureParts.setPartType(EmiEmcCountermeasureParts.getPartType());
                }
                if (EmiEmcCountermeasureParts.getValue() != null) {
                    existingEmiEmcCountermeasureParts.setValue(EmiEmcCountermeasureParts.getValue());
                }
                if (EmiEmcCountermeasureParts.getSchematicPart() != null) {
                    existingEmiEmcCountermeasureParts.setSchematicPart(EmiEmcCountermeasureParts.getSchematicPart());
                }
                if (EmiEmcCountermeasureParts.getRatingVoltage() != null) {
                    existingEmiEmcCountermeasureParts.setRatingVoltage(EmiEmcCountermeasureParts.getRatingVoltage());
                }
                if (EmiEmcCountermeasureParts.getRatingElectricity() != null) {
                    existingEmiEmcCountermeasureParts.setRatingElectricity(EmiEmcCountermeasureParts.getRatingElectricity());
                }
                if (EmiEmcCountermeasureParts.getCharacteristics() != null) {
                    existingEmiEmcCountermeasureParts.setCharacteristics(EmiEmcCountermeasureParts.getCharacteristics());
                }
                if (EmiEmcCountermeasureParts.getTolerance() != null) {
                    existingEmiEmcCountermeasureParts.setTolerance(EmiEmcCountermeasureParts.getTolerance());
                }
                if (EmiEmcCountermeasureParts.getManufacture() != null) {
                    existingEmiEmcCountermeasureParts.setManufacture(EmiEmcCountermeasureParts.getManufacture());
                }
                if (EmiEmcCountermeasureParts.getbCode() != null) {
                    existingEmiEmcCountermeasureParts.setbCode(EmiEmcCountermeasureParts.getbCode());
                }
                if (EmiEmcCountermeasureParts.getPartsName() != null) {
                    existingEmiEmcCountermeasureParts.setPartsName(EmiEmcCountermeasureParts.getPartsName());
                }
                if (EmiEmcCountermeasureParts.getItemRegistrationClassification() != null) {
                    existingEmiEmcCountermeasureParts.setItemRegistrationClassification(EmiEmcCountermeasureParts.getItemRegistrationClassification());
                }
                if (EmiEmcCountermeasureParts.getSpiceModel() != null) {
                    existingEmiEmcCountermeasureParts.setSpiceModel(EmiEmcCountermeasureParts.getSpiceModel());
                }
                if (EmiEmcCountermeasureParts.getPcbFootPrint() != null) {
                    existingEmiEmcCountermeasureParts.setPcbFootPrint(EmiEmcCountermeasureParts.getPcbFootPrint());
                }
                if (EmiEmcCountermeasureParts.getDelFlag() != null) {
                    existingEmiEmcCountermeasureParts.setDelFlag(EmiEmcCountermeasureParts.getDelFlag());
                }
                if (EmiEmcCountermeasureParts.getRemark() != null) {
                    existingEmiEmcCountermeasureParts.setRemark(EmiEmcCountermeasureParts.getRemark());
                }
                if (EmiEmcCountermeasureParts.getCreateBy() != null) {
                    existingEmiEmcCountermeasureParts.setCreateBy(EmiEmcCountermeasureParts.getCreateBy());
                }
                if (EmiEmcCountermeasureParts.getCreateTime() != null) {
                    existingEmiEmcCountermeasureParts.setCreateTime(EmiEmcCountermeasureParts.getCreateTime());
                }
                if (EmiEmcCountermeasureParts.getUpdateBy() != null) {
                    existingEmiEmcCountermeasureParts.setUpdateBy(EmiEmcCountermeasureParts.getUpdateBy());
                }
                if (EmiEmcCountermeasureParts.getUpdateTime() != null) {
                    existingEmiEmcCountermeasureParts.setUpdateTime(EmiEmcCountermeasureParts.getUpdateTime());
                }

                return existingEmiEmcCountermeasureParts;
            })
            .map(EmiEmcCountermeasurePartsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EmiEmcCountermeasureParts> findAll(Pageable pageable) {
        LOG.debug("Request to get all EmiEmcCountermeasurePartss");
        return EmiEmcCountermeasurePartsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EmiEmcCountermeasureParts> findOne(String id) {
        LOG.debug("Request to get EmiEmcCountermeasureParts : {}", id);
        return EmiEmcCountermeasurePartsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete EmiEmcCountermeasureParts : {}", id);
        EmiEmcCountermeasurePartsRepository.deleteById(id);
    }
}
