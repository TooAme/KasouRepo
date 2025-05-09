package com.chenhy.repository.commonEntity;

import com.chenhy.domain.commonEntity.ImagePickupDevices;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the ImagePickupDevices entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ImagePickupDevicesRepository extends JpaRepository<ImagePickupDevices, Long> {
    Optional<ImagePickupDevices> findById(@NotNull String id);

    Optional<ImagePickupDevices> findByBCode(String bCode);

    Optional<ImagePickupDevices> deleteById(String id);

    List<ImagePickupDevices> findByBCodeIn(List<String> ssSubBCodeList);

    List<ImagePickupDevices> findByPartNumber(@NotNull String partNumber);
}
