package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Connectors;
import com.chenhy.repository.commonEntity.ConnectorsRepository;
import com.chenhy.service.commonEntity.ConnectorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Connectors}.
 */
@Service
@Transactional
public class ConnectorsServiceImpl implements ConnectorsService {

    private static final Logger LOG = LoggerFactory.getLogger(ConnectorsServiceImpl.class);

    private final ConnectorsRepository ConnectorsRepository;

    public ConnectorsServiceImpl(ConnectorsRepository ConnectorsRepository) {
        this.ConnectorsRepository = ConnectorsRepository;
    }

    @Override
    public Connectors save(Connectors Connectors) {
        LOG.debug("Request to save Connectors : {}", Connectors);
        return ConnectorsRepository.save(Connectors);
    }

    @Override
    public Connectors update(Connectors Connectors) {
        LOG.debug("Request to update Connectors : {}", Connectors);
        return ConnectorsRepository.save(Connectors);
    }

    @Override
    public Optional<Connectors> partialUpdate(Connectors Connectors) {
        LOG.debug("Request to partially update Connectors : {}", Connectors);

        return ConnectorsRepository
            .findById(Connectors.getId())
            .map(existingConnectors -> {
                if (Connectors.getId() != null) {
                    existingConnectors.setId(Connectors.getId());
                }
                if (Connectors.getPartNumber() != null) {
                    existingConnectors.setPartNumber(Connectors.getPartNumber());
                }
                if (Connectors.getPartType() != null) {
                    existingConnectors.setPartType(Connectors.getPartType());
                }
                if (Connectors.getValue() != null) {
                    existingConnectors.setValue(Connectors.getValue());
                }
                if (Connectors.getSchematicPart() != null) {
                    existingConnectors.setSchematicPart(Connectors.getSchematicPart());
                }
                if (Connectors.getRatingVoltage() != null) {
                    existingConnectors.setRatingVoltage(Connectors.getRatingVoltage());
                }
                if (Connectors.getRatingElectricity() != null) {
                    existingConnectors.setRatingElectricity(Connectors.getRatingElectricity());
                }
                if (Connectors.getCharacteristics() != null) {
                    existingConnectors.setCharacteristics(Connectors.getCharacteristics());
                }
                if (Connectors.getTolerance() != null) {
                    existingConnectors.setTolerance(Connectors.getTolerance());
                }
                if (Connectors.getManufacture() != null) {
                    existingConnectors.setManufacture(Connectors.getManufacture());
                }
                if (Connectors.getbCode() != null) {
                    existingConnectors.setbCode(Connectors.getbCode());
                }
                if (Connectors.getPartsName() != null) {
                    existingConnectors.setPartsName(Connectors.getPartsName());
                }
                if (Connectors.getItemRegistrationClassification() != null) {
                    existingConnectors.setItemRegistrationClassification(Connectors.getItemRegistrationClassification());
                }
                if (Connectors.getSpiceModel() != null) {
                    existingConnectors.setSpiceModel(Connectors.getSpiceModel());
                }
                if (Connectors.getPcbFootPrint() != null) {
                    existingConnectors.setPcbFootPrint(Connectors.getPcbFootPrint());
                }
                if (Connectors.getDelFlag() != null) {
                    existingConnectors.setDelFlag(Connectors.getDelFlag());
                }
                if (Connectors.getRemark() != null) {
                    existingConnectors.setRemark(Connectors.getRemark());
                }
                if (Connectors.getCreateBy() != null) {
                    existingConnectors.setCreateBy(Connectors.getCreateBy());
                }
                if (Connectors.getCreateTime() != null) {
                    existingConnectors.setCreateTime(Connectors.getCreateTime());
                }
                if (Connectors.getUpdateBy() != null) {
                    existingConnectors.setUpdateBy(Connectors.getUpdateBy());
                }
                if (Connectors.getUpdateTime() != null) {
                    existingConnectors.setUpdateTime(Connectors.getUpdateTime());
                }

                return existingConnectors;
            })
            .map(ConnectorsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Connectors> findAll(Pageable pageable) {
        LOG.debug("Request to get all Connectorss");
        return ConnectorsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Connectors> findOne(String id) {
        LOG.debug("Request to get Connectors : {}", id);
        return ConnectorsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Connectors : {}", id);
        ConnectorsRepository.deleteById(id);
    }
}
