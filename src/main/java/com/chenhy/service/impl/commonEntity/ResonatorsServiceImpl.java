package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Resonators;
import com.chenhy.repository.commonEntity.ResonatorsRepository;
import com.chenhy.service.commonEntity.ResonatorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Resonators}.
 */
@Service
@Transactional
public class ResonatorsServiceImpl implements ResonatorsService {

    private static final Logger LOG = LoggerFactory.getLogger(ResonatorsServiceImpl.class);

    private final ResonatorsRepository ResonatorsRepository;

    public ResonatorsServiceImpl(ResonatorsRepository ResonatorsRepository) {
        this.ResonatorsRepository = ResonatorsRepository;
    }

    @Override
    public Resonators save(Resonators Resonators) {
        LOG.debug("Request to save Resonators : {}", Resonators);
        return ResonatorsRepository.save(Resonators);
    }

    @Override
    public Resonators update(Resonators Resonators) {
        LOG.debug("Request to update Resonators : {}", Resonators);
        return ResonatorsRepository.save(Resonators);
    }

    @Override
    public Optional<Resonators> partialUpdate(Resonators Resonators) {
        LOG.debug("Request to partially update Resonators : {}", Resonators);

        return ResonatorsRepository
            .findById(Resonators.getId())
            .map(existingResonators -> {
                if (Resonators.getId() != null) {
                    existingResonators.setId(Resonators.getId());
                }
                if (Resonators.getPartNumber() != null) {
                    existingResonators.setPartNumber(Resonators.getPartNumber());
                }
                if (Resonators.getPartType() != null) {
                    existingResonators.setPartType(Resonators.getPartType());
                }
                if (Resonators.getValue() != null) {
                    existingResonators.setValue(Resonators.getValue());
                }
                if (Resonators.getSchematicPart() != null) {
                    existingResonators.setSchematicPart(Resonators.getSchematicPart());
                }
                if (Resonators.getRatingVoltage() != null) {
                    existingResonators.setRatingVoltage(Resonators.getRatingVoltage());
                }
                if (Resonators.getRatingElectricity() != null) {
                    existingResonators.setRatingElectricity(Resonators.getRatingElectricity());
                }
                if (Resonators.getCharacteristics() != null) {
                    existingResonators.setCharacteristics(Resonators.getCharacteristics());
                }
                if (Resonators.getTolerance() != null) {
                    existingResonators.setTolerance(Resonators.getTolerance());
                }
                if (Resonators.getManufacture() != null) {
                    existingResonators.setManufacture(Resonators.getManufacture());
                }
                if (Resonators.getbCode() != null) {
                    existingResonators.setbCode(Resonators.getbCode());
                }
                if (Resonators.getPartsName() != null) {
                    existingResonators.setPartsName(Resonators.getPartsName());
                }
                if (Resonators.getItemRegistrationClassification() != null) {
                    existingResonators.setItemRegistrationClassification(Resonators.getItemRegistrationClassification());
                }
                if (Resonators.getSpiceModel() != null) {
                    existingResonators.setSpiceModel(Resonators.getSpiceModel());
                }
                if (Resonators.getPcbFootPrint() != null) {
                    existingResonators.setPcbFootPrint(Resonators.getPcbFootPrint());
                }
                if (Resonators.getDelFlag() != null) {
                    existingResonators.setDelFlag(Resonators.getDelFlag());
                }
                if (Resonators.getRemark() != null) {
                    existingResonators.setRemark(Resonators.getRemark());
                }
                if (Resonators.getCreateBy() != null) {
                    existingResonators.setCreateBy(Resonators.getCreateBy());
                }
                if (Resonators.getCreateTime() != null) {
                    existingResonators.setCreateTime(Resonators.getCreateTime());
                }
                if (Resonators.getUpdateBy() != null) {
                    existingResonators.setUpdateBy(Resonators.getUpdateBy());
                }
                if (Resonators.getUpdateTime() != null) {
                    existingResonators.setUpdateTime(Resonators.getUpdateTime());
                }

                return existingResonators;
            })
            .map(ResonatorsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Resonators> findAll(Pageable pageable) {
        LOG.debug("Request to get all Resonatorss");
        return ResonatorsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Resonators> findOne(String id) {
        LOG.debug("Request to get Resonators : {}", id);
        return ResonatorsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Resonators : {}", id);
        ResonatorsRepository.deleteById(id);
    }
}
