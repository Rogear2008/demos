package com.rogear.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 内存溢出
 * Created by Rogear on 2020/7/28
 **/
public class OOMDemo {
    public byte [] placeholder = new byte[1024 * 1024];

    public static void main(String[] args) {
        List<OOMDemo> oomDemoList = new ArrayList<OOMDemo>();
        while (true){
            oomDemoList.add(new OOMDemo());
        }
    }
}
