package com.huanggit.domain.dao;

import com.huanggit.domain.repository.BaseJpaRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.huanggit.domain.entity.Continent;
import org.apache.ibatis.annotations.Select;

public interface ContinentDao extends BaseJpaRepository<Continent> {

    int insert(@Param("pojo") Continent pojo);

    int insertSelective(@Param("pojo") Continent pojo);

    int insertList(@Param("pojos") List<Continent> pojo);

    int update(@Param("pojo") Continent pojo);

    List<Continent> find();

    List<Continent> findCodeAndNameAndChineseName();

    @Select("SELECT * FROM Continent ")
    List<Continent> findAll();
}
