package cn.java.thread.semaphoreandexchanger.semaphoretest1;

import cn.hutool.log.Log;

/**
 * 作者: Jiang
 * 创建时间: 2021-05-06 17:15
 * 描述: 运行测试类
 */

public class Run {
    private final static Log logger = Log.get();
    public static void main(String[] args) throws InterruptedException {
        AcquireUnireUninterruptiblyService service = new AcquireUnireUninterruptiblyService();

        ThreadTest threadTest = new ThreadTest(service);
        threadTest.setName("a");
        threadTest.start();

        ThreadTest threadTest1 = new ThreadTest(service);
        threadTest1.setName("b");
        threadTest1.start();
        Thread.sleep(1000);
        threadTest1.interrupt();
        logger.info("主线程中断了b!");
    }
}
