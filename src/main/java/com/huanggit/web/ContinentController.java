package com.huanggit.web;

import com.huanggit.annotation.OperationLog;
import com.huanggit.configuration.FileServerConfig;
import com.huanggit.general.constant.GeneralConstant;
import com.huanggit.general.dto.common.JsonResult;
import com.huanggit.service.ContinentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by huang on 2017-11-23-0023.
 */
@Api(value = "洲")
@RestController
@RequestMapping(value = "/continent")
public class ContinentController {

    @Autowired
    private ContinentService continentService;
    @Autowired
    private FileServerConfig fileServerConfig;

    @RequestMapping(value = "/load",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    @OperationLog
    @ApiOperation(value = "根据条件查询洲的信息",notes = "如果条件为空则查询全部的洲")
    public JsonResult load(@RequestParam(value = "code",required = false) String code,
            @RequestParam(value = "name",required = false) String name) {
        JsonResult jsonResult = new JsonResult();
        System.out.println(fileServerConfig.getServerRoot());
        jsonResult.appendData(GeneralConstant.DATA_STRING, continentService.load(code,name));
        return jsonResult;
    }
}
