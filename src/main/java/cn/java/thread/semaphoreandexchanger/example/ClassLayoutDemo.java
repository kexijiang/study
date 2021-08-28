package cn.java.thread.semaphoreandexchanger.example;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author: Jiang
 * @createTime: 2021-07-08 23:17
 * @description:
 */
public class ClassLayoutDemo {
    public static void main(String[] args) {
        /*创建一个对象实例*/
        ClassLayoutDemo cl = new ClassLayoutDemo();
        /*打印该对象实例在内存中的布局*/
        System.out.println(ClassLayout.parseInstance(cl).toPrintable());
    }
}
