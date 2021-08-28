package cn.java.concurrent;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 作者: Jiang
 * 时间: 2021/8/1
 * 描述:
 */
public class ThreadLocalDemo {



    static ThreadLocal<DateFormat> local = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static Date parse(String strDate) throws ParseException {
        return local.get().parse(strDate);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            executorService.execute(()->{
                try{
                    System.out.println(parse("2021-05-30 20:12:30"));
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
    }
}
