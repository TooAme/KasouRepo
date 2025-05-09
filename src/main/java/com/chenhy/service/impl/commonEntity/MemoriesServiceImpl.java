package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Memories;
import com.chenhy.repository.commonEntity.MemoriesRepository;
import com.chenhy.service.commonEntity.MemoriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Memories}.
 */
@Service
@Transactional
public class MemoriesServiceImpl implements MemoriesService {

    private static final Logger LOG = LoggerFactory.getLogger(MemoriesServiceImpl.class);

    private final MemoriesRepository MemoriesRepository;

    public MemoriesServiceImpl(MemoriesRepository MemoriesRepository) {
        this.MemoriesRepository = MemoriesRepository;
    }

    @Override
    public Memories save(Memories Memories) {
        LOG.debug("Request to save Memories : {}", Memories);
        return MemoriesRepository.save(Memories);
    }

    @Override
    public Memories update(Memories Memories) {
        LOG.debug("Request to update Memories : {}", Memories);
        return MemoriesRepository.save(Memories);
    }

    @Override
    public Optional<Memories> partialUpdate(Memories Memories) {
        LOG.debug("Request to partially update Memories : {}", Memories);

        return MemoriesRepository
            .findById(Memories.getId())
            .map(existingMemories -> {
                if (Memories.getId() != null) {
                    existingMemories.setId(Memories.getId());
                }
                if (Memories.getPartNumber() != null) {
                    existingMemories.setPartNumber(Memories.getPartNumber());
                }
                if (Memories.getPartType() != null) {
                    existingMemories.setPartType(Memories.getPartType());
                }
                if (Memories.getValue() != null) {
                    existingMemories.setValue(Memories.getValue());
                }
                if (Memories.getSchematicPart() != null) {
                    existingMemories.setSchematicPart(Memories.getSchematicPart());
                }
                if (Memories.getRatingVoltage() != null) {
                    existingMemories.setRatingVoltage(Memories.getRatingVoltage());
                }
                if (Memories.getRatingElectricity() != null) {
                    existingMemories.setRatingElectricity(Memories.getRatingElectricity());
                }
                if (Memories.getCharacteristics() != null) {
                    existingMemories.setCharacteristics(Memories.getCharacteristics());
                }
                if (Memories.getTolerance() != null) {
                    existingMemories.setTolerance(Memories.getTolerance());
                }
                if (Memories.getManufacture() != null) {
                    existingMemories.setManufacture(Memories.getManufacture());
                }
                if (Memories.getbCode() != null) {
                    existingMemories.setbCode(Memories.getbCode());
                }
                if (Memories.getPartsName() != null) {
                    existingMemories.setPartsName(Memories.getPartsName());
                }
                if (Memories.getItemRegistrationClassification() != null) {
                    existingMemories.setItemRegistrationClassification(Memories.getItemRegistrationClassification());
                }
                if (Memories.getSpiceModel() != null) {
                    existingMemories.setSpiceModel(Memories.getSpiceModel());
                }
                if (Memories.getPcbFootPrint() != null) {
                    existingMemories.setPcbFootPrint(Memories.getPcbFootPrint());
                }
                if (Memories.getDelFlag() != null) {
                    existingMemories.setDelFlag(Memories.getDelFlag());
                }
                if (Memories.getRemark() != null) {
                    existingMemories.setRemark(Memories.getRemark());
                }
                if (Memories.getCreateBy() != null) {
                    existingMemories.setCreateBy(Memories.getCreateBy());
                }
                if (Memories.getCreateTime() != null) {
                    existingMemories.setCreateTime(Memories.getCreateTime());
                }
                if (Memories.getUpdateBy() != null) {
                    existingMemories.setUpdateBy(Memories.getUpdateBy());
                }
                if (Memories.getUpdateTime() != null) {
                    existingMemories.setUpdateTime(Memories.getUpdateTime());
                }

                return existingMemories;
            })
            .map(MemoriesRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Memories> findAll(Pageable pageable) {
        LOG.debug("Request to get all Memoriess");
        return MemoriesRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Memories> findOne(String id) {
        LOG.debug("Request to get Memories : {}", id);
        return MemoriesRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Memories : {}", id);
        MemoriesRepository.deleteById(id);
    }
}
