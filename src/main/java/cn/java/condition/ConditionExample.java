package cn.java.condition;

import java.util.concurrent.locks.Lock;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-26 21:36
 * 描述:
 */
public class ConditionExample {

    private static Lock lock;

    public static void main(String[] args) {
        try {
            lock.newCondition().await();
            lock.newCondition().signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
