-- auto Generated on 2017-12-04 11:35:01 
-- DROP TABLE IF EXISTS `continent`; 
CREATE TABLE `continent`(
    `code` VARCHAR (50) UNIQUE NOT NULL COMMENT 'code',
    `name` VARCHAR (50) NOT NULL COMMENT 'name',
    `chinese_name` VARCHAR (50) NOT NULL COMMENT 'chineseName',
    `id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `create_time` DATETIME NOT NULL COMMENT 'createTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`continent`';
