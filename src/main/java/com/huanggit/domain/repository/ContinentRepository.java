package com.huanggit.domain.repository;

import com.huanggit.domain.entity.Continent;
import com.huanggit.domain.repository.base.BaseJpaRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by huang on 2017-12-08-0008.
 */
@Mapper
public interface ContinentRepository extends BaseJpaRepository<Continent> {

    int insert(@Param("pojo") Continent pojo);

    int insertSelective(@Param("pojo") Continent pojo);

    int insertList(@Param("pojos") List<Continent> pojo);

    int update(@Param("pojo") Continent pojo);

    //List<Continent> find();

    //List<Continent> findCodeAndNameAndChineseName();

    @Select("SELECT * FROM Continent ")
    List<Continent> findAll();
}
