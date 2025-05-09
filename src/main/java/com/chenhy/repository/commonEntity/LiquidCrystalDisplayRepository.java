package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.LiquidCrystalDisplay;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the LiquidCrystalDisplay entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LiquidCrystalDisplayRepository extends JpaRepository<LiquidCrystalDisplay, Long> {
    Optional<LiquidCrystalDisplay> findById(@NotNull String id);

    Optional<LiquidCrystalDisplay> findByBCode(String bCode);

    Optional<LiquidCrystalDisplay> deleteById(String id);

    List<LiquidCrystalDisplay> findByBCodeIn(List<String> ssSubBCodeList);

    List<LiquidCrystalDisplay> findByPartNumber(@NotNull String partNumber);
}
