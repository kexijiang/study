package cn.java.thread.semaphoreandexchanger.UseConditionWitNotifyOK;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyService
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-21
 * @lastModificationTime:2020-12-21
 */
public class MyService {
    private final Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public void await(){
        lock.lock();
        try{
            System.out.println(" await时间为"+System.currentTimeMillis());
            condition.await();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void signal(){
        lock.lock();
        try{
            System.out.println("signal时间为"+System.currentTimeMillis());
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}
class ThreadA extends Thread{
    private final MyService service;

    public ThreadA(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
class Run{
    public static void main(String[] args) throws InterruptedException{
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        threadA.start();
        Thread.sleep(3000);
        myService.signal();
    }
}
