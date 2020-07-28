package com.rogear.gc;

/**
 * JVM基本参数测试
 * Created by Rogear on 2020/7/28
 **/
public class JVMTest {
    public static void main(String[] args) {
        System.out.println("JVM : -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:./gc.log");
        System.gc();
    }
}
