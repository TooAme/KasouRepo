package com.chenhy.repository;

import com.chenhy.domain.ImportHistoryDetail;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ImportHistoryDetail entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ImportHistoryDetailRepository extends JpaRepository<ImportHistoryDetail, Long> {
    Optional<ImportHistoryDetail> findByUuid(UUID uuid);

    Optional<ImportHistoryDetail> findByTcihdPid(String pid);

    List<ImportHistoryDetail> findByTcihdPidAndDelFlagFalse(String pid);
}
