package cn.java.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-18 18:08
 * 描述:
 */
public class ConditionDemoNotify implements Runnable{

    private Lock lock;
    private Condition condition;

    public ConditionDemoNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }


    @Override
    public void run() {
        System.out.println("begin - ConditionDemoNotify");
        lock.lock();
        try{
            condition.await();//线程阻塞 Object.wiat() //因为任何对象都有monitor对象监视器
            System.out.println("end - ConditionDemoNotify");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
