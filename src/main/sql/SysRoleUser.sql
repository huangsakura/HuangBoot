-- auto Generated on 2018-04-28 09:46:19 
-- DROP TABLE IF EXISTS `sys_role_user`; 
CREATE TABLE `sys_role_user`(
    `sys_user_id` BIGINT (20) NOT NULL COMMENT 'sysUserId',
    `sys_role_id` BIGINT (20) NOT NULL COMMENT 'sysRoleId',
    `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `create_time` DATETIME NOT NULL COMMENT 'createTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`sys_role_user`';
