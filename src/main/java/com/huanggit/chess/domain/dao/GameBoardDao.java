package com.huanggit.chess.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.huanggit.chess.domain.entity.GameBoard;

@Mapper
public interface GameBoardDao {
    int insert(@Param("pojo") GameBoard pojo);

    int insertSelective(@Param("pojo") GameBoard pojo);

    int insertList(@Param("pojos") List<GameBoard> pojo);

    int update(@Param("pojo") GameBoard pojo);
}
