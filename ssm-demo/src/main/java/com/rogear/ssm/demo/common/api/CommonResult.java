package com.rogear.ssm.demo.common.api;

import com.rogear.ssm.demo.entity.User;

import java.io.Serializable;

/**
 * @author Rogear2008
 * @time 2022/6/14 22:35
 */
public class CommonResult <T> implements Serializable {

    private static final long serialVersionUID = 3324845617466112663L;

    private static final String SUCCESS = "200";

    private String code;

    private String message;

    private T data;

    public CommonResult(T data) {
        if (null != data) {
            code = SUCCESS;
            this.data = data;
        }
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
