package com.huanggit.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.huanggit.domain.entity.AccountChange;

@Mapper
public interface AccountChangeDao {
    int insert(@Param("pojo") AccountChange pojo);

    int insertSelective(@Param("pojo") AccountChange pojo);

    int insertList(@Param("pojos") List<AccountChange> pojo);

    int update(@Param("pojo") AccountChange pojo);
}
