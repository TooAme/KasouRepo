package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.MultiChipDiscreteDevices;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the MultiChipDiscreteDevices entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MultiChipDiscreteDevicesRepository extends JpaRepository<MultiChipDiscreteDevices, Long> {
    Optional<MultiChipDiscreteDevices> findById(@NotNull String id);

    Optional<MultiChipDiscreteDevices> findByBCode(String bCode);

    Optional<MultiChipDiscreteDevices> deleteById(String id);

    List<MultiChipDiscreteDevices> findByBCodeIn(List<String> ssSubBCodeList);

    List<MultiChipDiscreteDevices> findByPartNumber(@NotNull String partNumber);
}
