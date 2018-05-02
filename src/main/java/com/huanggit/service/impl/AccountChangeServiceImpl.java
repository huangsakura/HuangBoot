package com.huanggit.service.impl;

import com.huanggit.domain.dao.AccountChangeDao;
import com.huanggit.domain.entity.Account;
import com.huanggit.domain.entity.AccountChange;
import com.huanggit.enumeration.account.TransCode;
import com.huanggit.enumeration.common.ResultCode;
import com.huanggit.exception.BusinessException;
import com.huanggit.general.dto.common.Money;
import com.huanggit.service.AccountChangeService;
import com.huanggit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by huang on 2018-04-28-0028.
 */
@Service
@Transactional
public class AccountChangeServiceImpl implements AccountChangeService {

    @Resource
    private AccountChangeDao accountChangeDao;
    @Autowired
    private AccountService accountService;

    public int insert(AccountChange pojo){
        return accountChangeDao.insert(pojo);
    }

    public int insertSelective(AccountChange pojo){
        return accountChangeDao.insertSelective(pojo);
    }

    public int insertList(List<AccountChange> pojos){
        return accountChangeDao.insertList(pojos);
    }

    public int update(AccountChange pojo){
        return accountChangeDao.update(pojo);
    }

    @Override
    public void transfer(String countryAlpha3Code, String otherCountryAlpha3Code, Money amount) {
        Account account1 = accountService.getAndLock(countryAlpha3Code);
        if (null == account1) {
            throw new BusinessException("转出国家不存在", ResultCode.OBJECT_NOT_EXIST);
        }
        Account account2 = accountService.getAndLock(otherCountryAlpha3Code);
        if (null == account2) {
            throw new BusinessException("转入国家不存在", ResultCode.OBJECT_NOT_EXIST);
        }

        AccountChange accountChange1 = new AccountChange();
        accountChange1.setAmount(amount);
        accountChange1.setAmountBefore(account1.getAmount());
        accountChange1.setAmountAfter(account1.getAmount().subtract(amount));
        accountChange1.setCountryAlpha3Code(countryAlpha3Code);
        accountChange1.setRefCountryAlpha3Code(otherCountryAlpha3Code);
        accountChange1.setTransCode(TransCode.TRANSFER_OUT);
        accountChangeDao.insert(accountChange1);

        account1.setAmount(accountChange1.getAmountAfter());
        accountService.update(account1);

        AccountChange accountChange2 = new AccountChange();
        accountChange2.setAmount(amount);
        accountChange2.setAmountBefore(account2.getAmount());
        accountChange2.setAmountAfter(account2.getAmount().add(amount));
        accountChange2.setCountryAlpha3Code(otherCountryAlpha3Code);
        accountChange2.setRefCountryAlpha3Code(countryAlpha3Code);
        accountChange2.setTransCode(TransCode.TRANSFER_IN);
        accountChangeDao.insert(accountChange2);

        account2.setAmount(accountChange2.getAmountAfter());
        accountService.update(account2);
    }
}
