package com.huanggit.service.impl;

import com.huanggit.domain.dao.SysRoleDao;
import com.huanggit.domain.entity.SysRole;
import com.huanggit.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleDao sysRoleDao;

    @Override
    public int insert(SysRole pojo){
        return sysRoleDao.insert(pojo);
    }

    @Override
    public int insertSelective(SysRole pojo){
        return sysRoleDao.insertSelective(pojo);
    }

    @Override
    public int insertList(List<SysRole> pojos){
        return sysRoleDao.insertList(pojos);
    }

    @Override
    public int update(SysRole pojo){
        return sysRoleDao.update(pojo);
    }
}
