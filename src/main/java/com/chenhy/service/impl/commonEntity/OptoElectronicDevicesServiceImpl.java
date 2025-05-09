package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.OptoElectronicDevices;
import com.chenhy.repository.commonEntity.OptoElectronicDevicesRepository;
import com.chenhy.service.commonEntity.OptoElectronicDevicesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link OptoElectronicDevices}.
 */
@Service
@Transactional
public class OptoElectronicDevicesServiceImpl implements OptoElectronicDevicesService {

    private static final Logger LOG = LoggerFactory.getLogger(OptoElectronicDevicesServiceImpl.class);

    private final OptoElectronicDevicesRepository OptoElectronicDevicesRepository;

    public OptoElectronicDevicesServiceImpl(OptoElectronicDevicesRepository OptoElectronicDevicesRepository) {
        this.OptoElectronicDevicesRepository = OptoElectronicDevicesRepository;
    }

    @Override
    public OptoElectronicDevices save(OptoElectronicDevices OptoElectronicDevices) {
        LOG.debug("Request to save OptoElectronicDevices : {}", OptoElectronicDevices);
        return OptoElectronicDevicesRepository.save(OptoElectronicDevices);
    }

    @Override
    public OptoElectronicDevices update(OptoElectronicDevices OptoElectronicDevices) {
        LOG.debug("Request to update OptoElectronicDevices : {}", OptoElectronicDevices);
        return OptoElectronicDevicesRepository.save(OptoElectronicDevices);
    }

    @Override
    public Optional<OptoElectronicDevices> partialUpdate(OptoElectronicDevices OptoElectronicDevices) {
        LOG.debug("Request to partially update OptoElectronicDevices : {}", OptoElectronicDevices);

        return OptoElectronicDevicesRepository
            .findById(OptoElectronicDevices.getId())
            .map(existingOptoElectronicDevices -> {
                if (OptoElectronicDevices.getId() != null) {
                    existingOptoElectronicDevices.setId(OptoElectronicDevices.getId());
                }
                if (OptoElectronicDevices.getPartNumber() != null) {
                    existingOptoElectronicDevices.setPartNumber(OptoElectronicDevices.getPartNumber());
                }
                if (OptoElectronicDevices.getPartType() != null) {
                    existingOptoElectronicDevices.setPartType(OptoElectronicDevices.getPartType());
                }
                if (OptoElectronicDevices.getValue() != null) {
                    existingOptoElectronicDevices.setValue(OptoElectronicDevices.getValue());
                }
                if (OptoElectronicDevices.getSchematicPart() != null) {
                    existingOptoElectronicDevices.setSchematicPart(OptoElectronicDevices.getSchematicPart());
                }
                if (OptoElectronicDevices.getRatingVoltage() != null) {
                    existingOptoElectronicDevices.setRatingVoltage(OptoElectronicDevices.getRatingVoltage());
                }
                if (OptoElectronicDevices.getRatingElectricity() != null) {
                    existingOptoElectronicDevices.setRatingElectricity(OptoElectronicDevices.getRatingElectricity());
                }
                if (OptoElectronicDevices.getCharacteristics() != null) {
                    existingOptoElectronicDevices.setCharacteristics(OptoElectronicDevices.getCharacteristics());
                }
                if (OptoElectronicDevices.getTolerance() != null) {
                    existingOptoElectronicDevices.setTolerance(OptoElectronicDevices.getTolerance());
                }
                if (OptoElectronicDevices.getManufacture() != null) {
                    existingOptoElectronicDevices.setManufacture(OptoElectronicDevices.getManufacture());
                }
                if (OptoElectronicDevices.getbCode() != null) {
                    existingOptoElectronicDevices.setbCode(OptoElectronicDevices.getbCode());
                }
                if (OptoElectronicDevices.getPartsName() != null) {
                    existingOptoElectronicDevices.setPartsName(OptoElectronicDevices.getPartsName());
                }
                if (OptoElectronicDevices.getItemRegistrationClassification() != null) {
                    existingOptoElectronicDevices.setItemRegistrationClassification(OptoElectronicDevices.getItemRegistrationClassification());
                }
                if (OptoElectronicDevices.getSpiceModel() != null) {
                    existingOptoElectronicDevices.setSpiceModel(OptoElectronicDevices.getSpiceModel());
                }
                if (OptoElectronicDevices.getPcbFootPrint() != null) {
                    existingOptoElectronicDevices.setPcbFootPrint(OptoElectronicDevices.getPcbFootPrint());
                }
                if (OptoElectronicDevices.getDelFlag() != null) {
                    existingOptoElectronicDevices.setDelFlag(OptoElectronicDevices.getDelFlag());
                }
                if (OptoElectronicDevices.getRemark() != null) {
                    existingOptoElectronicDevices.setRemark(OptoElectronicDevices.getRemark());
                }
                if (OptoElectronicDevices.getCreateBy() != null) {
                    existingOptoElectronicDevices.setCreateBy(OptoElectronicDevices.getCreateBy());
                }
                if (OptoElectronicDevices.getCreateTime() != null) {
                    existingOptoElectronicDevices.setCreateTime(OptoElectronicDevices.getCreateTime());
                }
                if (OptoElectronicDevices.getUpdateBy() != null) {
                    existingOptoElectronicDevices.setUpdateBy(OptoElectronicDevices.getUpdateBy());
                }
                if (OptoElectronicDevices.getUpdateTime() != null) {
                    existingOptoElectronicDevices.setUpdateTime(OptoElectronicDevices.getUpdateTime());
                }

                return existingOptoElectronicDevices;
            })
            .map(OptoElectronicDevicesRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OptoElectronicDevices> findAll(Pageable pageable) {
        LOG.debug("Request to get all OptoElectronicDevicess");
        return OptoElectronicDevicesRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OptoElectronicDevices> findOne(String id) {
        LOG.debug("Request to get OptoElectronicDevices : {}", id);
        return OptoElectronicDevicesRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete OptoElectronicDevices : {}", id);
        OptoElectronicDevicesRepository.deleteById(id);
    }
}
