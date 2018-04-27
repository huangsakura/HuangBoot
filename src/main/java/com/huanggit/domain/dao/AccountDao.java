package com.huanggit.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.huanggit.domain.entity.Account;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountDao {
    int insert(@Param("pojo") Account pojo);

    int insertSelective(@Param("pojo") Account pojo);

    int insertList(@Param("pojos") List<Account> pojo);

    int update(@Param("pojo") Account pojo);

    @Select("SELECT * FROM account WHERE country_alpha3_code=#{countryAlpha3Code} FOR UPDATE")
    Account getAndLock(@Param("countryAlpha3Code") String countryAlpha3Code);

    @Select("SELECT * FROM account WHERE country_alpha3_code=#{countryAlpha3Code}")
    Account get(@Param("countryAlpha3Code") String countryAlpha3Code);
}
