package com.huanggit.service.impl;

import com.huanggit.domain.dao.AccountDao;
import com.huanggit.domain.entity.Account;
import com.huanggit.enumeration.common.ResultCode;
import com.huanggit.exception.BusinessException;
import com.huanggit.general.dto.common.Money;
import com.huanggit.service.AccountService;
import jdk.nashorn.internal.runtime.ECMAException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
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

    @Override
    public Account addAmount(String countryAlpha3Code, Money amount) {
        Account account = accountDao.getAndLock(countryAlpha3Code);
        if (null == account) {
            throw new BusinessException("国家不存在", ResultCode.OBJECT_NOT_EXIST);
        }
        account.setAmount(account.getAmount().add(amount));
        accountDao.update(account);
        return account;
    }

    @Override
    public Account reduceAmount(String countryAlpha3Code, Money amount) {
        return null;
    }

    @Override
    public void transfer(String countryAlpha3Code,String otherCountryAlpha3Code, Money amount) {
        Account accountFrom = accountDao.getAndLock(countryAlpha3Code);
        if (null == accountFrom) {
            throw new BusinessException("转出国家不存在", ResultCode.OBJECT_NOT_EXIST);
        }

        Account accountTo = accountDao.getAndLock(otherCountryAlpha3Code);
        if (null == accountTo) {
            throw new BusinessException("转入国家不存在", ResultCode.OBJECT_NOT_EXIST);
        }

        accountFrom.setAmount(accountFrom.getAmount().subtract(amount));
        accountDao.update(accountFrom);


        try {
            accountTo.setAmount(accountTo.getAmount().add(amount));
        } catch (Exception e) {

        }
        accountDao.update(accountTo);
    }
}
