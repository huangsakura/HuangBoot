-- auto Generated on 2018-04-28 10:01:20 
-- DROP TABLE IF EXISTS `account_change`; 
CREATE TABLE `account_change`(
    `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `country_alpha3_code` CHAR (3) NOT NULL COMMENT 'countryAlpha3Code',
    `trans_code` VARCHAR (16) NOT NULL COMMENT 'transCode',
    `amount_before` BIGINT (20) NOT NULL DEFAULT 0 COMMENT 'amount_before',
    `amount` BIGINT (20) NOT NULL DEFAULT 0 COMMENT 'amount',
    `amount_after` BIGINT (20) NOT NULL DEFAULT 0 COMMENT 'amount_after',
    `ref_country_alpha3_code` CHAR (3) DEFAULT NULL COMMENT 'refCountryAlpha3Code',
    `create_time` DATETIME NOT NULL COMMENT 'createTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`account_change`';
