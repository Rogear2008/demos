package com.rogear.gc;

/**
 * Created by Rogear on 2020/7/24
 * 引用计数算法
 **/
public class ReferenceCountingGC {
    public Object instance = null;

    public static void main(String[] args) {
        System.gc();
        ReferenceCountingGC a = new ReferenceCountingGC();
        ReferenceCountingGC b = new ReferenceCountingGC();
        a.instance = b;
        b.instance = a;
        //置空对象
        a = null;
        b = null;
        //手动调用gc
        System.out.println("start gc !");
        System.gc();
        while (true){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
