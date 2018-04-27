package com.huanggit;

import com.huanggit.general.dto.common.Money;
import com.huanggit.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by huang on 2018-04-27-0027.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testAdd() {
        new Thread(new Runnable(){
            @Override
            public void run() {
                accountService.addAmount("CHN", Money.cent(100L));
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                accountService.addAmount("CHN", Money.cent(101L));
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                accountService.addAmount("CHN", Money.cent(102L));
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                accountService.addAmount("CHN", Money.cent(103L));
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                accountService.addAmount("CHN", Money.cent(104L));
            }
        }).start();

    }

    @Test
    public void testTransfer() {
        accountService.transfer("CHN","USA",Money.cent(50L));
    }
}
