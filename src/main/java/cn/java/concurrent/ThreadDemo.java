package cn.java.concurrent;

import java.time.LocalDateTime;
import java.util.concurrent.CyclicBarrier;

/**
 * 作者: Jiang
 * 时间: 2021/8/4
 * 描述:
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Thread[] threadArr = new Thread[100];
        for (int i = 0; i < threadArr.length; i++) {
            threadArr[i] = new Thread(new ThreadExample());
            threadArr[i].start();
        }
    }
}

class ThreadExample implements Runnable{

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(100);

    @Override
    public void run() {
        try{
            cyclicBarrier.await();
            //此处写业务代码
            System.out.println(LocalDateTime.now());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
