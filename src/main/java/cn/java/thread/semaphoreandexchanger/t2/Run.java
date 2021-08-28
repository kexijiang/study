package cn.java.thread.semaphoreandexchanger.t2;

/**
 * @author: Jiang
 * @createTime: 2020-12-05 23:08
 * @description:
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(hasSelfPrivateNum);
        threadA.start();
        ThreadB threadB = new ThreadB(hasSelfPrivateNum);
        threadB.start();
    }
}
