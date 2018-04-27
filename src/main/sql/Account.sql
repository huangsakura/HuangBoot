-- auto Generated on 2018-04-27 15:34:16 
-- DROP TABLE IF EXISTS `account`; 
CREATE TABLE `account`(
    `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `country_alpha3_code` CHAR(3) UNIQUE NOT NULL COMMENT 'countryAlpha3Code',
    `amount` BIGINT (20) NOT NULL DEFAULT 0 COMMENT 'amount',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`account`';
