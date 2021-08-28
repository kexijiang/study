package cn.java.thread.semaphoreandexchanger.semaphoretest1;

/**
 * 作者: Jiang
 * 创建时间: 2021-05-06 17:12
 * 描述: 线程类
 */
public class ThreadTest extends Thread {
    private AcquireUnireUninterruptiblyService service = new AcquireUnireUninterruptiblyService();

    public ThreadTest(AcquireUnireUninterruptiblyService service) {
        super();
        this.service = service;
    }
    @Override
    public void run(){
        service.testMethod();
    }
}
