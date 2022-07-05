package com.rogear.jmeter.demo.pojo;

import java.io.Serializable;

/**
 * @author Rogear2008
 * @time 2022/6/29 23:00
 */
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = -5945926288892472113L;

    private String code;

    private String message;

    private T data;

    public CommonResult() {
        this.code = "200";
        this.message = "success";
    }

    public CommonResult(T data) {
        this.code = "200";
        this.data = data;
    }

    public CommonResult(String message) {
        this.code = "500";
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
