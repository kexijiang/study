package cn.java.thread.semaphoreandexchanger.daemonThread;
/**
 * @author: Jiang
 * @createTime: 2020-12-04 23:28
 * @description:
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.setDaemon(true);
            myThread.start();
            Thread.sleep(5000);
            System.out.println("我离开myThread对象也不在打印了,也就是停止了!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
