package com.example.springbootconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Rogear on 2020/6/12
 **/
@Component
@RabbitListener(queues = "my_queue_04")
public class Consumer1 {

    @RabbitHandler
    public void receive(String message){
        System.out.println("[consumer1] receive message : " + message);
    }
}
