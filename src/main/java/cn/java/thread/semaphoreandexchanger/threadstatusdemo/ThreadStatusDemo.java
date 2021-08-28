package cn.java.thread.semaphoreandexchanger.threadstatusdemo;

import lombok.SneakyThrows;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author: Jiang
 * @createTime: 2021-07-06 21:44
 * @description: 线程状态demo类
 */
public class ThreadStatusDemo {
    public static void main(String[] args) {

        /*TIME_WAITING状态*/
        new Thread(()->{
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"TIME_WAITING").start();
        /*WAITING状态*/
        new Thread(()->{
            Map<String,Object> a = new ConcurrentHashMap<>();
            while (true) {
                synchronized (ThreadStatusDemo.class){
                    try {
                        ThreadStatusDemo.class.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        },"WAITING").start();

        new Thread(new BlockDemo(),"BLOCK-DEMO-01").start();
        new Thread(new BlockDemo(),"BLOCK-DEMO-02").start();

    }
    static class BlockDemo extends Thread {
        @SneakyThrows
        @Override
        public void run() {
//            synchronized (BlockDemo.class){
//                while (true) TimeUnit.SECONDS.sleep(100);
//            }
        }
    }
}
