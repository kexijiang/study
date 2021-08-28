package cn.java.thread.semaphoreandexchanger.example;

/**
 * @author: Jiang
 * @createTime: 2021-07-08 21:58
 * @description:
 */
public class AtomicDemo {
    int i = 0;
    public synchronized void incr(){
        /*不是原子操作*/
        i++;
    }
    public static void main(String[] args) throws InterruptedException {
        AtomicDemo ad = new AtomicDemo();
        Thread[] thread = new Thread[2];
        for (int i = 0; i < 2; i++) {
            thread[i] = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    ad.incr();
                }
            });
            thread[i].start();
        }
        thread[0].join();
        thread[1].join();
        System.out.println("result:"+ad.i);

    }
}
