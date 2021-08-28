package cn.java.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * 作者: Jiang
 * 时间: 2021/8/2
 * 描述:
 */
public class CHMExample {
    private static final ConcurrentHashMap<String,Long> USER_ACESS_COUNT=new ConcurrentHashMap<>();

    public static void main(String[] args) {
        //针对用户来做一个访问次数的记录
        Long accessCount = USER_ACESS_COUNT.get("mic");
        //非线程安全的，有可能数据被覆盖
//        if(accessCount == null){
//            USER_ACESS_COUNT.put("mic",1L);
//        }else{
//            USER_ACESS_COUNT.put("mic",accessCount+1);
//        }
        //如果key不存在，将后面的lambda表达式作为value写入
        USER_ACESS_COUNT.computeIfAbsent("mic",k->1L);
        //如果key存在，则执行lambda表达式，
//        USER_ACESS_COUNT.computeIfPresent("mic",(k,v)->{
//
//        });
        ConcurrentHashMap<Integer,Integer> chm = new ConcurrentHashMap<>();
        Stream.of(1,2,2,4,6,7,2,3,4,6,8,1).forEach(v->{
            chm.merge(v,5, Integer::sum);
        });
        System.out.println(chm);
    }
}
