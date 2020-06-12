package com.rogear.rabbitmq.type2;

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

    private final static String QUEUE_NAME = "my_queue_01";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //创建队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //发布消息
        for (int i = 0;i < 100;i++){
            //创建消息
            String message = "[" + i + "] Hello World !";
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            System.out.println("send message : " + message);
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
