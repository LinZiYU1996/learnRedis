package com.lin.learnaopblogdemo.common;

import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/18
 * \* Time: 21:29
 * \* Description:
 * \
 */
public class BaseResponse implements Serializable {

    private int code;


    private String message;


    public BaseResponse() {
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static BaseResponse addError(ErrorCodeEnum errorCodeEnum) {
        return new BaseResponse(errorCodeEnum.getCode(), errorCodeEnum.getDesc());
    }

    public static BaseResponse addError(ErrorCodeEnum errorCodeEnum, String message) {
        return new BaseResponse(errorCodeEnum.getCode(), message);
    }


    public static BaseResponse addResult() {
        return new BaseResponse(ErrorCodeEnum.SUCCESS.getCode(), ErrorCodeEnum.SUCCESS.getDesc());
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
