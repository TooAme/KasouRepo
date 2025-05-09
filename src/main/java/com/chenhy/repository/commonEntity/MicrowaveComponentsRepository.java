package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.MicrowaveComponents;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the MicrowaveComponents entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MicrowaveComponentsRepository extends JpaRepository<MicrowaveComponents, Long> {
    Optional<MicrowaveComponents> findById(@NotNull String id);

    Optional<MicrowaveComponents> findByBCode(String bCode);

    Optional<MicrowaveComponents> deleteById(String id);

    List<MicrowaveComponents> findByBCodeIn(List<String> ssSubBCodeList);

    List<MicrowaveComponents> findByPartNumber(@NotNull String partNumber);
}
