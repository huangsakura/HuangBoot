package com.huanggit.service;

import java.util.List;
import com.huanggit.domain.entity.AccountChange;
import com.huanggit.general.dto.common.Money;

public interface AccountChangeService{

    public int insert(AccountChange pojo);

    public int insertSelective(AccountChange pojo);

    public int insertList(List<AccountChange> pojos);

    public int update(AccountChange pojo);

    public void transfer(String countryAlpha3Code,String otherCountryAlpha3Code,Money amount);
}
