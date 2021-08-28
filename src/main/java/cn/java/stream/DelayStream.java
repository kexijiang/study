package cn.java.stream;

import cn.hutool.log.Log;

import java.util.stream.Stream;

/**
 * @author: Jiang
 * @createTime: 2021-04-05 11:24
 * @description: 延迟方法: 返回值还是一个Stream的对象,可以继续调用Stream的方法,链式调用
 */
public class DelayStream {
    static final Log logger = Log.get();
    public static void main(String[] args) {
        //filter方法 返回一个新的流 参数为一个Predicate方法,如果为true 保留该元素
        Stream.of("电子","质子","中子","费米子","玻色子")
                .filter((String particle)-> particle.contains("子"))
                .forEach(logger::info);
        //map方法 返回一个映射后的流   m->m+2
        Stream.of("1","3","5","7").map(number->Integer.parseInt(number)+2).forEach(numberInt->logger.info(String.valueOf(numberInt)));
        //limit方法 对流进行截取 返回一个截取后的流 获取前几个元素
        Stream.of("3.","1","4","1").limit(3).forEach(logger::info);
        //skip方法 跳过前几个元素  返回一个截取后的流
        Stream.of("3.","1","4","1").skip(3).forEach(logger::info);
        //concat 方法, 将两个流合并为一个流
        Stream.concat(Stream.of("1","2","3","4"),Stream.of("张三","李四","王五","赵六")).forEach(logger::info);
    }
}
