package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Loudspeakers;
import com.chenhy.repository.commonEntity.LoudspeakersRepository;
import com.chenhy.service.commonEntity.LoudspeakersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Loudspeakers}.
 */
@Service
@Transactional
public class LoudspeakersServiceImpl implements LoudspeakersService {

    private static final Logger LOG = LoggerFactory.getLogger(LoudspeakersServiceImpl.class);

    private final LoudspeakersRepository LoudspeakersRepository;

    public LoudspeakersServiceImpl(LoudspeakersRepository LoudspeakersRepository) {
        this.LoudspeakersRepository = LoudspeakersRepository;
    }

    @Override
    public Loudspeakers save(Loudspeakers Loudspeakers) {
        LOG.debug("Request to save Loudspeakers : {}", Loudspeakers);
        return LoudspeakersRepository.save(Loudspeakers);
    }

    @Override
    public Loudspeakers update(Loudspeakers Loudspeakers) {
        LOG.debug("Request to update Loudspeakers : {}", Loudspeakers);
        return LoudspeakersRepository.save(Loudspeakers);
    }

    @Override
    public Optional<Loudspeakers> partialUpdate(Loudspeakers Loudspeakers) {
        LOG.debug("Request to partially update Loudspeakers : {}", Loudspeakers);

        return LoudspeakersRepository
            .findById(Loudspeakers.getId())
            .map(existingLoudspeakers -> {
                if (Loudspeakers.getId() != null) {
                    existingLoudspeakers.setId(Loudspeakers.getId());
                }
                if (Loudspeakers.getPartNumber() != null) {
                    existingLoudspeakers.setPartNumber(Loudspeakers.getPartNumber());
                }
                if (Loudspeakers.getPartType() != null) {
                    existingLoudspeakers.setPartType(Loudspeakers.getPartType());
                }
                if (Loudspeakers.getValue() != null) {
                    existingLoudspeakers.setValue(Loudspeakers.getValue());
                }
                if (Loudspeakers.getSchematicPart() != null) {
                    existingLoudspeakers.setSchematicPart(Loudspeakers.getSchematicPart());
                }
                if (Loudspeakers.getRatingVoltage() != null) {
                    existingLoudspeakers.setRatingVoltage(Loudspeakers.getRatingVoltage());
                }
                if (Loudspeakers.getRatingElectricity() != null) {
                    existingLoudspeakers.setRatingElectricity(Loudspeakers.getRatingElectricity());
                }
                if (Loudspeakers.getCharacteristics() != null) {
                    existingLoudspeakers.setCharacteristics(Loudspeakers.getCharacteristics());
                }
                if (Loudspeakers.getTolerance() != null) {
                    existingLoudspeakers.setTolerance(Loudspeakers.getTolerance());
                }
                if (Loudspeakers.getManufacture() != null) {
                    existingLoudspeakers.setManufacture(Loudspeakers.getManufacture());
                }
                if (Loudspeakers.getbCode() != null) {
                    existingLoudspeakers.setbCode(Loudspeakers.getbCode());
                }
                if (Loudspeakers.getPartsName() != null) {
                    existingLoudspeakers.setPartsName(Loudspeakers.getPartsName());
                }
                if (Loudspeakers.getItemRegistrationClassification() != null) {
                    existingLoudspeakers.setItemRegistrationClassification(Loudspeakers.getItemRegistrationClassification());
                }
                if (Loudspeakers.getSpiceModel() != null) {
                    existingLoudspeakers.setSpiceModel(Loudspeakers.getSpiceModel());
                }
                if (Loudspeakers.getPcbFootPrint() != null) {
                    existingLoudspeakers.setPcbFootPrint(Loudspeakers.getPcbFootPrint());
                }
                if (Loudspeakers.getDelFlag() != null) {
                    existingLoudspeakers.setDelFlag(Loudspeakers.getDelFlag());
                }
                if (Loudspeakers.getRemark() != null) {
                    existingLoudspeakers.setRemark(Loudspeakers.getRemark());
                }
                if (Loudspeakers.getCreateBy() != null) {
                    existingLoudspeakers.setCreateBy(Loudspeakers.getCreateBy());
                }
                if (Loudspeakers.getCreateTime() != null) {
                    existingLoudspeakers.setCreateTime(Loudspeakers.getCreateTime());
                }
                if (Loudspeakers.getUpdateBy() != null) {
                    existingLoudspeakers.setUpdateBy(Loudspeakers.getUpdateBy());
                }
                if (Loudspeakers.getUpdateTime() != null) {
                    existingLoudspeakers.setUpdateTime(Loudspeakers.getUpdateTime());
                }

                return existingLoudspeakers;
            })
            .map(LoudspeakersRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Loudspeakers> findAll(Pageable pageable) {
        LOG.debug("Request to get all Loudspeakerss");
        return LoudspeakersRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Loudspeakers> findOne(String id) {
        LOG.debug("Request to get Loudspeakers : {}", id);
        return LoudspeakersRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Loudspeakers : {}", id);
        LoudspeakersRepository.deleteById(id);
    }
}
