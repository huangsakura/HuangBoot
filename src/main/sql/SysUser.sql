-- auto Generated on 2018-04-28 09:45:09 
-- DROP TABLE IF EXISTS `sys_user`; 
CREATE TABLE `sys_user`(
    `user_name` VARCHAR (32) UNIQUE NOT NULL COMMENT 'userName',
    `password` VARCHAR (64) NOT NULL COMMENT 'password',
    `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `create_time` DATETIME NOT NULL COMMENT 'createTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`sys_user`';
