package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Terminals;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Terminals entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TerminalsRepository extends JpaRepository<Terminals, Long> {
    Optional<Terminals> findById(@NotNull String id);

    Optional<Terminals> findByBCode(String bCode);

    Optional<Terminals> deleteById(String id);

    List<Terminals> findByBCodeIn(List<String> ssSubBCodeList);

    List<Terminals> findByPartNumber(@NotNull String partNumber);
}
