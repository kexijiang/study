package cn.java.thread.semaphoreandexchanger;

import cn.java.thread.semaphoreandexchanger.p_r_test.C;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 作者: Jiang
 * 时间: 2021/7/31
 * 描述:
 */
public class CyclicBarrierExample {
    public static void main(String[] args) {
        int n = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n, () ->
        {
            System.out.println("所有数据写入完毕，继续处理其他任务。");
        });
        for (int i = 0; i < n; i++) {
            Writer writer = new Writer(cyclicBarrier);
            writer.start();
        }
    }

    static class Writer extends Thread {
        private final CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "写入数据完毕，等待其他线程");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }
}
