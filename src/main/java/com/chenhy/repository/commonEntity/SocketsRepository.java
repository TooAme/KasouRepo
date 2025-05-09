package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.Sockets;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Sockets entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SocketsRepository extends JpaRepository<Sockets, Long> {
    Optional<Sockets> findById(@NotNull String id);

    Optional<Sockets> findByBCode(String bCode);

    Optional<Sockets> deleteById(String id);

    List<Sockets> findByBCodeIn(List<String> ssSubBCodeList);

    List<Sockets> findByPartNumber(@NotNull String partNumber);
}
