package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.OrganicElectroluminescentDisplay;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the OrganicElectroluminescentDisplay entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrganicElectroluminescentDisplayRepository extends JpaRepository<OrganicElectroluminescentDisplay, Long> {
    Optional<OrganicElectroluminescentDisplay> findById(@NotNull String id);

    Optional<OrganicElectroluminescentDisplay> findByBCode(String bCode);

    Optional<OrganicElectroluminescentDisplay> deleteById(String id);

    List<OrganicElectroluminescentDisplay> findByBCodeIn(List<String> ssSubBCodeList);

    List<OrganicElectroluminescentDisplay> findByPartNumber(@NotNull String partNumber);
}
