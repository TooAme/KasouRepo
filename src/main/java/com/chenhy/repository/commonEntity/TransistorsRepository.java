package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Transistors;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Transistors entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TransistorsRepository extends JpaRepository<Transistors, Long> {
    Optional<Transistors> findById(@NotNull String id);

    Optional<Transistors> findByBCode(String bCode);

    Optional<Transistors> deleteById(String id);

    List<Transistors> findByBCodeIn(List<String> ssSubBCodeList);

    List<Transistors> findByPartNumber(@NotNull String partNumber);
}
