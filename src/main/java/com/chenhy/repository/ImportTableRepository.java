package com.chenhy.repository;

import com.chenhy.domain.ImportTable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ImportTable entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ImportTableRepository extends JpaRepository<ImportTable, Long> {}
