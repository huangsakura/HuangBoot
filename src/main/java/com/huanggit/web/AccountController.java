package com.huanggit.web;

import com.huanggit.annotation.OperationLog;
import com.huanggit.general.constant.GeneralConstant;
import com.huanggit.general.dto.common.JsonResult;
import com.huanggit.general.dto.common.Money;
import com.huanggit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huang on 2018-04-27-0027.
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/addAmount",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    @OperationLog
    public JsonResult addAmount(@RequestParam(value = "countryAlpha3Code") String countryAlpha3Code,
                           @RequestParam(value = "amount") Long amount) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.appendData(GeneralConstant.DATA_STRING, accountService.addAmount(countryAlpha3Code, Money.cent(amount)));
        return jsonResult;
    }
}
