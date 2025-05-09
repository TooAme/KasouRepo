package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Lamps;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Lamps entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LampsRepository extends JpaRepository<Lamps, Long> {
    Optional<Lamps> findById(@NotNull String id);

    Optional<Lamps> findByBCode(String bCode);

    Optional<Lamps> deleteById(String id);

    List<Lamps> findByBCodeIn(List<String> ssSubBCodeList);

    List<Lamps> findByPartNumber(@NotNull String partNumber);
}
