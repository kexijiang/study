package cn.java.thread.semaphoreandexchanger.twoObjectTwoLock;


/**
 * @author: Jiang
 * @createTime: 2020-12-05 23:08
 * @description:
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum1 = new HasSelfPrivateNum();
        HasSelfPrivateNum hasSelfPrivateNum2 = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(hasSelfPrivateNum1);
        threadA.start();
        ThreadB threadB = new ThreadB(hasSelfPrivateNum2);
        threadB.start();
    }
}
