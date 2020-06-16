package com.rogear.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.GetResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName Consumer
 * @Description 死信队列消费者
 * @Author Rogear
 * @Date 2020/6/11 23:18
 **/
public class DlxConsumer {

    private static final String DLX_QUEUE_NAME = "dlx_queue_01";
    private final static String DLX_EXCHANGE_NAME = "my_exchange_01";
    private static final String ROUTING_KEY = "dlx.#";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //声明死信队列
        channel.queueDeclare(DLX_QUEUE_NAME,true,false,false,null);
        channel.queueBind(DLX_QUEUE_NAME,DLX_EXCHANGE_NAME,ROUTING_KEY);

        //循环监听消息
        while (true){
            //监听死信队列
            GetResponse response = channel.basicGet(DLX_QUEUE_NAME, true);
            if (response != null){
                System.out.println("[DLX] receive message : " + new String(response.getBody()));
            }
            //休息10毫秒
            Thread.sleep(10);
        }
    }
}
