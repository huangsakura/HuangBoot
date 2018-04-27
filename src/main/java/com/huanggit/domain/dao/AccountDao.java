package com.huanggit.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.huanggit.domain.entity.Account;

@Mapper
public interface AccountDao {
    int insert(@Param("pojo") Account pojo);

    int insertSelective(@Param("pojo") Account pojo);

    int insertList(@Param("pojos") List<Account> pojo);

    int update(@Param("pojo") Account pojo);
}
