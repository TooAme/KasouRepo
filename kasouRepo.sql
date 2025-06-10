-- MySQL dump 10.13  Distrib 5.7.44, for Win64 (x86_64)
--
-- Host: 192.168.1.181    Database: importdb
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `DATABASECHANGELOG`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DATABASECHANGELOG` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATABASECHANGELOG`
--

/*!40000 ALTER TABLE `DATABASECHANGELOG` DISABLE KEYS */;
INSERT INTO `DATABASECHANGELOG` VALUES ('00000000000001','jhipster','config/liquibase/changelog/00000000000000_initial_schema.xml','2025-05-08 06:50:56',1,'EXECUTED','9:bfd7cab69cd6e102f2984dc77a94c2d4','createTable tableName=jhi_user; createTable tableName=jhi_authority; createTable tableName=jhi_user_authority; addPrimaryKey tableName=jhi_user_authority; createTable tableName=jhi_persistent_token; addForeignKeyConstraint baseTableName=jhi_user_a...','',NULL,'4.29.2',NULL,NULL,'6687055366'),('20250416051207-1','chenhy','config/liquibase/changelog/20250416051207_added_entity_ImportHistory.xml','2025-05-08 06:50:56',2,'EXECUTED','9:a30ec5dae0412503c1b81b0fcd2b8ecc','createTable tableName=t_import_his; dropDefaultValue columnName=tcih_importtime, tableName=t_import_his; dropDefaultValue columnName=create_time, tableName=t_import_his; dropDefaultValue columnName=update_time, tableName=t_import_his','',NULL,'4.29.2',NULL,NULL,'6687055366'),('20250416051208-1','chenhy','config/liquibase/changelog/20250416051208_added_entity_ImportHistoryDetail.xml','2025-05-08 06:50:56',3,'EXECUTED','9:d7425fec9e2503e2fef11651f8a3bb11','createTable tableName=t_import_his_detail; dropDefaultValue columnName=create_time, tableName=t_import_his_detail; dropDefaultValue columnName=update_time, tableName=t_import_his_detail','',NULL,'4.29.2',NULL,NULL,'6687055366'),('20250508115901','chenhy','config/liquibase/changelog/20250416051208_added_entity_ImportHistoryDetail.xml','2025-05-08 06:50:56',4,'EXECUTED','9:32b05ddebbf79592d29d11d12d90ab22','modifyDataType columnName=tcihd_error, tableName=t_import_his_detail','',NULL,'4.29.2',NULL,NULL,'6687055366'),('20250416051209-1','chenhy','config/liquibase/changelog/20250416051209_added_entity_ImportTable.xml','2025-05-08 06:50:56',5,'EXECUTED','9:aa53121271c3b3d33d86b03e2a8df19c','createTable tableName=t_import_table; dropDefaultValue columnName=create_time, tableName=t_import_table; dropDefaultValue columnName=update_time, tableName=t_import_table','',NULL,'4.29.2',NULL,NULL,'6687055366'),('20250416051210-1','chenhy','config/liquibase/changelog/20250416051210_added_entity_SSImport.xml','2025-05-08 06:50:56',6,'EXECUTED','9:b4027da75fbaa41d1de21b3a7220923f','createTable tableName=t_ss_import; dropDefaultValue columnName=create_time, tableName=t_ss_import; dropDefaultValue columnName=update_time, tableName=t_ss_import','',NULL,'4.29.2',NULL,NULL,'6687055366'),('20250425094404-1','chenhy','config/liquibase/changelog/20250425094404_added_entity_ImportSetting.xml','2025-05-08 06:50:56',7,'EXECUTED','9:0447994f65283a9e5ac3508caaae6707','createTable tableName=t_import_setting','',NULL,'4.29.2',NULL,NULL,'6687055366'),('20250425094404-1-data','chenhy','config/liquibase/changelog/20250425094404_added_entity_ImportSetting.xml','2025-05-08 06:50:59',8,'EXECUTED','9:0a1d0c202791870c5381dfc75151c2ed','loadData tableName=t_import_setting','',NULL,'4.29.2',NULL,NULL,'6687055366');
/*!40000 ALTER TABLE `DATABASECHANGELOG` ENABLE KEYS */;

--
-- Table structure for table `DATABASECHANGELOGLOCK`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DATABASECHANGELOGLOCK` (
  `ID` int NOT NULL,
  `LOCKED` tinyint NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATABASECHANGELOGLOCK`
--

/*!40000 ALTER TABLE `DATABASECHANGELOGLOCK` DISABLE KEYS */;
INSERT INTO `DATABASECHANGELOGLOCK` VALUES (1,0,NULL,NULL);
/*!40000 ALTER TABLE `DATABASECHANGELOGLOCK` ENABLE KEYS */;

--
-- Table structure for table `TMPPRTS`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TMPPRTS` (
  `TMPPRTNO` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'TMPPRTNO',
  `RELPRTNO` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'RELPRTNO',
  `USERNAME` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'USERNAME',
  `CREATETIME` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'CREATETIME'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci COMMENT='TMPPRTS';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TMPPRTS`
--

/*!40000 ALTER TABLE `TMPPRTS` DISABLE KEYS */;
/*!40000 ALTER TABLE `TMPPRTS` ENABLE KEYS */;

--
-- Temporary table structure for view `all_data_view`
--

SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `all_data_view` AS SELECT 
 1 AS `table_name`,
 1 AS `id`,
 1 AS `part_number`,
 1 AS `part_type`,
 1 AS `value`,
 1 AS `schematic_part`,
 1 AS `rating_voltage`,
 1 AS `rating_electricity`,
 1 AS `characteristics`,
 1 AS `tolerance`,
 1 AS `manufacture`,
 1 AS `b_code`,
 1 AS `parts_name`,
 1 AS `item_registration_classification`,
 1 AS `spice_model`,
 1 AS `pcb_footprint`,
 1 AS `create_by`,
 1 AS `create_time`,
 1 AS `update_by`,
 1 AS `update_time`,
 1 AS `del_flag`,
 1 AS `remark`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `antennas`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `antennas` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `antennas_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='アンテナ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `antennas`
--

/*!40000 ALTER TABLE `antennas` DISABLE KEYS */;
/*!40000 ALTER TABLE `antennas` ENABLE KEYS */;

--
-- Table structure for table `batteries`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `batteries` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `batteries_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='電池';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batteries`
--

/*!40000 ALTER TABLE `batteries` DISABLE KEYS */;
/*!40000 ALTER TABLE `batteries` ENABLE KEYS */;

--
-- Table structure for table `buzzers_sounders`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buzzers_sounders` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `buzzers_sounders_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='ブザー／サウンダ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buzzers_sounders`
--

/*!40000 ALTER TABLE `buzzers_sounders` DISABLE KEYS */;
/*!40000 ALTER TABLE `buzzers_sounders` ENABLE KEYS */;

--
-- Table structure for table `capacitors`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `capacitors` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `capacitors_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='コンデンサ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capacitors`
--

/*!40000 ALTER TABLE `capacitors` DISABLE KEYS */;
/*!40000 ALTER TABLE `capacitors` ENABLE KEYS */;

--
-- Table structure for table `circuit_breakers_for_equipment_protection`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `circuit_breakers_for_equipment_protection` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `circuit_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='BREAKERS FOR EQUIPMENT PROTECTION';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `circuit_breakers_for_equipment_protection`
--

/*!40000 ALTER TABLE `circuit_breakers_for_equipment_protection` DISABLE KEYS */;
/*!40000 ALTER TABLE `circuit_breakers_for_equipment_protection` ENABLE KEYS */;

--
-- Table structure for table `connectors`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `connectors` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `connectors_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='コネクタ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connectors`
--

/*!40000 ALTER TABLE `connectors` DISABLE KEYS */;
/*!40000 ALTER TABLE `connectors` ENABLE KEYS */;

--
-- Table structure for table `delay_lines`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delay_lines` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `delay_lines_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='ディレイライン';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delay_lines`
--

/*!40000 ALTER TABLE `delay_lines` DISABLE KEYS */;
/*!40000 ALTER TABLE `delay_lines` ENABLE KEYS */;

--
-- Table structure for table `diodes`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diodes` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `diodes_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='ダイオード';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diodes`
--

/*!40000 ALTER TABLE `diodes` DISABLE KEYS */;
/*!40000 ALTER TABLE `diodes` ENABLE KEYS */;

--
-- Table structure for table `electrical_discharge_gaps`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `electrical_discharge_gaps` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `electrical_discharge_gaps_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='放電ギャップ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `electrical_discharge_gaps`
--

/*!40000 ALTER TABLE `electrical_discharge_gaps` DISABLE KEYS */;
/*!40000 ALTER TABLE `electrical_discharge_gaps` ENABLE KEYS */;

--
-- Table structure for table `electromechanical_transducers`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `electromechanical_transducers` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `electromechanical_transducers_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='トランスデューサ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `electromechanical_transducers`
--

/*!40000 ALTER TABLE `electromechanical_transducers` DISABLE KEYS */;
/*!40000 ALTER TABLE `electromechanical_transducers` ENABLE KEYS */;

--
-- Table structure for table `emi_emc_countermeasure_parts`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emi_emc_countermeasure_parts` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `emi_emc_countermeasure_parts_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='EMI/EMC対策部品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emi_emc_countermeasure_parts`
--

/*!40000 ALTER TABLE `emi_emc_countermeasure_parts` DISABLE KEYS */;
/*!40000 ALTER TABLE `emi_emc_countermeasure_parts` ENABLE KEYS */;

--
-- Table structure for table `filters`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filters` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `filters_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='フィルタ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filters`
--

/*!40000 ALTER TABLE `filters` DISABLE KEYS */;
/*!40000 ALTER TABLE `filters` ENABLE KEYS */;

--
-- Table structure for table `function_circuit_modules`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `function_circuit_modules` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `function_circuit_modules_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='機能回路モジュール';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `function_circuit_modules`
--

/*!40000 ALTER TABLE `function_circuit_modules` DISABLE KEYS */;
/*!40000 ALTER TABLE `function_circuit_modules` ENABLE KEYS */;

--
-- Table structure for table `fuses`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fuses` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `fuses_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='ヒューズ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fuses`
--

/*!40000 ALTER TABLE `fuses` DISABLE KEYS */;
/*!40000 ALTER TABLE `fuses` ENABLE KEYS */;

--
-- Table structure for table `ics`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ics` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ics_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='IC';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ics`
--

/*!40000 ALTER TABLE `ics` DISABLE KEYS */;
/*!40000 ALTER TABLE `ics` ENABLE KEYS */;

--
-- Table structure for table `image_pickup_devices`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image_pickup_devices` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `image_pickup_devices_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='撮像素子';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_pickup_devices`
--

/*!40000 ALTER TABLE `image_pickup_devices` DISABLE KEYS */;
/*!40000 ALTER TABLE `image_pickup_devices` ENABLE KEYS */;

--
-- Table structure for table `inductors`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inductors` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `inductors_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='インダクタ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inductors`
--

/*!40000 ALTER TABLE `inductors` DISABLE KEYS */;
/*!40000 ALTER TABLE `inductors` ENABLE KEYS */;

--
-- Table structure for table `jhi_authority`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_authority` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_authority`
--

/*!40000 ALTER TABLE `jhi_authority` DISABLE KEYS */;
INSERT INTO `jhi_authority` VALUES ('ROLE_ADMIN'),('ROLE_USER');
/*!40000 ALTER TABLE `jhi_authority` ENABLE KEYS */;

--
-- Table structure for table `jhi_persistent_token`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_persistent_token` (
  `series` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `token_value` varchar(255) NOT NULL,
  `token_date` date DEFAULT NULL,
  `ip_address` varchar(39) DEFAULT NULL,
  `user_agent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`series`),
  KEY `fk_user_persistent_token` (`user_id`),
  CONSTRAINT `fk_user_persistent_token` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_persistent_token`
--

/*!40000 ALTER TABLE `jhi_persistent_token` DISABLE KEYS */;
INSERT INTO `jhi_persistent_token` VALUES ('2qxfm1ZZJoEb6iDcIaKb',1,'j2xA5DqlG4s16IY9Hyfb','2025-05-08','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36 Edg/136.0.0.0'),('aYMSFtJDA7SSzq27NjIk',1,'w0rMzVLmTC3bLs9OtkZ3','2025-05-16','0:0:0:0:0:0:0:1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36 Edg/136.0.0.0');
/*!40000 ALTER TABLE `jhi_persistent_token` ENABLE KEYS */;

--
-- Table structure for table `jhi_user`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password_hash` varchar(60) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(254) DEFAULT NULL,
  `image_url` varchar(256) DEFAULT NULL,
  `activated` bit(1) NOT NULL,
  `lang_key` varchar(10) DEFAULT NULL,
  `activation_key` varchar(20) DEFAULT NULL,
  `reset_key` varchar(20) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` timestamp NULL,
  `reset_date` timestamp NULL DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_user_login` (`login`),
  UNIQUE KEY `ux_user_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1050 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_user`
--

/*!40000 ALTER TABLE `jhi_user` DISABLE KEYS */;
INSERT INTO `jhi_user` VALUES (1,'admin','$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC','Administrator','Administrator','admin@localhost','',_binary '','ja',NULL,NULL,'system',NULL,NULL,'system',NULL),(2,'user','$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K','User','User','user@localhost','',_binary '','ja',NULL,NULL,'system',NULL,NULL,'system',NULL);
/*!40000 ALTER TABLE `jhi_user` ENABLE KEYS */;

--
-- Table structure for table `jhi_user_authority`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_user_authority` (
  `user_id` bigint NOT NULL,
  `authority_name` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`authority_name`),
  KEY `fk_authority_name` (`authority_name`),
  CONSTRAINT `fk_authority_name` FOREIGN KEY (`authority_name`) REFERENCES `jhi_authority` (`name`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_user_authority`
--

