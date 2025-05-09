package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Filters;
import com.chenhy.repository.commonEntity.FiltersRepository;
import com.chenhy.service.commonEntity.FiltersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Filters}.
 */
@Service
@Transactional
public class FiltersServiceImpl implements FiltersService {

    private static final Logger LOG = LoggerFactory.getLogger(FiltersServiceImpl.class);

    private final FiltersRepository FiltersRepository;

    public FiltersServiceImpl(FiltersRepository FiltersRepository) {
        this.FiltersRepository = FiltersRepository;
    }

    @Override
    public Filters save(Filters Filters) {
        LOG.debug("Request to save Filters : {}", Filters);
        return FiltersRepository.save(Filters);
    }

    @Override
    public Filters update(Filters Filters) {
        LOG.debug("Request to update Filters : {}", Filters);
        return FiltersRepository.save(Filters);
    }

    @Override
    public Optional<Filters> partialUpdate(Filters Filters) {
        LOG.debug("Request to partially update Filters : {}", Filters);

        return FiltersRepository
            .findById(Filters.getId())
            .map(existingFilters -> {
                if (Filters.getId() != null) {
                    existingFilters.setId(Filters.getId());
                }
                if (Filters.getPartNumber() != null) {
                    existingFilters.setPartNumber(Filters.getPartNumber());
                }
                if (Filters.getPartType() != null) {
                    existingFilters.setPartType(Filters.getPartType());
                }
                if (Filters.getValue() != null) {
                    existingFilters.setValue(Filters.getValue());
                }
                if (Filters.getSchematicPart() != null) {
                    existingFilters.setSchematicPart(Filters.getSchematicPart());
                }
                if (Filters.getRatingVoltage() != null) {
                    existingFilters.setRatingVoltage(Filters.getRatingVoltage());
                }
                if (Filters.getRatingElectricity() != null) {
                    existingFilters.setRatingElectricity(Filters.getRatingElectricity());
                }
                if (Filters.getCharacteristics() != null) {
                    existingFilters.setCharacteristics(Filters.getCharacteristics());
                }
                if (Filters.getTolerance() != null) {
                    existingFilters.setTolerance(Filters.getTolerance());
                }
                if (Filters.getManufacture() != null) {
                    existingFilters.setManufacture(Filters.getManufacture());
                }
                if (Filters.getbCode() != null) {
                    existingFilters.setbCode(Filters.getbCode());
                }
                if (Filters.getPartsName() != null) {
                    existingFilters.setPartsName(Filters.getPartsName());
                }
                if (Filters.getItemRegistrationClassification() != null) {
                    existingFilters.setItemRegistrationClassification(Filters.getItemRegistrationClassification());
                }
                if (Filters.getSpiceModel() != null) {
                    existingFilters.setSpiceModel(Filters.getSpiceModel());
                }
                if (Filters.getPcbFootPrint() != null) {
                    existingFilters.setPcbFootPrint(Filters.getPcbFootPrint());
                }
                if (Filters.getDelFlag() != null) {
                    existingFilters.setDelFlag(Filters.getDelFlag());
                }
                if (Filters.getRemark() != null) {
                    existingFilters.setRemark(Filters.getRemark());
                }
                if (Filters.getCreateBy() != null) {
                    existingFilters.setCreateBy(Filters.getCreateBy());
                }
                if (Filters.getCreateTime() != null) {
                    existingFilters.setCreateTime(Filters.getCreateTime());
                }
                if (Filters.getUpdateBy() != null) {
                    existingFilters.setUpdateBy(Filters.getUpdateBy());
                }
                if (Filters.getUpdateTime() != null) {
                    existingFilters.setUpdateTime(Filters.getUpdateTime());
                }

                return existingFilters;
            })
            .map(FiltersRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Filters> findAll(Pageable pageable) {
        LOG.debug("Request to get all Filterss");
        return FiltersRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Filters> findOne(String id) {
        LOG.debug("Request to get Filters : {}", id);
        return FiltersRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Filters : {}", id);
        FiltersRepository.deleteById(id);
    }
}
