package com.rogear.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName ConnectionUtil
 * @Description 连接Rabbitmq的工具类
 * @Author Rogear
 * @Date 2020/6/11 23:02
 **/
public class ConnectionUtil {

    public static Connection getConnection() throws IOException, TimeoutException {
        //定义连接工程
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        //设置用户名、密码、vhost
        connectionFactory.setUsername("user1");
        connectionFactory.setPassword("user1");
        connectionFactory.setVirtualHost("myVirtualHost");
        Connection connection = connectionFactory.newConnection();
        return connection;
    }
}
