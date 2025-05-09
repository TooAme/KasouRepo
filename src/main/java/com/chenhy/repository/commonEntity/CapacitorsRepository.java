package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Capacitors;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Capacitors entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CapacitorsRepository extends JpaRepository<Capacitors, Long> {
    Optional<Capacitors> findById(@NotNull String id);

    Optional<Capacitors> findByBCode(String bCode);

    Optional<Capacitors> deleteById(String id);

    List<Capacitors> findByBCodeIn(List<String> ssSubBCodeList);

    List<Capacitors> findByPartNumber(@NotNull String partNumber);
}
