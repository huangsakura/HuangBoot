-- auto Generated on 2018-05-04 14:48:12 
-- DROP TABLE IF EXISTS `game_board_change`; 
CREATE TABLE `game_board_change`(
    `game_id` BIGINT (20) NOT NULL COMMENT 'gameId',
    `chess_board_id` BIGINT (20) NOT NULL COMMENT 'chessBoardId',
    `chess_desc` VARCHAR (16) NOT NULL COMMENT 'chessDesc',
    `from_x` INT (1) NOT NULL COMMENT 'fromX',
    `from_y` INT (1) NOT NULL COMMENT 'fromY',
    `to_x` INT (1) NOT NULL COMMENT 'toX',
    `to_y` INT (1) NOT NULL COMMENT 'toY',
    `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `create_time` DATETIME NOT NULL COMMENT 'createTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`game_board_change`';
