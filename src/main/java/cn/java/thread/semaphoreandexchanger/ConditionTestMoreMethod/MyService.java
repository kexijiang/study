package cn.java.thread.semaphoreandexchanger.ConditionTestMoreMethod;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Jiang
 * @createTime: 2020-12-20 22:05
 * @description:
 */
public class MyService {
    private final Lock lock = new ReentrantLock();
    public void methodA(){
        lock.lock();
        try{
            System.out.println("methodA begin ThreadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodA end ThreadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void methodB(){
        lock.lock();
        try{
            System.out.println("methodB begin ThreadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodB end ThreadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
class ThreadA extends Thread{
    private MyService service;
    public ThreadA(MyService service){
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.methodA();
    }
}
class ThreadAA extends Thread{
    private final MyService service;
    public ThreadAA(MyService service){
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.methodA();
    }
}
class ThreadB extends Thread{
    private MyService service;
    public ThreadB(MyService service){
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.methodB();
    }
}
class ThreadBB extends Thread{
    private final MyService service;
    public ThreadBB(MyService service){
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.methodB();
    }
}
class Run{
    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadAA aa = new ThreadAA(service);
        aa.setName("AA");
        aa.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        ThreadBB bb = new ThreadBB(service);
        bb.setName("BB");
        bb.start();
    }
}