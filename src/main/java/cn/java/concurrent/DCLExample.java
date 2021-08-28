package cn.java.concurrent;

import cn.java.thread.semaphoreandexchanger.p_r_test.P;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-17 16:07
 * 描述:
 */
public class DCLExample {
    static DCLExample instance;
    public static DCLExample getInstance(){
        if(instance == null){
            synchronized (DCLExample.class){
                if(instance == null){
                    instance = new DCLExample();
                }
            }
        }
        return instance;
    }
}
