package com.huanggit.service.impl;

import com.huanggit.domain.dao.SysRoleUserDao;
import com.huanggit.domain.entity.SysRoleUser;
import com.huanggit.service.SysRoleUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysRoleUserServiceImpl implements SysRoleUserService {

    @Resource
    private SysRoleUserDao sysRoleUserDao;

    @Override
    public int insert(SysRoleUser pojo){
        return sysRoleUserDao.insert(pojo);
    }

    @Override
    public int insertSelective(SysRoleUser pojo){
        return sysRoleUserDao.insertSelective(pojo);
    }

    @Override
    public int insertList(List<SysRoleUser> pojos){
        return sysRoleUserDao.insertList(pojos);
    }

    @Override
    public int update(SysRoleUser pojo){
        return sysRoleUserDao.update(pojo);
    }
}
