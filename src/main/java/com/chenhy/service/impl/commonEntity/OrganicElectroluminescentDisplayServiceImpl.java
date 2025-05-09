package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.OrganicElectroluminescentDisplay;
import com.chenhy.repository.commonEntity.OrganicElectroluminescentDisplayRepository;
import com.chenhy.service.commonEntity.OrganicElectroluminescentDisplayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link OrganicElectroluminescentDisplay}.
 */
@Service
@Transactional
public class OrganicElectroluminescentDisplayServiceImpl implements OrganicElectroluminescentDisplayService {

    private static final Logger LOG = LoggerFactory.getLogger(OrganicElectroluminescentDisplayServiceImpl.class);

    private final OrganicElectroluminescentDisplayRepository OrganicElectroluminescentDisplayRepository;

    public OrganicElectroluminescentDisplayServiceImpl(OrganicElectroluminescentDisplayRepository OrganicElectroluminescentDisplayRepository) {
        this.OrganicElectroluminescentDisplayRepository = OrganicElectroluminescentDisplayRepository;
    }

    @Override
    public OrganicElectroluminescentDisplay save(OrganicElectroluminescentDisplay OrganicElectroluminescentDisplay) {
        LOG.debug("Request to save OrganicElectroluminescentDisplay : {}", OrganicElectroluminescentDisplay);
        return OrganicElectroluminescentDisplayRepository.save(OrganicElectroluminescentDisplay);
    }

    @Override
    public OrganicElectroluminescentDisplay update(OrganicElectroluminescentDisplay OrganicElectroluminescentDisplay) {
        LOG.debug("Request to update OrganicElectroluminescentDisplay : {}", OrganicElectroluminescentDisplay);
        return OrganicElectroluminescentDisplayRepository.save(OrganicElectroluminescentDisplay);
    }

    @Override
    public Optional<OrganicElectroluminescentDisplay> partialUpdate(OrganicElectroluminescentDisplay OrganicElectroluminescentDisplay) {
        LOG.debug("Request to partially update OrganicElectroluminescentDisplay : {}", OrganicElectroluminescentDisplay);

        return OrganicElectroluminescentDisplayRepository
            .findById(OrganicElectroluminescentDisplay.getId())
            .map(existingOrganicElectroluminescentDisplay -> {
                if (OrganicElectroluminescentDisplay.getId() != null) {
                    existingOrganicElectroluminescentDisplay.setId(OrganicElectroluminescentDisplay.getId());
                }
                if (OrganicElectroluminescentDisplay.getPartNumber() != null) {
                    existingOrganicElectroluminescentDisplay.setPartNumber(OrganicElectroluminescentDisplay.getPartNumber());
                }
                if (OrganicElectroluminescentDisplay.getPartType() != null) {
                    existingOrganicElectroluminescentDisplay.setPartType(OrganicElectroluminescentDisplay.getPartType());
                }
                if (OrganicElectroluminescentDisplay.getValue() != null) {
                    existingOrganicElectroluminescentDisplay.setValue(OrganicElectroluminescentDisplay.getValue());
                }
                if (OrganicElectroluminescentDisplay.getSchematicPart() != null) {
                    existingOrganicElectroluminescentDisplay.setSchematicPart(OrganicElectroluminescentDisplay.getSchematicPart());
                }
                if (OrganicElectroluminescentDisplay.getRatingVoltage() != null) {
                    existingOrganicElectroluminescentDisplay.setRatingVoltage(OrganicElectroluminescentDisplay.getRatingVoltage());
                }
                if (OrganicElectroluminescentDisplay.getRatingElectricity() != null) {
                    existingOrganicElectroluminescentDisplay.setRatingElectricity(OrganicElectroluminescentDisplay.getRatingElectricity());
                }
                if (OrganicElectroluminescentDisplay.getCharacteristics() != null) {
                    existingOrganicElectroluminescentDisplay.setCharacteristics(OrganicElectroluminescentDisplay.getCharacteristics());
                }
                if (OrganicElectroluminescentDisplay.getTolerance() != null) {
                    existingOrganicElectroluminescentDisplay.setTolerance(OrganicElectroluminescentDisplay.getTolerance());
                }
                if (OrganicElectroluminescentDisplay.getManufacture() != null) {
                    existingOrganicElectroluminescentDisplay.setManufacture(OrganicElectroluminescentDisplay.getManufacture());
                }
                if (OrganicElectroluminescentDisplay.getbCode() != null) {
                    existingOrganicElectroluminescentDisplay.setbCode(OrganicElectroluminescentDisplay.getbCode());
                }
                if (OrganicElectroluminescentDisplay.getPartsName() != null) {
                    existingOrganicElectroluminescentDisplay.setPartsName(OrganicElectroluminescentDisplay.getPartsName());
                }
                if (OrganicElectroluminescentDisplay.getItemRegistrationClassification() != null) {
                    existingOrganicElectroluminescentDisplay.setItemRegistrationClassification(OrganicElectroluminescentDisplay.getItemRegistrationClassification());
                }
                if (OrganicElectroluminescentDisplay.getSpiceModel() != null) {
                    existingOrganicElectroluminescentDisplay.setSpiceModel(OrganicElectroluminescentDisplay.getSpiceModel());
                }
                if (OrganicElectroluminescentDisplay.getPcbFootPrint() != null) {
                    existingOrganicElectroluminescentDisplay.setPcbFootPrint(OrganicElectroluminescentDisplay.getPcbFootPrint());
                }
                if (OrganicElectroluminescentDisplay.getDelFlag() != null) {
                    existingOrganicElectroluminescentDisplay.setDelFlag(OrganicElectroluminescentDisplay.getDelFlag());
                }
                if (OrganicElectroluminescentDisplay.getRemark() != null) {
                    existingOrganicElectroluminescentDisplay.setRemark(OrganicElectroluminescentDisplay.getRemark());
                }
                if (OrganicElectroluminescentDisplay.getCreateBy() != null) {
                    existingOrganicElectroluminescentDisplay.setCreateBy(OrganicElectroluminescentDisplay.getCreateBy());
                }
                if (OrganicElectroluminescentDisplay.getCreateTime() != null) {
                    existingOrganicElectroluminescentDisplay.setCreateTime(OrganicElectroluminescentDisplay.getCreateTime());
                }
                if (OrganicElectroluminescentDisplay.getUpdateBy() != null) {
                    existingOrganicElectroluminescentDisplay.setUpdateBy(OrganicElectroluminescentDisplay.getUpdateBy());
                }
                if (OrganicElectroluminescentDisplay.getUpdateTime() != null) {
                    existingOrganicElectroluminescentDisplay.setUpdateTime(OrganicElectroluminescentDisplay.getUpdateTime());
                }

                return existingOrganicElectroluminescentDisplay;
            })
            .map(OrganicElectroluminescentDisplayRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OrganicElectroluminescentDisplay> findAll(Pageable pageable) {
        LOG.debug("Request to get all OrganicElectroluminescentDisplays");
        return OrganicElectroluminescentDisplayRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrganicElectroluminescentDisplay> findOne(String id) {
        LOG.debug("Request to get OrganicElectroluminescentDisplay : {}", id);
        return OrganicElectroluminescentDisplayRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete OrganicElectroluminescentDisplay : {}", id);
        OrganicElectroluminescentDisplayRepository.deleteById(id);
    }
}
