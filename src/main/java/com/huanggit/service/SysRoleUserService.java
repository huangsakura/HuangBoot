package com.huanggit.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.huanggit.domain.entity.SysRoleUser;
import com.huanggit.domain.dao.SysRoleUserDao;

@Service
public class SysRoleUserService{

    @Resource
    private SysRoleUserDao sysRoleUserDao;

    public int insert(SysRoleUser pojo){
        return sysRoleUserDao.insert(pojo);
    }

    public int insertSelective(SysRoleUser pojo){
        return sysRoleUserDao.insertSelective(pojo);
    }

    public int insertList(List<SysRoleUser> pojos){
        return sysRoleUserDao.insertList(pojos);
    }

    public int update(SysRoleUser pojo){
        return sysRoleUserDao.update(pojo);
    }
}
