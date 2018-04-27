package com.huanggit.test.web;

import com.huanggit.general.dto.common.JsonResult;
import com.huanggit.general.dto.common.Money;
import com.huanggit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huang on 2018-04-27-0027.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/addAmount",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public JsonResult addAmount() {
        JsonResult jsonResult = new JsonResult();
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
        return jsonResult;
    }
}
