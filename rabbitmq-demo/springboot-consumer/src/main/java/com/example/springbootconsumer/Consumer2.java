package com.example.springbootconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Rogear on 2020/6/12
 **/
@Component
@RabbitListener(queues = "my_queue_05")
public class Consumer2 {

    @RabbitHandler
    public void receive(String message){
        System.out.println("[consumer2] receive message : " + message);
    }
}
