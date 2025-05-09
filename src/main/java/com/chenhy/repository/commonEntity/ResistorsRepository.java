package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Resistors;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Resistors entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ResistorsRepository extends JpaRepository<Resistors, Long> {
    Optional<Resistors> findById(@NotNull String id);

    Optional<Resistors> findByBCode(String bCode);

    Optional<Resistors> deleteById(String id);

    List<Resistors> findByBCodeIn(List<String> ssSubBCodeList);

    List<Resistors> findByPartNumber(@NotNull String partNumber);
}
