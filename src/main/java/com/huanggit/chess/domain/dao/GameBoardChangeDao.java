package com.huanggit.chess.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.huanggit.chess.domain.entity.GameBoardChange;

@Mapper
public interface GameBoardChangeDao {
    int insert(@Param("pojo") GameBoardChange pojo);

    int update(@Param("pojo") GameBoardChange pojo);
}
