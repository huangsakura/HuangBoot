package com.huanggit.service;

import com.huanggit.domain.dao.SysRoleDao;
import com.huanggit.domain.dao.SysRoleUserDao;
import com.huanggit.domain.entity.SysRole;
import com.huanggit.domain.entity.SysRoleUser;
import com.huanggit.enumeration.common.ResultCode;
import com.huanggit.exception.BusinessException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import com.huanggit.domain.entity.SysUser;
import com.huanggit.domain.dao.SysUserDao;

@Service
public class SysUserService implements UserDetailsService {

    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SysRoleUserDao sysRoleUserDao;
    @Resource
    private SysRoleDao sysRoleDao;

    public int insert(SysUser pojo){
        return sysUserDao.insert(pojo);
    }

    public int insertSelective(SysUser pojo){
        return sysUserDao.insertSelective(pojo);
    }

    public int insertList(List<SysUser> pojos){
        return sysUserDao.insertList(pojos);
    }

    public int update(SysUser pojo){
        return sysUserDao.update(pojo);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser = sysUserDao.getByUserName(s);
        if (null == sysUser) {
            throw new BusinessException(ResultCode.OBJECT_NOT_EXIST);
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<SysRoleUser> sysRoleUserList = sysRoleUserDao.findBySysUserId(sysUser.getId());
        for (SysRoleUser sysRoleUser : sysRoleUserList) {
            SysRole sysRole = sysRoleDao.getById(sysRoleUser.getSysRoleId());
            authorities.add(new SimpleGrantedAuthority(sysRole.getName()));
        }
        return new User(sysUser.getUserName(), sysUser.getPassword(), authorities);
    }
}
