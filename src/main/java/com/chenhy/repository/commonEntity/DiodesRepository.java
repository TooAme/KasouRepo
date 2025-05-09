package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Diodes;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Diodes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DiodesRepository extends JpaRepository<Diodes, Long> {
    Optional<Diodes> findById(@NotNull String id);

    Optional<Diodes> findByBCode(String bCode);

    Optional<Diodes> deleteById(String id);

    List<Diodes> findByBCodeIn(List<String> ssSubBCodeList);

    List<Diodes> findByPartNumber(@NotNull String partNumber);
}
