package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.RfComponents;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the RfComponents entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RfComponentsRepository extends JpaRepository<RfComponents, Long> {
    Optional<RfComponents> findById(@NotNull String id);

    Optional<RfComponents> findByBCode(String bCode);

    Optional<RfComponents> deleteById(String id);

    List<RfComponents> findByBCodeIn(List<String> ssSubBCodeList);

    List<RfComponents> findByPartNumber(@NotNull String partNumber);
}
