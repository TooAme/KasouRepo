package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.PowerSupplies;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the PowerSupplies entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PowerSuppliesRepository extends JpaRepository<PowerSupplies, Long> {
    Optional<PowerSupplies> findById(@NotNull String id);

    Optional<PowerSupplies> findByBCode(String bCode);

    Optional<PowerSupplies> deleteById(String id);

    List<PowerSupplies> findByBCodeIn(List<String> ssSubBCodeList);

    List<PowerSupplies> findByPartNumber(@NotNull String partNumber);
}
