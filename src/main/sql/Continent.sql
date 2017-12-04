-- auto Generated on 2017-12-04 11:35:01 
-- DROP TABLE IF EXISTS `continent`; 
CREATE TABLE `continent`(
    `code` VARCHAR (50) UNIQUE NOT NULL COMMENT 'code',
    `name` VARCHAR (50) NOT NULL COMMENT 'name',
    `chinese_name` VARCHAR (50) NOT NULL COMMENT 'chineseName',
    `id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `create_time` DATETIME NOT NULL COMMENT 'createTime',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uni_Code` (`Code`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`continent`';

INSERT into continent(Code,Name,Chinese_Name,create_time)
  VALUES('AS','Asia','亚洲',now());
INSERT into continent(Code,Name,Chinese_Name,create_time)
  VALUES('AF','Africa','非洲',now());
INSERT into continent(Code,Name,Chinese_Name,create_time)
  VALUES('AM','Americas','美洲',now());
INSERT into continent(Code,Name,Chinese_Name,create_time)
  VALUES('EU','Europe','欧洲',now());
INSERT into continent(Code,Name,Chinese_Name,create_time)
  VALUES('AN','Antarctica','南极洲',now());
  INSERT into continent(Code,Name,Chinese_Name,create_time)
  VALUES('OC','Oceania','大洋洲',now());