-- auto Generated on 2018-04-28 09:46:53 
-- DROP TABLE IF EXISTS `sys_role`; 
CREATE TABLE `sys_role`(
    `name` VARCHAR (64) NOT NULL COMMENT 'name',
    `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `create_time` DATETIME NOT NULL COMMENT 'createTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`sys_role`';
