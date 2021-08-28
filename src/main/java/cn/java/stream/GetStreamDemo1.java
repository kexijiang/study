package cn.java.stream;

import cn.hutool.log.Log;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author: Jiang
 * @createTime: 2021-04-05 10:46
 * @description:
 */
public class GetStreamDemo1 {
    static final Log logger = Log.get();
    public static void main(String[] args) {
        //list获取流
        List<String> stringList = new ArrayList<>();
        Stream<String> stringStream = stringList.stream();
        //set获取流
        Set<String> stringSet = new HashSet<>();
        stringStream = stringSet.stream();
        //Map的key获取流
        Map<String,String> map = new HashMap<>();
        Set<String> keySet = map.keySet();
        stringStream = keySet.stream();
        Collection<String> values = map.values();
        stringStream = values.stream();
        //获取map的映射关系的流
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String,String>> stringStream1 = entries.stream();
        //把数组转换为liu
        Stream<Integer> integerStream = Stream.of(0, 1, 3, 2, 54, 6);


    }
}
