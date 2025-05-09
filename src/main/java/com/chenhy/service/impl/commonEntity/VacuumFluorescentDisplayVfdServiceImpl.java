package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.VacuumFluorescentDisplayVfd;
import com.chenhy.repository.commonEntity.VacuumFluorescentDisplayVfdRepository;
import com.chenhy.service.commonEntity.VacuumFluorescentDisplayVfdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link VacuumFluorescentDisplayVfd}.
 */
@Service
@Transactional
public class VacuumFluorescentDisplayVfdServiceImpl implements VacuumFluorescentDisplayVfdService {

    private static final Logger LOG = LoggerFactory.getLogger(VacuumFluorescentDisplayVfdServiceImpl.class);

    private final VacuumFluorescentDisplayVfdRepository VacuumFluorescentDisplayVfdRepository;

    public VacuumFluorescentDisplayVfdServiceImpl(VacuumFluorescentDisplayVfdRepository VacuumFluorescentDisplayVfdRepository) {
        this.VacuumFluorescentDisplayVfdRepository = VacuumFluorescentDisplayVfdRepository;
    }

    @Override
    public VacuumFluorescentDisplayVfd save(VacuumFluorescentDisplayVfd VacuumFluorescentDisplayVfd) {
        LOG.debug("Request to save VacuumFluorescentDisplayVfd : {}", VacuumFluorescentDisplayVfd);
        return VacuumFluorescentDisplayVfdRepository.save(VacuumFluorescentDisplayVfd);
    }

    @Override
    public VacuumFluorescentDisplayVfd update(VacuumFluorescentDisplayVfd VacuumFluorescentDisplayVfd) {
        LOG.debug("Request to update VacuumFluorescentDisplayVfd : {}", VacuumFluorescentDisplayVfd);
        return VacuumFluorescentDisplayVfdRepository.save(VacuumFluorescentDisplayVfd);
    }

    @Override
    public Optional<VacuumFluorescentDisplayVfd> partialUpdate(VacuumFluorescentDisplayVfd VacuumFluorescentDisplayVfd) {
        LOG.debug("Request to partially update VacuumFluorescentDisplayVfd : {}", VacuumFluorescentDisplayVfd);

        return VacuumFluorescentDisplayVfdRepository
            .findById(VacuumFluorescentDisplayVfd.getId())
            .map(existingVacuumFluorescentDisplayVfd -> {
                if (VacuumFluorescentDisplayVfd.getId() != null) {
                    existingVacuumFluorescentDisplayVfd.setId(VacuumFluorescentDisplayVfd.getId());
                }
                if (VacuumFluorescentDisplayVfd.getPartNumber() != null) {
                    existingVacuumFluorescentDisplayVfd.setPartNumber(VacuumFluorescentDisplayVfd.getPartNumber());
                }
                if (VacuumFluorescentDisplayVfd.getPartType() != null) {
                    existingVacuumFluorescentDisplayVfd.setPartType(VacuumFluorescentDisplayVfd.getPartType());
                }
                if (VacuumFluorescentDisplayVfd.getValue() != null) {
                    existingVacuumFluorescentDisplayVfd.setValue(VacuumFluorescentDisplayVfd.getValue());
                }
                if (VacuumFluorescentDisplayVfd.getSchematicPart() != null) {
                    existingVacuumFluorescentDisplayVfd.setSchematicPart(VacuumFluorescentDisplayVfd.getSchematicPart());
                }
                if (VacuumFluorescentDisplayVfd.getRatingVoltage() != null) {
                    existingVacuumFluorescentDisplayVfd.setRatingVoltage(VacuumFluorescentDisplayVfd.getRatingVoltage());
                }
                if (VacuumFluorescentDisplayVfd.getRatingElectricity() != null) {
                    existingVacuumFluorescentDisplayVfd.setRatingElectricity(VacuumFluorescentDisplayVfd.getRatingElectricity());
                }
                if (VacuumFluorescentDisplayVfd.getCharacteristics() != null) {
                    existingVacuumFluorescentDisplayVfd.setCharacteristics(VacuumFluorescentDisplayVfd.getCharacteristics());
                }
                if (VacuumFluorescentDisplayVfd.getTolerance() != null) {
                    existingVacuumFluorescentDisplayVfd.setTolerance(VacuumFluorescentDisplayVfd.getTolerance());
                }
                if (VacuumFluorescentDisplayVfd.getManufacture() != null) {
                    existingVacuumFluorescentDisplayVfd.setManufacture(VacuumFluorescentDisplayVfd.getManufacture());
                }
                if (VacuumFluorescentDisplayVfd.getbCode() != null) {
                    existingVacuumFluorescentDisplayVfd.setbCode(VacuumFluorescentDisplayVfd.getbCode());
                }
                if (VacuumFluorescentDisplayVfd.getPartsName() != null) {
                    existingVacuumFluorescentDisplayVfd.setPartsName(VacuumFluorescentDisplayVfd.getPartsName());
                }
                if (VacuumFluorescentDisplayVfd.getItemRegistrationClassification() != null) {
                    existingVacuumFluorescentDisplayVfd.setItemRegistrationClassification(VacuumFluorescentDisplayVfd.getItemRegistrationClassification());
                }
                if (VacuumFluorescentDisplayVfd.getSpiceModel() != null) {
                    existingVacuumFluorescentDisplayVfd.setSpiceModel(VacuumFluorescentDisplayVfd.getSpiceModel());
                }
                if (VacuumFluorescentDisplayVfd.getPcbFootPrint() != null) {
                    existingVacuumFluorescentDisplayVfd.setPcbFootPrint(VacuumFluorescentDisplayVfd.getPcbFootPrint());
                }
                if (VacuumFluorescentDisplayVfd.getDelFlag() != null) {
                    existingVacuumFluorescentDisplayVfd.setDelFlag(VacuumFluorescentDisplayVfd.getDelFlag());
                }
                if (VacuumFluorescentDisplayVfd.getRemark() != null) {
                    existingVacuumFluorescentDisplayVfd.setRemark(VacuumFluorescentDisplayVfd.getRemark());
                }
                if (VacuumFluorescentDisplayVfd.getCreateBy() != null) {
                    existingVacuumFluorescentDisplayVfd.setCreateBy(VacuumFluorescentDisplayVfd.getCreateBy());
                }
                if (VacuumFluorescentDisplayVfd.getCreateTime() != null) {
                    existingVacuumFluorescentDisplayVfd.setCreateTime(VacuumFluorescentDisplayVfd.getCreateTime());
                }
                if (VacuumFluorescentDisplayVfd.getUpdateBy() != null) {
                    existingVacuumFluorescentDisplayVfd.setUpdateBy(VacuumFluorescentDisplayVfd.getUpdateBy());
                }
                if (VacuumFluorescentDisplayVfd.getUpdateTime() != null) {
                    existingVacuumFluorescentDisplayVfd.setUpdateTime(VacuumFluorescentDisplayVfd.getUpdateTime());
                }

                return existingVacuumFluorescentDisplayVfd;
            })
            .map(VacuumFluorescentDisplayVfdRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<VacuumFluorescentDisplayVfd> findAll(Pageable pageable) {
        LOG.debug("Request to get all VacuumFluorescentDisplayVfds");
        return VacuumFluorescentDisplayVfdRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VacuumFluorescentDisplayVfd> findOne(String id) {
        LOG.debug("Request to get VacuumFluorescentDisplayVfd : {}", id);
        return VacuumFluorescentDisplayVfdRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete VacuumFluorescentDisplayVfd : {}", id);
        VacuumFluorescentDisplayVfdRepository.deleteById(id);
    }
}
