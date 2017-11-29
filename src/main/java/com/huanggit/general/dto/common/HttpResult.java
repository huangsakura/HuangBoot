package com.huanggit.general.dto.common;

import lombok.Data;

/**
 * Created by huang on 2017-11-29-0029.
 */
@Data
public class HttpResult {

    private Integer responseCode = 400;

    private String responseText;

    private String errorMessage;
}
