package com.autumn.common.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;
    private Object data;

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success() {
        return new Result(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), null);
    }

    public static Result successMsg(String msg) {
        return new Result(StatusCode.SUCCESS.getCode(), msg, null);
    }

    public static Result successData(Object data) {
        return new Result(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), data);
    }

    public static Result success(String msg, Object data) {
        return new Result(StatusCode.SUCCESS.getCode(), msg, data);
    }

    public static Result fail() {
        return new Result(StatusCode.ERROR.getCode(), StatusCode.ERROR.getMsg(), null);
    }

    public static Result failCode(int code) {
        return new Result(code, StatusCode.ERROR.getMsg(), null);
    }

    public static Result failMsg(String msg) {
        return new Result(StatusCode.ERROR.getCode(), msg, null);
    }

    public static Result failData(Object data) {
        return new Result(StatusCode.ERROR.getCode(), StatusCode.ERROR.getMsg(), data);
    }

    public static Result failMsg(int code, String msg) {
        return new Result(code, msg, null);
    }

    public static Result failData(int code, Object data) {
        return new Result(code, StatusCode.ERROR.getMsg(), data);
    }

    public static Result fail(String msg, Object data) {
        return new Result(StatusCode.ERROR.getCode(), msg, data);
    }

    public static Result fail(int code, String msg, Object data) {
        return new Result(code, msg, data);
    }

}
