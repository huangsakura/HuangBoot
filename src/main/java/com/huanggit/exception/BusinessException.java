package com.huanggit.exception;

import com.huanggit.enumeration.common.ExceptionCode;

/**
 * Created by huang on 2017-11-18-0018.
 */
public class BusinessException extends RuntimeException {

    private final String message;
    private final ExceptionCode code;

    public BusinessException(String message, ExceptionCode exceptionCode) {
        this.message = message;
        this.code = exceptionCode;
    }

    public BusinessException(ExceptionCode exceptionCode) {
        this.message = exceptionCode.getMessage();
        this.code = exceptionCode;
    }

    public BusinessException(String message) {
        this.message = message;
        this.code = ExceptionCode.OTHER;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ExceptionCode getCode() {
        return code;
    }
}
