package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Transformers;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Transformers entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TransformersRepository extends JpaRepository<Transformers, Long> {
    Optional<Transformers> findById(@NotNull String id);

    Optional<Transformers> findByBCode(String bCode);

    Optional<Transformers> deleteById(String id);

    List<Transformers> findByBCodeIn(List<String> ssSubBCodeList);

    List<Transformers> findByPartNumber(@NotNull String partNumber);
}
