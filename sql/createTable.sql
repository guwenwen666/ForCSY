CREATE DATABASE  IF NOT EXISTS `csy` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `csy`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: csy
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `b_user_account`
--

DROP TABLE IF EXISTS `b_user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长主键从1000开始',
  `account` varchar(16) NOT NULL COMMENT '帐号名称',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `nickname` varchar(16) DEFAULT NULL COMMENT '昵称',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `emailStatue` tinyint(4) DEFAULT '2' COMMENT '邮箱是否激活1:正常、2:未激活',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号码',
  `phoneStatue` tinyint(4) DEFAULT '2' COMMENT '手机是否激活1:正常、2:未激活',
  `safeKey` varchar(128) NOT NULL COMMENT '安全密钥',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态1:正常、2:封号',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `account_UNIQUE` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8 COMMENT='用户帐号管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `b_user_info`
--

DROP TABLE IF EXISTS `b_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_user_info` (
  `foreign_account` varchar(16) NOT NULL COMMENT '外键帐号',
  `gender` tinyint(4) DEFAULT '1' COMMENT '性别(1:男、0:女)  默认为男性',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `signature` varchar(32) DEFAULT NULL COMMENT '个性签名',
  `favicon` varchar(512) DEFAULT NULL COMMENT '头像地址',
  `blood` int(2) DEFAULT NULL COMMENT '血型',
  `address` varchar(128) DEFAULT NULL COMMENT '地址',
  `tag` varchar(128) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`foreign_account`),
  UNIQUE KEY `foreign_account_UNIQUE` (`foreign_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `b_xtpz_dmlx`
--

DROP TABLE IF EXISTS `b_xtpz_dmlx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_xtpz_dmlx` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `dmlxywm` varchar(32) NOT NULL COMMENT '代码类型英文名',
  `dmlxzwm` varchar(32) NOT NULL COMMENT '代码类型中文名',
  `fdmlxywm` varchar(32) DEFAULT NULL COMMENT '父代码类型英文名',
  `dmlxms` varchar(128) DEFAULT NULL COMMENT '代码类型描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dmlxywm_UNIQUE` (`dmlxywm`),
  UNIQUE KEY `dmlxzwm_UNIQUE` (`dmlxzwm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代码类型管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `b_xtpz_dmx`
--

DROP TABLE IF EXISTS `b_xtpz_dmx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_xtpz_dmx` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `foreign_dmlxywm` varchar(32) NOT NULL COMMENT '外键 代码类型英文名',
  `dmxywm` varchar(32) NOT NULL COMMENT '代码项英文名',
  `dmxzwm` varchar(32) NOT NULL COMMENT '代码项中文名',
  `value` varchar(45) NOT NULL COMMENT '值',
  `dmxms` varchar(128) DEFAULT NULL COMMENT '代码项描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代码项管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'csy'
--

--
-- Dumping routines for database 'csy'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-31 21:58:45
