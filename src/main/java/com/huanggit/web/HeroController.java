package com.huanggit.web;

import com.huanggit.annotation.OperationLog;
import com.huanggit.enumeration.hero.HeroType;
import com.huanggit.general.dto.common.JsonResult;
import com.huanggit.service.HeroService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huang on 2017-11-17-0017.
 */
@Api(value = "英雄")
@Controller
@RequestMapping(value = "/hero")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @RequestMapping(value = "/loadAll",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public JsonResult loadAll() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.appendData("data", heroService.loadAll());
        return jsonResult;
    }

    @OperationLog
    @RequestMapping(value = "/findByHeroType",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public JsonResult findByHeroType(@RequestParam(value = "heroType") HeroType heroType) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.appendData("data", heroService.findByHeroType(heroType));
        return jsonResult;
    }
}