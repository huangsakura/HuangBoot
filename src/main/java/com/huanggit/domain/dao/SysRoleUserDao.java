package com.huanggit.domain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.huanggit.domain.entity.SysRoleUser;

@Mapper
public interface SysRoleUserDao {
    int insert(@Param("pojo") SysRoleUser pojo);

    int insertSelective(@Param("pojo") SysRoleUser pojo);

    int insertList(@Param("pojos") List<SysRoleUser> pojo);

    int update(@Param("pojo") SysRoleUser pojo);

    List<SysRoleUser> findBySysUserId(@Param("sysUserId")Long sysUserId);
}
