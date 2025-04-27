package com.chenhy.repository;

import com.chenhy.domain.SSImport;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the SSImport entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SSImportRepository extends JpaRepository<SSImport, Long> {
    Optional<SSImport> findBySsSubBCode(String ssSubBCode);
}
