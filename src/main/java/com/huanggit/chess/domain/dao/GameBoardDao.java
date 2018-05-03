package com.huanggit.chess.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.huanggit.chess.domain.entity.GameBoard;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GameBoardDao {
    int insert(@Param("pojo") GameBoard pojo);

    int insertSelective(@Param("pojo") GameBoard pojo);

    int insertList(@Param("pojos") List<GameBoard> pojo);

    int update(@Param("pojo") GameBoard pojo);

    @Select("SELECT * FROM game_board WHERE game_id=#{gameId} and x=#{x} AND y=#{y} AND valid_code='0'")
    GameBoard getByPosition(@Param("gameId") Long gameId,@Param("x") int x,@Param("y") int y);
}
