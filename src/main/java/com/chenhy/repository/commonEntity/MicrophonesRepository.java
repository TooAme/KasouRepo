package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Microphones;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Microphones entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MicrophonesRepository extends JpaRepository<Microphones, Long> {
    Optional<Microphones> findById(@NotNull String id);

    Optional<Microphones> findByBCode(String bCode);

    Optional<Microphones> deleteById(String id);

    List<Microphones> findByBCodeIn(List<String> ssSubBCodeList);

    List<Microphones> findByPartNumber(@NotNull String partNumber);
}
