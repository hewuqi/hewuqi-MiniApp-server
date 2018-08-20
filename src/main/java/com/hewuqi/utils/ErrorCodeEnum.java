package com.hewuqi.utils;

/**
 * 错误码枚举
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/8/5 23:32
 */
public enum ErrorCodeEnum {

    SUCCESS(200, "成功"),
    UNKONWN_ERROR(99999, "未知错误"),

    //权限模块
    USER_EXIST(10001, "用户名已存在");


    private int code;
    private String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public static ErrorCodeEnum getEnumByErrorCode(int errorcode) {
        for (int i = 0; i < ErrorCodeEnum.values().length; i++) {
            if (ErrorCodeEnum.values()[i].getCode() == errorcode) {
                return ErrorCodeEnum.values()[i];
            }
        }
        return UNKONWN_ERROR;
    }

}
