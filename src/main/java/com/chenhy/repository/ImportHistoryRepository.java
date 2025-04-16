package com.chenhy.repository;

import com.chenhy.domain.ImportHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ImportHistory entity.
 */
@Repository
public interface ImportHistoryRepository extends JpaRepository<ImportHistory, Long> {}
