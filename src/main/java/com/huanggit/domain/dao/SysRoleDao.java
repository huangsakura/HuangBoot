package com.huanggit.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.huanggit.domain.entity.SysRole;

@Mapper
public interface SysRoleDao {
    int insert(@Param("pojo") SysRole pojo);

    int insertSelective(@Param("pojo") SysRole pojo);

    int insertList(@Param("pojos") List<SysRole> pojo);

    int update(@Param("pojo") SysRole pojo);

    SysRole getById(@Param("id")Long id);
}
