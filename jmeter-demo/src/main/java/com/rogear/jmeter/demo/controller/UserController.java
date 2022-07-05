package com.rogear.jmeter.demo.controller;

import com.rogear.jmeter.demo.pojo.CommonResult;
import com.rogear.jmeter.demo.pojo.User;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rogear2008
 * @time 2022/6/29 22:53
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static List<User> userList = new ArrayList<>();

    @PostConstruct
    public static void init() {
        userList.add(new User("1", "zhangsan", "123", true));
        userList.add(new User("2", "lisi", "123", true));
    }

    @GetMapping("/query")
    public CommonResult query(String username) {
        List<User> users = userList.stream().filter(x -> x.getUsername().equals(username)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(users)) {
            return new CommonResult(users.get(0));
        }
        return new CommonResult();
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        userList.add(user);
        return new CommonResult();
    }

    @DeleteMapping("/delete")
    public CommonResult delete(String id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(id)) {
                userList.remove(i);
                return new CommonResult();
            }
        }
        return new CommonResult("No user of id:" + id);
    }
}
