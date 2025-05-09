package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.BuzzersSounders;
import com.chenhy.repository.commonEntity.BuzzersSoundersRepository;
import com.chenhy.service.commonEntity.BuzzersSoundersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link BuzzersSounders}.
 */
@Service
@Transactional
public class BuzzersSoundersServiceImpl implements BuzzersSoundersService {

    private static final Logger LOG = LoggerFactory.getLogger(BuzzersSoundersServiceImpl.class);

    private final BuzzersSoundersRepository BuzzersSoundersRepository;

    public BuzzersSoundersServiceImpl(BuzzersSoundersRepository BuzzersSoundersRepository) {
        this.BuzzersSoundersRepository = BuzzersSoundersRepository;
    }

    @Override
    public BuzzersSounders save(BuzzersSounders BuzzersSounders) {
        LOG.debug("Request to save BuzzersSounders : {}", BuzzersSounders);
        return BuzzersSoundersRepository.save(BuzzersSounders);
    }

    @Override
    public BuzzersSounders update(BuzzersSounders BuzzersSounders) {
        LOG.debug("Request to update BuzzersSounders : {}", BuzzersSounders);
        return BuzzersSoundersRepository.save(BuzzersSounders);
    }

    @Override
    public Optional<BuzzersSounders> partialUpdate(BuzzersSounders BuzzersSounders) {
        LOG.debug("Request to partially update BuzzersSounders : {}", BuzzersSounders);

        return BuzzersSoundersRepository
            .findById(BuzzersSounders.getId())
            .map(existingBuzzersSounders -> {
                if (BuzzersSounders.getId() != null) {
                    existingBuzzersSounders.setId(BuzzersSounders.getId());
                }
                if (BuzzersSounders.getPartNumber() != null) {
                    existingBuzzersSounders.setPartNumber(BuzzersSounders.getPartNumber());
                }
                if (BuzzersSounders.getPartType() != null) {
                    existingBuzzersSounders.setPartType(BuzzersSounders.getPartType());
                }
                if (BuzzersSounders.getValue() != null) {
                    existingBuzzersSounders.setValue(BuzzersSounders.getValue());
                }
                if (BuzzersSounders.getSchematicPart() != null) {
                    existingBuzzersSounders.setSchematicPart(BuzzersSounders.getSchematicPart());
                }
                if (BuzzersSounders.getRatingVoltage() != null) {
                    existingBuzzersSounders.setRatingVoltage(BuzzersSounders.getRatingVoltage());
                }
                if (BuzzersSounders.getRatingElectricity() != null) {
                    existingBuzzersSounders.setRatingElectricity(BuzzersSounders.getRatingElectricity());
                }
                if (BuzzersSounders.getCharacteristics() != null) {
                    existingBuzzersSounders.setCharacteristics(BuzzersSounders.getCharacteristics());
                }
                if (BuzzersSounders.getTolerance() != null) {
                    existingBuzzersSounders.setTolerance(BuzzersSounders.getTolerance());
                }
                if (BuzzersSounders.getManufacture() != null) {
                    existingBuzzersSounders.setManufacture(BuzzersSounders.getManufacture());
                }
                if (BuzzersSounders.getbCode() != null) {
                    existingBuzzersSounders.setbCode(BuzzersSounders.getbCode());
                }
                if (BuzzersSounders.getPartsName() != null) {
                    existingBuzzersSounders.setPartsName(BuzzersSounders.getPartsName());
                }
                if (BuzzersSounders.getItemRegistrationClassification() != null) {
                    existingBuzzersSounders.setItemRegistrationClassification(BuzzersSounders.getItemRegistrationClassification());
                }
                if (BuzzersSounders.getSpiceModel() != null) {
                    existingBuzzersSounders.setSpiceModel(BuzzersSounders.getSpiceModel());
                }
                if (BuzzersSounders.getPcbFootPrint() != null) {
                    existingBuzzersSounders.setPcbFootPrint(BuzzersSounders.getPcbFootPrint());
                }
                if (BuzzersSounders.getDelFlag() != null) {
                    existingBuzzersSounders.setDelFlag(BuzzersSounders.getDelFlag());
                }
                if (BuzzersSounders.getRemark() != null) {
                    existingBuzzersSounders.setRemark(BuzzersSounders.getRemark());
                }
                if (BuzzersSounders.getCreateBy() != null) {
                    existingBuzzersSounders.setCreateBy(BuzzersSounders.getCreateBy());
                }
                if (BuzzersSounders.getCreateTime() != null) {
                    existingBuzzersSounders.setCreateTime(BuzzersSounders.getCreateTime());
                }
                if (BuzzersSounders.getUpdateBy() != null) {
                    existingBuzzersSounders.setUpdateBy(BuzzersSounders.getUpdateBy());
                }
                if (BuzzersSounders.getUpdateTime() != null) {
                    existingBuzzersSounders.setUpdateTime(BuzzersSounders.getUpdateTime());
                }

                return existingBuzzersSounders;
            })
            .map(BuzzersSoundersRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BuzzersSounders> findAll(Pageable pageable) {
        LOG.debug("Request to get all BuzzersSounderss");
        return BuzzersSoundersRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BuzzersSounders> findOne(String id) {
        LOG.debug("Request to get BuzzersSounders : {}", id);
        return BuzzersSoundersRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete BuzzersSounders : {}", id);
        BuzzersSoundersRepository.deleteById(id);
    }
}
