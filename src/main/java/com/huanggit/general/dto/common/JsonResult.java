package com.huanggit.general.dto.common;

import com.huanggit.enumeration.common.ResultCode;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huang on 2017-11-15-0015.
 */
@Data
public class JsonResult {

    private boolean success = true;

    private ResultCode code = ResultCode.SUCCESS;

    private String message;

    private Map<String,Object> data = new HashMap<>();

    public void appendData(String key,Object value) {
        data.put(key,value);
    }
}
