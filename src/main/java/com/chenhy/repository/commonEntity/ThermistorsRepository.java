package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Thermistors;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Thermistors entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ThermistorsRepository extends JpaRepository<Thermistors, Long> {
    Optional<Thermistors> findById(@NotNull String id);

    Optional<Thermistors> findByBCode(String bCode);

    Optional<Thermistors> deleteById(String id);

    List<Thermistors> findByBCodeIn(List<String> ssSubBCodeList);

    List<Thermistors> findByPartNumber(@NotNull String partNumber);
}
