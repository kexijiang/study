package cn.java.thread.semaphoreandexchanger.Fair_noFair_test;

/**
 * @author: Jiang
 * @createTime: 2020-12-20 21:13
 * @description:
 */
public class Test1_1 {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService(false);
        MyThread[] array1 = new MyThread[10];
        MyThread[] array2 = new MyThread[10];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = new MyThread(myService);
            array1[i].setName("array1+++"+(i+1));
        }
        for (int i = 0; i < array1.length; i++) {
            array1[i].start();
        }
        for (int i = 0; i <array2.length ; i++) {
            array2[i] = new MyThread(myService);
            array2[i].setName("array2---"+(i+1));
        }
        Thread.sleep(500);
        for (int i = 0; i < array2.length; i++) {
            array2[i].start();
        }
    }
}
