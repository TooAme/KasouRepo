package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Filters;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Filters entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FiltersRepository extends JpaRepository<Filters, Long> {
    Optional<Filters> findById(@NotNull String id);

    Optional<Filters> findByBCode(String bCode);

    Optional<Filters> deleteById(String id);

    List<Filters> findByBCodeIn(List<String> ssSubBCodeList);

    List<Filters> findByPartNumber(@NotNull String partNumber);
}
