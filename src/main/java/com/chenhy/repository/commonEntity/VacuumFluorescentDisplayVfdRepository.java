package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.VacuumFluorescentDisplayVfd;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the VacuumFluorescentDisplayVfd entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VacuumFluorescentDisplayVfdRepository extends JpaRepository<VacuumFluorescentDisplayVfd, Long> {
    Optional<VacuumFluorescentDisplayVfd> findById(@NotNull String id);

    Optional<VacuumFluorescentDisplayVfd> findByBCode(String bCode);

    Optional<VacuumFluorescentDisplayVfd> deleteById(String id);

    List<VacuumFluorescentDisplayVfd> findByBCodeIn(List<String> ssSubBCodeList);

    List<VacuumFluorescentDisplayVfd> findByPartNumber(@NotNull String partNumber);
}
