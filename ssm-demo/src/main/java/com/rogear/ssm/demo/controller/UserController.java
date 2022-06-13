package com.rogear.ssm.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Rogear2008
 * @time 2022/6/13 21:53
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/page")
    public String page() {
        return "user-page";
    }
}
