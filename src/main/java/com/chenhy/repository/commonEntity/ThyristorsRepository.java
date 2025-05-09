package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Thyristors;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Thyristors entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ThyristorsRepository extends JpaRepository<Thyristors, Long> {
    Optional<Thyristors> findById(@NotNull String id);

    Optional<Thyristors> findByBCode(String bCode);

    Optional<Thyristors> deleteById(String id);

    List<Thyristors> findByBCodeIn(List<String> ssSubBCodeList);

    List<Thyristors> findByPartNumber(@NotNull String partNumber);
}
