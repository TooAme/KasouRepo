package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Relays;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Relays entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RelaysRepository extends JpaRepository<Relays, Long> {
    Optional<Relays> findById(@NotNull String id);

    Optional<Relays> findByBCode(String bCode);

    Optional<Relays> deleteById(String id);

    List<Relays> findByBCodeIn(List<String> ssSubBCodeList);

    List<Relays> findByPartNumber(@NotNull String partNumber);
}
