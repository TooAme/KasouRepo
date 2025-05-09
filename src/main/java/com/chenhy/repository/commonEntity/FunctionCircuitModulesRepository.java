package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.FunctionCircuitModules;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the FunctionCircuitModules entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FunctionCircuitModulesRepository extends JpaRepository<FunctionCircuitModules, Long> {
    Optional<FunctionCircuitModules> findById(@NotNull String id);

    Optional<FunctionCircuitModules> findByBCode(String bCode);

    Optional<FunctionCircuitModules> deleteById(String id);

    List<FunctionCircuitModules> findByBCodeIn(List<String> ssSubBCodeList);

    List<FunctionCircuitModules> findByPartNumber(@NotNull String partNumber);
}
