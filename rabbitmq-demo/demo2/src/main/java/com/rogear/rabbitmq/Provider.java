package com.rogear.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.impl.AMQBasicProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName Provider
 * @Description 消息生产者
 * @Author Rogear
 * @Date 2020/6/11 23:10
 **/
public class Provider {

    private final static String QUEUE_NAME = "my_queue_01";
    private final static String EXCHANGE_NAME = "my_exchange_01";
    private static final String ROUTING_KEY = "dlx.hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //创建消息
        String message = "Hello World !";
        //设置消息过期时间
        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder().expiration("10000").build();
        //发布消息
        channel.basicPublish(EXCHANGE_NAME,ROUTING_KEY,true,properties,message.getBytes());
        System.out.println("send message : " + message);
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
