package com.chenhy.repository;

import com.chenhy.domain.ImportHistoryDetail;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ImportHistoryDetail entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ImportHistoryDetailRepository extends JpaRepository<ImportHistoryDetail, Long> {}
