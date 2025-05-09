package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.ElectromechanicalTransducers;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the ElectromechanicalTransducers entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ElectromechanicalTransducersRepository extends JpaRepository<ElectromechanicalTransducers, Long> {
    Optional<ElectromechanicalTransducers> findById(@NotNull String id);

    Optional<ElectromechanicalTransducers> findByBCode(String bCode);

    Optional<ElectromechanicalTransducers> deleteById(String id);

    List<ElectromechanicalTransducers> findByBCodeIn(List<String> ssSubBCodeList);

    List<ElectromechanicalTransducers> findByPartNumber(@NotNull String partNumber);
}
