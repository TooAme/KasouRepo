package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Antennas;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Antennas entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AntennasRepository extends JpaRepository<Antennas, Long> {
    Optional<Antennas> findById(@NotNull String id);

    Optional<Antennas> findByBCode(String bCode);

    Optional<Antennas> deleteById(String id);

    List<Antennas> findByBCodeIn(List<String> ssSubBCodeList);

    List<Antennas> findByPartNumber(@NotNull String partNumber);
}
