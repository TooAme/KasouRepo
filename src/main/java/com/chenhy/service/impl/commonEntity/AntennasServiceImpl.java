package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Antennas;
import com.chenhy.repository.commonEntity.AntennasRepository;
import com.chenhy.service.commonEntity.AntennasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Antennas}.
 */
@Service
@Transactional
public class AntennasServiceImpl implements AntennasService {

    private static final Logger LOG = LoggerFactory.getLogger(AntennasServiceImpl.class);

    private final AntennasRepository AntennasRepository;

    public AntennasServiceImpl(AntennasRepository AntennasRepository) {
        this.AntennasRepository = AntennasRepository;
    }

    @Override
    public Antennas save(Antennas Antennas) {
        LOG.debug("Request to save Antennas : {}", Antennas);
        return AntennasRepository.save(Antennas);
    }

    @Override
    public Antennas update(Antennas Antennas) {
        LOG.debug("Request to update Antennas : {}", Antennas);
        return AntennasRepository.save(Antennas);
    }

    @Override
    public Optional<Antennas> partialUpdate(Antennas Antennas) {
        LOG.debug("Request to partially update Antennas : {}", Antennas);

        return AntennasRepository
            .findById(Antennas.getId())
            .map(existingAntennas -> {
                if (Antennas.getId() != null) {
                    existingAntennas.setId(Antennas.getId());
                }
                if (Antennas.getPartNumber() != null) {
                    existingAntennas.setPartNumber(Antennas.getPartNumber());
                }
                if (Antennas.getPartType() != null) {
                    existingAntennas.setPartType(Antennas.getPartType());
                }
                if (Antennas.getValue() != null) {
                    existingAntennas.setValue(Antennas.getValue());
                }
                if (Antennas.getSchematicPart() != null) {
                    existingAntennas.setSchematicPart(Antennas.getSchematicPart());
                }
                if (Antennas.getRatingVoltage() != null) {
                    existingAntennas.setRatingVoltage(Antennas.getRatingVoltage());
                }
                if (Antennas.getRatingElectricity() != null) {
                    existingAntennas.setRatingElectricity(Antennas.getRatingElectricity());
                }
                if (Antennas.getCharacteristics() != null) {
                    existingAntennas.setCharacteristics(Antennas.getCharacteristics());
                }
                if (Antennas.getTolerance() != null) {
                    existingAntennas.setTolerance(Antennas.getTolerance());
                }
                if (Antennas.getManufacture() != null) {
                    existingAntennas.setManufacture(Antennas.getManufacture());
                }
                if (Antennas.getbCode() != null) {
                    existingAntennas.setbCode(Antennas.getbCode());
                }
                if (Antennas.getPartsName() != null) {
                    existingAntennas.setPartsName(Antennas.getPartsName());
                }
                if (Antennas.getItemRegistrationClassification() != null) {
                    existingAntennas.setItemRegistrationClassification(Antennas.getItemRegistrationClassification());
                }
                if (Antennas.getSpiceModel() != null) {
                    existingAntennas.setSpiceModel(Antennas.getSpiceModel());
                }
                if (Antennas.getPcbFootPrint() != null) {
                    existingAntennas.setPcbFootPrint(Antennas.getPcbFootPrint());
                }
                if (Antennas.getDelFlag() != null) {
                    existingAntennas.setDelFlag(Antennas.getDelFlag());
                }
                if (Antennas.getRemark() != null) {
                    existingAntennas.setRemark(Antennas.getRemark());
                }
                if (Antennas.getCreateBy() != null) {
                    existingAntennas.setCreateBy(Antennas.getCreateBy());
                }
                if (Antennas.getCreateTime() != null) {
                    existingAntennas.setCreateTime(Antennas.getCreateTime());
                }
                if (Antennas.getUpdateBy() != null) {
                    existingAntennas.setUpdateBy(Antennas.getUpdateBy());
                }
                if (Antennas.getUpdateTime() != null) {
                    existingAntennas.setUpdateTime(Antennas.getUpdateTime());
                }

                return existingAntennas;
            })
            .map(AntennasRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Antennas> findAll(Pageable pageable) {
        LOG.debug("Request to get all Antennass");
        return AntennasRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Antennas> findOne(String id) {
        LOG.debug("Request to get Antennas : {}", id);
        return AntennasRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Antennas : {}", id);
        AntennasRepository.deleteById(id);
    }
}
