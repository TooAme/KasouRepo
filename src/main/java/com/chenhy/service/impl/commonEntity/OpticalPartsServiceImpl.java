package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.OpticalParts;
import com.chenhy.repository.commonEntity.OpticalPartsRepository;
import com.chenhy.service.commonEntity.OpticalPartsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link OpticalParts}.
 */
@Service
@Transactional
public class OpticalPartsServiceImpl implements OpticalPartsService {

    private static final Logger LOG = LoggerFactory.getLogger(OpticalPartsServiceImpl.class);

    private final OpticalPartsRepository OpticalPartsRepository;

    public OpticalPartsServiceImpl(OpticalPartsRepository OpticalPartsRepository) {
        this.OpticalPartsRepository = OpticalPartsRepository;
    }

    @Override
    public OpticalParts save(OpticalParts OpticalParts) {
        LOG.debug("Request to save OpticalParts : {}", OpticalParts);
        return OpticalPartsRepository.save(OpticalParts);
    }

    @Override
    public OpticalParts update(OpticalParts OpticalParts) {
        LOG.debug("Request to update OpticalParts : {}", OpticalParts);
        return OpticalPartsRepository.save(OpticalParts);
    }

    @Override
    public Optional<OpticalParts> partialUpdate(OpticalParts OpticalParts) {
        LOG.debug("Request to partially update OpticalParts : {}", OpticalParts);

        return OpticalPartsRepository
            .findById(OpticalParts.getId())
            .map(existingOpticalParts -> {
                if (OpticalParts.getId() != null) {
                    existingOpticalParts.setId(OpticalParts.getId());
                }
                if (OpticalParts.getPartNumber() != null) {
                    existingOpticalParts.setPartNumber(OpticalParts.getPartNumber());
                }
                if (OpticalParts.getPartType() != null) {
                    existingOpticalParts.setPartType(OpticalParts.getPartType());
                }
                if (OpticalParts.getValue() != null) {
                    existingOpticalParts.setValue(OpticalParts.getValue());
                }
                if (OpticalParts.getSchematicPart() != null) {
                    existingOpticalParts.setSchematicPart(OpticalParts.getSchematicPart());
                }
                if (OpticalParts.getRatingVoltage() != null) {
                    existingOpticalParts.setRatingVoltage(OpticalParts.getRatingVoltage());
                }
                if (OpticalParts.getRatingElectricity() != null) {
                    existingOpticalParts.setRatingElectricity(OpticalParts.getRatingElectricity());
                }
                if (OpticalParts.getCharacteristics() != null) {
                    existingOpticalParts.setCharacteristics(OpticalParts.getCharacteristics());
                }
                if (OpticalParts.getTolerance() != null) {
                    existingOpticalParts.setTolerance(OpticalParts.getTolerance());
                }
                if (OpticalParts.getManufacture() != null) {
                    existingOpticalParts.setManufacture(OpticalParts.getManufacture());
                }
                if (OpticalParts.getbCode() != null) {
                    existingOpticalParts.setbCode(OpticalParts.getbCode());
                }
                if (OpticalParts.getPartsName() != null) {
                    existingOpticalParts.setPartsName(OpticalParts.getPartsName());
                }
                if (OpticalParts.getItemRegistrationClassification() != null) {
                    existingOpticalParts.setItemRegistrationClassification(OpticalParts.getItemRegistrationClassification());
                }
                if (OpticalParts.getSpiceModel() != null) {
                    existingOpticalParts.setSpiceModel(OpticalParts.getSpiceModel());
                }
                if (OpticalParts.getPcbFootPrint() != null) {
                    existingOpticalParts.setPcbFootPrint(OpticalParts.getPcbFootPrint());
                }
                if (OpticalParts.getDelFlag() != null) {
                    existingOpticalParts.setDelFlag(OpticalParts.getDelFlag());
                }
                if (OpticalParts.getRemark() != null) {
                    existingOpticalParts.setRemark(OpticalParts.getRemark());
                }
                if (OpticalParts.getCreateBy() != null) {
                    existingOpticalParts.setCreateBy(OpticalParts.getCreateBy());
                }
                if (OpticalParts.getCreateTime() != null) {
                    existingOpticalParts.setCreateTime(OpticalParts.getCreateTime());
                }
                if (OpticalParts.getUpdateBy() != null) {
                    existingOpticalParts.setUpdateBy(OpticalParts.getUpdateBy());
                }
                if (OpticalParts.getUpdateTime() != null) {
                    existingOpticalParts.setUpdateTime(OpticalParts.getUpdateTime());
                }

                return existingOpticalParts;
            })
            .map(OpticalPartsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OpticalParts> findAll(Pageable pageable) {
        LOG.debug("Request to get all OpticalPartss");
        return OpticalPartsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OpticalParts> findOne(String id) {
        LOG.debug("Request to get OpticalParts : {}", id);
        return OpticalPartsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete OpticalParts : {}", id);
        OpticalPartsRepository.deleteById(id);
    }
}
