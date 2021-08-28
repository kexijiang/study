package cn.java.thread.semaphoreandexchanger.Fair_noFair_test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Jiang
 * @createTime: 2020-12-20 21:07
 * @description:
 */
public class MyService {
    public Lock lock;
    public MyService(boolean fair){
        lock = new ReentrantLock(fair);
    }
    public void testMethod(){
        try {
            lock.lock();
            System.out.println("testMethod "+ Thread.currentThread().getName());
            Thread.sleep(500);
            lock.unlock();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
