package cn.java.thread.semaphoreandexchanger.ReentrantLockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Jiang
 * @createTime: 2020-12-20 21:51
 * @description:
 */
public class MyService {
    private final Lock lock = new ReentrantLock(true);
    public void testMethod(){
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName="+ Thread.currentThread().getName()+(" "+(i+1)));
            }
        }finally {
            lock.unlock();
        }
    }
}
class MyThread extends Thread{
    private final MyService service;
    public MyThread(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
class Run{
    public static void main(String[] args) {
        MyService service = new MyService();
        MyThread myThread1 = new MyThread(service);
        MyThread myThread2 = new MyThread(service);
        MyThread myThread3 = new MyThread(service);
        MyThread myThread4 = new MyThread(service);
        MyThread myThread5 = new MyThread(service);
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
    }
}