/*!40000 ALTER TABLE `jhi_user_authority` DISABLE KEYS */;
INSERT INTO `jhi_user_authority` VALUES (1,'ROLE_ADMIN'),(1,'ROLE_USER'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `jhi_user_authority` ENABLE KEYS */;

--
-- Table structure for table `lamps`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lamps` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lamps_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='ランプ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lamps`
--

/*!40000 ALTER TABLE `lamps` DISABLE KEYS */;
/*!40000 ALTER TABLE `lamps` ENABLE KEYS */;

--
-- Table structure for table `liquid_crystal_display`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `liquid_crystal_display` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `liquid_crystal_display_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='液晶表示デバイス';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liquid_crystal_display`
--

/*!40000 ALTER TABLE `liquid_crystal_display` DISABLE KEYS */;
/*!40000 ALTER TABLE `liquid_crystal_display` ENABLE KEYS */;

--
-- Table structure for table `loudspeakers`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loudspeakers` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `loudspeakers_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='スピーカ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loudspeakers`
--

/*!40000 ALTER TABLE `loudspeakers` DISABLE KEYS */;
/*!40000 ALTER TABLE `loudspeakers` ENABLE KEYS */;

--
-- Table structure for table `memories`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memories` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `memories_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='メモリ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memories`
--

/*!40000 ALTER TABLE `memories` DISABLE KEYS */;
/*!40000 ALTER TABLE `memories` ENABLE KEYS */;

--
-- Table structure for table `microphones`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `microphones` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `microphones_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='マイクロホン';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `microphones`
--

/*!40000 ALTER TABLE `microphones` DISABLE KEYS */;
/*!40000 ALTER TABLE `microphones` ENABLE KEYS */;

--
-- Table structure for table `microwave_components`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `microwave_components` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `microwave_components_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='マイクロ波部品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `microwave_components`
--

/*!40000 ALTER TABLE `microwave_components` DISABLE KEYS */;
/*!40000 ALTER TABLE `microwave_components` ENABLE KEYS */;

--
-- Table structure for table `multi_chip_discrete_devices`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `multi_chip_discrete_devices` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `multi_chip_discrete_devices_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='複合ディスクリートデバイス';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `multi_chip_discrete_devices`
--

/*!40000 ALTER TABLE `multi_chip_discrete_devices` DISABLE KEYS */;
/*!40000 ALTER TABLE `multi_chip_discrete_devices` ENABLE KEYS */;

--
-- Table structure for table `optical_parts`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `optical_parts` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `optical_parts_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='光部品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `optical_parts`
--

/*!40000 ALTER TABLE `optical_parts` DISABLE KEYS */;
/*!40000 ALTER TABLE `optical_parts` ENABLE KEYS */;

--
-- Table structure for table `opto_electronic_devices`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opto_electronic_devices` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `opto_electronic_devices_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='光半導体';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opto_electronic_devices`
--

/*!40000 ALTER TABLE `opto_electronic_devices` DISABLE KEYS */;
/*!40000 ALTER TABLE `opto_electronic_devices` ENABLE KEYS */;

--
-- Table structure for table `organic_electroluminescent_display`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organic_electroluminescent_display` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `organic_electroluminescent_display_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='有機ELディスプレイ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organic_electroluminescent_display`
--

/*!40000 ALTER TABLE `organic_electroluminescent_display` DISABLE KEYS */;
/*!40000 ALTER TABLE `organic_electroluminescent_display` ENABLE KEYS */;

--
-- Table structure for table `oscillators`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oscillators` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `oscillators_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='発振器';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oscillators`
--

/*!40000 ALTER TABLE `oscillators` DISABLE KEYS */;
/*!40000 ALTER TABLE `oscillators` ENABLE KEYS */;

--
-- Table structure for table `plasma_display_device`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plasma_display_device` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `plasma_display_device_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='プラズマディスプレイデバイス';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plasma_display_device`
--

/*!40000 ALTER TABLE `plasma_display_device` DISABLE KEYS */;
/*!40000 ALTER TABLE `plasma_display_device` ENABLE KEYS */;

--
-- Table structure for table `power_supplies`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `power_supplies` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `power_supplies_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='電源';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `power_supplies`
--

/*!40000 ALTER TABLE `power_supplies` DISABLE KEYS */;
/*!40000 ALTER TABLE `power_supplies` ENABLE KEYS */;

--
-- Table structure for table `relays`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relays` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `relays_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='リレー';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relays`
--

/*!40000 ALTER TABLE `relays` DISABLE KEYS */;
/*!40000 ALTER TABLE `relays` ENABLE KEYS */;

--
-- Table structure for table `resistors`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resistors` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `resistors_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='抵抗器';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resistors`
--

/*!40000 ALTER TABLE `resistors` DISABLE KEYS */;
INSERT INTO `resistors` VALUES ('04b363e1-7d27-4f06-a0a4-cd7c408e9e1b','RKC4BDTPA-10KJ','ネットワーク抵抗器','10kOhm','RKC4BDTPA103J',NULL,'0.125W',NULL,'5percent','','B011103-0339','R','3',NULL,'RKC4BDTPA103J','admin','2025-05-16 09:56:15','admin','2025-05-16 09:56:15',1,NULL),('187f88b4-71c7-4754-ba59-05715211297e','YC358LJK-07100KL','ネットワーク抵抗器','100kOhm','YC358LJK-07100KL',NULL,'0.063W',NULL,'5percent','Yageo','B011103-3252','R','3',NULL,'YC358LJK-07100KL','admin','2025-05-16 09:56:15','admin','2025-05-16 09:56:15',1,NULL),('1e56ff2f-fc97-4484-aac8-1a7931e98986','EXB28V104JX','ネットワーク抵抗器','100kOhm','EXB28V104JX',NULL,'0.063W',NULL,'5percent','Panasonic','B011103-0408','R','3',NULL,'EXB28V104JX','admin','2025-05-16 09:56:15','admin','2025-05-16 09:56:15',1,NULL),('22f09d35-79f2-4b1d-b4ad-f4c16058344c','MNR34J5ABJ333','ネットワーク抵抗器','33kOhm','MNR34J5ABJ333',NULL,'0.125W',NULL,'5percent','ROHM','B011103-4093','R','3',NULL,'MNR34J5ABJ333','admin','2025-05-16 09:56:11','admin','2025-05-16 09:56:11',1,NULL),('391baaf2-1f4f-43b5-9759-955f14a775d9','RKC4BDTPA621J','ネットワーク抵抗器','620Ohm','RKC4BDTPA621J',NULL,'0.125W',NULL,'5percent','KOA','B011103-0685','R','3',NULL,'RKC4BDTPA621J','admin','2025-05-16 09:56:12','admin','2025-05-16 09:56:12',1,NULL),('3f12be84-0692-4693-8f37-39c9b44ff015','CREN10TR104JM','ネットワーク抵抗器','100kOhm','CREN10TR104JM',NULL,'0.063W',NULL,'5percent','Akane','B011103-3324','R','3',NULL,'CREN10TR104JM','admin','2025-05-16 09:56:13','admin','2025-05-16 09:56:13',1,NULL),('4313a9c9-5889-4e52-9773-e38f7e4bf22d','RM2012B-103/103-NDXW10','ネットワーク抵抗器','10kOhm','RM2012B-103/103-NDXW10',NULL,'0.05W',NULL,'0.5percent','Susumu','B011103-4058','R','3',NULL,'RM2012B-103/103-NDXW10','admin','2025-05-16 09:56:12','admin','2025-05-16 09:56:12',1,NULL),('445fe694-981e-4796-8664-9bf9e1512a2e','EXBA10E104J','ネットワーク抵抗器','100kOhm','EXBA10E104J',NULL,'0.063W',NULL,'5percent','Panasonic','B011103-0503','R','3',NULL,'EXBA10E104J','admin','2025-05-16 09:56:12','admin','2025-05-16 09:56:12',1,NULL),('489917ec-58a0-4751-8f3c-5859445a60a7','CN2A8TTE103J','ネットワーク抵抗器','10kOhm','CN2A8TTE103J',NULL,'0.1W',NULL,'5percent','KOA','B011103-2266','R','3',NULL,'CN2A8TTE103J','admin','2025-05-16 09:56:11','admin','2025-05-16 09:56:11',1,NULL),('495a11c1-f8a2-457d-9b92-ccfafea0f7bd','CAY10-472J4LF','ネットワーク抵抗器','4.7kOhm','CAY10-472J4LF',NULL,'0.0625W',NULL,'5percent','Bourns','B011103-2981','R','3',NULL,'CAY10-472J4LF','admin','2025-05-16 09:56:14','admin','2025-05-16 09:56:14',1,NULL),('4a14a930-8af7-4892-bfb4-38b65e655622','CAT25-104JALF','ネットワーク抵抗器','100kOhm','CAT25-104JALF',NULL,'0.0625W',NULL,'5percent','Bourns','B011103-4447','R','3',NULL,'CAT25-104JALF','admin','2025-05-16 09:56:14','admin','2025-05-16 09:56:14',1,NULL),('564fea4b-2dd0-4614-9523-dbb07487aa45','EXBA10E333J','ネットワーク抵抗器','33kOhm','EXBA10E333J',NULL,'0.063W',NULL,'5percent','Pana','B011103-1853','R','3',NULL,'EXBA10E333J','admin','2025-05-16 09:56:12','admin','2025-05-16 09:56:12',1,NULL),('5a0ea002-43be-4dcd-9515-cd6ebd8ab4a5','CREC08TR104JM','ネットワーク抵抗器','100kOhm','CREC08TR104JM',NULL,'0.063W',NULL,'5percent','akane','B011103-2977','R','3',NULL,'CREC08TR104JM','admin','2025-05-16 09:56:15','admin','2025-05-16 09:56:15',1,NULL),('65308b7f-ccb5-479a-a1b5-3107128bcf03','CND1J10YTTD103J','ネットワーク抵抗器','10kOhm','CND1J10YTTD103J',NULL,'0.05W',NULL,'5percent','KOA','B011103-3503','R','3',NULL,'CND1J10YTTD103J','admin','2025-05-16 09:56:12','admin','2025-05-16 09:56:12',1,NULL),('75c6ca4f-c0f3-436b-90ad-fdc9aef674c4','MNR34J5ABJ470','ネットワーク抵抗器','47Ohm','MNR34J5ABJ470',NULL,'0.125W',NULL,'5percent','ROHM','B011103-4094','R','3',NULL,'MNR34J5ABJ470','admin','2025-05-16 09:56:11','admin','2025-05-16 09:56:11',1,NULL),('77682bce-e2b3-4579-bf93-3a99eb432102','CAT25-103JALF','ネットワーク抵抗器','10kOhm','CAT25-103JALF',NULL,'0.0625W',NULL,'5percent','Bourns','B011103-2518','R','3',NULL,'CAT25-103JALF','admin','2025-05-16 09:56:14','admin','2025-05-16 09:56:14',1,NULL),('7a12edb4-1326-4891-8b38-917069cc2e73','EXBA10E473J','ネットワーク抵抗器','47kOhm','EXBA10E473J',NULL,'0.063W',NULL,'5percent','Panasonic','B011103-3532','R','3',NULL,'EXBA10E473J','admin','2025-05-16 09:56:12','admin','2025-05-16 09:56:12',1,NULL),('7c471a7c-1913-48dc-8f72-6d7243fa815f','EXBE10C104J','ネットワーク抵抗器','100kOhm','EXBE10C104J',NULL,'0.063W',NULL,'5percent','Panasonic','B011103-4448','R','3',NULL,'EXBE10C104J','admin','2025-05-16 09:56:13','admin','2025-05-16 09:56:13',1,NULL),('7d95f509-c255-4b0a-aa31-a1f1480fd26e','CREC08TR470JM','ネットワーク抵抗器','47Ohm','CREC08TR470JM',NULL,'0.063W',NULL,'5percent','akane','B011103-2974','R','3',NULL,'CREC08TR470JM','admin','2025-05-16 09:56:15','admin','2025-05-16 09:56:15',1,NULL),('838ba439-e7b4-4cc4-9745-ae6f62fad26b','CAY10-104J4LF','ネットワーク抵抗器','100kOhm','CAY10-104J4LF',NULL,'0.0625W',NULL,'5percent','Bourns','B011103-2976','R','3',NULL,'CAY10-104J4LF','admin','2025-05-16 09:56:14','admin','2025-05-16 09:56:14',1,NULL),('85ac1c54-093b-4ea3-bedc-856d7169e311','CAY16-104J4LF','ネットワーク抵抗器','100kOhm','CAY16-104J4LF',NULL,'0.0625W',NULL,'5percent','Bourns','B011103-2985','R','3',NULL,'CAY16-104J4LF','admin','2025-05-16 09:56:14','admin','2025-05-16 09:56:14',1,NULL),('86431403-918c-4ea3-aec1-912b8a20d7be','EXB28V470JX','ネットワーク抵抗器','47Ohm','EXB28V470JX',NULL,'0.063W',NULL,'5percent','Panasonic','B011103-0409','R','3',NULL,'EXB28V470JX','admin','2025-05-16 09:56:13','admin','2025-05-16 09:56:13',1,NULL),('91a4aa3a-9bb1-49b5-82c1-b73b6c12e3d4','CREC08TR472JM','ネットワーク抵抗器','4.7kOhm','CREC08TR472JM',NULL,'0.063W',NULL,'5percent','akane','B011103-2982','R','3',NULL,'CREC08TR472JM','admin','2025-05-16 09:56:15','admin','2025-05-16 09:56:15',1,NULL),('920884ba-140f-49f6-a568-3a9d2f555bb3','MNR35J5RJ333','ネットワーク抵抗器','33kOhm','MNR35J5RJ333',NULL,'0.063W',NULL,'5percent','ROHM','B011103-4088','R','3',NULL,'MNR35J5RJ333','admin','2025-05-16 09:56:12','admin','2025-05-16 09:56:12',1,NULL),('935b3998-66d8-48b2-b1e8-086234e75066','RKC4BDTPA-620RJ','ネットワーク抵抗器','62Ohm','RKC4BDTPA620J',NULL,'0.125W',NULL,'5percent','','B011103-0342','R','3',NULL,'RKC4BDTPA620J','admin','2025-05-16 09:56:13','admin','2025-05-16 09:56:13',1,NULL),('93e507db-e6af-4ea1-9414-6c1034684e9a','YC164-JR-07100KL','ネットワーク抵抗器','100kOhm','YC164-JR-07100KL',NULL,'0.063W',NULL,'5percent','Yageo','B011103-3251','R','3',NULL,'YC164-JR-07100KL','admin','2025-05-16 09:56:15','admin','2025-05-16 09:56:15',1,NULL),('944eaf70-b721-4d6a-a8a6-94fcde3d0694','BCN318SB473J7','ネットワーク抵抗器','47kOhm','BCN318SB473J7',NULL,'0.063W',NULL,'5percent','TT Electronics','B011103-6279','R','3',NULL,'BCN318SB473J7','admin','2025-05-16 09:56:15','admin','2025-05-16 09:56:15',1,NULL),('95ea3614-85e5-4e37-8683-7e10685ff413','RKC4BDTPA-47KJ','ネットワーク抵抗器','47kOhm','RKC4BDTPA473J',NULL,'0.125W',NULL,'5percent','','B011103-0341','R','3',NULL,'RKC4BDTPA473J','admin','2025-05-16 09:56:16','admin','2025-05-16 09:56:16',1,NULL),('968f90d8-977d-4dc8-9f63-d50d88ccb7d0','MNR34J5ABJ101','ネットワーク抵抗器','100Ohm','MNR34J5ABJ101',NULL,'0.125W',NULL,'5percent','ROHM','B011103-4091','R','3',NULL,'MNR34J5ABJ101','admin','2025-05-16 09:56:11','admin','2025-05-16 09:56:11',1,NULL),('9ecae9d1-7f06-4da0-8107-8cbcaae6a97e','EXB28V472J','ネットワーク抵抗器','4.7kOhm','EXB28V472JX',NULL,'0.063W',NULL,'5percent','Panasonic','B011103-1916','R','3',NULL,'EXB28V472JX','admin','2025-05-16 09:56:13','admin','2025-05-16 09:56:13',1,NULL),('a305238b-54cc-448d-8dce-75ee06a729ef','CREA08TR104JM','ネットワーク抵抗器','100kOhm','CREA08TR104JM',NULL,'0.063W',NULL,'5percent','Akane','B011103-2986','R','3',NULL,'CREA08TR104JM','admin','2025-05-16 09:56:15','admin','2025-05-16 09:56:15',1,NULL),('a759486b-952a-4f09-bb2d-61a0a73879b0','EXB28V104J','ネットワーク抵抗器','100kOhm','EXB28V104JX',NULL,'0.063W',NULL,'5percent','Panasonic','B011103-1412','R','3',NULL,'EXB28V104JX','admin','2025-05-16 09:56:12','admin','2025-05-16 09:56:12',1,NULL),('aa3d93d6-afd3-49c7-a284-b41bded94ab7','EXB28V470J','ネットワーク抵抗器','47Ohm','EXB28V470JX',NULL,'0.063W',NULL,'5percent','Panasonic','B011103-0565','R','3',NULL,'EXB28V470JX','admin','2025-05-16 09:56:12','admin','2025-05-16 09:56:12',1,NULL),('b7d6cb00-6a0f-405f-9cae-699a9d99a85f','EXBE10C103J','ネットワーク抵抗器','10kOhm','EXBE10C103J',NULL,'0.063W',NULL,'5percent','Panasonic','B011103-2338','R','3',NULL,'EXBE10C103J','admin','2025-05-16 09:56:13','admin','2025-05-16 09:56:13',1,NULL),('bab55cc6-e6a4-4e76-88f0-c70e6255738c','EXB38V104J','ネットワーク抵抗器','100kOhm','EXB38V104JV',NULL,'0.063W',NULL,'5percent','Panasonic','B011103-1052','R','3',NULL,'EXB38V104JV','admin','2025-05-16 09:56:13','admin','2025-05-16 09:56:13',1,NULL),('bd4c8fb3-5c3c-41a1-948f-3cfee98c8d81','CAY10-470J4LF','ネットワーク抵抗器','47Ohm','CAY10-470J4LF',NULL,'0.0625W',NULL,'5percent','Bourns','B011103-2973','R','3',NULL,'CAY10-470J4LF','admin','2025-05-16 09:56:14','admin','2025-05-16 09:56:14',1,NULL),('c80e2215-6e18-4f06-b156-271f23a3a664','NCR3A8333J','ネットワーク抵抗器','33kOhm','NCR3A8333J',NULL,'0.063W',NULL,'5percent','HDK','B011103-3109','R','3',NULL,'NCR3A8333J','admin','2025-05-16 09:56:14','admin','2025-05-16 09:56:14',1,NULL),('cb50d81f-fa43-47a4-b4a3-1e605efc6467','EXBV8V101JV','ネットワーク抵抗器','100Ohm','EXBV8V101JV',NULL,'0.063W',NULL,'5percent','Panasonic','B011103-1854','R','3',NULL,'EXBV8V101JV','admin','2025-05-16 09:56:13','admin','2025-05-16 09:56:13',1,NULL),('cbd8aac9-2562-4afd-bce9-1b81eec039a4','MNR18E0APJ103','ネットワーク抵抗器','10kOhm','MNR18E0APJ103',NULL,'0.063W',NULL,'5percent','ROHM','B011103-2265','R','3',NULL,'MNR18E0APJ103','admin','2025-05-16 09:56:10','admin','2025-05-16 09:56:10',1,NULL),('cc05851f-7d88-4900-bed6-37e5dd998c6d','RKC8BDTPA-47KJ','ネットワーク抵抗器','47kOhm','RKC8BDTPA473J',NULL,'0.125W',NULL,'5percent','','B011103-0344','R','3',NULL,'RKC8BDTPA473J','admin','2025-05-16 09:56:15','admin','2025-05-16 09:56:15',1,NULL),('ceda245a-5e1e-4596-abf3-215d8ddb7753','RM2012B-104/104-NDXW10','ネットワーク抵抗器','100kOhm','RM2012B-104/104-NDXW10',NULL,'0.05W',NULL,'0.5percent','Susumu','B011103-4059','R','3',NULL,'RM2012B-104/104-NDXW10','admin','2025-05-16 09:56:15','admin','2025-05-16 09:56:15',1,NULL),('d12b14f6-423f-474c-bcc9-d02f18d68636','RKC4BDTPA-5.1KJ','ネットワーク抵抗器','5.1kOhm','RKC4BDTPA512J',NULL,'0.125W',NULL,'5percent','','B011103-0340','R','3',NULL,'RKC4BDTPA512J','admin','2025-05-16 09:56:13','admin','2025-05-16 09:56:13',1,NULL),('d3e77c49-b3c6-4c0c-a28d-ffbea5c84c52','RAC104D472JCTH','ネットワーク抵抗器','4.7kOhm','RAC104D472JCTH',NULL,'0.063W',NULL,'5percent','KAMAYA','B011103-2980','R','3',NULL,'RAC104D472JCTH','admin','2025-05-16 09:56:11','admin','2025-05-16 09:56:11',1,NULL),('d9d35d5d-c0f5-4bc8-8c91-a5b09b4222a8','RAC104D470JCTH','ネットワーク抵抗器','47Ohm','RAC104D470JCTH',NULL,'0.063W',NULL,'5percent','KAMAYA','B011103-2970','R','3',NULL,'RAC104D470JCTH','admin','2025-05-16 09:56:11','admin','2025-05-16 09:56:11',1,NULL),('e2f6341d-bd0d-4544-bcef-c99c44313599','RAC164D104JCTP','ネットワーク抵抗器','100kOhm','RAC164D104JCTP',NULL,'0.1W',NULL,'5percent','KAMAYA','B011103-2984','R','3',NULL,'RAC164D104JCTP','admin','2025-05-16 09:56:11','admin','2025-05-16 09:56:11',1,NULL),('e6fd4fdc-2a63-4d73-9a90-763f69a302e6','NCR3A8104J','ネットワーク抵抗器','100kOhm','NCR3A8104J',NULL,'0.063W',NULL,'5percent','HDK','B011103-2851','R','3',NULL,'NCR3A8104J','admin','2025-05-16 09:56:14','admin','2025-05-16 09:56:14',1,NULL),('f22c4d8e-167d-4e39-9b1a-d5046b55303e','CAT16-101J4LF','ネットワーク抵抗器','100Ohm','CAT16-101J4LF',NULL,'0.0625W',NULL,'5percent','Bourns','B011103-4072','R','3',NULL,'CAT16-101J4LF','admin','2025-05-16 09:56:13','admin','2025-05-16 09:56:13',1,NULL),('faf87f2a-95b3-493c-8846-22fa34701c34','RAC104D104JCTH','ネットワーク抵抗器','100kOhm','RAC104D104JCTH',NULL,'0.063W',NULL,'5percent','KAMAYA','B011103-2975','R','3',NULL,'RAC104D104JCTH','admin','2025-05-16 09:56:10','admin','2025-05-16 09:56:10',1,NULL);
/*!40000 ALTER TABLE `resistors` ENABLE KEYS */;

--
-- Table structure for table `resonators`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resonators` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `resonators_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='発振子／共振子／水晶振動子';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resonators`
--

/*!40000 ALTER TABLE `resonators` DISABLE KEYS */;
/*!40000 ALTER TABLE `resonators` ENABLE KEYS */;

--
-- Table structure for table `rf_components`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rf_components` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `rf_components_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='高周波部品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rf_components`
--

/*!40000 ALTER TABLE `rf_components` DISABLE KEYS */;
/*!40000 ALTER TABLE `rf_components` ENABLE KEYS */;

--
-- Table structure for table `sensors`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sensors` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sensors_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='センサ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensors`
--

/*!40000 ALTER TABLE `sensors` DISABLE KEYS */;
/*!40000 ALTER TABLE `sensors` ENABLE KEYS */;

--
-- Table structure for table `sockets`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sockets` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sockets_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='ソケット';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sockets`
--

/*!40000 ALTER TABLE `sockets` DISABLE KEYS */;
/*!40000 ALTER TABLE `sockets` ENABLE KEYS */;

--
-- Table structure for table `switches`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `switches` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `switches_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='スイッチ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `switches`
--

/*!40000 ALTER TABLE `switches` DISABLE KEYS */;
/*!40000 ALTER TABLE `switches` ENABLE KEYS */;

--
-- Table structure for table `t_import_his`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_import_his` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `tcih_code` varchar(255) DEFAULT NULL,
  `tcih_filename` varchar(255) DEFAULT NULL,
  `tcih_importtime` datetime(6),
  `tcih_status` bit(1) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime(6),
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime(6),
  `del_flag` tinyint(1) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_import_his`
--

/*!40000 ALTER TABLE `t_import_his` DISABLE KEYS */;
INSERT INTO `t_import_his` VALUES (1,'3a4582cd-283f-4854-a0cc-02f2e290663e','XJA007','XJA007_ネットワーク抵抗器_v2.xlsx','2025-05-16 09:56:07.497304',_binary '','admin','2025-05-16 09:56:07.498308',NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `t_import_his` ENABLE KEYS */;

--
-- Table structure for table `t_import_his_detail`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_import_his_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `tcihd_pid` varchar(255) DEFAULT NULL,
  `tcihd_line` varchar(255) DEFAULT NULL,
  `tcihd_error` varchar(5000) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime(6),
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime(6),
  `del_flag` tinyint(1) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_import_his_detail`
--

/*!40000 ALTER TABLE `t_import_his_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_import_his_detail` ENABLE KEYS */;

--
-- Table structure for table `t_import_setting`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_import_setting` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `tcis_code` varchar(255) DEFAULT NULL COMMENT 'コード：COMMON　共通（他は末端分類コードを設定）',
  `tcis_type` varchar(255) DEFAULT NULL COMMENT '処理タイプ',
  `tcis_incol` varchar(255) DEFAULT NULL COMMENT '処理対象列',
  `tcis_editrule` varchar(255) DEFAULT NULL COMMENT '編集ルール',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=398 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_import_setting`
--

/*!40000 ALTER TABLE `t_import_setting` DISABLE KEYS */;
INSERT INTO `t_import_setting` VALUES (1,'COMMON','SCHEMATIC_PART','T',''),(2,'COMMON','DEL','N',''),(3,'COMMON','PART_TYPE','L',''),(4,'COMMON','PART_NUMBER','T',''),(5,'COMMON','MANUFACTURE','W',''),(6,'COMMON','B_CODE','AC',''),(7,'COMMON','ITEM_REGISTRATION_CLASSFICATION','','3'),(8,'COMMON','SPICE_MODEL','',''),(9,'A/Dコンバータ','VALUE','T',''),(10,'A/Dコンバータ','PARTS_NAME','','IC'),(11,'A/Dコンバータ','PACKAGE_TYPE','AP',''),(12,'CCDエリアセンサ','VALUE','',''),(13,'CCDエリアセンサ','PARTS_NAME','','IC'),(14,'CCDリニアセンサ','VALUE','',''),(15,'CCDリニアセンサ','PARTS_NAME','','IC'),(16,'D/Aコンバータ','VALUE','T',''),(17,'D/Aコンバータ','PARTS_NAME','','IC'),(18,'D/Aコンバータ','PACKAGE_TYPE','AP',''),(19,'DC-DCコンバータ','VALUE','T',''),(20,'DC-DCコンバータ','PARTS_NAME','','IC'),(21,'DIMMソケット','VALUE','AK',''),(22,'DIMMソケット','PARTS_NAME','','J'),(23,'DRAM','VALUE','T',''),(24,'DRAM','PARTS_NAME','','IC'),(25,'DSP','VALUE','T',''),(26,'DSP','PARTS_NAME','','IC'),(27,'EEPROM','VALUE','T',''),(28,'EEPROM','PARTS_NAME','','IC'),(29,'EMIフィルタ','VALUE','',''),(30,'EMIフィルタ','PARTS_NAME','','NF'),(31,'EPROM','VALUE','T',''),(32,'EPROM','PARTS_NAME','','IC'),(33,'GTOサイリスタ','VALUE','',''),(34,'GTOサイリスタ','PARTS_NAME','','SCR'),(35,'IC/LSIソケット','VALUE','',''),(36,'IC/LSIソケット','PARTS_NAME','','J'),(37,'IC/LSIソケット','PACKAGE_TYPE','AK',''),(38,'ICカード用IC','VALUE','T',''),(39,'ICカード用IC','PARTS_NAME','','IC'),(40,'IGBT','VALUE','',''),(41,'IGBT','PARTS_NAME','','Q'),(42,'IPD','VALUE','T',''),(43,'IPD','PARTS_NAME','','IC'),(44,'LEDランプ','VALUE','',''),(45,'LEDランプ','PARTS_NAME','','OPT'),(46,'MOSFET','VALUE','',''),(47,'MOSFET','PARTS_NAME','','Q'),(48,'MOSセンサ','VALUE','',''),(49,'MOSセンサ','PARTS_NAME','','IC'),(50,'NTCサーミスタ','VALUE','AG,AH',''),(51,'NTCサーミスタ','TOLERANCE','AI,AJ',''),(52,'NTCサーミスタ','PARTS_NAME','','TS'),(53,'OTPROM','PARTS_NAME','','IC'),(54,'OTPROM','VALUE','T',''),(55,'PTCサーミスタ','VALUE','AG,AH',''),(56,'PTCサーミスタ','TOLERANCE','AI,AJ',''),(57,'PTCサーミスタ','PARTS_NAME','','TS'),(58,'SRAM','VALUE','T',''),(59,'SRAM','PARTS_NAME','','IC'),(60,'TVSダイオード','VALUE','',''),(61,'TVSダイオード','PARTS_NAME','','D'),(62,'アンテナ受け口','VALUE','',''),(63,'アンテナ受け口','PARTS_NAME','','J'),(64,'インタフェースドライバ','VALUE','T',''),(65,'インタフェースドライバ','PARTS_NAME','','IC'),(66,'インバータ','VALUE','T',''),(67,'インバータ','PARTS_NAME','','IC'),(68,'エンコーダ','VALUE','',''),(69,'エンコーダ','PARTS_NAME','','SW'),(70,'オペアンプ','PACKAGE_TYPE','AU',''),(71,'オペアンプ','VALUE','T',''),(72,'オペアンプ','PARTS_NAME','','IC'),(73,'カスタムIC','VALUE','T',''),(74,'カスタムIC','PARTS_NAME','','IC'),(75,'コモンモードチョークコイル','VALUE','',''),(76,'コモンモードチョークコイル','PARTS_NAME','','L'),(77,'コンパレータ','VALUE','T',''),(78,'コンパレータ','PARTS_NAME','','IC'),(79,'サーキットプロテクタ','PARTS_NAME','','SW'),(80,'サーキットプロテクタ','RATING_VOLTAGE','AI,AJ',''),(81,'サーキットプロテクタ','VALUE','AG,AH',''),(82,'シャント電源用IC','VALUE','T',''),(83,'シャント電源用IC','PARTS_NAME','','IC'),(84,'ショットキバリアダイオード','VALUE','',''),(85,'ショットキバリアダイオード','PARTS_NAME','','D'),(86,'シリーズ電源用IC','VALUE','T',''),(87,'シリーズ電源用IC','PARTS_NAME','','IC'),(88,'シリーズ電源用IC','PACKAGE_TYPE','AG',''),(89,'スイッチングダイオード','VALUE','',''),(90,'スイッチングダイオード','PARTS_NAME','','D'),(91,'スイッチング電源用IC','VALUE','T',''),(92,'スイッチング電源用IC','PARTS_NAME','','IC'),(93,'スイッチング電源用IC','PACKAGE_TYPE','AG',''),(94,'ステッピングモータドライバIC','VALUE','T',''),(95,'ステッピングモータドライバIC','PARTS_NAME','','IC'),(96,'ストレージ用IC','VALUE','T',''),(97,'ストレージ用IC','PARTS_NAME','','IC'),(98,'スピーカ','VALUE','T',''),(99,'スピーカ','PARTS_NAME','','SP'),(100,'スライドスイッチ','VALUE','',''),(101,'スライドスイッチ','PARTS_NAME','','SW'),(102,'セグメント型有機ELディスプレイ','VALUE','',''),(103,'セグメント型有機ELディスプレイ','PARTS_NAME','','VDT'),(104,'セグメント型液晶表示デバイス','VALUE','',''),(105,'セグメント型液晶表示デバイス','PARTS_NAME','','LCD'),(106,'セラミックコンデンサ','PCB_FOOTPRINT','AM,AO,AQ,AS,AY',''),(107,'セラミックコンデンサ','SCHEMATIC_PART','','C'),(108,'セラミックコンデンサ','VALUE','AZ,BA',''),(109,'セラミックコンデンサ','RATING_VOLTAGE','AG,AH',''),(110,'セラミックコンデンサ','CHARACTERISTICS','BF',''),(111,'セラミックコンデンサ','TOLERANCE','BB,BC,BD,BE',''),(112,'セラミックコンデンサ','PARTS_NAME','','C'),(113,'ツェナーダイオード','VALUE','',''),(114,'ツェナーダイオード','PARTS_NAME','','D'),(115,'データ通信用送受信ユニット','VALUE','T',''),(116,'データ通信用送受信ユニット','PARTS_NAME','','IC'),(117,'ディップスイッチ','VALUE','',''),(118,'ディップスイッチ','PARTS_NAME','','SW'),(119,'ディレイライン','PARTS_NAME','',''),(120,'ディレイライン','VALUE','',''),(121,'トライアック','VALUE','',''),(122,'トライアック','PARTS_NAME','','SCR'),(123,'トランジスタソケット','VALUE','',''),(124,'トランジスタソケット','PARTS_NAME','','J'),(125,'トランス','PARTS_NAME','','T'),(126,'トランス','VALUE','',''),(127,'トランスミッタ／レシーバ','PARTS_NAME','','OPT'),(128,'トランスミッタ／レシーバ','VALUE','AG',''),(129,'ネットワーク抵抗器','VALUE','AI,AJ',''),(130,'ネットワーク抵抗器','PCB_FOOTPRINT','AV,AX,AZ,BB,BH',''),(131,'ネットワーク抵抗器','RATING_ELECTRICITY','AG,AH',''),(132,'ネットワーク抵抗器','TOLERANCE','AK,AL',''),(133,'ネットワーク抵抗器','PARTS_NAME','','R'),(134,'ノーマルモードチョークコイル','VALUE','',''),(135,'ノーマルモードチョークコイル','PARTS_NAME','','L'),(136,'ハイブリッドチョークコイル','VALUE','',''),(137,'ハイブリッドチョークコイル','PARTS_NAME','','L'),(138,'バイポーラトランジスタ','VALUE','',''),(139,'バイポーラトランジスタ','PARTS_NAME','','Q'),(140,'バリスタ','VALUE','',''),(141,'バリスタ','PARTS_NAME','','D'),(142,'ヒューズホルダ／ソケット','VALUE','AK',''),(143,'ヒューズホルダ／ソケット','PARTS_NAME','','J'),(144,'フィルムコンデンサ','VALUE','AZ,BA',''),(145,'フィルムコンデンサ','RATING_VOLTAGE','AG,AH',''),(146,'フィルムコンデンサ','TOLERANCE','BB,BC,BD,BE',''),(147,'フィルムコンデンサ','PARTS_NAME','','C'),(148,'フィルムコンデンサ','PCB_FOOTPRINT','AM,AO,AQ,AS,AY',''),(149,'フィルムコンデンサ','SCHEMATIC_PART','','C'),(150,'フェライトビーズ','VALUE','',''),(151,'フェライトビーズ','PARTS_NAME','','NF'),(152,'フォトインタラプタ','VALUE','',''),(153,'フォトインタラプタ','PARTS_NAME','','PI'),(154,'フォトカプラ','VALUE','',''),(155,'フォトカプラ','PARTS_NAME','','PC'),(156,'フックスイッチ','VALUE','',''),(157,'フックスイッチ','PARTS_NAME','','SW'),(158,'プッシュスイッチ','VALUE','',''),(159,'プッシュスイッチ','PARTS_NAME','','SW'),(160,'ブラシつきモータドライバIC','VALUE','T',''),(161,'ブラシつきモータドライバIC','PARTS_NAME','','IC'),(162,'ブラシレスモータドライバIC','VALUE','T',''),(163,'ブラシレスモータドライバIC','PARTS_NAME','','IC'),(164,'プラズマディスプレイデバイス','VALUE','',''),(165,'プラズマディスプレイデバイス','PARTS_NAME','','VDT'),(166,'フラッシュメモリ','VALUE','T',''),(167,'フラッシュメモリ','PARTS_NAME','','IC'),(168,'プリント基板用ソケット','VALUE','',''),(169,'プリント基板用ソケット','PARTS_NAME','','J'),(170,'プログラマブルロジック','VALUE','T',''),(171,'プログラマブルロジック','PARTS_NAME','','IC'),(172,'マイカコンデンサ','PCB_FOOTPRINT','AM,AO,AQ,AS,AY',''),(173,'マイカコンデンサ','SCHEMATIC_PART','','C'),(174,'マイカコンデンサ','TOLERANCE','BB,BC,BD,BE',''),(175,'マイカコンデンサ','PARTS_NAME','','C'),(176,'マイカコンデンサ','VALUE','AZ,BA',''),(177,'マイカコンデンサ','RATING_VOLTAGE','AG,AH',''),(178,'マイクロコンピュータ','VALUE','T',''),(179,'マイクロコンピュータ','PARTS_NAME','','IC'),(180,'マイクロコンピュータ','PACKAGE_TYPE','AR',''),(181,'マイクロスイッチ','VALUE','',''),(182,'マイクロスイッチ','PARTS_NAME','','SW'),(183,'マイクロホン','PARTS_NAME','','MP'),(184,'マイクロホン','VALUE','T',''),(185,'マイクロ波部品','VALUE','',''),(186,'マイクロ波部品','PARTS_NAME','',''),(187,'マグネチックブザー／サウンダ','VALUE','T',''),(188,'マグネチックブザー／サウンダ','PARTS_NAME','','BZ'),(189,'マスクROM','VALUE','T',''),(190,'マスクROM','PARTS_NAME','','IC'),(191,'マトリクス型有機ELディスプレイ','VALUE','',''),(192,'マトリクス型有機ELディスプレイ','PARTS_NAME','','VDT'),(193,'マトリクス型液晶表示デバイス','VALUE','',''),(194,'マトリクス型液晶表示デバイス','PARTS_NAME','','LCD'),(195,'メモリカード','VALUE','T',''),(196,'メモリカード','PARTS_NAME','','IC'),(197,'メモリモジュール','VALUE','T',''),(198,'メモリモジュール','PARTS_NAME','','IC'),(199,'メンブレンスイッチ','VALUE','',''),(200,'メンブレンスイッチ','PARTS_NAME','','SW'),(201,'リードスイッチ','VALUE','',''),(202,'リードスイッチ','PARTS_NAME','','SW'),(203,'リーフスイッチ','VALUE','',''),(204,'リーフスイッチ','PARTS_NAME','','SW'),(205,'リセッタブルヒューズ','PARTS_NAME','','F'),(206,'リセッタブルヒューズ','VALUE','AG,AH',''),(207,'リレー用ソケット','VALUE','',''),(208,'リレー用ソケット','PARTS_NAME','','J'),(209,'レーザダイオード','VALUE','',''),(210,'レーザダイオード','PARTS_NAME','','D'),(211,'レバースイッチ','VALUE','',''),(212,'レバースイッチ','PARTS_NAME','','SW'),(213,'ロータリスイッチ','VALUE','',''),(214,'ロータリスイッチ','PARTS_NAME','','SW'),(215,'ロッカスイッチ','VALUE','',''),(216,'ロッカスイッチ','PARTS_NAME','','SW'),(217,'一次電池','VALUE','AM,AN',''),(218,'一次電池','PARTS_NAME','','E'),(219,'一般サイリスタ','VALUE','',''),(220,'一般サイリスタ','PARTS_NAME','','SCR'),(221,'二次電池','VALUE','AM,AN',''),(222,'二次電池','PARTS_NAME','','E'),(223,'位置センサ','VALUE','T',''),(224,'位置センサ','PARTS_NAME','','SNS'),(225,'信号用ソケット','VALUE','',''),(226,'信号用ソケット','PARTS_NAME','','J'),(227,'信号用フィルタ','VALUE','',''),(228,'信号用フィルタ','PARTS_NAME','','NF'),(229,'光サイリスタ','VALUE','',''),(230,'光サイリスタ','PARTS_NAME','','SCR'),(231,'光スイッチ','VALUE','AG',''),(232,'光スイッチ','PARTS_NAME','','OPT'),(233,'光応用製品','VALUE','',''),(234,'光応用製品','PARTS_NAME','','OPT'),(235,'力／トルクセンサ','VALUE','T',''),(236,'力／トルクセンサ','PARTS_NAME','','SNS'),(237,'半導体リレー','VALUE','',''),(238,'半導体リレー','PARTS_NAME','','RY'),(239,'受光素子','VALUE','',''),(240,'受光素子','PARTS_NAME','','PD'),(241,'可変インダクタ','VALUE','BJ,BK',''),(242,'可変インダクタ','PARTS_NAME','','L'),(243,'可変コンデンサ','VALUE','BB,BC',''),(244,'可変コンデンサ','RATING_VOLTAGE','AG,AH',''),(245,'可変コンデンサ','PARTS_NAME','','C'),(246,'可変コンデンサ','PCB_FOOTPRINT','AM,AO,AQ,AS,Ay',''),(247,'可変コンデンサ','SCHEMATIC_PART','','C'),(248,'可変容量ダイオード','VALUE','',''),(249,'可変容量ダイオード','PARTS_NAME','','VD'),(250,'可変抵抗器','VALUE','AI,AJ',''),(251,'可変抵抗器','PCB_FOOTPRINT','AQ,AS,AU,AW,BC',''),(252,'可変抵抗器','RATING_ELECTRICITY','AG,AH',''),(253,'可変抵抗器','TOLERANCE','AK,AL',''),(254,'可変抵抗器','PARTS_NAME','','R'),(255,'可変抵抗器','SCHEMATIC_PART','','VR'),(256,'可視光線センサ','VALUE','T',''),(257,'可視光線センサ','PARTS_NAME','','SNS'),(258,'回転角／回転数センサ','VALUE','T',''),(259,'回転角／回転数センサ','PARTS_NAME','','SNS'),(260,'固定インダクタ','VALUE','BJ,BK',''),(261,'固定インダクタ','TOLERANCE','BL,BM,BN,BO',''),(262,'固定インダクタ','PARTS_NAME','','L'),(263,'固定抵抗器','VALUE','AI,AJ',''),(264,'固定抵抗器','PCB_FOOTPRINT','AQ,AS,AU,AW,BC',''),(265,'固定抵抗器','RATING_ELECTRICITY','AG,AH',''),(266,'固定抵抗器','TOLERANCE','AK,AL',''),(267,'固定抵抗器','PARTS_NAME','','R'),(268,'固定抵抗器','SCHEMATIC_PART','','R'),(269,'圧力センサ','VALUE','T',''),(270,'圧力センサ','PARTS_NAME','','SNS'),(271,'圧電セラミックス振動子','VALUE','AG,AH',''),(272,'圧電セラミックス振動子','CHARACTERISTICS','BK,BL',''),(273,'圧電セラミックス振動子','PARTS_NAME','','X'),(274,'圧電ブザー／サウンダ','VALUE','T',''),(275,'圧電ブザー／サウンダ','PARTS_NAME','','BZ'),(276,'基板側コネクタ_コネクタ','VALUE','',''),(277,'基板側コネクタ_コネクタ','PARTS_NAME','','J'),(278,'変位センサ','VALUE','T',''),(279,'変位センサ','PARTS_NAME','','SNS'),(280,'太陽電池','VALUE','T',''),(281,'太陽電池','PARTS_NAME','','E'),(282,'小型メモリーカードソケット','VALUE','',''),(283,'小型メモリーカードソケット','PARTS_NAME','','J'),(284,'強誘電体メモリ','VALUE','T',''),(285,'強誘電体メモリ','PARTS_NAME','','IC'),(286,'感振／転倒検知スイッチ','VALUE','',''),(287,'感振／転倒検知スイッチ','PARTS_NAME','','SW'),(288,'感熱スイッチ','VALUE','',''),(289,'感熱スイッチ','PARTS_NAME','','SW'),(290,'接合型FET','VALUE','',''),(291,'接合型FET','PARTS_NAME','','Q'),(292,'放射線センサ','VALUE','T',''),(293,'放射線センサ','PARTS_NAME','','SNS'),(294,'放電ギャップ','VALUE','',''),(295,'放電ギャップ','PARTS_NAME','',''),(296,'放電ランプ','VALUE','',''),(297,'放電ランプ','PARTS_NAME','','OPT'),(298,'整流用ダイオード','VALUE','',''),(299,'整流用ダイオード','PARTS_NAME','','D'),(300,'時計用IC','VALUE','T',''),(301,'時計用IC','PARTS_NAME','','IC'),(302,'機能回路モジュール','VALUE','',''),(303,'機能回路モジュール','PARTS_NAME','','IC'),(304,'歪みセンサ','VALUE','T',''),(305,'歪みセンサ','PARTS_NAME','','SNS'),(306,'水晶フィルタ','VALUE','',''),(307,'水晶フィルタ','PARTS_NAME','','NF'),(308,'水晶発振器','PARTS_NAME','','X'),(309,'水晶発振器','VALUE','BD,BE',''),(310,'水晶発振子用ソケット','VALUE','',''),(311,'水晶発振子用ソケット','PARTS_NAME','','J'),(312,'汎用リニアIC','VALUE','T',''),(313,'汎用リニアIC','PARTS_NAME','','IC'),(314,'汎用ロジックIC','VALUE','T',''),(315,'汎用ロジックIC','PARTS_NAME','','IC'),(316,'汎用ロジックIC','PACKAGE_TYPE','AL',''),(317,'流速／流量センサ','VALUE','T',''),(318,'流速／流量センサ','PARTS_NAME','','SNS'),(319,'温度／湿度／気圧センサ','VALUE','T',''),(320,'温度／湿度／気圧センサ','PARTS_NAME','','SNS'),(321,'温度ヒューズ','VALUE','AV,AW',''),(322,'温度ヒューズ','PARTS_NAME','','F'),(323,'照光ランプ用ソケット','VALUE','',''),(324,'照光ランプ用ソケット','PARTS_NAME','','J'),(325,'照度センサ','VALUE','T',''),(326,'照度センサ','PARTS_NAME','','SNS'),(327,'物体検出センサ','VALUE','T',''),(328,'物体検出センサ','PARTS_NAME','','SNS'),(329,'発光ダイオード','VALUE','',''),(330,'発光ダイオード','PARTS_NAME','','D'),(331,'発振子／共振子／水晶振動子','VALUE','AG,AH',''),(332,'発振子／共振子／水晶振動子','CHARACTERISTICS','AM,AN',''),(333,'発振子／共振子／水晶振動子','TOLERANCE','AI,AJ,AK,AL',''),(334,'発振子／共振子／水晶振動子','PARTS_NAME','','X'),(335,'白熱電球','VALUE','',''),(336,'白熱電球','PARTS_NAME','','OPT'),(337,'磁歪振動子','VALUE','AG,AH',''),(338,'磁歪振動子','PARTS_NAME','','X'),(339,'磁気センサ','VALUE','T',''),(340,'磁気センサ','PARTS_NAME','','SNS'),(341,'端子','VALUE','AG',''),(342,'端子','PARTS_NAME','','J'),(343,'粉体センサ','VALUE','T',''),(344,'粉体センサ','PARTS_NAME','','SNS'),(345,'紫外線センサ','VALUE','T',''),(346,'紫外線センサ','PARTS_NAME','','SNS'),(347,'蛍光ランプ','VALUE','',''),(348,'蛍光ランプ','PARTS_NAME','','OPT'),(349,'蛍光表示管','VALUE','',''),(350,'蛍光表示管','PARTS_NAME','','VDT'),(351,'表示用IC','VALUE','T',''),(352,'表示用IC','PARTS_NAME','','IC'),(353,'複合ディスクリートデバイス','VALUE','',''),(354,'複合ディスクリートデバイス','PARTS_NAME','',''),(355,'複合メモリ','PARTS_NAME','','IC'),(356,'複合メモリ','VALUE','T',''),(357,'複合機能付スイッチ','VALUE','',''),(358,'複合機能付スイッチ','PARTS_NAME','','SW'),(359,'角度／振動／速度／加速度センサ','VALUE','T',''),(360,'角度／振動／速度／加速度センサ','PARTS_NAME','','SNS'),(361,'角速度センサ','VALUE','T',''),(362,'角速度センサ','PARTS_NAME','','SNS'),(363,'赤外線センサ','VALUE','T',''),(364,'赤外線センサ','PARTS_NAME','','SNS'),(365,'送受信アンテナ','VALUE','T',''),(366,'送受信アンテナ','PARTS_NAME','','ANT'),(367,'電圧検出用IC','PACKAGE_TYPE','AG',''),(368,'電圧検出用IC','VALUE','T',''),(369,'電圧検出用IC','PARTS_NAME','','IC'),(370,'電子管用ソケット','VALUE','',''),(371,'電子管用ソケット','PARTS_NAME','','J'),(372,'電気二重層コンデンサ','VALUE','AZ,BA',''),(373,'電気二重層コンデンサ','RATING_VOLTAGE','AG,AH',''),(374,'電気二重層コンデンサ','TOLERANCE','BB,BC,BD,BE',''),(375,'電気二重層コンデンサ','PARTS_NAME','','C'),(376,'電気二重層コンデンサ','PCB_FOOTPRINT','AM,AO,AQ,AS,AY',''),(377,'電気二重層コンデンサ','SCHEMATIC_PART','','C'),(378,'電池のアダプタ／ホルダー','VALUE','',''),(379,'電池のアダプタ／ホルダー','PARTS_NAME','','J'),(380,'電流センサ','VALUE','T',''),(381,'電流センサ','PARTS_NAME','','SNS'),(382,'電流ヒューズ','PARTS_NAME','','F'),(383,'電流ヒューズ','VALUE','AG,AH',''),(384,'電源用ソケット','VALUE','',''),(385,'電源用ソケット','PARTS_NAME','','J'),(386,'電界センサ','VALUE','T',''),(387,'電界センサ','PARTS_NAME','','SNS'),(388,'電磁リレー','VALUE','',''),(389,'電磁リレー','PARTS_NAME','','RY'),(390,'電解コンデンサ','PCB_FOOTPRINT','AM,AO,AQ,AS,AY',''),(391,'電解コンデンサ','SCHEMATIC_PART','','CE'),(392,'電解コンデンサ','VALUE','AZ,BA',''),(393,'電解コンデンサ','RATING_VOLTAGE','AG,AH',''),(394,'電解コンデンサ','TOLERANCE','BB,BC,BD,BE',''),(395,'電解コンデンサ','PARTS_NAME','','C'),(396,'音響用IC','VALUE','T',''),(397,'音響用IC','PARTS_NAME','','IC');
/*!40000 ALTER TABLE `t_import_setting` ENABLE KEYS */;

--
-- Table structure for table `t_import_table`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_import_table` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `bCode` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='通用表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_import_table`
--

/*!40000 ALTER TABLE `t_import_table` DISABLE KEYS */;
INSERT INTO `t_import_table` VALUES ('0731c92b-ffce-44b1-aaad-24b5af4493b5','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-3532-2025-05-16T09:56:12.329877500Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('080f91a9-43d6-4897-8749-2b17fa9c7024','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-4094-2025-05-16T09:56:11.253227100Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('08b498b4-2aab-44db-818d-7b3afeeb3cdf','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2518-2025-05-16T09:56:13.614330Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('0b8fdb3c-2563-4ba6-a0d8-c100e00135f1','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2975-2025-05-16T09:56:09.691596100Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('0d7013ca-2b85-4615-9771-df81c8c461ed','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-0342-2025-05-16T09:56:13.338878300Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('1265cc48-27be-44de-960f-a0389ec9374a','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2973-2025-05-16T09:56:13.645967900Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('12e099e0-f401-4bff-a0ee-52efff59b38d','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-4088-2025-05-16T09:56:11.518220200Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('13fccb73-e4a7-4e1c-8128-0a849a8f9eb0','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-4093-2025-05-16T09:56:11.052423Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('18b07d12-0fdb-416f-9cee-0f4e3c8118c6','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2981-2025-05-16T09:56:13.893986300Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('18dae2b7-077f-42e3-a59d-43291bd6732a','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-4058-2025-05-16T09:56:11.664231Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('1e756105-ffc8-4fff-870a-c480a9c87921','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2976-2025-05-16T09:56:13.471627Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('2e42ada7-7b7b-4fe6-a259-7aa2de3b71fe','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2982-2025-05-16T09:56:15.386483300Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('3098b933-1fbe-4e66-a515-35c571139e70','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-0340-2025-05-16T09:56:13.163879300Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('3c9f2e11-447b-4a98-921a-576832f196e0','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-3324-2025-05-16T09:56:13.107879400Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('46ee6247-2e8c-4db3-8d6d-c002d4be68fa','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2338-2025-05-16T09:56:12.481885600Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('47b62cbb-f24d-493c-ae7d-6a573e7dc8e9','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-0409-2025-05-16T09:56:12.455882400Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('48a44466-2f46-48f6-b484-27d9d7fd0834','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2265-2025-05-16T09:56:09.691596100Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('4ed49183-5279-4156-86cd-6d488ca11a30','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-0565-2025-05-16T09:56:12.236330700Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('51c72890-1e69-4270-a628-c920194238f2','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-1052-2025-05-16T09:56:12.867880800Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('5c59d0ac-3215-445e-bfe1-81aae81df431','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-1854-2025-05-16T09:56:12.997889600Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('66eb5612-c535-4d1e-a166-96f0f86993a9','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2984-2025-05-16T09:56:11.181345400Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('69723b82-d52c-4bf1-9b19-fa4b67a71176','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-0408-2025-05-16T09:56:14.410227100Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('7126f99b-9282-4f94-a942-d3f48d5c926e','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2266-2025-05-16T09:56:11.399220900Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('75fb3a98-c823-4336-8230-666e15c55f35','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-4447-2025-05-16T09:56:13.780952600Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('7735c761-e6b9-41cf-bdce-620489f5ba85','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-3252-2025-05-16T09:56:15.150485600Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('79b4a0a7-b6ca-46f2-b8a3-ee41da400fea','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2970-2025-05-16T09:56:10.550763400Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('7a45bb1f-0e22-43c5-bc04-d40a0eb4bc4c','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2977-2025-05-16T09:56:15.052477300Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('7bc472e5-df76-4527-8e06-1d1a26c5e61f','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-1412-2025-05-16T09:56:12.008770700Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('7dae53c0-535e-4e2e-ad29-e307155125a9','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-3503-2025-05-16T09:56:11.584222400Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('807bb53b-5eab-4a11-8683-846eb3e3b461','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-0341-2025-05-16T09:56:15.467480100Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('85f40dc5-6f03-444e-b277-ead3899da6a0','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-3251-2025-05-16T09:56:14.967816100Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('94afcc55-ee2c-4748-b294-26a5d6404358','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-0339-2025-05-16T09:56:15.320485400Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('9866b84b-a582-4012-b4a2-a08171f080eb','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-4059-2025-05-16T09:56:14.544369900Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('9a9fdd00-d2be-4e81-a8bf-03098c90020c','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-0503-2025-05-16T09:56:11.935769800Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('9e255be6-9c56-4a11-9439-2bd7923a17c8','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-4072-2025-05-16T09:56:13.245879300Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('9e96dd99-35c9-491d-bcd8-452ac9c949de','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2980-2025-05-16T09:56:10.947425700Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('a38e6dc5-f405-4b5f-a2f7-861a124f48c4','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-1916-2025-05-16T09:56:12.618889Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('b478cc8c-380a-476d-9660-819a497b2d4a','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-0685-2025-05-16T09:56:11.789773800Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('c4b6acc6-ad0f-4a27-8f24-79ef181aa3f4','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-4091-2025-05-16T09:56:10.732205200Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('c7d6bf7b-1d5e-4895-a4c3-6739d25f9aef','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-4448-2025-05-16T09:56:12.747875200Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('d4d81eaa-4c58-44fe-96d3-b36db2f55a12','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2974-2025-05-16T09:56:15.265480700Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('d6f6f00d-7023-4b79-9bd1-e927df4d572b','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2985-2025-05-16T09:56:14.162315100Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('dd47e1ca-0c4e-435e-a820-b49fd41f3de8','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-1853-2025-05-16T09:56:12.133330600Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('f0e119d2-7ba1-48b2-91b1-246df86c3c80','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-3109-2025-05-16T09:56:14.314259Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('f25da050-3bcd-40da-aaa6-a43bf62229e7','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2851-2025-05-16T09:56:14.043185400Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('f615e65d-298d-41c4-b85a-beb0ed3fa698','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-6279-2025-05-16T09:56:14.784368400Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('f672fe95-68e2-42d3-9c71-11dca0f7862e','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-2986-2025-05-16T09:56:14.851729Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors'),('fe45f09c-3b49-4cc5-961f-79280fbad2db','mark','mark',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'B011103-0344-2025-05-16T09:56:14.666373800Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Resistors');
/*!40000 ALTER TABLE `t_import_table` ENABLE KEYS */;

--
-- Table structure for table `t_ss_import`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ss_import` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `ss_create_by` varchar(255) DEFAULT NULL,
  `ss_filename` varchar(255) DEFAULT NULL,
  `ss_b_code` varchar(255) DEFAULT NULL,
  `ss_sub_b_code` varchar(255) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime(6),
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime(6),
  `del_flag` tinyint(1) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_ss_import`
--

/*!40000 ALTER TABLE `t_ss_import` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_ss_import` ENABLE KEYS */;

--
-- Table structure for table `terminals`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terminals` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `terminals_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='端子';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terminals`
--

/*!40000 ALTER TABLE `terminals` DISABLE KEYS */;
/*!40000 ALTER TABLE `terminals` ENABLE KEYS */;

--
-- Table structure for table `thermistors`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thermistors` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `thermistors_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='サーミスタ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thermistors`
--

/*!40000 ALTER TABLE `thermistors` DISABLE KEYS */;
/*!40000 ALTER TABLE `thermistors` ENABLE KEYS */;

--
-- Table structure for table `thyristors`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thyristors` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `thyristors_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='サイリスタ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thyristors`
--

/*!40000 ALTER TABLE `thyristors` DISABLE KEYS */;
/*!40000 ALTER TABLE `thyristors` ENABLE KEYS */;

--
-- Table structure for table `transformers`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transformers` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `transformers_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='トランス';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transformers`
--

/*!40000 ALTER TABLE `transformers` DISABLE KEYS */;
/*!40000 ALTER TABLE `transformers` ENABLE KEYS */;

--
-- Table structure for table `transistors`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transistors` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `transistors_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='トランジスタ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transistors`
--

/*!40000 ALTER TABLE `transistors` DISABLE KEYS */;
/*!40000 ALTER TABLE `transistors` ENABLE KEYS */;

--
-- Table structure for table `vacuum_fluorescent_display_vfd`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacuum_fluorescent_display_vfd` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `vacuum_fluorescent_display_vfd_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='蛍光表示管';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacuum_fluorescent_display_vfd`
--

/*!40000 ALTER TABLE `vacuum_fluorescent_display_vfd` DISABLE KEYS */;
/*!40000 ALTER TABLE `vacuum_fluorescent_display_vfd` ENABLE KEYS */;

--
-- Table structure for table `varistors`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `varistors` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `part_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Number',
  `part_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Part Type',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Value',
  `schematic_part` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Schematic Part',
  `rating_voltage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Voltage',
  `rating_electricity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Rating Electricity',
  `characteristics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Characteristics',
  `tolerance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Tolerance',
  `manufacture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Manufacture',
  `b_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B Code',
  `parts_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Parts Name',
  `item_registration_classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Item registration classification',
  `spice_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Spice Model',
  `pcb_footprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'PCB footprint',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '作成者',
  `create_time` datetime DEFAULT NULL COMMENT '作成日',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新日',
  `del_flag` tinyint(1) DEFAULT '1' COMMENT '削除フラグ 1:未削除, 0:削除',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  UNIQUE KEY `varistors_UN` (`b_code`),
  KEY `idx_b_code` (`b_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='バリスタ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `varistors`
--

/*!40000 ALTER TABLE `varistors` DISABLE KEYS */;
/*!40000 ALTER TABLE `varistors` ENABLE KEYS */;

--
-- Final view structure for view `all_data_view`
--

/*!50001 DROP VIEW IF EXISTS `all_data_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `all_data_view` AS select 'resistors' AS `table_name`,`resistors`.`id` AS `id`,`resistors`.`part_number` AS `part_number`,`resistors`.`part_type` AS `part_type`,`resistors`.`value` AS `value`,`resistors`.`schematic_part` AS `schematic_part`,`resistors`.`rating_voltage` AS `rating_voltage`,`resistors`.`rating_electricity` AS `rating_electricity`,`resistors`.`characteristics` AS `characteristics`,`resistors`.`tolerance` AS `tolerance`,`resistors`.`manufacture` AS `manufacture`,`resistors`.`b_code` AS `b_code`,`resistors`.`parts_name` AS `parts_name`,`resistors`.`item_registration_classification` AS `item_registration_classification`,`resistors`.`spice_model` AS `spice_model`,`resistors`.`pcb_footprint` AS `pcb_footprint`,`resistors`.`create_by` AS `create_by`,`resistors`.`create_time` AS `create_time`,`resistors`.`update_by` AS `update_by`,`resistors`.`update_time` AS `update_time`,`resistors`.`del_flag` AS `del_flag`,`resistors`.`remark` AS `remark` from `resistors` union select 'thermistors' AS `table_name`,`thermistors`.`id` AS `id`,`thermistors`.`part_number` AS `part_number`,`thermistors`.`part_type` AS `part_type`,`thermistors`.`value` AS `value`,`thermistors`.`schematic_part` AS `schematic_part`,`thermistors`.`rating_voltage` AS `rating_voltage`,`thermistors`.`rating_electricity` AS `rating_electricity`,`thermistors`.`characteristics` AS `characteristics`,`thermistors`.`tolerance` AS `tolerance`,`thermistors`.`manufacture` AS `manufacture`,`thermistors`.`b_code` AS `b_code`,`thermistors`.`parts_name` AS `parts_name`,`thermistors`.`item_registration_classification` AS `item_registration_classification`,`thermistors`.`spice_model` AS `spice_model`,`thermistors`.`pcb_footprint` AS `pcb_footprint`,`thermistors`.`create_by` AS `create_by`,`thermistors`.`create_time` AS `create_time`,`thermistors`.`update_by` AS `update_by`,`thermistors`.`update_time` AS `update_time`,`thermistors`.`del_flag` AS `del_flag`,`thermistors`.`remark` AS `remark` from `thermistors` union select 'varistors' AS `table_name`,`varistors`.`id` AS `id`,`varistors`.`part_number` AS `part_number`,`varistors`.`part_type` AS `part_type`,`varistors`.`value` AS `value`,`varistors`.`schematic_part` AS `schematic_part`,`varistors`.`rating_voltage` AS `rating_voltage`,`varistors`.`rating_electricity` AS `rating_electricity`,`varistors`.`characteristics` AS `characteristics`,`varistors`.`tolerance` AS `tolerance`,`varistors`.`manufacture` AS `manufacture`,`varistors`.`b_code` AS `b_code`,`varistors`.`parts_name` AS `parts_name`,`varistors`.`item_registration_classification` AS `item_registration_classification`,`varistors`.`spice_model` AS `spice_model`,`varistors`.`pcb_footprint` AS `pcb_footprint`,`varistors`.`create_by` AS `create_by`,`varistors`.`create_time` AS `create_time`,`varistors`.`update_by` AS `update_by`,`varistors`.`update_time` AS `update_time`,`varistors`.`del_flag` AS `del_flag`,`varistors`.`remark` AS `remark` from `varistors` union select 'inductors' AS `table_name`,`inductors`.`id` AS `id`,`inductors`.`part_number` AS `part_number`,`inductors`.`part_type` AS `part_type`,`inductors`.`value` AS `value`,`inductors`.`schematic_part` AS `schematic_part`,`inductors`.`rating_voltage` AS `rating_voltage`,`inductors`.`rating_electricity` AS `rating_electricity`,`inductors`.`characteristics` AS `characteristics`,`inductors`.`tolerance` AS `tolerance`,`inductors`.`manufacture` AS `manufacture`,`inductors`.`b_code` AS `b_code`,`inductors`.`parts_name` AS `parts_name`,`inductors`.`item_registration_classification` AS `item_registration_classification`,`inductors`.`spice_model` AS `spice_model`,`inductors`.`pcb_footprint` AS `pcb_footprint`,`inductors`.`create_by` AS `create_by`,`inductors`.`create_time` AS `create_time`,`inductors`.`update_by` AS `update_by`,`inductors`.`update_time` AS `update_time`,`inductors`.`del_flag` AS `del_flag`,`inductors`.`remark` AS `remark` from `inductors` union select 'capacitors' AS `table_name`,`capacitors`.`id` AS `id`,`capacitors`.`part_number` AS `part_number`,`capacitors`.`part_type` AS `part_type`,`capacitors`.`value` AS `value`,`capacitors`.`schematic_part` AS `schematic_part`,`capacitors`.`rating_voltage` AS `rating_voltage`,`capacitors`.`rating_electricity` AS `rating_electricity`,`capacitors`.`characteristics` AS `characteristics`,`capacitors`.`tolerance` AS `tolerance`,`capacitors`.`manufacture` AS `manufacture`,`capacitors`.`b_code` AS `b_code`,`capacitors`.`parts_name` AS `parts_name`,`capacitors`.`item_registration_classification` AS `item_registration_classification`,`capacitors`.`spice_model` AS `spice_model`,`capacitors`.`pcb_footprint` AS `pcb_footprint`,`capacitors`.`create_by` AS `create_by`,`capacitors`.`create_time` AS `create_time`,`capacitors`.`update_by` AS `update_by`,`capacitors`.`update_time` AS `update_time`,`capacitors`.`del_flag` AS `del_flag`,`capacitors`.`remark` AS `remark` from `capacitors` union select 'transformers' AS `table_name`,`transformers`.`id` AS `id`,`transformers`.`part_number` AS `part_number`,`transformers`.`part_type` AS `part_type`,`transformers`.`value` AS `value`,`transformers`.`schematic_part` AS `schematic_part`,`transformers`.`rating_voltage` AS `rating_voltage`,`transformers`.`rating_electricity` AS `rating_electricity`,`transformers`.`characteristics` AS `characteristics`,`transformers`.`tolerance` AS `tolerance`,`transformers`.`manufacture` AS `manufacture`,`transformers`.`b_code` AS `b_code`,`transformers`.`parts_name` AS `parts_name`,`transformers`.`item_registration_classification` AS `item_registration_classification`,`transformers`.`spice_model` AS `spice_model`,`transformers`.`pcb_footprint` AS `pcb_footprint`,`transformers`.`create_by` AS `create_by`,`transformers`.`create_time` AS `create_time`,`transformers`.`update_by` AS `update_by`,`transformers`.`update_time` AS `update_time`,`transformers`.`del_flag` AS `del_flag`,`transformers`.`remark` AS `remark` from `transformers` union select 'electrical_discharge_gaps' AS `table_name`,`electrical_discharge_gaps`.`id` AS `id`,`electrical_discharge_gaps`.`part_number` AS `part_number`,`electrical_discharge_gaps`.`part_type` AS `part_type`,`electrical_discharge_gaps`.`value` AS `value`,`electrical_discharge_gaps`.`schematic_part` AS `schematic_part`,`electrical_discharge_gaps`.`rating_voltage` AS `rating_voltage`,`electrical_discharge_gaps`.`rating_electricity` AS `rating_electricity`,`electrical_discharge_gaps`.`characteristics` AS `characteristics`,`electrical_discharge_gaps`.`tolerance` AS `tolerance`,`electrical_discharge_gaps`.`manufacture` AS `manufacture`,`electrical_discharge_gaps`.`b_code` AS `b_code`,`electrical_discharge_gaps`.`parts_name` AS `parts_name`,`electrical_discharge_gaps`.`item_registration_classification` AS `item_registration_classification`,`electrical_discharge_gaps`.`spice_model` AS `spice_model`,`electrical_discharge_gaps`.`pcb_footprint` AS `pcb_footprint`,`electrical_discharge_gaps`.`create_by` AS `create_by`,`electrical_discharge_gaps`.`create_time` AS `create_time`,`electrical_discharge_gaps`.`update_by` AS `update_by`,`electrical_discharge_gaps`.`update_time` AS `update_time`,`electrical_discharge_gaps`.`del_flag` AS `del_flag`,`electrical_discharge_gaps`.`remark` AS `remark` from `electrical_discharge_gaps` union select 'resonators' AS `table_name`,`resonators`.`id` AS `id`,`resonators`.`part_number` AS `part_number`,`resonators`.`part_type` AS `part_type`,`resonators`.`value` AS `value`,`resonators`.`schematic_part` AS `schematic_part`,`resonators`.`rating_voltage` AS `rating_voltage`,`resonators`.`rating_electricity` AS `rating_electricity`,`resonators`.`characteristics` AS `characteristics`,`resonators`.`tolerance` AS `tolerance`,`resonators`.`manufacture` AS `manufacture`,`resonators`.`b_code` AS `b_code`,`resonators`.`parts_name` AS `parts_name`,`resonators`.`item_registration_classification` AS `item_registration_classification`,`resonators`.`spice_model` AS `spice_model`,`resonators`.`pcb_footprint` AS `pcb_footprint`,`resonators`.`create_by` AS `create_by`,`resonators`.`create_time` AS `create_time`,`resonators`.`update_by` AS `update_by`,`resonators`.`update_time` AS `update_time`,`resonators`.`del_flag` AS `del_flag`,`resonators`.`remark` AS `remark` from `resonators` union select 'electromechanical_transducers' AS `table_name`,`electromechanical_transducers`.`id` AS `id`,`electromechanical_transducers`.`part_number` AS `part_number`,`electromechanical_transducers`.`part_type` AS `part_type`,`electromechanical_transducers`.`value` AS `value`,`electromechanical_transducers`.`schematic_part` AS `schematic_part`,`electromechanical_transducers`.`rating_voltage` AS `rating_voltage`,`electromechanical_transducers`.`rating_electricity` AS `rating_electricity`,`electromechanical_transducers`.`characteristics` AS `characteristics`,`electromechanical_transducers`.`tolerance` AS `tolerance`,`electromechanical_transducers`.`manufacture` AS `manufacture`,`electromechanical_transducers`.`b_code` AS `b_code`,`electromechanical_transducers`.`parts_name` AS `parts_name`,`electromechanical_transducers`.`item_registration_classification` AS `item_registration_classification`,`electromechanical_transducers`.`spice_model` AS `spice_model`,`electromechanical_transducers`.`pcb_footprint` AS `pcb_footprint`,`electromechanical_transducers`.`create_by` AS `create_by`,`electromechanical_transducers`.`create_time` AS `create_time`,`electromechanical_transducers`.`update_by` AS `update_by`,`electromechanical_transducers`.`update_time` AS `update_time`,`electromechanical_transducers`.`del_flag` AS `del_flag`,`electromechanical_transducers`.`remark` AS `remark` from `electromechanical_transducers` union select 'oscillators' AS `table_name`,`oscillators`.`id` AS `id`,`oscillators`.`part_number` AS `part_number`,`oscillators`.`part_type` AS `part_type`,`oscillators`.`value` AS `value`,`oscillators`.`schematic_part` AS `schematic_part`,`oscillators`.`rating_voltage` AS `rating_voltage`,`oscillators`.`rating_electricity` AS `rating_electricity`,`oscillators`.`characteristics` AS `characteristics`,`oscillators`.`tolerance` AS `tolerance`,`oscillators`.`manufacture` AS `manufacture`,`oscillators`.`b_code` AS `b_code`,`oscillators`.`parts_name` AS `parts_name`,`oscillators`.`item_registration_classification` AS `item_registration_classification`,`oscillators`.`spice_model` AS `spice_model`,`oscillators`.`pcb_footprint` AS `pcb_footprint`,`oscillators`.`create_by` AS `create_by`,`oscillators`.`create_time` AS `create_time`,`oscillators`.`update_by` AS `update_by`,`oscillators`.`update_time` AS `update_time`,`oscillators`.`del_flag` AS `del_flag`,`oscillators`.`remark` AS `remark` from `oscillators` union select 'filters' AS `table_name`,`filters`.`id` AS `id`,`filters`.`part_number` AS `part_number`,`filters`.`part_type` AS `part_type`,`filters`.`value` AS `value`,`filters`.`schematic_part` AS `schematic_part`,`filters`.`rating_voltage` AS `rating_voltage`,`filters`.`rating_electricity` AS `rating_electricity`,`filters`.`characteristics` AS `characteristics`,`filters`.`tolerance` AS `tolerance`,`filters`.`manufacture` AS `manufacture`,`filters`.`b_code` AS `b_code`,`filters`.`parts_name` AS `parts_name`,`filters`.`item_registration_classification` AS `item_registration_classification`,`filters`.`spice_model` AS `spice_model`,`filters`.`pcb_footprint` AS `pcb_footprint`,`filters`.`create_by` AS `create_by`,`filters`.`create_time` AS `create_time`,`filters`.`update_by` AS `update_by`,`filters`.`update_time` AS `update_time`,`filters`.`del_flag` AS `del_flag`,`filters`.`remark` AS `remark` from `filters` union select 'delay_lines' AS `table_name`,`delay_lines`.`id` AS `id`,`delay_lines`.`part_number` AS `part_number`,`delay_lines`.`part_type` AS `part_type`,`delay_lines`.`value` AS `value`,`delay_lines`.`schematic_part` AS `schematic_part`,`delay_lines`.`rating_voltage` AS `rating_voltage`,`delay_lines`.`rating_electricity` AS `rating_electricity`,`delay_lines`.`characteristics` AS `characteristics`,`delay_lines`.`tolerance` AS `tolerance`,`delay_lines`.`manufacture` AS `manufacture`,`delay_lines`.`b_code` AS `b_code`,`delay_lines`.`parts_name` AS `parts_name`,`delay_lines`.`item_registration_classification` AS `item_registration_classification`,`delay_lines`.`spice_model` AS `spice_model`,`delay_lines`.`pcb_footprint` AS `pcb_footprint`,`delay_lines`.`create_by` AS `create_by`,`delay_lines`.`create_time` AS `create_time`,`delay_lines`.`update_by` AS `update_by`,`delay_lines`.`update_time` AS `update_time`,`delay_lines`.`del_flag` AS `del_flag`,`delay_lines`.`remark` AS `remark` from `delay_lines` union select 'microwave_components' AS `table_name`,`microwave_components`.`id` AS `id`,`microwave_components`.`part_number` AS `part_number`,`microwave_components`.`part_type` AS `part_type`,`microwave_components`.`value` AS `value`,`microwave_components`.`schematic_part` AS `schematic_part`,`microwave_components`.`rating_voltage` AS `rating_voltage`,`microwave_components`.`rating_electricity` AS `rating_electricity`,`microwave_components`.`characteristics` AS `characteristics`,`microwave_components`.`tolerance` AS `tolerance`,`microwave_components`.`manufacture` AS `manufacture`,`microwave_components`.`b_code` AS `b_code`,`microwave_components`.`parts_name` AS `parts_name`,`microwave_components`.`item_registration_classification` AS `item_registration_classification`,`microwave_components`.`spice_model` AS `spice_model`,`microwave_components`.`pcb_footprint` AS `pcb_footprint`,`microwave_components`.`create_by` AS `create_by`,`microwave_components`.`create_time` AS `create_time`,`microwave_components`.`update_by` AS `update_by`,`microwave_components`.`update_time` AS `update_time`,`microwave_components`.`del_flag` AS `del_flag`,`microwave_components`.`remark` AS `remark` from `microwave_components` union select 'function_circuit_modules' AS `table_name`,`function_circuit_modules`.`id` AS `id`,`function_circuit_modules`.`part_number` AS `part_number`,`function_circuit_modules`.`part_type` AS `part_type`,`function_circuit_modules`.`value` AS `value`,`function_circuit_modules`.`schematic_part` AS `schematic_part`,`function_circuit_modules`.`rating_voltage` AS `rating_voltage`,`function_circuit_modules`.`rating_electricity` AS `rating_electricity`,`function_circuit_modules`.`characteristics` AS `characteristics`,`function_circuit_modules`.`tolerance` AS `tolerance`,`function_circuit_modules`.`manufacture` AS `manufacture`,`function_circuit_modules`.`b_code` AS `b_code`,`function_circuit_modules`.`parts_name` AS `parts_name`,`function_circuit_modules`.`item_registration_classification` AS `item_registration_classification`,`function_circuit_modules`.`spice_model` AS `spice_model`,`function_circuit_modules`.`pcb_footprint` AS `pcb_footprint`,`function_circuit_modules`.`create_by` AS `create_by`,`function_circuit_modules`.`create_time` AS `create_time`,`function_circuit_modules`.`update_by` AS `update_by`,`function_circuit_modules`.`update_time` AS `update_time`,`function_circuit_modules`.`del_flag` AS `del_flag`,`function_circuit_modules`.`remark` AS `remark` from `function_circuit_modules` union select 'switches' AS `table_name`,`switches`.`id` AS `id`,`switches`.`part_number` AS `part_number`,`switches`.`part_type` AS `part_type`,`switches`.`value` AS `value`,`switches`.`schematic_part` AS `schematic_part`,`switches`.`rating_voltage` AS `rating_voltage`,`switches`.`rating_electricity` AS `rating_electricity`,`switches`.`characteristics` AS `characteristics`,`switches`.`tolerance` AS `tolerance`,`switches`.`manufacture` AS `manufacture`,`switches`.`b_code` AS `b_code`,`switches`.`parts_name` AS `parts_name`,`switches`.`item_registration_classification` AS `item_registration_classification`,`switches`.`spice_model` AS `spice_model`,`switches`.`pcb_footprint` AS `pcb_footprint`,`switches`.`create_by` AS `create_by`,`switches`.`create_time` AS `create_time`,`switches`.`update_by` AS `update_by`,`switches`.`update_time` AS `update_time`,`switches`.`del_flag` AS `del_flag`,`switches`.`remark` AS `remark` from `switches` union select 'connectors' AS `table_name`,`connectors`.`id` AS `id`,`connectors`.`part_number` AS `part_number`,`connectors`.`part_type` AS `part_type`,`connectors`.`value` AS `value`,`connectors`.`schematic_part` AS `schematic_part`,`connectors`.`rating_voltage` AS `rating_voltage`,`connectors`.`rating_electricity` AS `rating_electricity`,`connectors`.`characteristics` AS `characteristics`,`connectors`.`tolerance` AS `tolerance`,`connectors`.`manufacture` AS `manufacture`,`connectors`.`b_code` AS `b_code`,`connectors`.`parts_name` AS `parts_name`,`connectors`.`item_registration_classification` AS `item_registration_classification`,`connectors`.`spice_model` AS `spice_model`,`connectors`.`pcb_footprint` AS `pcb_footprint`,`connectors`.`create_by` AS `create_by`,`connectors`.`create_time` AS `create_time`,`connectors`.`update_by` AS `update_by`,`connectors`.`update_time` AS `update_time`,`connectors`.`del_flag` AS `del_flag`,`connectors`.`remark` AS `remark` from `connectors` union select 'sockets' AS `table_name`,`sockets`.`id` AS `id`,`sockets`.`part_number` AS `part_number`,`sockets`.`part_type` AS `part_type`,`sockets`.`value` AS `value`,`sockets`.`schematic_part` AS `schematic_part`,`sockets`.`rating_voltage` AS `rating_voltage`,`sockets`.`rating_electricity` AS `rating_electricity`,`sockets`.`characteristics` AS `characteristics`,`sockets`.`tolerance` AS `tolerance`,`sockets`.`manufacture` AS `manufacture`,`sockets`.`b_code` AS `b_code`,`sockets`.`parts_name` AS `parts_name`,`sockets`.`item_registration_classification` AS `item_registration_classification`,`sockets`.`spice_model` AS `spice_model`,`sockets`.`pcb_footprint` AS `pcb_footprint`,`sockets`.`create_by` AS `create_by`,`sockets`.`create_time` AS `create_time`,`sockets`.`update_by` AS `update_by`,`sockets`.`update_time` AS `update_time`,`sockets`.`del_flag` AS `del_flag`,`sockets`.`remark` AS `remark` from `sockets` union select 'fuses' AS `table_name`,`fuses`.`id` AS `id`,`fuses`.`part_number` AS `part_number`,`fuses`.`part_type` AS `part_type`,`fuses`.`value` AS `value`,`fuses`.`schematic_part` AS `schematic_part`,`fuses`.`rating_voltage` AS `rating_voltage`,`fuses`.`rating_electricity` AS `rating_electricity`,`fuses`.`characteristics` AS `characteristics`,`fuses`.`tolerance` AS `tolerance`,`fuses`.`manufacture` AS `manufacture`,`fuses`.`b_code` AS `b_code`,`fuses`.`parts_name` AS `parts_name`,`fuses`.`item_registration_classification` AS `item_registration_classification`,`fuses`.`spice_model` AS `spice_model`,`fuses`.`pcb_footprint` AS `pcb_footprint`,`fuses`.`create_by` AS `create_by`,`fuses`.`create_time` AS `create_time`,`fuses`.`update_by` AS `update_by`,`fuses`.`update_time` AS `update_time`,`fuses`.`del_flag` AS `del_flag`,`fuses`.`remark` AS `remark` from `fuses` union select 'circuit_breakers_for_equipment_protection' AS `table_name`,`circuit_breakers_for_equipment_protection`.`id` AS `id`,`circuit_breakers_for_equipment_protection`.`part_number` AS `part_number`,`circuit_breakers_for_equipment_protection`.`part_type` AS `part_type`,`circuit_breakers_for_equipment_protection`.`value` AS `value`,`circuit_breakers_for_equipment_protection`.`schematic_part` AS `schematic_part`,`circuit_breakers_for_equipment_protection`.`rating_voltage` AS `rating_voltage`,`circuit_breakers_for_equipment_protection`.`rating_electricity` AS `rating_electricity`,`circuit_breakers_for_equipment_protection`.`characteristics` AS `characteristics`,`circuit_breakers_for_equipment_protection`.`tolerance` AS `tolerance`,`circuit_breakers_for_equipment_protection`.`manufacture` AS `manufacture`,`circuit_breakers_for_equipment_protection`.`b_code` AS `b_code`,`circuit_breakers_for_equipment_protection`.`parts_name` AS `parts_name`,`circuit_breakers_for_equipment_protection`.`item_registration_classification` AS `item_registration_classification`,`circuit_breakers_for_equipment_protection`.`spice_model` AS `spice_model`,`circuit_breakers_for_equipment_protection`.`pcb_footprint` AS `pcb_footprint`,`circuit_breakers_for_equipment_protection`.`create_by` AS `create_by`,`circuit_breakers_for_equipment_protection`.`create_time` AS `create_time`,`circuit_breakers_for_equipment_protection`.`update_by` AS `update_by`,`circuit_breakers_for_equipment_protection`.`update_time` AS `update_time`,`circuit_breakers_for_equipment_protection`.`del_flag` AS `del_flag`,`circuit_breakers_for_equipment_protection`.`remark` AS `remark` from `circuit_breakers_for_equipment_protection` union select 'terminals' AS `table_name`,`terminals`.`id` AS `id`,`terminals`.`part_number` AS `part_number`,`terminals`.`part_type` AS `part_type`,`terminals`.`value` AS `value`,`terminals`.`schematic_part` AS `schematic_part`,`terminals`.`rating_voltage` AS `rating_voltage`,`terminals`.`rating_electricity` AS `rating_electricity`,`terminals`.`characteristics` AS `characteristics`,`terminals`.`tolerance` AS `tolerance`,`terminals`.`manufacture` AS `manufacture`,`terminals`.`b_code` AS `b_code`,`terminals`.`parts_name` AS `parts_name`,`terminals`.`item_registration_classification` AS `item_registration_classification`,`terminals`.`spice_model` AS `spice_model`,`terminals`.`pcb_footprint` AS `pcb_footprint`,`terminals`.`create_by` AS `create_by`,`terminals`.`create_time` AS `create_time`,`terminals`.`update_by` AS `update_by`,`terminals`.`update_time` AS `update_time`,`terminals`.`del_flag` AS `del_flag`,`terminals`.`remark` AS `remark` from `terminals` union select 'relays' AS `table_name`,`relays`.`id` AS `id`,`relays`.`part_number` AS `part_number`,`relays`.`part_type` AS `part_type`,`relays`.`value` AS `value`,`relays`.`schematic_part` AS `schematic_part`,`relays`.`rating_voltage` AS `rating_voltage`,`relays`.`rating_electricity` AS `rating_electricity`,`relays`.`characteristics` AS `characteristics`,`relays`.`tolerance` AS `tolerance`,`relays`.`manufacture` AS `manufacture`,`relays`.`b_code` AS `b_code`,`relays`.`parts_name` AS `parts_name`,`relays`.`item_registration_classification` AS `item_registration_classification`,`relays`.`spice_model` AS `spice_model`,`relays`.`pcb_footprint` AS `pcb_footprint`,`relays`.`create_by` AS `create_by`,`relays`.`create_time` AS `create_time`,`relays`.`update_by` AS `update_by`,`relays`.`update_time` AS `update_time`,`relays`.`del_flag` AS `del_flag`,`relays`.`remark` AS `remark` from `relays` union select 'optical_parts' AS `table_name`,`optical_parts`.`id` AS `id`,`optical_parts`.`part_number` AS `part_number`,`optical_parts`.`part_type` AS `part_type`,`optical_parts`.`value` AS `value`,`optical_parts`.`schematic_part` AS `schematic_part`,`optical_parts`.`rating_voltage` AS `rating_voltage`,`optical_parts`.`rating_electricity` AS `rating_electricity`,`optical_parts`.`characteristics` AS `characteristics`,`optical_parts`.`tolerance` AS `tolerance`,`optical_parts`.`manufacture` AS `manufacture`,`optical_parts`.`b_code` AS `b_code`,`optical_parts`.`parts_name` AS `parts_name`,`optical_parts`.`item_registration_classification` AS `item_registration_classification`,`optical_parts`.`spice_model` AS `spice_model`,`optical_parts`.`pcb_footprint` AS `pcb_footprint`,`optical_parts`.`create_by` AS `create_by`,`optical_parts`.`create_time` AS `create_time`,`optical_parts`.`update_by` AS `update_by`,`optical_parts`.`update_time` AS `update_time`,`optical_parts`.`del_flag` AS `del_flag`,`optical_parts`.`remark` AS `remark` from `optical_parts` union select 'loudspeakers' AS `table_name`,`loudspeakers`.`id` AS `id`,`loudspeakers`.`part_number` AS `part_number`,`loudspeakers`.`part_type` AS `part_type`,`loudspeakers`.`value` AS `value`,`loudspeakers`.`schematic_part` AS `schematic_part`,`loudspeakers`.`rating_voltage` AS `rating_voltage`,`loudspeakers`.`rating_electricity` AS `rating_electricity`,`loudspeakers`.`characteristics` AS `characteristics`,`loudspeakers`.`tolerance` AS `tolerance`,`loudspeakers`.`manufacture` AS `manufacture`,`loudspeakers`.`b_code` AS `b_code`,`loudspeakers`.`parts_name` AS `parts_name`,`loudspeakers`.`item_registration_classification` AS `item_registration_classification`,`loudspeakers`.`spice_model` AS `spice_model`,`loudspeakers`.`pcb_footprint` AS `pcb_footprint`,`loudspeakers`.`create_by` AS `create_by`,`loudspeakers`.`create_time` AS `create_time`,`loudspeakers`.`update_by` AS `update_by`,`loudspeakers`.`update_time` AS `update_time`,`loudspeakers`.`del_flag` AS `del_flag`,`loudspeakers`.`remark` AS `remark` from `loudspeakers` union select 'microphones' AS `table_name`,`microphones`.`id` AS `id`,`microphones`.`part_number` AS `part_number`,`microphones`.`part_type` AS `part_type`,`microphones`.`value` AS `value`,`microphones`.`schematic_part` AS `schematic_part`,`microphones`.`rating_voltage` AS `rating_voltage`,`microphones`.`rating_electricity` AS `rating_electricity`,`microphones`.`characteristics` AS `characteristics`,`microphones`.`tolerance` AS `tolerance`,`microphones`.`manufacture` AS `manufacture`,`microphones`.`b_code` AS `b_code`,`microphones`.`parts_name` AS `parts_name`,`microphones`.`item_registration_classification` AS `item_registration_classification`,`microphones`.`spice_model` AS `spice_model`,`microphones`.`pcb_footprint` AS `pcb_footprint`,`microphones`.`create_by` AS `create_by`,`microphones`.`create_time` AS `create_time`,`microphones`.`update_by` AS `update_by`,`microphones`.`update_time` AS `update_time`,`microphones`.`del_flag` AS `del_flag`,`microphones`.`remark` AS `remark` from `microphones` union select 'buzzers_sounders' AS `table_name`,`buzzers_sounders`.`id` AS `id`,`buzzers_sounders`.`part_number` AS `part_number`,`buzzers_sounders`.`part_type` AS `part_type`,`buzzers_sounders`.`value` AS `value`,`buzzers_sounders`.`schematic_part` AS `schematic_part`,`buzzers_sounders`.`rating_voltage` AS `rating_voltage`,`buzzers_sounders`.`rating_electricity` AS `rating_electricity`,`buzzers_sounders`.`characteristics` AS `characteristics`,`buzzers_sounders`.`tolerance` AS `tolerance`,`buzzers_sounders`.`manufacture` AS `manufacture`,`buzzers_sounders`.`b_code` AS `b_code`,`buzzers_sounders`.`parts_name` AS `parts_name`,`buzzers_sounders`.`item_registration_classification` AS `item_registration_classification`,`buzzers_sounders`.`spice_model` AS `spice_model`,`buzzers_sounders`.`pcb_footprint` AS `pcb_footprint`,`buzzers_sounders`.`create_by` AS `create_by`,`buzzers_sounders`.`create_time` AS `create_time`,`buzzers_sounders`.`update_by` AS `update_by`,`buzzers_sounders`.`update_time` AS `update_time`,`buzzers_sounders`.`del_flag` AS `del_flag`,`buzzers_sounders`.`remark` AS `remark` from `buzzers_sounders` union select 'sensors' AS `table_name`,`sensors`.`id` AS `id`,`sensors`.`part_number` AS `part_number`,`sensors`.`part_type` AS `part_type`,`sensors`.`value` AS `value`,`sensors`.`schematic_part` AS `schematic_part`,`sensors`.`rating_voltage` AS `rating_voltage`,`sensors`.`rating_electricity` AS `rating_electricity`,`sensors`.`characteristics` AS `characteristics`,`sensors`.`tolerance` AS `tolerance`,`sensors`.`manufacture` AS `manufacture`,`sensors`.`b_code` AS `b_code`,`sensors`.`parts_name` AS `parts_name`,`sensors`.`item_registration_classification` AS `item_registration_classification`,`sensors`.`spice_model` AS `spice_model`,`sensors`.`pcb_footprint` AS `pcb_footprint`,`sensors`.`create_by` AS `create_by`,`sensors`.`create_time` AS `create_time`,`sensors`.`update_by` AS `update_by`,`sensors`.`update_time` AS `update_time`,`sensors`.`del_flag` AS `del_flag`,`sensors`.`remark` AS `remark` from `sensors` union select 'power_supplies' AS `table_name`,`power_supplies`.`id` AS `id`,`power_supplies`.`part_number` AS `part_number`,`power_supplies`.`part_type` AS `part_type`,`power_supplies`.`value` AS `value`,`power_supplies`.`schematic_part` AS `schematic_part`,`power_supplies`.`rating_voltage` AS `rating_voltage`,`power_supplies`.`rating_electricity` AS `rating_electricity`,`power_supplies`.`characteristics` AS `characteristics`,`power_supplies`.`tolerance` AS `tolerance`,`power_supplies`.`manufacture` AS `manufacture`,`power_supplies`.`b_code` AS `b_code`,`power_supplies`.`parts_name` AS `parts_name`,`power_supplies`.`item_registration_classification` AS `item_registration_classification`,`power_supplies`.`spice_model` AS `spice_model`,`power_supplies`.`pcb_footprint` AS `pcb_footprint`,`power_supplies`.`create_by` AS `create_by`,`power_supplies`.`create_time` AS `create_time`,`power_supplies`.`update_by` AS `update_by`,`power_supplies`.`update_time` AS `update_time`,`power_supplies`.`del_flag` AS `del_flag`,`power_supplies`.`remark` AS `remark` from `power_supplies` union select 'antennas' AS `table_name`,`antennas`.`id` AS `id`,`antennas`.`part_number` AS `part_number`,`antennas`.`part_type` AS `part_type`,`antennas`.`value` AS `value`,`antennas`.`schematic_part` AS `schematic_part`,`antennas`.`rating_voltage` AS `rating_voltage`,`antennas`.`rating_electricity` AS `rating_electricity`,`antennas`.`characteristics` AS `characteristics`,`antennas`.`tolerance` AS `tolerance`,`antennas`.`manufacture` AS `manufacture`,`antennas`.`b_code` AS `b_code`,`antennas`.`parts_name` AS `parts_name`,`antennas`.`item_registration_classification` AS `item_registration_classification`,`antennas`.`spice_model` AS `spice_model`,`antennas`.`pcb_footprint` AS `pcb_footprint`,`antennas`.`create_by` AS `create_by`,`antennas`.`create_time` AS `create_time`,`antennas`.`update_by` AS `update_by`,`antennas`.`update_time` AS `update_time`,`antennas`.`del_flag` AS `del_flag`,`antennas`.`remark` AS `remark` from `antennas` union select 'rf_components' AS `table_name`,`rf_components`.`id` AS `id`,`rf_components`.`part_number` AS `part_number`,`rf_components`.`part_type` AS `part_type`,`rf_components`.`value` AS `value`,`rf_components`.`schematic_part` AS `schematic_part`,`rf_components`.`rating_voltage` AS `rating_voltage`,`rf_components`.`rating_electricity` AS `rating_electricity`,`rf_components`.`characteristics` AS `characteristics`,`rf_components`.`tolerance` AS `tolerance`,`rf_components`.`manufacture` AS `manufacture`,`rf_components`.`b_code` AS `b_code`,`rf_components`.`parts_name` AS `parts_name`,`rf_components`.`item_registration_classification` AS `item_registration_classification`,`rf_components`.`spice_model` AS `spice_model`,`rf_components`.`pcb_footprint` AS `pcb_footprint`,`rf_components`.`create_by` AS `create_by`,`rf_components`.`create_time` AS `create_time`,`rf_components`.`update_by` AS `update_by`,`rf_components`.`update_time` AS `update_time`,`rf_components`.`del_flag` AS `del_flag`,`rf_components`.`remark` AS `remark` from `rf_components` union select 'emi_emc_countermeasure_parts' AS `table_name`,`emi_emc_countermeasure_parts`.`id` AS `id`,`emi_emc_countermeasure_parts`.`part_number` AS `part_number`,`emi_emc_countermeasure_parts`.`part_type` AS `part_type`,`emi_emc_countermeasure_parts`.`value` AS `value`,`emi_emc_countermeasure_parts`.`schematic_part` AS `schematic_part`,`emi_emc_countermeasure_parts`.`rating_voltage` AS `rating_voltage`,`emi_emc_countermeasure_parts`.`rating_electricity` AS `rating_electricity`,`emi_emc_countermeasure_parts`.`characteristics` AS `characteristics`,`emi_emc_countermeasure_parts`.`tolerance` AS `tolerance`,`emi_emc_countermeasure_parts`.`manufacture` AS `manufacture`,`emi_emc_countermeasure_parts`.`b_code` AS `b_code`,`emi_emc_countermeasure_parts`.`parts_name` AS `parts_name`,`emi_emc_countermeasure_parts`.`item_registration_classification` AS `item_registration_classification`,`emi_emc_countermeasure_parts`.`spice_model` AS `spice_model`,`emi_emc_countermeasure_parts`.`pcb_footprint` AS `pcb_footprint`,`emi_emc_countermeasure_parts`.`create_by` AS `create_by`,`emi_emc_countermeasure_parts`.`create_time` AS `create_time`,`emi_emc_countermeasure_parts`.`update_by` AS `update_by`,`emi_emc_countermeasure_parts`.`update_time` AS `update_time`,`emi_emc_countermeasure_parts`.`del_flag` AS `del_flag`,`emi_emc_countermeasure_parts`.`remark` AS `remark` from `emi_emc_countermeasure_parts` union select 'batteries' AS `table_name`,`batteries`.`id` AS `id`,`batteries`.`part_number` AS `part_number`,`batteries`.`part_type` AS `part_type`,`batteries`.`value` AS `value`,`batteries`.`schematic_part` AS `schematic_part`,`batteries`.`rating_voltage` AS `rating_voltage`,`batteries`.`rating_electricity` AS `rating_electricity`,`batteries`.`characteristics` AS `characteristics`,`batteries`.`tolerance` AS `tolerance`,`batteries`.`manufacture` AS `manufacture`,`batteries`.`b_code` AS `b_code`,`batteries`.`parts_name` AS `parts_name`,`batteries`.`item_registration_classification` AS `item_registration_classification`,`batteries`.`spice_model` AS `spice_model`,`batteries`.`pcb_footprint` AS `pcb_footprint`,`batteries`.`create_by` AS `create_by`,`batteries`.`create_time` AS `create_time`,`batteries`.`update_by` AS `update_by`,`batteries`.`update_time` AS `update_time`,`batteries`.`del_flag` AS `del_flag`,`batteries`.`remark` AS `remark` from `batteries` union select 'lamps' AS `table_name`,`lamps`.`id` AS `id`,`lamps`.`part_number` AS `part_number`,`lamps`.`part_type` AS `part_type`,`lamps`.`value` AS `value`,`lamps`.`schematic_part` AS `schematic_part`,`lamps`.`rating_voltage` AS `rating_voltage`,`lamps`.`rating_electricity` AS `rating_electricity`,`lamps`.`characteristics` AS `characteristics`,`lamps`.`tolerance` AS `tolerance`,`lamps`.`manufacture` AS `manufacture`,`lamps`.`b_code` AS `b_code`,`lamps`.`parts_name` AS `parts_name`,`lamps`.`item_registration_classification` AS `item_registration_classification`,`lamps`.`spice_model` AS `spice_model`,`lamps`.`pcb_footprint` AS `pcb_footprint`,`lamps`.`create_by` AS `create_by`,`lamps`.`create_time` AS `create_time`,`lamps`.`update_by` AS `update_by`,`lamps`.`update_time` AS `update_time`,`lamps`.`del_flag` AS `del_flag`,`lamps`.`remark` AS `remark` from `lamps` union select 'memories' AS `table_name`,`memories`.`id` AS `id`,`memories`.`part_number` AS `part_number`,`memories`.`part_type` AS `part_type`,`memories`.`value` AS `value`,`memories`.`schematic_part` AS `schematic_part`,`memories`.`rating_voltage` AS `rating_voltage`,`memories`.`rating_electricity` AS `rating_electricity`,`memories`.`characteristics` AS `characteristics`,`memories`.`tolerance` AS `tolerance`,`memories`.`manufacture` AS `manufacture`,`memories`.`b_code` AS `b_code`,`memories`.`parts_name` AS `parts_name`,`memories`.`item_registration_classification` AS `item_registration_classification`,`memories`.`spice_model` AS `spice_model`,`memories`.`pcb_footprint` AS `pcb_footprint`,`memories`.`create_by` AS `create_by`,`memories`.`create_time` AS `create_time`,`memories`.`update_by` AS `update_by`,`memories`.`update_time` AS `update_time`,`memories`.`del_flag` AS `del_flag`,`memories`.`remark` AS `remark` from `memories` union select 'ics' AS `table_name`,`ics`.`id` AS `id`,`ics`.`part_number` AS `part_number`,`ics`.`part_type` AS `part_type`,`ics`.`value` AS `value`,`ics`.`schematic_part` AS `schematic_part`,`ics`.`rating_voltage` AS `rating_voltage`,`ics`.`rating_electricity` AS `rating_electricity`,`ics`.`characteristics` AS `characteristics`,`ics`.`tolerance` AS `tolerance`,`ics`.`manufacture` AS `manufacture`,`ics`.`b_code` AS `b_code`,`ics`.`parts_name` AS `parts_name`,`ics`.`item_registration_classification` AS `item_registration_classification`,`ics`.`spice_model` AS `spice_model`,`ics`.`pcb_footprint` AS `pcb_footprint`,`ics`.`create_by` AS `create_by`,`ics`.`create_time` AS `create_time`,`ics`.`update_by` AS `update_by`,`ics`.`update_time` AS `update_time`,`ics`.`del_flag` AS `del_flag`,`ics`.`remark` AS `remark` from `ics` union select 'opto_electronic_devices' AS `table_name`,`opto_electronic_devices`.`id` AS `id`,`opto_electronic_devices`.`part_number` AS `part_number`,`opto_electronic_devices`.`part_type` AS `part_type`,`opto_electronic_devices`.`value` AS `value`,`opto_electronic_devices`.`schematic_part` AS `schematic_part`,`opto_electronic_devices`.`rating_voltage` AS `rating_voltage`,`opto_electronic_devices`.`rating_electricity` AS `rating_electricity`,`opto_electronic_devices`.`characteristics` AS `characteristics`,`opto_electronic_devices`.`tolerance` AS `tolerance`,`opto_electronic_devices`.`manufacture` AS `manufacture`,`opto_electronic_devices`.`b_code` AS `b_code`,`opto_electronic_devices`.`parts_name` AS `parts_name`,`opto_electronic_devices`.`item_registration_classification` AS `item_registration_classification`,`opto_electronic_devices`.`spice_model` AS `spice_model`,`opto_electronic_devices`.`pcb_footprint` AS `pcb_footprint`,`opto_electronic_devices`.`create_by` AS `create_by`,`opto_electronic_devices`.`create_time` AS `create_time`,`opto_electronic_devices`.`update_by` AS `update_by`,`opto_electronic_devices`.`update_time` AS `update_time`,`opto_electronic_devices`.`del_flag` AS `del_flag`,`opto_electronic_devices`.`remark` AS `remark` from `opto_electronic_devices` union select 'transistors' AS `table_name`,`transistors`.`id` AS `id`,`transistors`.`part_number` AS `part_number`,`transistors`.`part_type` AS `part_type`,`transistors`.`value` AS `value`,`transistors`.`schematic_part` AS `schematic_part`,`transistors`.`rating_voltage` AS `rating_voltage`,`transistors`.`rating_electricity` AS `rating_electricity`,`transistors`.`characteristics` AS `characteristics`,`transistors`.`tolerance` AS `tolerance`,`transistors`.`manufacture` AS `manufacture`,`transistors`.`b_code` AS `b_code`,`transistors`.`parts_name` AS `parts_name`,`transistors`.`item_registration_classification` AS `item_registration_classification`,`transistors`.`spice_model` AS `spice_model`,`transistors`.`pcb_footprint` AS `pcb_footprint`,`transistors`.`create_by` AS `create_by`,`transistors`.`create_time` AS `create_time`,`transistors`.`update_by` AS `update_by`,`transistors`.`update_time` AS `update_time`,`transistors`.`del_flag` AS `del_flag`,`transistors`.`remark` AS `remark` from `transistors` union select 'diodes' AS `table_name`,`diodes`.`id` AS `id`,`diodes`.`part_number` AS `part_number`,`diodes`.`part_type` AS `part_type`,`diodes`.`value` AS `value`,`diodes`.`schematic_part` AS `schematic_part`,`diodes`.`rating_voltage` AS `rating_voltage`,`diodes`.`rating_electricity` AS `rating_electricity`,`diodes`.`characteristics` AS `characteristics`,`diodes`.`tolerance` AS `tolerance`,`diodes`.`manufacture` AS `manufacture`,`diodes`.`b_code` AS `b_code`,`diodes`.`parts_name` AS `parts_name`,`diodes`.`item_registration_classification` AS `item_registration_classification`,`diodes`.`spice_model` AS `spice_model`,`diodes`.`pcb_footprint` AS `pcb_footprint`,`diodes`.`create_by` AS `create_by`,`diodes`.`create_time` AS `create_time`,`diodes`.`update_by` AS `update_by`,`diodes`.`update_time` AS `update_time`,`diodes`.`del_flag` AS `del_flag`,`diodes`.`remark` AS `remark` from `diodes` union select 'image_pickup_devices' AS `table_name`,`image_pickup_devices`.`id` AS `id`,`image_pickup_devices`.`part_number` AS `part_number`,`image_pickup_devices`.`part_type` AS `part_type`,`image_pickup_devices`.`value` AS `value`,`image_pickup_devices`.`schematic_part` AS `schematic_part`,`image_pickup_devices`.`rating_voltage` AS `rating_voltage`,`image_pickup_devices`.`rating_electricity` AS `rating_electricity`,`image_pickup_devices`.`characteristics` AS `characteristics`,`image_pickup_devices`.`tolerance` AS `tolerance`,`image_pickup_devices`.`manufacture` AS `manufacture`,`image_pickup_devices`.`b_code` AS `b_code`,`image_pickup_devices`.`parts_name` AS `parts_name`,`image_pickup_devices`.`item_registration_classification` AS `item_registration_classification`,`image_pickup_devices`.`spice_model` AS `spice_model`,`image_pickup_devices`.`pcb_footprint` AS `pcb_footprint`,`image_pickup_devices`.`create_by` AS `create_by`,`image_pickup_devices`.`create_time` AS `create_time`,`image_pickup_devices`.`update_by` AS `update_by`,`image_pickup_devices`.`update_time` AS `update_time`,`image_pickup_devices`.`del_flag` AS `del_flag`,`image_pickup_devices`.`remark` AS `remark` from `image_pickup_devices` union select 'thyristors' AS `table_name`,`thyristors`.`id` AS `id`,`thyristors`.`part_number` AS `part_number`,`thyristors`.`part_type` AS `part_type`,`thyristors`.`value` AS `value`,`thyristors`.`schematic_part` AS `schematic_part`,`thyristors`.`rating_voltage` AS `rating_voltage`,`thyristors`.`rating_electricity` AS `rating_electricity`,`thyristors`.`characteristics` AS `characteristics`,`thyristors`.`tolerance` AS `tolerance`,`thyristors`.`manufacture` AS `manufacture`,`thyristors`.`b_code` AS `b_code`,`thyristors`.`parts_name` AS `parts_name`,`thyristors`.`item_registration_classification` AS `item_registration_classification`,`thyristors`.`spice_model` AS `spice_model`,`thyristors`.`pcb_footprint` AS `pcb_footprint`,`thyristors`.`create_by` AS `create_by`,`thyristors`.`create_time` AS `create_time`,`thyristors`.`update_by` AS `update_by`,`thyristors`.`update_time` AS `update_time`,`thyristors`.`del_flag` AS `del_flag`,`thyristors`.`remark` AS `remark` from `thyristors` union select 'multi_chip_discrete_devices' AS `table_name`,`multi_chip_discrete_devices`.`id` AS `id`,`multi_chip_discrete_devices`.`part_number` AS `part_number`,`multi_chip_discrete_devices`.`part_type` AS `part_type`,`multi_chip_discrete_devices`.`value` AS `value`,`multi_chip_discrete_devices`.`schematic_part` AS `schematic_part`,`multi_chip_discrete_devices`.`rating_voltage` AS `rating_voltage`,`multi_chip_discrete_devices`.`rating_electricity` AS `rating_electricity`,`multi_chip_discrete_devices`.`characteristics` AS `characteristics`,`multi_chip_discrete_devices`.`tolerance` AS `tolerance`,`multi_chip_discrete_devices`.`manufacture` AS `manufacture`,`multi_chip_discrete_devices`.`b_code` AS `b_code`,`multi_chip_discrete_devices`.`parts_name` AS `parts_name`,`multi_chip_discrete_devices`.`item_registration_classification` AS `item_registration_classification`,`multi_chip_discrete_devices`.`spice_model` AS `spice_model`,`multi_chip_discrete_devices`.`pcb_footprint` AS `pcb_footprint`,`multi_chip_discrete_devices`.`create_by` AS `create_by`,`multi_chip_discrete_devices`.`create_time` AS `create_time`,`multi_chip_discrete_devices`.`update_by` AS `update_by`,`multi_chip_discrete_devices`.`update_time` AS `update_time`,`multi_chip_discrete_devices`.`del_flag` AS `del_flag`,`multi_chip_discrete_devices`.`remark` AS `remark` from `multi_chip_discrete_devices` union select 'liquid_crystal_display' AS `table_name`,`liquid_crystal_display`.`id` AS `id`,`liquid_crystal_display`.`part_number` AS `part_number`,`liquid_crystal_display`.`part_type` AS `part_type`,`liquid_crystal_display`.`value` AS `value`,`liquid_crystal_display`.`schematic_part` AS `schematic_part`,`liquid_crystal_display`.`rating_voltage` AS `rating_voltage`,`liquid_crystal_display`.`rating_electricity` AS `rating_electricity`,`liquid_crystal_display`.`characteristics` AS `characteristics`,`liquid_crystal_display`.`tolerance` AS `tolerance`,`liquid_crystal_display`.`manufacture` AS `manufacture`,`liquid_crystal_display`.`b_code` AS `b_code`,`liquid_crystal_display`.`parts_name` AS `parts_name`,`liquid_crystal_display`.`item_registration_classification` AS `item_registration_classification`,`liquid_crystal_display`.`spice_model` AS `spice_model`,`liquid_crystal_display`.`pcb_footprint` AS `pcb_footprint`,`liquid_crystal_display`.`create_by` AS `create_by`,`liquid_crystal_display`.`create_time` AS `create_time`,`liquid_crystal_display`.`update_by` AS `update_by`,`liquid_crystal_display`.`update_time` AS `update_time`,`liquid_crystal_display`.`del_flag` AS `del_flag`,`liquid_crystal_display`.`remark` AS `remark` from `liquid_crystal_display` union select 'organic_electroluminescent_display' AS `table_name`,`organic_electroluminescent_display`.`id` AS `id`,`organic_electroluminescent_display`.`part_number` AS `part_number`,`organic_electroluminescent_display`.`part_type` AS `part_type`,`organic_electroluminescent_display`.`value` AS `value`,`organic_electroluminescent_display`.`schematic_part` AS `schematic_part`,`organic_electroluminescent_display`.`rating_voltage` AS `rating_voltage`,`organic_electroluminescent_display`.`rating_electricity` AS `rating_electricity`,`organic_electroluminescent_display`.`characteristics` AS `characteristics`,`organic_electroluminescent_display`.`tolerance` AS `tolerance`,`organic_electroluminescent_display`.`manufacture` AS `manufacture`,`organic_electroluminescent_display`.`b_code` AS `b_code`,`organic_electroluminescent_display`.`parts_name` AS `parts_name`,`organic_electroluminescent_display`.`item_registration_classification` AS `item_registration_classification`,`organic_electroluminescent_display`.`spice_model` AS `spice_model`,`organic_electroluminescent_display`.`pcb_footprint` AS `pcb_footprint`,`organic_electroluminescent_display`.`create_by` AS `create_by`,`organic_electroluminescent_display`.`create_time` AS `create_time`,`organic_electroluminescent_display`.`update_by` AS `update_by`,`organic_electroluminescent_display`.`update_time` AS `update_time`,`organic_electroluminescent_display`.`del_flag` AS `del_flag`,`organic_electroluminescent_display`.`remark` AS `remark` from `organic_electroluminescent_display` union select 'plasma_display_device' AS `table_name`,`plasma_display_device`.`id` AS `id`,`plasma_display_device`.`part_number` AS `part_number`,`plasma_display_device`.`part_type` AS `part_type`,`plasma_display_device`.`value` AS `value`,`plasma_display_device`.`schematic_part` AS `schematic_part`,`plasma_display_device`.`rating_voltage` AS `rating_voltage`,`plasma_display_device`.`rating_electricity` AS `rating_electricity`,`plasma_display_device`.`characteristics` AS `characteristics`,`plasma_display_device`.`tolerance` AS `tolerance`,`plasma_display_device`.`manufacture` AS `manufacture`,`plasma_display_device`.`b_code` AS `b_code`,`plasma_display_device`.`parts_name` AS `parts_name`,`plasma_display_device`.`item_registration_classification` AS `item_registration_classification`,`plasma_display_device`.`spice_model` AS `spice_model`,`plasma_display_device`.`pcb_footprint` AS `pcb_footprint`,`plasma_display_device`.`create_by` AS `create_by`,`plasma_display_device`.`create_time` AS `create_time`,`plasma_display_device`.`update_by` AS `update_by`,`plasma_display_device`.`update_time` AS `update_time`,`plasma_display_device`.`del_flag` AS `del_flag`,`plasma_display_device`.`remark` AS `remark` from `plasma_display_device` union select 'vacuum_fluorescent_display_vfd' AS `table_name`,`vacuum_fluorescent_display_vfd`.`id` AS `id`,`vacuum_fluorescent_display_vfd`.`part_number` AS `part_number`,`vacuum_fluorescent_display_vfd`.`part_type` AS `part_type`,`vacuum_fluorescent_display_vfd`.`value` AS `value`,`vacuum_fluorescent_display_vfd`.`schematic_part` AS `schematic_part`,`vacuum_fluorescent_display_vfd`.`rating_voltage` AS `rating_voltage`,`vacuum_fluorescent_display_vfd`.`rating_electricity` AS `rating_electricity`,`vacuum_fluorescent_display_vfd`.`characteristics` AS `characteristics`,`vacuum_fluorescent_display_vfd`.`tolerance` AS `tolerance`,`vacuum_fluorescent_display_vfd`.`manufacture` AS `manufacture`,`vacuum_fluorescent_display_vfd`.`b_code` AS `b_code`,`vacuum_fluorescent_display_vfd`.`parts_name` AS `parts_name`,`vacuum_fluorescent_display_vfd`.`item_registration_classification` AS `item_registration_classification`,`vacuum_fluorescent_display_vfd`.`spice_model` AS `spice_model`,`vacuum_fluorescent_display_vfd`.`pcb_footprint` AS `pcb_footprint`,`vacuum_fluorescent_display_vfd`.`create_by` AS `create_by`,`vacuum_fluorescent_display_vfd`.`create_time` AS `create_time`,`vacuum_fluorescent_display_vfd`.`update_by` AS `update_by`,`vacuum_fluorescent_display_vfd`.`update_time` AS `update_time`,`vacuum_fluorescent_display_vfd`.`del_flag` AS `del_flag`,`vacuum_fluorescent_display_vfd`.`remark` AS `remark` from `vacuum_fluorescent_display_vfd` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-10  9:08:02
