package com.huanggit.enumeration.account;

/**
 * Created by huang on 2018-04-28-0028.
 */
public enum TransCode {
    TRANSFER_OUT("TRANSFER_OUT","转出"),
    TRANSFER_IN("TRANSFER_IN","转入");

    private TransCode(String code,String message) {
        this.code = code;
        this.message = message;
    }

    private final String code;
    private final String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
