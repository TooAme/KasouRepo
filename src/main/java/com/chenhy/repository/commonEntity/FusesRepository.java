package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Fuses;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Fuses entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FusesRepository extends JpaRepository<Fuses, Long> {
    Optional<Fuses> findById(@NotNull String id);

    Optional<Fuses> findByBCode(String bCode);

    Optional<Fuses> deleteById(String id);

    List<Fuses> findByBCodeIn(List<String> ssSubBCodeList);

    List<Fuses> findByPartNumber(@NotNull String partNumber);
}
