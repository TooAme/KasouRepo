package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Batteries;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Batteries entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BatteriesRepository extends JpaRepository<Batteries, Long> {
    Optional<Batteries> findById(@NotNull String id);

    Optional<Batteries> findByBCode(String bCode);

    Optional<Batteries> deleteById(String id);

    List<Batteries> findByBCodeIn(List<String> ssSubBCodeList);

    List<Batteries> findByPartNumber(@NotNull String partNumber);
}
