package com.huanggit.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.huanggit.domain.entity.Country;

@Mapper
public interface CountryDao {
    int insert(@Param("pojo") Country pojo);

    int insertSelective(@Param("pojo") Country pojo);

    int insertList(@Param("pojos") List<Country> pojo);

    int update(@Param("pojo") Country pojo);

    List<Country> findSelective(@Param("pojo") Country pojo);
}
