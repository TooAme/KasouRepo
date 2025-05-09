package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.DelayLines;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the DelayLines entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DelayLinesRepository extends JpaRepository<DelayLines, Long> {
    Optional<DelayLines> findById(@NotNull String id);

    Optional<DelayLines> findByBCode(String bCode);

    Optional<DelayLines> deleteById(String id);

    List<DelayLines> findByBCodeIn(List<String> ssSubBCodeList);

    List<DelayLines> findByPartNumber(@NotNull String partNumber);
}
