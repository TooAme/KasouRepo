package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Varistors;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Varistors entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VaristorsRepository extends JpaRepository<Varistors, Long> {
    Optional<Varistors> findById(@NotNull String id);

    Optional<Varistors> findByBCode(String bCode);

    Optional<Varistors> deleteById(String id);

    List<Varistors> findByBCodeIn(List<String> ssSubBCodeList);

    List<Varistors> findByPartNumber(@NotNull String partNumber);
}
