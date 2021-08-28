package cn.java.thread.semaphoreandexchanger.wait_notify_service;

/**
 * @ClassName: Test
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-11
 * @lastModificationTime:2020-12-11
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        MyThreadA myThreadA = new MyThreadA(myService);
        myThreadA.start();
        Thread.sleep(5000);
        MyThreadB myThreadB = new MyThreadB(myService);
        myThreadB.start();
    }
}
