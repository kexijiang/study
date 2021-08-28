package cn.java.stream;

import cn.hutool.log.Log;

import java.util.stream.Stream;

/**
 * @author: Jiang
 * @createTime: 2021-04-05 11:21
 * @description: 流的终结方法有两个 forEach 与 count
 */
public class PutAnEndToStream {
    static final Log logger = Log.get();
    public static void main(String[] args) {
        //forEach方法 终结方法,无返回值 消费方法
        Stream.of("一","二","三","四").forEach(logger::info);
        //count方法 终结方法 返回值为一个long类型的整数
        long count = Stream.of("一","二","三","四").count();
        logger.info(String.valueOf(count));
    }
}
