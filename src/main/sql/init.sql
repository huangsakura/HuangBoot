/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : study

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-16 18:35:33
*/

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `continent`;
CREATE TABLE `continent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Code` char(2) COLLATE utf8_bin DEFAULT NULL,
  `Name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `Chinese_Name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `create_Time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_Code` (`Code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT into continent(Code,Name,Chinese_Name,create_time)
  VALUES('AS','Asia','亚洲',now());
INSERT into continent(Code,Name,Chinese_Name,create_time)
  VALUES('AF','Africa','非洲',now());
INSERT into continent(Code,Name,Chinese_Name,create_time)
  VALUES('NA','NorthAmerica','北美洲',now());
INSERT into continent(Code,Name,Chinese_Name,create_time)
  VALUES('SA','SouthAmerica','南美洲',now());
INSERT into continent(Code,Name,Chinese_Name,create_time)
  VALUES('EU','Europe','欧洲',now());
INSERT into continent(Code,Name,Chinese_Name,create_time)
  VALUES('AN','Antarctica','南极洲',now());

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Alpha2_Code` char(2) COLLATE utf8_bin DEFAULT NULL,
  `Alpha3_Code` char(3) COLLATE utf8_bin DEFAULT NULL,
  `Name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `Full_Name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `Chinese_Name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `Chinese_Full_Name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `capital_Name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `capital_Chinese_Name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `population` int(10) DEFAULT NULL,
  `national_Flag` varchar(64) DEFAULT NULL,
  `continent_Code` char(2) COLLATE utf8_bin DEFAULT NULL,
  `area` int(10) COLLATE utf8_bin DEFAULT NULL,
  `create_Time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_Alpha2_Code` (`Alpha2_Code`) USING BTREE,
  UNIQUE KEY `uni_Alpha3_Code` (`Alpha3_Code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
