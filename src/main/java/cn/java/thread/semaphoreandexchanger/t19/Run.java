package cn.java.thread.semaphoreandexchanger.t19;

/**
 * @author: Jiang
 * @createTime: 2020-12-04 23:15
 * @description:
 */
public class Run {
    public static void main(String[] args) {
        for(int i = 0;i < 5;i++){
            MyThread1 thread1 = new MyThread1();
            thread1.setPriority(1);
            thread1.start();
            MyThread2 myThread2 = new MyThread2();
            myThread2.setPriority(10);
            myThread2.start();
        }
    }
}
