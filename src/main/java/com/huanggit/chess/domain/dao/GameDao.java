package com.huanggit.chess.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.huanggit.chess.domain.entity.Game;

@Mapper
public interface GameDao {
    int insert(@Param("pojo") Game pojo);

    int insertSelective(@Param("pojo") Game pojo);

    int insertList(@Param("pojos") List<Game> pojo);

    int update(@Param("pojo") Game pojo);
}
