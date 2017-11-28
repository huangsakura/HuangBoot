package com.huanggit.web;

import com.huanggit.annotation.OperationLog;
import com.huanggit.general.dto.common.JsonResult;
import com.huanggit.service.ContinentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huang on 2017-11-23-0023.
 */
@Api(value = "洲")
@RestController
@RequestMapping(value = "/continent")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @RequestMapping(value = "/loadAll",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    @OperationLog
    @ApiOperation(value = "加载所有的洲",notes = "加载所有的洲")
    public JsonResult loadAll() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.appendData("data", continentService.loadAll());
        return jsonResult;
    }
}
