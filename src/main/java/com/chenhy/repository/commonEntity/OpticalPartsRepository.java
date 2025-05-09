package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.OpticalParts;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the OpticalParts entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OpticalPartsRepository extends JpaRepository<OpticalParts, Long> {
    Optional<OpticalParts> findById(@NotNull String id);

    Optional<OpticalParts> findByBCode(String bCode);

    Optional<OpticalParts> deleteById(String id);

    List<OpticalParts> findByBCodeIn(List<String> ssSubBCodeList);

    List<OpticalParts> findByPartNumber(@NotNull String partNumber);
}
