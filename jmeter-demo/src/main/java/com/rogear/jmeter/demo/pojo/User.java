package com.rogear.jmeter.demo.pojo;

import java.io.Serializable;

/**
 * @author Rogear2008
 * @time 2022/6/29 22:55
 */
public class User implements Serializable {
    private static final long serialVersionUID = -981192143455319380L;

    private String id;

    private String username;

    private String password;

    private Boolean enable;

    public User() {
    }

    public User(String id, String username, String password, Boolean enable) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enable = enable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
