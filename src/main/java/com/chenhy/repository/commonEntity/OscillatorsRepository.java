package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Oscillators;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Oscillators entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OscillatorsRepository extends JpaRepository<Oscillators, Long> {
    Optional<Oscillators> findById(@NotNull String id);

    Optional<Oscillators> findByBCode(String bCode);

    Optional<Oscillators> deleteById(String id);

    List<Oscillators> findByBCodeIn(List<String> ssSubBCodeList);

    List<Oscillators> findByPartNumber(@NotNull String partNumber);
}
