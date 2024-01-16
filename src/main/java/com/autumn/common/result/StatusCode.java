package com.autumn.common.result;

public enum StatusCode {
    /*
     * 异常参数
     * */
    SUCCESS(0, "成功"),
    ERROR(1, "失败"),
    LOGIN_ERROR(201, "账号或密码错误"),
    SYSTEM_ERROR(500, "系统异常"),
    ;


    private Integer code;
    private String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
