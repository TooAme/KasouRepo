package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.EmiEmcCountermeasureParts;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the EmiEmcCountermeasureParts entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmiEmcCountermeasurePartsRepository extends JpaRepository<EmiEmcCountermeasureParts, Long> {
    Optional<EmiEmcCountermeasureParts> findById(@NotNull String id);

    Optional<EmiEmcCountermeasureParts> findByBCode(String bCode);

    Optional<EmiEmcCountermeasureParts> deleteById(String id);

    List<EmiEmcCountermeasureParts> findByBCodeIn(List<String> ssSubBCodeList);

    List<EmiEmcCountermeasureParts> findByPartNumber(@NotNull String partNumber);
}
