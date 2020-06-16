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
 * @Description 消息消费者
 * @Author Rogear
 * @Date 2020/6/11 23:18
 **/
public class Consumer {

    private static final String QUEUE_NAME = "my_queue_01";
    private final static String EXCHANGE_NAME = "my_exchange_01";
    //死信队列
    private static final String DLX_QUEUE_NAME = "dlx_queue_01";
    private final static String DLX_EXCHANGE_NAME = "dlx_exchange_01";
    private static final String ROUTING_KEY = "dlx.#";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //声明一个普通的交换机、队列和路由
        channel.exchangeDeclare(EXCHANGE_NAME,"topic",true,false,null);
        //设置私信队列的交换机
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("x-dead-letter-exchange",DLX_EXCHANGE_NAME);
        //声明队列
        channel.queueDeclare(QUEUE_NAME,true,false,false,map);
        //绑定
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTING_KEY);

        //声明私信队列
        channel.exchangeDeclare(DLX_EXCHANGE_NAME,"topic",true,false,null);
        channel.queueDeclare(DLX_QUEUE_NAME,true,false,false,null);
        channel.queueBind(DLX_QUEUE_NAME,DLX_EXCHANGE_NAME,"#");

        //循环监听消息
        while (true){
            //监听普通队列
            GetResponse response = channel.basicGet(QUEUE_NAME, true);
            if (response != null){
                System.out.println("[Consumer1] receive message : " + new String(response.getBody()));
            }
            //休息10毫秒
            Thread.sleep(10);
        }
    }
}
