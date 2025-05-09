package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Transformers;
import com.chenhy.repository.commonEntity.TransformersRepository;
import com.chenhy.service.commonEntity.TransformersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Transformers}.
 */
@Service
@Transactional
public class TransformersServiceImpl implements TransformersService {

    private static final Logger LOG = LoggerFactory.getLogger(TransformersServiceImpl.class);

    private final TransformersRepository TransformersRepository;

    public TransformersServiceImpl(TransformersRepository TransformersRepository) {
        this.TransformersRepository = TransformersRepository;
    }

    @Override
    public Transformers save(Transformers Transformers) {
        LOG.debug("Request to save Transformers : {}", Transformers);
        return TransformersRepository.save(Transformers);
    }

    @Override
    public Transformers update(Transformers Transformers) {
        LOG.debug("Request to update Transformers : {}", Transformers);
        return TransformersRepository.save(Transformers);
    }

    @Override
    public Optional<Transformers> partialUpdate(Transformers Transformers) {
        LOG.debug("Request to partially update Transformers : {}", Transformers);

        return TransformersRepository
            .findById(Transformers.getId())
            .map(existingTransformers -> {
                if (Transformers.getId() != null) {
                    existingTransformers.setId(Transformers.getId());
                }
                if (Transformers.getPartNumber() != null) {
                    existingTransformers.setPartNumber(Transformers.getPartNumber());
                }
                if (Transformers.getPartType() != null) {
                    existingTransformers.setPartType(Transformers.getPartType());
                }
                if (Transformers.getValue() != null) {
                    existingTransformers.setValue(Transformers.getValue());
                }
                if (Transformers.getSchematicPart() != null) {
                    existingTransformers.setSchematicPart(Transformers.getSchematicPart());
                }
                if (Transformers.getRatingVoltage() != null) {
                    existingTransformers.setRatingVoltage(Transformers.getRatingVoltage());
                }
                if (Transformers.getRatingElectricity() != null) {
                    existingTransformers.setRatingElectricity(Transformers.getRatingElectricity());
                }
                if (Transformers.getCharacteristics() != null) {
                    existingTransformers.setCharacteristics(Transformers.getCharacteristics());
                }
                if (Transformers.getTolerance() != null) {
                    existingTransformers.setTolerance(Transformers.getTolerance());
                }
                if (Transformers.getManufacture() != null) {
                    existingTransformers.setManufacture(Transformers.getManufacture());
                }
                if (Transformers.getbCode() != null) {
                    existingTransformers.setbCode(Transformers.getbCode());
                }
                if (Transformers.getPartsName() != null) {
                    existingTransformers.setPartsName(Transformers.getPartsName());
                }
                if (Transformers.getItemRegistrationClassification() != null) {
                    existingTransformers.setItemRegistrationClassification(Transformers.getItemRegistrationClassification());
                }
                if (Transformers.getSpiceModel() != null) {
                    existingTransformers.setSpiceModel(Transformers.getSpiceModel());
                }
                if (Transformers.getPcbFootPrint() != null) {
                    existingTransformers.setPcbFootPrint(Transformers.getPcbFootPrint());
                }
                if (Transformers.getDelFlag() != null) {
                    existingTransformers.setDelFlag(Transformers.getDelFlag());
                }
                if (Transformers.getRemark() != null) {
                    existingTransformers.setRemark(Transformers.getRemark());
                }
                if (Transformers.getCreateBy() != null) {
                    existingTransformers.setCreateBy(Transformers.getCreateBy());
                }
                if (Transformers.getCreateTime() != null) {
                    existingTransformers.setCreateTime(Transformers.getCreateTime());
                }
                if (Transformers.getUpdateBy() != null) {
                    existingTransformers.setUpdateBy(Transformers.getUpdateBy());
                }
                if (Transformers.getUpdateTime() != null) {
                    existingTransformers.setUpdateTime(Transformers.getUpdateTime());
                }

                return existingTransformers;
            })
            .map(TransformersRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Transformers> findAll(Pageable pageable) {
        LOG.debug("Request to get all Transformerss");
        return TransformersRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Transformers> findOne(String id) {
        LOG.debug("Request to get Transformers : {}", id);
        return TransformersRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Transformers : {}", id);
        TransformersRepository.deleteById(id);
    }
}
