package com.rogear.ssm.demo.service.impl;

import com.rogear.ssm.demo.dao.UserMapper;
import com.rogear.ssm.demo.entity.User;
import com.rogear.ssm.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rogear2008
 * @time 2022/6/6 23:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
