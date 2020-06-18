package com.rogear;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * 主题
 * Created by Rogear on 2020/6/18
 **/
public class Topic {
    public static void main(String[] args) {
        //设置连接参数
        Properties properties = new Properties();
        properties.put("bootstrap.servers","192.168.1.80:9092");
        AdminClient adminClient = AdminClient.create(properties);
        //创建一个topic
        ArrayList<NewTopic> topics = new ArrayList<NewTopic>();
        NewTopic newTopic = new NewTopic("topic1",1,(short) 1);
        topics.add(newTopic);
        CreateTopicsResult result = adminClient.createTopics(topics);
        try {
            result.all().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("创建topic：“topic1”成功！");
    }
}
