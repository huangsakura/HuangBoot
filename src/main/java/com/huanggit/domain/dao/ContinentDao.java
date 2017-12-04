package com.huanggit.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.huanggit.domain.entity.Continent;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ContinentDao {
    int insert(@Param("pojo") Continent pojo);

    int insertSelective(@Param("pojo") Continent pojo);

    int insertList(@Param("pojos") List<Continent> pojo);

    int update(@Param("pojo") Continent pojo);

    @Select("SELECT * FROM Continent")
    List<Continent> findAll();
}
