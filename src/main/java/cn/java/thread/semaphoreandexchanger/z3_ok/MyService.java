package cn.java.thread.semaphoreandexchanger.z3_ok;


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
    private final Lock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();
    public void await(){
        lock.lock();
        try {
            System.out.println("A");
            condition.await();
            System.out.println("B");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("锁释放了！");
        }
    }
}
class MyThreadA extends Thread{
    private final MyService service;

    public MyThreadA(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
class Run{
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThreadA a1 = new MyThreadA(myService);
        a1.start();
        MyThreadA a2 = new MyThreadA(myService);
        a2.start();
        MyThreadA a3 = new MyThreadA(myService);
        a3.start();
    }
}