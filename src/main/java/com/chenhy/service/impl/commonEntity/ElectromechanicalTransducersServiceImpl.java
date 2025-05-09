package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.ElectromechanicalTransducers;
import com.chenhy.repository.commonEntity.ElectromechanicalTransducersRepository;
import com.chenhy.service.commonEntity.ElectromechanicalTransducersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ElectromechanicalTransducers}.
 */
@Service
@Transactional
public class ElectromechanicalTransducersServiceImpl implements ElectromechanicalTransducersService {

    private static final Logger LOG = LoggerFactory.getLogger(ElectromechanicalTransducersServiceImpl.class);

    private final ElectromechanicalTransducersRepository ElectromechanicalTransducersRepository;

    public ElectromechanicalTransducersServiceImpl(ElectromechanicalTransducersRepository ElectromechanicalTransducersRepository) {
        this.ElectromechanicalTransducersRepository = ElectromechanicalTransducersRepository;
    }

    @Override
    public ElectromechanicalTransducers save(ElectromechanicalTransducers ElectromechanicalTransducers) {
        LOG.debug("Request to save ElectromechanicalTransducers : {}", ElectromechanicalTransducers);
        return ElectromechanicalTransducersRepository.save(ElectromechanicalTransducers);
    }

    @Override
    public ElectromechanicalTransducers update(ElectromechanicalTransducers ElectromechanicalTransducers) {
        LOG.debug("Request to update ElectromechanicalTransducers : {}", ElectromechanicalTransducers);
        return ElectromechanicalTransducersRepository.save(ElectromechanicalTransducers);
    }

    @Override
    public Optional<ElectromechanicalTransducers> partialUpdate(ElectromechanicalTransducers ElectromechanicalTransducers) {
        LOG.debug("Request to partially update ElectromechanicalTransducers : {}", ElectromechanicalTransducers);

        return ElectromechanicalTransducersRepository
            .findById(ElectromechanicalTransducers.getId())
            .map(existingElectromechanicalTransducers -> {
                if (ElectromechanicalTransducers.getId() != null) {
                    existingElectromechanicalTransducers.setId(ElectromechanicalTransducers.getId());
                }
                if (ElectromechanicalTransducers.getPartNumber() != null) {
                    existingElectromechanicalTransducers.setPartNumber(ElectromechanicalTransducers.getPartNumber());
                }
                if (ElectromechanicalTransducers.getPartType() != null) {
                    existingElectromechanicalTransducers.setPartType(ElectromechanicalTransducers.getPartType());
                }
                if (ElectromechanicalTransducers.getValue() != null) {
                    existingElectromechanicalTransducers.setValue(ElectromechanicalTransducers.getValue());
                }
                if (ElectromechanicalTransducers.getSchematicPart() != null) {
                    existingElectromechanicalTransducers.setSchematicPart(ElectromechanicalTransducers.getSchematicPart());
                }
                if (ElectromechanicalTransducers.getRatingVoltage() != null) {
                    existingElectromechanicalTransducers.setRatingVoltage(ElectromechanicalTransducers.getRatingVoltage());
                }
                if (ElectromechanicalTransducers.getRatingElectricity() != null) {
                    existingElectromechanicalTransducers.setRatingElectricity(ElectromechanicalTransducers.getRatingElectricity());
                }
                if (ElectromechanicalTransducers.getCharacteristics() != null) {
                    existingElectromechanicalTransducers.setCharacteristics(ElectromechanicalTransducers.getCharacteristics());
                }
                if (ElectromechanicalTransducers.getTolerance() != null) {
                    existingElectromechanicalTransducers.setTolerance(ElectromechanicalTransducers.getTolerance());
                }
                if (ElectromechanicalTransducers.getManufacture() != null) {
                    existingElectromechanicalTransducers.setManufacture(ElectromechanicalTransducers.getManufacture());
                }
                if (ElectromechanicalTransducers.getbCode() != null) {
                    existingElectromechanicalTransducers.setbCode(ElectromechanicalTransducers.getbCode());
                }
                if (ElectromechanicalTransducers.getPartsName() != null) {
                    existingElectromechanicalTransducers.setPartsName(ElectromechanicalTransducers.getPartsName());
                }
                if (ElectromechanicalTransducers.getItemRegistrationClassification() != null) {
                    existingElectromechanicalTransducers.setItemRegistrationClassification(ElectromechanicalTransducers.getItemRegistrationClassification());
                }
                if (ElectromechanicalTransducers.getSpiceModel() != null) {
                    existingElectromechanicalTransducers.setSpiceModel(ElectromechanicalTransducers.getSpiceModel());
                }
                if (ElectromechanicalTransducers.getPcbFootPrint() != null) {
                    existingElectromechanicalTransducers.setPcbFootPrint(ElectromechanicalTransducers.getPcbFootPrint());
                }
                if (ElectromechanicalTransducers.getDelFlag() != null) {
                    existingElectromechanicalTransducers.setDelFlag(ElectromechanicalTransducers.getDelFlag());
                }
                if (ElectromechanicalTransducers.getRemark() != null) {
                    existingElectromechanicalTransducers.setRemark(ElectromechanicalTransducers.getRemark());
                }
                if (ElectromechanicalTransducers.getCreateBy() != null) {
                    existingElectromechanicalTransducers.setCreateBy(ElectromechanicalTransducers.getCreateBy());
                }
                if (ElectromechanicalTransducers.getCreateTime() != null) {
                    existingElectromechanicalTransducers.setCreateTime(ElectromechanicalTransducers.getCreateTime());
                }
                if (ElectromechanicalTransducers.getUpdateBy() != null) {
                    existingElectromechanicalTransducers.setUpdateBy(ElectromechanicalTransducers.getUpdateBy());
                }
                if (ElectromechanicalTransducers.getUpdateTime() != null) {
                    existingElectromechanicalTransducers.setUpdateTime(ElectromechanicalTransducers.getUpdateTime());
                }

                return existingElectromechanicalTransducers;
            })
            .map(ElectromechanicalTransducersRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ElectromechanicalTransducers> findAll(Pageable pageable) {
        LOG.debug("Request to get all ElectromechanicalTransducerss");
        return ElectromechanicalTransducersRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ElectromechanicalTransducers> findOne(String id) {
        LOG.debug("Request to get ElectromechanicalTransducers : {}", id);
        return ElectromechanicalTransducersRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete ElectromechanicalTransducers : {}", id);
        ElectromechanicalTransducersRepository.deleteById(id);
    }
}
