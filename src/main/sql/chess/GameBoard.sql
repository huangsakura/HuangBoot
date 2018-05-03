-- auto Generated on 2018-05-03 17:32:20 
-- DROP TABLE IF EXISTS `game_board`; 
CREATE TABLE `game_board`(
    `game_id` BIGINT (20) NOT NULL COMMENT 'gameId',
    `army` VARCHAR (8) NOT NULL COMMENT 'army',
    `duty` VARCHAR (8) NOT NULL COMMENT 'duty',
    `chess_sequence` INT (1) NOT NULL COMMENT 'chessSequence',
    `x` INT (1) DEFAULT NULL COMMENT 'x',
    `y` INT (1) DEFAULT NULL COMMENT 'y',
    `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    PRIMARY KEY (`id`),
    UNIQUE KEY `UNI_game_army_duty_sequence` (`game_id`,`army`,`duty`,`chess_sequence`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`game_board`';
