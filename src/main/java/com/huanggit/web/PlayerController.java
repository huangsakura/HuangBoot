package com.huanggit.web;

import com.huanggit.enumeration.player.Gender;
import com.huanggit.general.dto.common.JsonResult;
import com.huanggit.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huang on 2017-11-15-0015.
 */
@Controller
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult register(@RequestParam("mobile") String mobile,
                               @RequestParam("password") String password,
                               @RequestParam("nickName") String nickName,
                               @RequestParam("gender") Gender gender) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.appendData("data",playerService.register(mobile,password,nickName,gender));
        return jsonResult;
    }
}
