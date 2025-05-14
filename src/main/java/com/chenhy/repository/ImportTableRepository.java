package com.chenhy.repository;

import com.chenhy.domain.ImportTable;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ImportTable entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ImportTableRepository extends JpaRepository<ImportTable, Long> {
    Optional<ImportTable> findById(@NotNull String id);

    Optional<ImportTable> findByBCode(String bCode);

    Optional<ImportTable> deleteById(String id);

    List<ImportTable> findByBCodeIn(List<String> ssSubBCodeList);

    List<ImportTable> findByPartNumber(@NotNull String partNumber);

    List<ImportTable> findByBCodeContaining(String bCode);

}
