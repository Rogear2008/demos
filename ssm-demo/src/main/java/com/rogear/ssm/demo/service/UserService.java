package com.rogear.ssm.demo.service;

import com.rogear.ssm.demo.entity.User;

/**
 * @author Rogear2008
 * @time 2022/6/6 23:05
 */
public interface UserService {

    User selectByPrimaryKey(Integer id);
}
