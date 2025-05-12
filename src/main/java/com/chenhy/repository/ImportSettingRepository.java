package com.chenhy.repository;

import com.chenhy.domain.ImportSetting;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ImportSetting entity.
 */
@SuppressWarnings("unused")
@Repository
@Cacheable (value = "ImportSetting")
public interface ImportSettingRepository extends JpaRepository<ImportSetting, Long> {
    Optional<ImportSetting> findOneByTcisCodeAndTcisType(String settingCharacter1, String settingCharacter2);

    List<ImportSetting> findAllByTcisCode(String string);
}
