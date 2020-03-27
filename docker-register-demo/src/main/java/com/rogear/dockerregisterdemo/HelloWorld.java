package com.rogear.dockerregisterdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rogear on 2020/3/27
 **/
@RestController
public class HelloWorld {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World !";
    }
}
