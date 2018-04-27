package com.huanggit.service;

import java.util.List;
import com.huanggit.domain.entity.SysRole;

public interface SysRoleService{

    public int insert(SysRole pojo);

    public int insertSelective(SysRole pojo);

    public int insertList(List<SysRole> pojos);

    public int update(SysRole pojo);
}
