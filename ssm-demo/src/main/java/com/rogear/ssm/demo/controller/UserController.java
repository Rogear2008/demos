package com.rogear.ssm.demo.controller;

import com.rogear.ssm.demo.common.api.CommonResult;
import com.rogear.ssm.demo.common.api.EasyUiPage;
import com.rogear.ssm.demo.entity.User;
import com.rogear.ssm.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Rogear2008
 * @time 2022/6/13 21:53
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/page")
    public String page() {
        return "user-page";
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public EasyUiPage<User> listUser(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                       @RequestParam(value = "keyWord", required = false) String keyWord) {
        EasyUiPage<User> userPage = userService.listUser(pageNum, pageSize, keyWord);
        return userPage;
    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult createUser(User user) {
        CommonResult result = userService.createUser(user);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult updateUser(User user) {
        CommonResult result = userService.updateUser(user);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(Integer id) {
        CommonResult result = userService.delete(id);
        return result;
    }
}
