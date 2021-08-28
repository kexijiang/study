package cn.java.thread.semaphoreandexchanger.example;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author: Jiang
 * @createTime: 2021-07-09 21:16
 * @description:
 */
public class LockDemo {
    Object o = new Object();

    public static void main(String[] args) {
        LockDemo demo = new LockDemo();
        /*加锁之前打印该对象的内存显示*/
        System.out.println(ClassLayout.parseInstance(demo).toPrintable());

        System.out.println("加锁之后。。。。。");
        /*此时加锁变为轻量级锁，此时有其他线程进入到下面的同步块，会先自旋，*/
        /*CAS（） 保证数据操作的原子性。*/
        synchronized (demo){
            System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        }

    }
}
