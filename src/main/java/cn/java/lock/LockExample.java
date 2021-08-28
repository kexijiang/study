package cn.java.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-17 17:31
 * 描述: 重入锁的例子
 */
public class LockExample {

    static Lock lock = new ReentrantLock();

    private static int count = 0;

    public static void inc(){

        if(lock.tryLock()){//返回true,代表抢占成功,false,代表抢占失败,如果没抢占到锁，这里不会阻塞
            //如果未获取到锁,不会走此代码块中代码
        }
        lock.lock();//抢占锁 如果没有抢占到锁会阻塞
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        count++;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Thread thread1 = new Thread(()->{
                LockExample.inc();
            });
            thread1.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result:"+count);
    }
}
