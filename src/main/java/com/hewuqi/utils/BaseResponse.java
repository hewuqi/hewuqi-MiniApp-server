package com.hewuqi.utils;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/5/13 17:02
 */
public class BaseResponse {
    private String code;
    private String msg;
    private Object data;

    public BaseResponse(Object data){
        this.code = "200";
        this.msg = "success";
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

