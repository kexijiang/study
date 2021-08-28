package cn.java.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-18 18:08
 * 描述:
 */
public class ConditionDemoWait implements Runnable{

    private Lock lock;
    private Condition condition;

    public ConditionDemoWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }


    @Override
    public void run() {
        System.out.println("begin - ConditionDemoWait");
        lock.lock();
        try{
            condition.signal();//线程唤醒 Object.notify() //因为任何对象都有monitor对象监视器
            System.out.println("end - ConditionDemoWait");
        } finally {
            lock.unlock();
        }
    }
}
