package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.OptoElectronicDevices;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the OptoElectronicDevices entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OptoElectronicDevicesRepository extends JpaRepository<OptoElectronicDevices, Long> {
    Optional<OptoElectronicDevices> findById(@NotNull String id);

    Optional<OptoElectronicDevices> findByBCode(String bCode);

    Optional<OptoElectronicDevices> deleteById(String id);

    List<OptoElectronicDevices> findByBCodeIn(List<String> ssSubBCodeList);

    List<OptoElectronicDevices> findByPartNumber(@NotNull String partNumber);
}
