package com.huanggit.service;

import java.util.List;
import com.huanggit.domain.entity.SysUser;

public interface SysUserService {

    public int insert(SysUser pojo);

    public int insertSelective(SysUser pojo);

    public int insertList(List<SysUser> pojos);

    public int update(SysUser pojo);
}
