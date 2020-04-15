package com.rogear.mongodbdemo.dao.impl;

import com.rogear.mongodbdemo.dao.UserDao;
import com.rogear.mongodbdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Rogear on 2020/4/13
 **/
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void save(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public void update(User user) {
        //修改范围
        Query query = new Query(Criteria.where("id").is(user.getId()));
        //修改内容
        Update update = new Update();
        update.set("password",user.getPassword());
        mongoTemplate.updateFirst(query,update,user.getClass());
    }

    @Override
    public List<User> findAll() {
        List<User> list = mongoTemplate.findAll(User.class);
        return list;
    }

    @Override
    public void delete(Integer id) {
        User user = mongoTemplate.findById(id, User.class);
        mongoTemplate.remove(user);
    }
}
