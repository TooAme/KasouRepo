package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Resonators;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Resonators entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ResonatorsRepository extends JpaRepository<Resonators, Long> {
    Optional<Resonators> findById(@NotNull String id);

    Optional<Resonators> findByBCode(String bCode);

    Optional<Resonators> deleteById(String id);

    List<Resonators> findByBCodeIn(List<String> ssSubBCodeList);

    List<Resonators> findByPartNumber(@NotNull String partNumber);
}
