package cn.java.thread.semaphoreandexchanger.synchronizedMethodLockObject;

/**
 * @author: Jiang
 * @createTime: 2020-12-04 23:15
 * @description:
 */
public class Run {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        ThreadA threadA = new ThreadA(myObject);
        threadA.setName("a");
        ThreadB threadB = new ThreadB(myObject);
        threadB.setName("b");
        threadA.start();
        threadB.start();
    }
}
