package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Connectors;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Connectors entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ConnectorsRepository extends JpaRepository<Connectors, Long> {
    Optional<Connectors> findById(@NotNull String id);

    Optional<Connectors> findByBCode(String bCode);

    Optional<Connectors> deleteById(String id);

    List<Connectors> findByBCodeIn(List<String> ssSubBCodeList);

    List<Connectors> findByPartNumber(@NotNull String partNumber);
}
