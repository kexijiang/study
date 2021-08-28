package cn.java.thread.semaphoreandexchanger.synchronizedMethodLockObject2;

/**
 * @author: Jiang
 * @createTime: 2020-12-05 23:25
 * @description:
 */
public class ThreadA extends Thread {
    private MyObject object;
    public ThreadA(MyObject object){
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}
