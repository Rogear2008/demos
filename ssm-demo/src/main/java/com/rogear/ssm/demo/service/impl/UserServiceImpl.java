package com.rogear.ssm.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.rogear.ssm.demo.common.api.EasyUiPage;
import com.rogear.ssm.demo.dao.UserMapper;
import com.rogear.ssm.demo.entity.User;
import com.rogear.ssm.demo.entity.UserExample;
import com.rogear.ssm.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

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

    @Override
    public EasyUiPage<User> listUser(Integer pageNum, Integer pageSize, String keyWord) {
        PageHelper.startPage(pageNum, pageSize);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyWord)) {
            criteria.andUsernameLike(keyWord);
        }
        List<User> users = userMapper.selectByExample(example);
        return new EasyUiPage<>(users);
    }
}
