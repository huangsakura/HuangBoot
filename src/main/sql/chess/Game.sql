-- auto Generated on 2018-05-03 18:10:14 
-- DROP TABLE IF EXISTS `game`; 
CREATE TABLE `game`(
    `red_user_id` BIGINT (20) NOT NULL COMMENT 'redUserId',
    `black_user_id` BIGINT (20) NOT NULL COMMENT 'blackUserId',
    `status` VARCHAR (16) NOT NULL COMMENT 'status',
    `winner` VARCHAR (8) DEFAULT NULL COMMENT 'winner',
    `start_time` DATETIME DEFAULT NULL COMMENT 'startTime',
    `finish_time` DATETIME DEFAULT NULL COMMENT 'finishTime',
    `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`game`';
