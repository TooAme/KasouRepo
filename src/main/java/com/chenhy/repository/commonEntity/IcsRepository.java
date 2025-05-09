package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Ics;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Ics entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IcsRepository extends JpaRepository<Ics, Long> {
    Optional<Ics> findById(@NotNull String id);

    Optional<Ics> findByBCode(String bCode);

    Optional<Ics> deleteById(String id);

    List<Ics> findByBCodeIn(List<String> ssSubBCodeList);

    List<Ics> findByPartNumber(@NotNull String partNumber);
}
