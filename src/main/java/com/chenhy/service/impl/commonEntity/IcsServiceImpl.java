package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Ics;
import com.chenhy.repository.commonEntity.IcsRepository;
import com.chenhy.service.commonEntity.IcsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Ics}.
 */
@Service
@Transactional
public class IcsServiceImpl implements IcsService {

    private static final Logger LOG = LoggerFactory.getLogger(IcsServiceImpl.class);

    private final IcsRepository IcsRepository;

    public IcsServiceImpl(IcsRepository IcsRepository) {
        this.IcsRepository = IcsRepository;
    }

    @Override
    public Ics save(Ics Ics) {
        LOG.debug("Request to save Ics : {}", Ics);
        return IcsRepository.save(Ics);
    }

    @Override
    public Ics update(Ics Ics) {
        LOG.debug("Request to update Ics : {}", Ics);
        return IcsRepository.save(Ics);
    }

    @Override
    public Optional<Ics> partialUpdate(Ics Ics) {
        LOG.debug("Request to partially update Ics : {}", Ics);

        return IcsRepository
            .findById(Ics.getId())
            .map(existingIcs -> {
                if (Ics.getId() != null) {
                    existingIcs.setId(Ics.getId());
                }
                if (Ics.getPartNumber() != null) {
                    existingIcs.setPartNumber(Ics.getPartNumber());
                }
                if (Ics.getPartType() != null) {
                    existingIcs.setPartType(Ics.getPartType());
                }
                if (Ics.getValue() != null) {
                    existingIcs.setValue(Ics.getValue());
                }
                if (Ics.getSchematicPart() != null) {
                    existingIcs.setSchematicPart(Ics.getSchematicPart());
                }
                if (Ics.getRatingVoltage() != null) {
                    existingIcs.setRatingVoltage(Ics.getRatingVoltage());
                }
                if (Ics.getRatingElectricity() != null) {
                    existingIcs.setRatingElectricity(Ics.getRatingElectricity());
                }
                if (Ics.getCharacteristics() != null) {
                    existingIcs.setCharacteristics(Ics.getCharacteristics());
                }
                if (Ics.getTolerance() != null) {
                    existingIcs.setTolerance(Ics.getTolerance());
                }
                if (Ics.getManufacture() != null) {
                    existingIcs.setManufacture(Ics.getManufacture());
                }
                if (Ics.getbCode() != null) {
                    existingIcs.setbCode(Ics.getbCode());
                }
                if (Ics.getPartsName() != null) {
                    existingIcs.setPartsName(Ics.getPartsName());
                }
                if (Ics.getItemRegistrationClassification() != null) {
                    existingIcs.setItemRegistrationClassification(Ics.getItemRegistrationClassification());
                }
                if (Ics.getSpiceModel() != null) {
                    existingIcs.setSpiceModel(Ics.getSpiceModel());
                }
                if (Ics.getPcbFootPrint() != null) {
                    existingIcs.setPcbFootPrint(Ics.getPcbFootPrint());
                }
                if (Ics.getDelFlag() != null) {
                    existingIcs.setDelFlag(Ics.getDelFlag());
                }
                if (Ics.getRemark() != null) {
                    existingIcs.setRemark(Ics.getRemark());
                }
                if (Ics.getCreateBy() != null) {
                    existingIcs.setCreateBy(Ics.getCreateBy());
                }
                if (Ics.getCreateTime() != null) {
                    existingIcs.setCreateTime(Ics.getCreateTime());
                }
                if (Ics.getUpdateBy() != null) {
                    existingIcs.setUpdateBy(Ics.getUpdateBy());
                }
                if (Ics.getUpdateTime() != null) {
                    existingIcs.setUpdateTime(Ics.getUpdateTime());
                }

                return existingIcs;
            })
            .map(IcsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Ics> findAll(Pageable pageable) {
        LOG.debug("Request to get all Icss");
        return IcsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Ics> findOne(String id) {
        LOG.debug("Request to get Ics : {}", id);
        return IcsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Ics : {}", id);
        IcsRepository.deleteById(id);
    }
}
