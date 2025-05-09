package com.chenhy.service.impl.commonEntity;

import com.chenhy.domain.commonEntity.Sockets;
import com.chenhy.repository.commonEntity.SocketsRepository;
import com.chenhy.service.commonEntity.SocketsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Sockets}.
 */
@Service
@Transactional
public class SocketsServiceImpl implements SocketsService {

    private static final Logger LOG = LoggerFactory.getLogger(SocketsServiceImpl.class);

    private final SocketsRepository SocketsRepository;

    public SocketsServiceImpl(SocketsRepository SocketsRepository) {
        this.SocketsRepository = SocketsRepository;
    }

    @Override
    public Sockets save(Sockets Sockets) {
        LOG.debug("Request to save Sockets : {}", Sockets);
        return SocketsRepository.save(Sockets);
    }

    @Override
    public Sockets update(Sockets Sockets) {
        LOG.debug("Request to update Sockets : {}", Sockets);
        return SocketsRepository.save(Sockets);
    }

    @Override
    public Optional<Sockets> partialUpdate(Sockets Sockets) {
        LOG.debug("Request to partially update Sockets : {}", Sockets);

        return SocketsRepository
            .findById(Sockets.getId())
            .map(existingSockets -> {
                if (Sockets.getId() != null) {
                    existingSockets.setId(Sockets.getId());
                }
                if (Sockets.getPartNumber() != null) {
                    existingSockets.setPartNumber(Sockets.getPartNumber());
                }
                if (Sockets.getPartType() != null) {
                    existingSockets.setPartType(Sockets.getPartType());
                }
                if (Sockets.getValue() != null) {
                    existingSockets.setValue(Sockets.getValue());
                }
                if (Sockets.getSchematicPart() != null) {
                    existingSockets.setSchematicPart(Sockets.getSchematicPart());
                }
                if (Sockets.getRatingVoltage() != null) {
                    existingSockets.setRatingVoltage(Sockets.getRatingVoltage());
                }
                if (Sockets.getRatingElectricity() != null) {
                    existingSockets.setRatingElectricity(Sockets.getRatingElectricity());
                }
                if (Sockets.getCharacteristics() != null) {
                    existingSockets.setCharacteristics(Sockets.getCharacteristics());
                }
                if (Sockets.getTolerance() != null) {
                    existingSockets.setTolerance(Sockets.getTolerance());
                }
                if (Sockets.getManufacture() != null) {
                    existingSockets.setManufacture(Sockets.getManufacture());
                }
                if (Sockets.getbCode() != null) {
                    existingSockets.setbCode(Sockets.getbCode());
                }
                if (Sockets.getPartsName() != null) {
                    existingSockets.setPartsName(Sockets.getPartsName());
                }
                if (Sockets.getItemRegistrationClassification() != null) {
                    existingSockets.setItemRegistrationClassification(Sockets.getItemRegistrationClassification());
                }
                if (Sockets.getSpiceModel() != null) {
                    existingSockets.setSpiceModel(Sockets.getSpiceModel());
                }
                if (Sockets.getPcbFootPrint() != null) {
                    existingSockets.setPcbFootPrint(Sockets.getPcbFootPrint());
                }
                if (Sockets.getDelFlag() != null) {
                    existingSockets.setDelFlag(Sockets.getDelFlag());
                }
                if (Sockets.getRemark() != null) {
                    existingSockets.setRemark(Sockets.getRemark());
                }
                if (Sockets.getCreateBy() != null) {
                    existingSockets.setCreateBy(Sockets.getCreateBy());
                }
                if (Sockets.getCreateTime() != null) {
                    existingSockets.setCreateTime(Sockets.getCreateTime());
                }
                if (Sockets.getUpdateBy() != null) {
                    existingSockets.setUpdateBy(Sockets.getUpdateBy());
                }
                if (Sockets.getUpdateTime() != null) {
                    existingSockets.setUpdateTime(Sockets.getUpdateTime());
                }

                return existingSockets;
            })
            .map(SocketsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Sockets> findAll(Pageable pageable) {
        LOG.debug("Request to get all Socketss");
        return SocketsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sockets> findOne(String id) {
        LOG.debug("Request to get Sockets : {}", id);
        return SocketsRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        LOG.debug("Request to delete Sockets : {}", id);
        SocketsRepository.deleteById(id);
    }
}
