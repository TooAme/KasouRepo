package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Capacitors;
import com.chenhy.repository.commonEntity.CapacitorsRepository;
import com.chenhy.service.commonEntity.CapacitorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Capacitors}.
 */
@Service
@Transactional
public class CapacitorsServiceImpl implements CapacitorsService {

    private static final Logger LOG = LoggerFactory.getLogger(CapacitorsServiceImpl.class);

    private final CapacitorsRepository CapacitorsRepository;

    public CapacitorsServiceImpl(CapacitorsRepository CapacitorsRepository) {
        this.CapacitorsRepository = CapacitorsRepository;
    }

    @Override
    public Capacitors save(Capacitors Capacitors) {
        LOG.debug("Request to save Capacitors : {}", Capacitors);
        return CapacitorsRepository.save(Capacitors);
    }

    @Override
    public Capacitors update(Capacitors Capacitors) {
        LOG.debug("Request to update Capacitors : {}", Capacitors);
        return CapacitorsRepository.save(Capacitors);
    }

    @Override
    public Optional<Capacitors> partialUpdate(Capacitors Capacitors) {
        LOG.debug("Request to partially update Capacitors : {}", Capacitors);

        return CapacitorsRepository
            .findById(Capacitors.getId())
            .map(existingCapacitors -> {
                if (Capacitors.getId() != null) {
                    existingCapacitors.setId(Capacitors.getId());
                }
                if (Capacitors.getPartNumber() != null) {
                    existingCapacitors.setPartNumber(Capacitors.getPartNumber());
                }
                if (Capacitors.getPartType() != null) {
                    existingCapacitors.setPartType(Capacitors.getPartType());
                }
                if (Capacitors.getValue() != null) {
                    existingCapacitors.setValue(Capacitors.getValue());
                }
                if (Capacitors.getSchematicPart() != null) {
                    existingCapacitors.setSchematicPart(Capacitors.getSchematicPart());
                }
                if (Capacitors.getRatingVoltage() != null) {
                    existingCapacitors.setRatingVoltage(Capacitors.getRatingVoltage());
                }
                if (Capacitors.getRatingElectricity() != null) {
                    existingCapacitors.setRatingElectricity(Capacitors.getRatingElectricity());
                }
                if (Capacitors.getCharacteristics() != null) {
                    existingCapacitors.setCharacteristics(Capacitors.getCharacteristics());
                }
                if (Capacitors.getTolerance() != null) {
                    existingCapacitors.setTolerance(Capacitors.getTolerance());
                }
                if (Capacitors.getManufacture() != null) {
                    existingCapacitors.setManufacture(Capacitors.getManufacture());
                }
                if (Capacitors.getbCode() != null) {
                    existingCapacitors.setbCode(Capacitors.getbCode());
                }
                if (Capacitors.getPartsName() != null) {
                    existingCapacitors.setPartsName(Capacitors.getPartsName());
                }
                if (Capacitors.getItemRegistrationClassification() != null) {
                    existingCapacitors.setItemRegistrationClassification(Capacitors.getItemRegistrationClassification());
                }
                if (Capacitors.getSpiceModel() != null) {
                    existingCapacitors.setSpiceModel(Capacitors.getSpiceModel());
                }
                if (Capacitors.getPcbFootPrint() != null) {
                    existingCapacitors.setPcbFootPrint(Capacitors.getPcbFootPrint());
                }
                if (Capacitors.getDelFlag() != null) {
                    existingCapacitors.setDelFlag(Capacitors.getDelFlag());
                }
                if (Capacitors.getRemark() != null) {
                    existingCapacitors.setRemark(Capacitors.getRemark());
                }
                if (Capacitors.getCreateBy() != null) {
                    existingCapacitors.setCreateBy(Capacitors.getCreateBy());
                }
                if (Capacitors.getCreateTime() != null) {
                    existingCapacitors.setCreateTime(Capacitors.getCreateTime());
                }
                if (Capacitors.getUpdateBy() != null) {
                    existingCapacitors.setUpdateBy(Capacitors.getUpdateBy());
                }
                if (Capacitors.getUpdateTime() != null) {
                    existingCapacitors.setUpdateTime(Capacitors.getUpdateTime());
                }

                return existingCapacitors;
            })
            .map(CapacitorsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Capacitors> findAll(Pageable pageable) {
        LOG.debug("Request to get all Capacitorss");
        return CapacitorsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Capacitors> findOne(String id) {
        LOG.debug("Request to get Capacitors : {}", id);
        return CapacitorsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Capacitors : {}", id);
        CapacitorsRepository.deleteById(id);
    }
}
