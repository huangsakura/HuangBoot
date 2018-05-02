-- auto Generated on 2018-04-28 09:52:23 
-- DROP TABLE IF EXISTS `subway_line_station`; 
CREATE TABLE `subway_line_station`(
    `station_code` CHAR (8) NOT NULL COMMENT 'stationCode',
    `line_number` INT (2) NOT NULL COMMENT 'lineNumber',
    `open_date` DATETIME NOT NULL COMMENT 'openDate',
    `station_sort_number` INT (2) NOT NULL COMMENT 'stationSortNumber',
    `away_from_prev_station` BIGINT (6) NOT NULL COMMENT 'awayFromPrevStation',
    `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `create_time` DATETIME NOT NULL COMMENT 'createTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`subway_line_station`';
