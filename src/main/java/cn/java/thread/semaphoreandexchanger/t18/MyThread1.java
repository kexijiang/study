package cn.java.thread.semaphoreandexchanger.t18;

/**
 * @author: Jiang
 * @createTime: 2020-12-04 23:02
 * @description:
 */
public class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread1 run priority="+this.getPriority());
        Masthead2 thread2 = new Masthead2();
        thread2.start();
    }
}

class Masthead2 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread2 run priority="+this.getPriority());
    }
}

class Run{
    public static void main(String[] args) {
        System.out.println("main thread begin priority="+Thread.currentThread().getPriority());
        System.out.println("main thread end priority="+Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
    }
}
