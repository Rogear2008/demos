package com.example.springbootprovider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rogear on 2020/6/12
 **/
@RestController
public class Provider {

    private final String QUEUE_NAME = "my_queue_04";
    private final String EXCHANGE_NAME = "my_exchange_05";
    private final String ROUTE_KEY = "aa.bb.cc";

    private final AmqpTemplate amqpTemplate;

    public Provider(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @RequestMapping("/send")
    public String send(){
        String message = "Hello World !";
        amqpTemplate.convertAndSend(QUEUE_NAME,message);
        System.out.println("send message !");
        return "success";
    }

    @RequestMapping("/sendTopic")
    public String sendTopic(){
        String message = "Hello World !";
        amqpTemplate.convertAndSend(EXCHANGE_NAME,ROUTE_KEY,message);
        System.out.println("send topic message !");
        return "success";
    }
}
