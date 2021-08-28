package cn.java.thread.semaphoreandexchanger.Fair_noFair_test;

/**
 * @author: Jiang
 * @createTime: 2020-12-20 21:11
 * @description:
 */
public class MyThread extends Thread {
    private MyService service;

    public MyThread(MyService service) {
        super();
        this.service = service;
    }
    @Override
    public void run(){
        service.testMethod();
    }
}

