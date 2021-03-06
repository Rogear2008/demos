package com.rogear.rabbitmq.type4;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rogear.rabbitmq.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName Provider
 * @Description 消息生产者
 * @Author Rogear
 * @Date 2020/6/11 23:10
 **/
public class Provider {

    private final static String EXCHANGE_NAME = "my_exchange_02";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //创建交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        //创建消息
        String message1 = "info message";
        String message2 = "error message";
        //向交换机发送消息,设置路由key
        channel.basicPublish(EXCHANGE_NAME,"info",null,message1.getBytes());
        channel.basicPublish(EXCHANGE_NAME,"error",null,message2.getBytes());
        System.out.println("send message : " + message1);
        System.out.println("send message : " + message2);
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
