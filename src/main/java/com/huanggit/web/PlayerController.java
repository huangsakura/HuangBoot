package com.huanggit.web;

import com.huanggit.enumeration.common.ResultCode;
import com.huanggit.enumeration.player.Gender;
import com.huanggit.exception.BusinessException;
import com.huanggit.general.dto.common.JsonResult;
import com.huanggit.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huang on 2017-11-15-0015.
 */
@Api(value = "玩家")
@Controller
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @ApiImplicitParam(value = "注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public JsonResult register(@RequestParam("mobile") String mobile,
                               @RequestParam("password") String password,
                               @RequestParam(value = "nickName",required = false) String nickName,
                               @RequestParam(value = "gender",required = false,defaultValue = "UNKNOWN") Gender gender) {
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult.appendData("data",playerService.register(mobile,password,nickName,gender));
        } catch (BusinessException e) {
            jsonResult.setSuccess(false);
            jsonResult.setCode(e.getCode());
            jsonResult.setMessage(e.getMessage());
        } catch (Exception e) {
            jsonResult.setSuccess(false);
            jsonResult.setCode(ResultCode.OTHER);
            String.valueOf(Gender.UNKNOWN);
        }
        return jsonResult;
    }

    @ApiImplicitParam(value = "登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public JsonResult login(@RequestParam("mobile") String mobile,
                            @RequestParam("password") String password) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.appendData("data",playerService.login(mobile,password));
        return jsonResult;
    }
}
