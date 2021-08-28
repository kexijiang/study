package cn.java.thread.semaphoreandexchanger.MustUseMoreCondition_Error;

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
    public final Condition condition = lock.newCondition();
    public void awaitA(){
        lock.lock();
        try{
            System.out.println("begin awaitA时间为"+System.currentTimeMillis()+" ThreadName=" + Thread.currentThread().getName());
            condition.await();
            System.out.println("  end awaitA时间为"+System.currentTimeMillis()+" ThreadName=" + Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void awaitB(){
        lock.lock();
        try{
            System.out.println("begin awaitB时间为"+System.currentTimeMillis()+" ThreadName=" + Thread.currentThread().getName());
            condition.await();
            System.out.println("  end awaitB时间为"+System.currentTimeMillis()+" ThreadName=" + Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void signalAll(){
        lock.lock();
        try{
            System.out.println("  signalAll时间为"+System.currentTimeMillis()+" ThreadName=" + Thread.currentThread().getName());
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
class ThreadA extends Thread{
    private final MyService service;
    public ThreadA(MyService service){
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.awaitA();
    }
}
class ThreadB extends Thread{
    private final MyService service;
    public ThreadB(MyService service){
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.awaitB();
    }
}
class Run{
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB = new ThreadB(myService);
        threadB.setName("B");
        threadB.start();
        Thread.sleep(3000);
        myService.signalAll();
    }
}