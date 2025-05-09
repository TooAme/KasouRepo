package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.MultiChipDiscreteDevices;
import com.chenhy.repository.commonEntity.MultiChipDiscreteDevicesRepository;
import com.chenhy.service.commonEntity.MultiChipDiscreteDevicesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MultiChipDiscreteDevices}.
 */
@Service
@Transactional
public class MultiChipDiscreteDevicesServiceImpl implements MultiChipDiscreteDevicesService {

    private static final Logger LOG = LoggerFactory.getLogger(MultiChipDiscreteDevicesServiceImpl.class);

    private final MultiChipDiscreteDevicesRepository MultiChipDiscreteDevicesRepository;

    public MultiChipDiscreteDevicesServiceImpl(MultiChipDiscreteDevicesRepository MultiChipDiscreteDevicesRepository) {
        this.MultiChipDiscreteDevicesRepository = MultiChipDiscreteDevicesRepository;
    }

    @Override
    public MultiChipDiscreteDevices save(MultiChipDiscreteDevices MultiChipDiscreteDevices) {
        LOG.debug("Request to save MultiChipDiscreteDevices : {}", MultiChipDiscreteDevices);
        return MultiChipDiscreteDevicesRepository.save(MultiChipDiscreteDevices);
    }

    @Override
    public MultiChipDiscreteDevices update(MultiChipDiscreteDevices MultiChipDiscreteDevices) {
        LOG.debug("Request to update MultiChipDiscreteDevices : {}", MultiChipDiscreteDevices);
        return MultiChipDiscreteDevicesRepository.save(MultiChipDiscreteDevices);
    }

    @Override
    public Optional<MultiChipDiscreteDevices> partialUpdate(MultiChipDiscreteDevices MultiChipDiscreteDevices) {
        LOG.debug("Request to partially update MultiChipDiscreteDevices : {}", MultiChipDiscreteDevices);

        return MultiChipDiscreteDevicesRepository
            .findById(MultiChipDiscreteDevices.getId())
            .map(existingMultiChipDiscreteDevices -> {
                if (MultiChipDiscreteDevices.getId() != null) {
                    existingMultiChipDiscreteDevices.setId(MultiChipDiscreteDevices.getId());
                }
                if (MultiChipDiscreteDevices.getPartNumber() != null) {
                    existingMultiChipDiscreteDevices.setPartNumber(MultiChipDiscreteDevices.getPartNumber());
                }
                if (MultiChipDiscreteDevices.getPartType() != null) {
                    existingMultiChipDiscreteDevices.setPartType(MultiChipDiscreteDevices.getPartType());
                }
                if (MultiChipDiscreteDevices.getValue() != null) {
                    existingMultiChipDiscreteDevices.setValue(MultiChipDiscreteDevices.getValue());
                }
                if (MultiChipDiscreteDevices.getSchematicPart() != null) {
                    existingMultiChipDiscreteDevices.setSchematicPart(MultiChipDiscreteDevices.getSchematicPart());
                }
                if (MultiChipDiscreteDevices.getRatingVoltage() != null) {
                    existingMultiChipDiscreteDevices.setRatingVoltage(MultiChipDiscreteDevices.getRatingVoltage());
                }
                if (MultiChipDiscreteDevices.getRatingElectricity() != null) {
                    existingMultiChipDiscreteDevices.setRatingElectricity(MultiChipDiscreteDevices.getRatingElectricity());
                }
                if (MultiChipDiscreteDevices.getCharacteristics() != null) {
                    existingMultiChipDiscreteDevices.setCharacteristics(MultiChipDiscreteDevices.getCharacteristics());
                }
                if (MultiChipDiscreteDevices.getTolerance() != null) {
                    existingMultiChipDiscreteDevices.setTolerance(MultiChipDiscreteDevices.getTolerance());
                }
                if (MultiChipDiscreteDevices.getManufacture() != null) {
                    existingMultiChipDiscreteDevices.setManufacture(MultiChipDiscreteDevices.getManufacture());
                }
                if (MultiChipDiscreteDevices.getbCode() != null) {
                    existingMultiChipDiscreteDevices.setbCode(MultiChipDiscreteDevices.getbCode());
                }
                if (MultiChipDiscreteDevices.getPartsName() != null) {
                    existingMultiChipDiscreteDevices.setPartsName(MultiChipDiscreteDevices.getPartsName());
                }
                if (MultiChipDiscreteDevices.getItemRegistrationClassification() != null) {
                    existingMultiChipDiscreteDevices.setItemRegistrationClassification(MultiChipDiscreteDevices.getItemRegistrationClassification());
                }
                if (MultiChipDiscreteDevices.getSpiceModel() != null) {
                    existingMultiChipDiscreteDevices.setSpiceModel(MultiChipDiscreteDevices.getSpiceModel());
                }
                if (MultiChipDiscreteDevices.getPcbFootPrint() != null) {
                    existingMultiChipDiscreteDevices.setPcbFootPrint(MultiChipDiscreteDevices.getPcbFootPrint());
                }
                if (MultiChipDiscreteDevices.getDelFlag() != null) {
                    existingMultiChipDiscreteDevices.setDelFlag(MultiChipDiscreteDevices.getDelFlag());
                }
                if (MultiChipDiscreteDevices.getRemark() != null) {
                    existingMultiChipDiscreteDevices.setRemark(MultiChipDiscreteDevices.getRemark());
                }
                if (MultiChipDiscreteDevices.getCreateBy() != null) {
                    existingMultiChipDiscreteDevices.setCreateBy(MultiChipDiscreteDevices.getCreateBy());
                }
                if (MultiChipDiscreteDevices.getCreateTime() != null) {
                    existingMultiChipDiscreteDevices.setCreateTime(MultiChipDiscreteDevices.getCreateTime());
                }
                if (MultiChipDiscreteDevices.getUpdateBy() != null) {
                    existingMultiChipDiscreteDevices.setUpdateBy(MultiChipDiscreteDevices.getUpdateBy());
                }
                if (MultiChipDiscreteDevices.getUpdateTime() != null) {
                    existingMultiChipDiscreteDevices.setUpdateTime(MultiChipDiscreteDevices.getUpdateTime());
                }

                return existingMultiChipDiscreteDevices;
            })
            .map(MultiChipDiscreteDevicesRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MultiChipDiscreteDevices> findAll(Pageable pageable) {
        LOG.debug("Request to get all MultiChipDiscreteDevicess");
        return MultiChipDiscreteDevicesRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MultiChipDiscreteDevices> findOne(String id) {
        LOG.debug("Request to get MultiChipDiscreteDevices : {}", id);
        return MultiChipDiscreteDevicesRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete MultiChipDiscreteDevices : {}", id);
        MultiChipDiscreteDevicesRepository.deleteById(id);
    }
}
