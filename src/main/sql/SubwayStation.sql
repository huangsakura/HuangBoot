-- auto Generated on 2018-04-28 09:48:55 
-- DROP TABLE IF EXISTS `subway_station`; 
CREATE TABLE `subway_station`(
    `station_code` CHAR (8) UNIQUE NOT NULL COMMENT 'stationCode',
    `english_name` VARCHAR (32) NOT NULL COMMENT 'englishName',
    `chinese_name` VARCHAR (64) NOT NULL COMMENT 'chineseName',
    `max_passenger` INT (6) NOT NULL COMMENT 'maxPassenger',
    `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `create_time` DATETIME NOT NULL COMMENT 'createTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`subway_station`';
