-- auto Generated on 2018-04-28 09:53:21 
-- DROP TABLE IF EXISTS `subway_line`; 
CREATE TABLE `subway_line`(
    `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `line_number` INT (2) NOT NULL COMMENT 'lineNumber',
    `line_chinese_name` VARCHAR (64) NOT NULL COMMENT 'lineChineseName',
    `open_date` DATETIME DEFAULT NULL COMMENT 'openDate',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`subway_line`';
