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

-- ----------------------------
-- Table structure for hero
-- ----------------------------
DROP TABLE IF EXISTS `hero`;
CREATE TABLE `hero` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hero_name` varchar(32) COLLATE utf8_bin NOT NULL,
  `hero_code` varchar(32) COLLATE utf8_bin NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_hero_code` (`hero_code`) USING BTREE,
  UNIQUE KEY `uni_hero_name` (`hero_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for hero_types
-- ----------------------------
DROP TABLE IF EXISTS `hero_types`;
CREATE TABLE `hero_types` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hero_Code` varchar(32) COLLATE utf8_bin NOT NULL,
  `hero_Types` varchar(32) COLLATE utf8_bin NOT NULL,
  `create_Time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_hero_Code_hero_Types` (`hero_Code`,`hero_Types`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for player
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `player_Code` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `mobile` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `password_Salt` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `nick_Name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `point` int(8) DEFAULT NULL,
  `gender` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `rank` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `create_Time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_mobile` (`mobile`) USING BTREE,
  UNIQUE KEY `uni_player_Code` (`player_Code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for player_heros
-- ----------------------------
DROP TABLE IF EXISTS `player_heros`;
CREATE TABLE `player_heros` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `player_Code` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `hero_Code` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `hero_Proficiency` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `create_Time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_player_Code_hero_Code` (`player_Code`,`hero_Code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


insert into hero(hero_name,hero_code,create_time) values('孙尚香','sunshangxiang',now());
insert into hero(hero_name,hero_code,create_time) values('虞姬','yuji',now());
insert into hero(hero_name,hero_code,create_time) values('项羽','xiangyu',now());
insert into hero(hero_name,hero_code,create_time) values('嬴政','yingzheng',now());
insert into hero(hero_name,hero_code,create_time) values('荆轲','jingke',now());
insert into hero(hero_name,hero_code,create_time) values('刘邦','liubang',now());
insert into hero(hero_name,hero_code,create_time) values('韩信','hanxin',now());
insert into hero(hero_name,hero_code,create_time) values('扁鹊','bianque',now());
insert into hero(hero_name,hero_code,create_time) values('宫本武藏','gongbenwuzang',now());
insert into hero(hero_name,hero_code,create_time) values('不知火舞','buzhihuowu',now());
insert into hero(hero_name,hero_code,create_time) values('娜可露露','nakelulu',now());
insert into hero(hero_name,hero_code,create_time) values('橘右京','juyoujing',now());