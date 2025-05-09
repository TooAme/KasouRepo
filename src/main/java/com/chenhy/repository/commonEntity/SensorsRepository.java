package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Sensors;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Sensors entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SensorsRepository extends JpaRepository<Sensors, Long> {
    Optional<Sensors> findById(@NotNull String id);

    Optional<Sensors> findByBCode(String bCode);

    Optional<Sensors> deleteById(String id);

    List<Sensors> findByBCodeIn(List<String> ssSubBCodeList);

    List<Sensors> findByPartNumber(@NotNull String partNumber);
}
