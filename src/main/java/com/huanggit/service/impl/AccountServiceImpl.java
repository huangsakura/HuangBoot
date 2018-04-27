package com.huanggit.service.impl;

import com.huanggit.domain.dao.AccountDao;
import com.huanggit.domain.entity.Account;
import com.huanggit.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public int insert(Account pojo){
        return accountDao.insert(pojo);
    }

    @Override
    public int insertSelective(Account pojo){
        return accountDao.insertSelective(pojo);
    }

    @Override
    public int insertList(List<Account> pojos){
        return accountDao.insertList(pojos);
    }

    @Override
    public int update(Account pojo){
        return accountDao.update(pojo);
    }
}
