package com.huanggit.domain.dao;

import com.huanggit.enumeration.hero.HeroType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by huang on 2017-11-17-0017.
 */
@Mapper
public interface HeroTypesDao {

    @Select("SELECT hero_Type FROM hero_types WHERE hero_Code=#{heroCode}")
    List<HeroType> findTypesByHero(@Param(value = "heroCode") String heroCode);
}
