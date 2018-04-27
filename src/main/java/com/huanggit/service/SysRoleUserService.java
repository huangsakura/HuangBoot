package com.huanggit.service;

import java.util.List;
import com.huanggit.domain.entity.SysRoleUser;

public interface SysRoleUserService{

    public int insert(SysRoleUser pojo);

    public int insertSelective(SysRoleUser pojo);

    public int insertList(List<SysRoleUser> pojos);

    public int update(SysRoleUser pojo);
}
