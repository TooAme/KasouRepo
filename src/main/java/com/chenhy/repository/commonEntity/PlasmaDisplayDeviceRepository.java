package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.PlasmaDisplayDevice;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the PlasmaDisplayDevice entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PlasmaDisplayDeviceRepository extends JpaRepository<PlasmaDisplayDevice, Long> {
    Optional<PlasmaDisplayDevice> findById(@NotNull String id);

    Optional<PlasmaDisplayDevice> findByBCode(String bCode);

    Optional<PlasmaDisplayDevice> deleteById(String id);

    List<PlasmaDisplayDevice> findByBCodeIn(List<String> ssSubBCodeList);

    List<PlasmaDisplayDevice> findByPartNumber(@NotNull String partNumber);
}
