package com.huanggit.test.service;

import com.huanggit.general.dto.common.Money;
import com.huanggit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huang on 2018-04-28-0028.
 */
@Service
@Transactional
public class TestService {

    @Autowired
    private AccountService accountService;

    public void test1() {
        accountService.addAmount("CHN", Money.cent(100L));
        accountService.addAmount("USA", Money.cent(100L));
        accountService.addAmount("RUS", Money.cent(100L));
    }
}
