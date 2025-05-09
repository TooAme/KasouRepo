package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Terminals;
import com.chenhy.repository.commonEntity.TerminalsRepository;
import com.chenhy.service.commonEntity.TerminalsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Terminals}.
 */
@Service
@Transactional
public class TerminalsServiceImpl implements TerminalsService {

    private static final Logger LOG = LoggerFactory.getLogger(TerminalsServiceImpl.class);

    private final TerminalsRepository TerminalsRepository;

    public TerminalsServiceImpl(TerminalsRepository TerminalsRepository) {
        this.TerminalsRepository = TerminalsRepository;
    }

    @Override
    public Terminals save(Terminals Terminals) {
        LOG.debug("Request to save Terminals : {}", Terminals);
        return TerminalsRepository.save(Terminals);
    }

    @Override
    public Terminals update(Terminals Terminals) {
        LOG.debug("Request to update Terminals : {}", Terminals);
        return TerminalsRepository.save(Terminals);
    }

    @Override
    public Optional<Terminals> partialUpdate(Terminals Terminals) {
        LOG.debug("Request to partially update Terminals : {}", Terminals);

        return TerminalsRepository
            .findById(Terminals.getId())
            .map(existingTerminals -> {
                if (Terminals.getId() != null) {
                    existingTerminals.setId(Terminals.getId());
                }
                if (Terminals.getPartNumber() != null) {
                    existingTerminals.setPartNumber(Terminals.getPartNumber());
                }
                if (Terminals.getPartType() != null) {
                    existingTerminals.setPartType(Terminals.getPartType());
                }
                if (Terminals.getValue() != null) {
                    existingTerminals.setValue(Terminals.getValue());
                }
                if (Terminals.getSchematicPart() != null) {
                    existingTerminals.setSchematicPart(Terminals.getSchematicPart());
                }
                if (Terminals.getRatingVoltage() != null) {
                    existingTerminals.setRatingVoltage(Terminals.getRatingVoltage());
                }
                if (Terminals.getRatingElectricity() != null) {
                    existingTerminals.setRatingElectricity(Terminals.getRatingElectricity());
                }
                if (Terminals.getCharacteristics() != null) {
                    existingTerminals.setCharacteristics(Terminals.getCharacteristics());
                }
                if (Terminals.getTolerance() != null) {
                    existingTerminals.setTolerance(Terminals.getTolerance());
                }
                if (Terminals.getManufacture() != null) {
                    existingTerminals.setManufacture(Terminals.getManufacture());
                }
                if (Terminals.getbCode() != null) {
                    existingTerminals.setbCode(Terminals.getbCode());
                }
                if (Terminals.getPartsName() != null) {
                    existingTerminals.setPartsName(Terminals.getPartsName());
                }
                if (Terminals.getItemRegistrationClassification() != null) {
                    existingTerminals.setItemRegistrationClassification(Terminals.getItemRegistrationClassification());
                }
                if (Terminals.getSpiceModel() != null) {
                    existingTerminals.setSpiceModel(Terminals.getSpiceModel());
                }
                if (Terminals.getPcbFootPrint() != null) {
                    existingTerminals.setPcbFootPrint(Terminals.getPcbFootPrint());
                }
                if (Terminals.getDelFlag() != null) {
                    existingTerminals.setDelFlag(Terminals.getDelFlag());
                }
                if (Terminals.getRemark() != null) {
                    existingTerminals.setRemark(Terminals.getRemark());
                }
                if (Terminals.getCreateBy() != null) {
                    existingTerminals.setCreateBy(Terminals.getCreateBy());
                }
                if (Terminals.getCreateTime() != null) {
                    existingTerminals.setCreateTime(Terminals.getCreateTime());
                }
                if (Terminals.getUpdateBy() != null) {
                    existingTerminals.setUpdateBy(Terminals.getUpdateBy());
                }
                if (Terminals.getUpdateTime() != null) {
                    existingTerminals.setUpdateTime(Terminals.getUpdateTime());
                }

                return existingTerminals;
            })
            .map(TerminalsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Terminals> findAll(Pageable pageable) {
        LOG.debug("Request to get all Terminalss");
        return TerminalsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Terminals> findOne(String id) {
        LOG.debug("Request to get Terminals : {}", id);
        return TerminalsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Terminals : {}", id);
        TerminalsRepository.deleteById(id);
    }
}
