package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Memories;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Memories entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MemoriesRepository extends JpaRepository<Memories, Long> {
    Optional<Memories> findById(@NotNull String id);

    Optional<Memories> findByBCode(String bCode);

    Optional<Memories> deleteById(String id);

    List<Memories> findByBCodeIn(List<String> ssSubBCodeList);

    List<Memories> findByPartNumber(@NotNull String partNumber);
}
