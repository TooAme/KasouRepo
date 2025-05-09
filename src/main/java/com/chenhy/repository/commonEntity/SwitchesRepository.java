package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Switches;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Switches entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SwitchesRepository extends JpaRepository<Switches, Long> {
    Optional<Switches> findById(@NotNull String id);

    Optional<Switches> findByBCode(String bCode);

    Optional<Switches> deleteById(String id);

    List<Switches> findByBCodeIn(List<String> ssSubBCodeList);

    List<Switches> findByPartNumber(@NotNull String partNumber);
}
