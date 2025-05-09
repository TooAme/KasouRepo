package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.CircuitBreakersForEquipmentProtection;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the CircuitBreakersForEquipmentProtection entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CircuitBreakersForEquipmentProtectionRepository extends JpaRepository<CircuitBreakersForEquipmentProtection, Long> {
    Optional<CircuitBreakersForEquipmentProtection> findById(@NotNull String id);

    Optional<CircuitBreakersForEquipmentProtection> findByBCode(String bCode);

    Optional<CircuitBreakersForEquipmentProtection> deleteById(String id);

    List<CircuitBreakersForEquipmentProtection> findByBCodeIn(List<String> ssSubBCodeList);

    List<CircuitBreakersForEquipmentProtection> findByPartNumber(@NotNull String partNumber);
}
