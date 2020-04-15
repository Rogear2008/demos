package com.rogear.mongodbdemo.dao;

import com.rogear.mongodbdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void save() {
        User user = new User();
        user.setId(3L);
        user.setUsername("abc");
        user.setPassword("123");
        userDao.save(user);
    }

    @Test
    void update() {
        User user = new User();
        user.setId(1L);
        user.setUsername("abc");
        user.setPassword("111");
        userDao.update(user);
    }

    @Test
    void findAll() {
        List<User> list = userDao.findAll();
        System.out.println("result:" + list.toArray());
    }

    @Test
    void delete() {
        userDao.delete(1);
    }
}