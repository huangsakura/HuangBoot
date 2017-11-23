package com.huanggit.enumeration.common;

/**
 * Created by huang on 2017-11-15-0015.
 */
public enum ResultCode {
    SUCCESS("SUCCESS","成功"),
    PLAYER_NOT_EXIST("PLAYER_NOT_EXIST","玩家不存在"),
    NOT_ALLOWED_PARAMETER("NOT_ALLOWED_PARAMETER","不允许的参数"),
    MOBILE_EXISTED("MOBILE_EXISTED","手机号已存在"),
    OTHER("OTHER","其他");


    private ResultCode(String code,String message) {
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