package com.example.springbootprovider;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Rogear on 2020/6/12
 **/
@Configuration
public class RabbitConfig {

    private final String QUEUE_NAME_04 = "my_queue_04";
    private final String QUEUE_NAME_05 = "my_queue_05";
    private final String EXCHANGE_NAME = "my_exchange_05";

    /**
     * 创建队列
     * @return
     */
    @Bean
    public Queue myQueue04(){
        return new Queue(QUEUE_NAME_04);
    }

    /**
     * 创建队列
     * @return
     */
    @Bean
    public Queue myQueue05(){
        return new Queue(QUEUE_NAME_05);
    }

    /**
     * 创建交换机
     * @return
     */
    @Bean
    public TopicExchange myExchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    /**
     * 绑定交换机和队列（设置路由键）
     * @return
     */
    @Bean
    public Binding myBinding1(){
        return BindingBuilder.bind(myQueue04()).to(myExchange()).with("aa.bb.*");
    }

    /**
     * 绑定交换机和队列（设置路由键）
     * @return
     */
    @Bean
    public Binding myBinding2(){
        return BindingBuilder.bind(myQueue05()).to(myExchange()).with("aa.#");
    }
}
