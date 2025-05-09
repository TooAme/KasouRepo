package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.ImagePickupDevices;
import com.chenhy.repository.commonEntity.ImagePickupDevicesRepository;
import com.chenhy.service.commonEntity.ImagePickupDevicesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ImagePickupDevices}.
 */
@Service
@Transactional
public class ImagePickupDevicesServiceImpl implements ImagePickupDevicesService {

    private static final Logger LOG = LoggerFactory.getLogger(ImagePickupDevicesServiceImpl.class);

    private final ImagePickupDevicesRepository ImagePickupDevicesRepository;

    public ImagePickupDevicesServiceImpl(ImagePickupDevicesRepository ImagePickupDevicesRepository) {
        this.ImagePickupDevicesRepository = ImagePickupDevicesRepository;
    }

    @Override
    public ImagePickupDevices save(ImagePickupDevices ImagePickupDevices) {
        LOG.debug("Request to save ImagePickupDevices : {}", ImagePickupDevices);
        return ImagePickupDevicesRepository.save(ImagePickupDevices);
    }

    @Override
    public ImagePickupDevices update(ImagePickupDevices ImagePickupDevices) {
        LOG.debug("Request to update ImagePickupDevices : {}", ImagePickupDevices);
        return ImagePickupDevicesRepository.save(ImagePickupDevices);
    }

    @Override
    public Optional<ImagePickupDevices> partialUpdate(ImagePickupDevices ImagePickupDevices) {
        LOG.debug("Request to partially update ImagePickupDevices : {}", ImagePickupDevices);

        return ImagePickupDevicesRepository
            .findById(ImagePickupDevices.getId())
            .map(existingImagePickupDevices -> {
                if (ImagePickupDevices.getId() != null) {
                    existingImagePickupDevices.setId(ImagePickupDevices.getId());
                }
                if (ImagePickupDevices.getPartNumber() != null) {
                    existingImagePickupDevices.setPartNumber(ImagePickupDevices.getPartNumber());
                }
                if (ImagePickupDevices.getPartType() != null) {
                    existingImagePickupDevices.setPartType(ImagePickupDevices.getPartType());
                }
                if (ImagePickupDevices.getValue() != null) {
                    existingImagePickupDevices.setValue(ImagePickupDevices.getValue());
                }
                if (ImagePickupDevices.getSchematicPart() != null) {
                    existingImagePickupDevices.setSchematicPart(ImagePickupDevices.getSchematicPart());
                }
                if (ImagePickupDevices.getRatingVoltage() != null) {
                    existingImagePickupDevices.setRatingVoltage(ImagePickupDevices.getRatingVoltage());
                }
                if (ImagePickupDevices.getRatingElectricity() != null) {
                    existingImagePickupDevices.setRatingElectricity(ImagePickupDevices.getRatingElectricity());
                }
                if (ImagePickupDevices.getCharacteristics() != null) {
                    existingImagePickupDevices.setCharacteristics(ImagePickupDevices.getCharacteristics());
                }
                if (ImagePickupDevices.getTolerance() != null) {
                    existingImagePickupDevices.setTolerance(ImagePickupDevices.getTolerance());
                }
                if (ImagePickupDevices.getManufacture() != null) {
                    existingImagePickupDevices.setManufacture(ImagePickupDevices.getManufacture());
                }
                if (ImagePickupDevices.getbCode() != null) {
                    existingImagePickupDevices.setbCode(ImagePickupDevices.getbCode());
                }
                if (ImagePickupDevices.getPartsName() != null) {
                    existingImagePickupDevices.setPartsName(ImagePickupDevices.getPartsName());
                }
                if (ImagePickupDevices.getItemRegistrationClassification() != null) {
                    existingImagePickupDevices.setItemRegistrationClassification(ImagePickupDevices.getItemRegistrationClassification());
                }
                if (ImagePickupDevices.getSpiceModel() != null) {
                    existingImagePickupDevices.setSpiceModel(ImagePickupDevices.getSpiceModel());
                }
                if (ImagePickupDevices.getPcbFootPrint() != null) {
                    existingImagePickupDevices.setPcbFootPrint(ImagePickupDevices.getPcbFootPrint());
                }
                if (ImagePickupDevices.getDelFlag() != null) {
                    existingImagePickupDevices.setDelFlag(ImagePickupDevices.getDelFlag());
                }
                if (ImagePickupDevices.getRemark() != null) {
                    existingImagePickupDevices.setRemark(ImagePickupDevices.getRemark());
                }
                if (ImagePickupDevices.getCreateBy() != null) {
                    existingImagePickupDevices.setCreateBy(ImagePickupDevices.getCreateBy());
                }
                if (ImagePickupDevices.getCreateTime() != null) {
                    existingImagePickupDevices.setCreateTime(ImagePickupDevices.getCreateTime());
                }
                if (ImagePickupDevices.getUpdateBy() != null) {
                    existingImagePickupDevices.setUpdateBy(ImagePickupDevices.getUpdateBy());
                }
                if (ImagePickupDevices.getUpdateTime() != null) {
                    existingImagePickupDevices.setUpdateTime(ImagePickupDevices.getUpdateTime());
                }

                return existingImagePickupDevices;
            })
            .map(ImagePickupDevicesRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ImagePickupDevices> findAll(Pageable pageable) {
        LOG.debug("Request to get all ImagePickupDevicess");
        return ImagePickupDevicesRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ImagePickupDevices> findOne(String id) {
        LOG.debug("Request to get ImagePickupDevices : {}", id);
        return ImagePickupDevicesRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete ImagePickupDevices : {}", id);
        ImagePickupDevicesRepository.deleteById(id);
    }
}
