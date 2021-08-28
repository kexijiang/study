package cn.java.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-18 18:14
 * 描述:
 */
public class ConditionExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ConditionDemoWait conditionDemoWait = new ConditionDemoWait(lock,condition);
        ConditionDemoNotify conditionDemoNotify = new ConditionDemoNotify(lock,condition);


    }
}
