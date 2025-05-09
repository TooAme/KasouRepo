package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.BuzzersSounders;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the BuzzersSounders entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BuzzersSoundersRepository extends JpaRepository<BuzzersSounders, Long> {
    Optional<BuzzersSounders> findById(@NotNull String id);

    Optional<BuzzersSounders> findByBCode(String bCode);

    Optional<BuzzersSounders> deleteById(String id);

    List<BuzzersSounders> findByBCodeIn(List<String> ssSubBCodeList);

    List<BuzzersSounders> findByPartNumber(@NotNull String partNumber);
}
