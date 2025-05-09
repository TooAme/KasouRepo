package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.ElectricalDischargeGaps;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the ElectricalDischargeGaps entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ElectricalDischargeGapsRepository extends JpaRepository<ElectricalDischargeGaps, Long> {
    Optional<ElectricalDischargeGaps> findById(@NotNull String id);

    Optional<ElectricalDischargeGaps> findByBCode(String bCode);

    Optional<ElectricalDischargeGaps> deleteById(String id);

    List<ElectricalDischargeGaps> findByBCodeIn(List<String> ssSubBCodeList);

    List<ElectricalDischargeGaps> findByPartNumber(@NotNull String partNumber);
}
