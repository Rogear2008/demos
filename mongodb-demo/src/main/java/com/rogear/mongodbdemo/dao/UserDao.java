package com.rogear.mongodbdemo.dao;

import com.rogear.mongodbdemo.pojo.User;

import java.util.List;

/**
 * Created by Rogear on 2020/4/13
 **/
public interface UserDao {
    void save(User user);

    void update(User user);

    List<User> findAll();

    void delete(Integer id);
}
