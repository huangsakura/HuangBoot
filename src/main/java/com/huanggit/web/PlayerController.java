package com.huanggit.web;

import com.huanggit.annotation.OperationLog;
import com.huanggit.enumeration.common.ResultCode;
import com.huanggit.enumeration.player.Gender;
import com.huanggit.exception.BusinessException;
import com.huanggit.general.dto.common.JsonResult;
import com.huanggit.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huang on 2017-11-15-0015.
 */
@Slf4j
@Api(value = "玩家")
@Controller
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @ApiOperation(value = "注册",notes = "注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    @OperationLog
    public JsonResult register(@ApiParam(name = "mobile",required = true,value = "手机号") @RequestParam(value = "mobile",required = true) String mobile,
                               @ApiParam(name = "password",required = true,value = "密码") @RequestParam(value = "password",required = true) String password,
                               @ApiParam(name = "nickName",required = false,value = "昵称") @RequestParam(value = "nickName",required = false) String nickName,
                               @ApiParam(name = "gender",required = false,value = "性别") @RequestParam(value = "gender",required = false) Gender gender) {
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult.appendData("data",playerService.register(mobile,password,nickName,gender));
        } catch (BusinessException e) {
            jsonResult.setSuccess(false);
            jsonResult.setCode(e.getCode());
            jsonResult.setMessage(e.getMessage());
        } catch (Exception e) {
            log.error("注册失败:{}",e.getMessage());
            jsonResult.setSuccess(false);
            jsonResult.setCode(ResultCode.OTHER);
            jsonResult.setMessage("注册失败");
        }
        return jsonResult;
    }

    @ApiOperation(value = "登录",notes = "注册")
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    @OperationLog
    public JsonResult login(@ApiParam(name = "mobile",required = true,value = "手机号") @RequestParam(value = "mobile",required = true) String mobile,
                            @ApiParam(name = "password",required = true,value = "密码") @RequestParam(value = "password",required = true) String password) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.appendData("data",playerService.login(mobile,password));
        return jsonResult;
    }
}
