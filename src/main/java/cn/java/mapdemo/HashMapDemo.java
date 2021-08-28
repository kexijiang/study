package cn.java.mapdemo;

import java.util.HashMap;

/**
 * @author: Jiang
 * @createTime: 2021-07-10 22:47
 * @description:
 */
public class HashMapDemo {


    public static void main(String[] args) {
        HashMap<String,String> demo = new HashMap<>();
        demo.put("index","hello");
        String val = demo.put("index","world");
        System.out.println(val);
        System.out.println(0.75*16);
    }
}
