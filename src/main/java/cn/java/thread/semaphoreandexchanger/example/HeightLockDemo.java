package cn.java.thread.semaphoreandexchanger.example;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author: Jiang
 * @createTime: 2021-07-09 21:29
 * @description:
 */
public class HeightLockDemo {
    public static void main(String[] args) {
        HeightLockDemo demo = new HeightLockDemo();
        Thread t1 = new Thread(()->{
           synchronized (demo){
               System.out.println("t1 locked");
               System.out.println(ClassLayout.parseInstance(demo).toPrintable());
           }
        });
        t1.start();
        synchronized (demo){
            System.out.println("main locked");
            System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        }
    }

}
