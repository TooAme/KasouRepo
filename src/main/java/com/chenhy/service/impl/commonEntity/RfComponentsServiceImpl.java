package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.RfComponents;
import com.chenhy.repository.commonEntity.RfComponentsRepository;
import com.chenhy.service.commonEntity.RfComponentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link RfComponents}.
 */
@Service
@Transactional
public class RfComponentsServiceImpl implements RfComponentsService {

    private static final Logger LOG = LoggerFactory.getLogger(RfComponentsServiceImpl.class);

    private final RfComponentsRepository RfComponentsRepository;

    public RfComponentsServiceImpl(RfComponentsRepository RfComponentsRepository) {
        this.RfComponentsRepository = RfComponentsRepository;
    }

    @Override
    public RfComponents save(RfComponents RfComponents) {
        LOG.debug("Request to save RfComponents : {}", RfComponents);
        return RfComponentsRepository.save(RfComponents);
    }

    @Override
    public RfComponents update(RfComponents RfComponents) {
        LOG.debug("Request to update RfComponents : {}", RfComponents);
        return RfComponentsRepository.save(RfComponents);
    }

    @Override
    public Optional<RfComponents> partialUpdate(RfComponents RfComponents) {
        LOG.debug("Request to partially update RfComponents : {}", RfComponents);

        return RfComponentsRepository
            .findById(RfComponents.getId())
            .map(existingRfComponents -> {
                if (RfComponents.getId() != null) {
                    existingRfComponents.setId(RfComponents.getId());
                }
                if (RfComponents.getPartNumber() != null) {
                    existingRfComponents.setPartNumber(RfComponents.getPartNumber());
                }
                if (RfComponents.getPartType() != null) {
                    existingRfComponents.setPartType(RfComponents.getPartType());
                }
                if (RfComponents.getValue() != null) {
                    existingRfComponents.setValue(RfComponents.getValue());
                }
                if (RfComponents.getSchematicPart() != null) {
                    existingRfComponents.setSchematicPart(RfComponents.getSchematicPart());
                }
                if (RfComponents.getRatingVoltage() != null) {
                    existingRfComponents.setRatingVoltage(RfComponents.getRatingVoltage());
                }
                if (RfComponents.getRatingElectricity() != null) {
                    existingRfComponents.setRatingElectricity(RfComponents.getRatingElectricity());
                }
                if (RfComponents.getCharacteristics() != null) {
                    existingRfComponents.setCharacteristics(RfComponents.getCharacteristics());
                }
                if (RfComponents.getTolerance() != null) {
                    existingRfComponents.setTolerance(RfComponents.getTolerance());
                }
                if (RfComponents.getManufacture() != null) {
                    existingRfComponents.setManufacture(RfComponents.getManufacture());
                }
                if (RfComponents.getbCode() != null) {
                    existingRfComponents.setbCode(RfComponents.getbCode());
                }
                if (RfComponents.getPartsName() != null) {
                    existingRfComponents.setPartsName(RfComponents.getPartsName());
                }
                if (RfComponents.getItemRegistrationClassification() != null) {
                    existingRfComponents.setItemRegistrationClassification(RfComponents.getItemRegistrationClassification());
                }
                if (RfComponents.getSpiceModel() != null) {
                    existingRfComponents.setSpiceModel(RfComponents.getSpiceModel());
                }
                if (RfComponents.getPcbFootPrint() != null) {
                    existingRfComponents.setPcbFootPrint(RfComponents.getPcbFootPrint());
                }
                if (RfComponents.getDelFlag() != null) {
                    existingRfComponents.setDelFlag(RfComponents.getDelFlag());
                }
                if (RfComponents.getRemark() != null) {
                    existingRfComponents.setRemark(RfComponents.getRemark());
                }
                if (RfComponents.getCreateBy() != null) {
                    existingRfComponents.setCreateBy(RfComponents.getCreateBy());
                }
                if (RfComponents.getCreateTime() != null) {
                    existingRfComponents.setCreateTime(RfComponents.getCreateTime());
                }
                if (RfComponents.getUpdateBy() != null) {
                    existingRfComponents.setUpdateBy(RfComponents.getUpdateBy());
                }
                if (RfComponents.getUpdateTime() != null) {
                    existingRfComponents.setUpdateTime(RfComponents.getUpdateTime());
                }

                return existingRfComponents;
            })
            .map(RfComponentsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RfComponents> findAll(Pageable pageable) {
        LOG.debug("Request to get all RfComponentss");
        return RfComponentsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RfComponents> findOne(String id) {
        LOG.debug("Request to get RfComponents : {}", id);
        return RfComponentsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete RfComponents : {}", id);
        RfComponentsRepository.deleteById(id);
    }
}
