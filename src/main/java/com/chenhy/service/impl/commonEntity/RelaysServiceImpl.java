package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Relays;
import com.chenhy.repository.commonEntity.RelaysRepository;
import com.chenhy.service.commonEntity.RelaysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Relays}.
 */
@Service
@Transactional
public class RelaysServiceImpl implements RelaysService {

    private static final Logger LOG = LoggerFactory.getLogger(RelaysServiceImpl.class);

    private final RelaysRepository RelaysRepository;

    public RelaysServiceImpl(RelaysRepository RelaysRepository) {
        this.RelaysRepository = RelaysRepository;
    }

    @Override
    public Relays save(Relays Relays) {
        LOG.debug("Request to save Relays : {}", Relays);
        return RelaysRepository.save(Relays);
    }

    @Override
    public Relays update(Relays Relays) {
        LOG.debug("Request to update Relays : {}", Relays);
        return RelaysRepository.save(Relays);
    }

    @Override
    public Optional<Relays> partialUpdate(Relays Relays) {
        LOG.debug("Request to partially update Relays : {}", Relays);

        return RelaysRepository
            .findById(Relays.getId())
            .map(existingRelays -> {
                if (Relays.getId() != null) {
                    existingRelays.setId(Relays.getId());
                }
                if (Relays.getPartNumber() != null) {
                    existingRelays.setPartNumber(Relays.getPartNumber());
                }
                if (Relays.getPartType() != null) {
                    existingRelays.setPartType(Relays.getPartType());
                }
                if (Relays.getValue() != null) {
                    existingRelays.setValue(Relays.getValue());
                }
                if (Relays.getSchematicPart() != null) {
                    existingRelays.setSchematicPart(Relays.getSchematicPart());
                }
                if (Relays.getRatingVoltage() != null) {
                    existingRelays.setRatingVoltage(Relays.getRatingVoltage());
                }
                if (Relays.getRatingElectricity() != null) {
                    existingRelays.setRatingElectricity(Relays.getRatingElectricity());
                }
                if (Relays.getCharacteristics() != null) {
                    existingRelays.setCharacteristics(Relays.getCharacteristics());
                }
                if (Relays.getTolerance() != null) {
                    existingRelays.setTolerance(Relays.getTolerance());
                }
                if (Relays.getManufacture() != null) {
                    existingRelays.setManufacture(Relays.getManufacture());
                }
                if (Relays.getbCode() != null) {
                    existingRelays.setbCode(Relays.getbCode());
                }
                if (Relays.getPartsName() != null) {
                    existingRelays.setPartsName(Relays.getPartsName());
                }
                if (Relays.getItemRegistrationClassification() != null) {
                    existingRelays.setItemRegistrationClassification(Relays.getItemRegistrationClassification());
                }
                if (Relays.getSpiceModel() != null) {
                    existingRelays.setSpiceModel(Relays.getSpiceModel());
                }
                if (Relays.getPcbFootPrint() != null) {
                    existingRelays.setPcbFootPrint(Relays.getPcbFootPrint());
                }
                if (Relays.getDelFlag() != null) {
                    existingRelays.setDelFlag(Relays.getDelFlag());
                }
                if (Relays.getRemark() != null) {
                    existingRelays.setRemark(Relays.getRemark());
                }
                if (Relays.getCreateBy() != null) {
                    existingRelays.setCreateBy(Relays.getCreateBy());
                }
                if (Relays.getCreateTime() != null) {
                    existingRelays.setCreateTime(Relays.getCreateTime());
                }
                if (Relays.getUpdateBy() != null) {
                    existingRelays.setUpdateBy(Relays.getUpdateBy());
                }
                if (Relays.getUpdateTime() != null) {
                    existingRelays.setUpdateTime(Relays.getUpdateTime());
                }

                return existingRelays;
            })
            .map(RelaysRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Relays> findAll(Pageable pageable) {
        LOG.debug("Request to get all Relayss");
        return RelaysRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Relays> findOne(String id) {
        LOG.debug("Request to get Relays : {}", id);
        return RelaysRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Relays : {}", id);
        RelaysRepository.deleteById(id);
    }
}
