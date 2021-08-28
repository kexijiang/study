package cn.java.thread.semaphoreandexchanger.semaphoretest1;

import cn.hutool.log.Log;

import java.util.concurrent.Semaphore;

/**
 * 作者: Jiang
 * 创建时间: 2021-05-06 17:06
 * 描述: 方法acquireUnireUninterruptibly()的使用
 */
public class AcquireUnireUninterruptiblyService {
    private final Semaphore semaphore = new Semaphore(1);
    private final static Log logger = Log.get();
    public void testMethod(){
        try {
            semaphore.acquire();
            logger.info("线程{}启动时间:{}",Thread.currentThread().getName(),System.currentTimeMillis());
            for (int i = 0; i < Integer.MAX_VALUE/10; i++) {
                String newString = new String();
                Math.random();
            }
            logger.info("线程{}结束时间:{}",Thread.currentThread().getName(),System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            logger.error("线程{}进入了catch",Thread.currentThread().getName());
            e.printStackTrace();
        }
    }
}
