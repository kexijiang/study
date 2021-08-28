package cn.java.requestblockqueue;

import cn.java.thread.semaphoreandexchanger.p_r_test.C;

import java.util.concurrent.CountDownLatch;

/**
 * 作者: Jiang
 * 时间: 2021/7/31
 * 描述:
 */
public class ChainExample {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(3);
        countDownLatch.countDown();

        FinalRequestProcessor finalRequestProcessor = new FinalRequestProcessor();
        finalRequestProcessor.start();
        SaveRequestProcessor saveRequestProcessor = new SaveRequestProcessor(finalRequestProcessor);
        saveRequestProcessor.start();
        PrintProcessor printProcessor = new PrintProcessor(saveRequestProcessor);
        printProcessor.start();
        for (int i = 0; i < 10; i++) {
            ValidProcessor validProcessor = new ValidProcessor(printProcessor);
            Request request = new Request();
            request.setName("Jiang"+i);
            validProcessor.processorRequest(request);
            validProcessor.start();
        }
    }
}
