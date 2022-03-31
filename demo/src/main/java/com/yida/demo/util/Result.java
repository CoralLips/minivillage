package com.yida.demo.util;

import lombok.Data;

@Data
public class Result {
    public static int SUCCESS_CODE = 1;
    public static int FAIL_CODE = -1;

    int code;
    String message;
    Object data;

    private Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success() { return new Result(SUCCESS_CODE,null,null); }
    public static Result success(Object data) { return new Result(SUCCESS_CODE,null,data); }
    public static Result fail(String message) {
        return new Result(FAIL_CODE,message,null);
    }

}
