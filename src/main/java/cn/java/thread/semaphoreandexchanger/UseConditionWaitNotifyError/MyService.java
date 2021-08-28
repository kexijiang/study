package cn.java.thread.semaphoreandexchanger.UseConditionWaitNotifyError;



import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: myService
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-21
 * @lastModificationTime: 2020-12-21
 */
public class MyService {
    private final Lock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();
    public void await(){
        try {
            condition.await();
        }catch (InterruptedException e){
            e.printStackTrace();
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
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        threadA.start();
    }
}
