
CREATE TABLE `game_board` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`game_id` BIGINT(20) NOT NULL COMMENT 'gameId',
	`army` VARCHAR(8) NOT NULL COMMENT 'army',
	`duty` VARCHAR(8) NOT NULL COMMENT 'duty',
	`chess_sequence` INT(1) NOT NULL COMMENT 'chessSequence',
	`x` INT(1) NOT NULL COMMENT 'x',
	`y` INT(1) NOT NULL COMMENT 'y',
	`valid_code` VARCHAR (24) NOT NULL DEFAULT '0',
	`create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `UNI_game_army_duty_sequence` (`game_id`, `army`, `duty`, `chess_sequence`) USING BTREE,
	UNIQUE INDEX `uni_game_x_y_valid` (`game_id`, `x`, `y`, `valid_code`) USING BTREE
)
COMMENT='`game_board`'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
