package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Inductors;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Inductors entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InductorsRepository extends JpaRepository<Inductors, Long> {
    Optional<Inductors> findById(@NotNull String id);

    Optional<Inductors> findByBCode(String bCode);

    Optional<Inductors> deleteById(String id);

    List<Inductors> findByBCodeIn(List<String> ssSubBCodeList);

    List<Inductors> findByPartNumber(@NotNull String partNumber);
}
