package com.huanggit.web;

import com.huanggit.annotation.OperationLog;
import com.huanggit.general.constant.GeneralConstant;
import com.huanggit.general.dto.common.JsonResult;
import com.huanggit.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by huang on 2017-12-12-0012.
 */
@Api(value = "国家")
@RestController
@RequestMapping(value = "/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/load",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    @OperationLog
    @ApiOperation(value = "根据条件查询国家的信息",notes = "如果条件为空则查询全部的国家")
    public JsonResult load() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.appendData(GeneralConstant.DATA_STRING, countryService.find());
        return jsonResult;
    }
}
