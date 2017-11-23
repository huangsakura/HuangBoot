package com.huanggit.domain.dao;

import com.huanggit.domain.entity.Hero;
import com.huanggit.enumeration.hero.HeroType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by huang on 2017-11-17-0017.
 */
@Mapper
public interface HeroDao {

    @Select("SELECT t1.hero_code,t1.hero_name FROM hero_types t "
            +"INNER JOIN hero t1 ON t.hero_code=t1.hero_code "
            +"WHERE t.hero_Type=#{heroType}")
    List<Hero> findByHeroType(@Param("heroType") HeroType heroType);
}
