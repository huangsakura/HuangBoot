package com.huanggit.exception;

import com.huanggit.enumeration.common.ResultCode;

/**
 * Created by huang on 2017-11-18-0018.
 */
public class BusinessException extends RuntimeException {

    private final String message;
    private final ResultCode code;

    public BusinessException(String message, ResultCode exceptionCode) {
        this.message = message;
        this.code = exceptionCode;
    }

    public BusinessException(ResultCode exceptionCode) {
        this.message = exceptionCode.getMessage();
        this.code = exceptionCode;
    }

    public BusinessException(String message) {
        this.message = message;
        this.code = ResultCode.OTHER;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ResultCode getCode() {
        return code;
    }
}
