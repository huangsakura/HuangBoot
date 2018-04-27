package com.huanggit.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.huanggit.domain.entity.Account;

@Service
public interface AccountService{

    public int insert(Account pojo);

    public int insertSelective(Account pojo);

    public int insertList(List<Account> pojos);

    public int update(Account pojo);
}
