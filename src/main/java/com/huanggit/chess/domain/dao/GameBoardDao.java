package com.huanggit.chess.domain.dao;

import com.huanggit.chess.enumeration.Army;
import com.huanggit.chess.enumeration.Duty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.huanggit.chess.domain.entity.GameBoard;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GameBoardDao {
    int insert(@Param("pojo") GameBoard pojo);

    int update(@Param("pojo") GameBoard pojo);

    @Select("SELECT * FROM game_board WHERE game_id=#{gameId} and x=#{x} AND y=#{y} AND valid_code='0' FOR UPDATE")
    GameBoard getByPositionForUpdate(@Param("gameId") Long gameId,@Param("x") int x,@Param("y") int y);

    @Select("SELECT * FROM game_board WHERE game_id=#{gameId} AND army=#{army} AND duty=#{duty} AND chess_sequence=#{chessSequence} FOR UPDATE")
    GameBoard getByChessForUpdate(@Param("gameId") Long gameId,@Param("army") Army army,@Param("duty") Duty duty,@Param("chessSequence") Integer chessSequence);

    @Select("SELECT * FROM game_board WHERE id=#{id} FOR UPDATE")
    GameBoard getForUpdate(@Param("id") Long id);

    @Select("SELECT * FROM game_board WHERE id=#{id}")
    GameBoard get(@Param("id") Long id);
}
