package com.chenhy.repository;

import com.chenhy.domain.ImportTable;
import jakarta.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ImportTable entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ImportTableRepository extends JpaRepository<ImportTable, Long> {
    Long findByUuid(@NotNull UUID uuid);

    Optional<ImportTable> findByBCode(String bCode);
}
