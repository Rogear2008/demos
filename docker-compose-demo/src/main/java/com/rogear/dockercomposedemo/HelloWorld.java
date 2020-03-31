package com.rogear.dockercomposedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Rogear on 2020/3/30
 **/
@RestController
public class HelloWorld {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String helloWorld(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select host,user from user limit 1");
        return list.toString();
    }
}
