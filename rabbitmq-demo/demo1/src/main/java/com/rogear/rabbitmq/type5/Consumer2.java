package com.rogear.rabbitmq.type5;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.GetResponse;
import com.rogear.rabbitmq.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName Consumer
 * @Description 消息消费者
 * @Author Rogear
 * @Date 2020/6/11 23:18
 **/
public class Consumer2 {

    private static final String QUEUE_NAME = "my_queue_02";
    private final static String EXCHANGE_NAME = "my_exchange_03";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //队列绑定到交换机
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"aa.#");
        //循环监听消息
        while (true){
            GetResponse response = channel.basicGet(QUEUE_NAME, true);
            if (response != null){
                System.out.println("[Consumer2] receive message : " + new String(response.getBody()));
            }
            //休息10毫秒
            Thread.sleep(10);
        }
    }
}
