package cn.java.thread.semaphoreandexchanger.synchronizedMethodLockObject;

/**
 * @author: Jiang
 * @createTime: 2020-12-05 23:25
 * @description:
 */
public class ThreadB extends Thread {
    private MyObject object;
    public ThreadB(MyObject object){
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}
