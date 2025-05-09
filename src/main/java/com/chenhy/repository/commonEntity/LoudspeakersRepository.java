package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Loudspeakers;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Loudspeakers entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LoudspeakersRepository extends JpaRepository<Loudspeakers, Long> {
    Optional<Loudspeakers> findById(@NotNull String id);

    Optional<Loudspeakers> findByBCode(String bCode);

    Optional<Loudspeakers> deleteById(String id);

    List<Loudspeakers> findByBCodeIn(List<String> ssSubBCodeList);

    List<Loudspeakers> findByPartNumber(@NotNull String partNumber);
}
