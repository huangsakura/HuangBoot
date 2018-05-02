package com.huanggit.service;

import com.huanggit.general.dto.common.Money;
import java.util.List;
import com.huanggit.domain.entity.Account;

public interface AccountService{

    public int insert(Account pojo);

    public int insertSelective(Account pojo);

    public int insertList(List<Account> pojos);

    public int update(Account pojo);

    Account addAmount(String countryAlpha3Code,Money amount);

    Account reduceAmount(String countryAlpha3Code,Money amount);

    Account getAndLock(String countryAlpha3Code);
}
