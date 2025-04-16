package com.chenhy.repository;

import com.chenhy.domain.SSImport;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the SSImport entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SSImportRepository extends JpaRepository<SSImport, Long> {}
