package cn.java.thread.semaphoreandexchanger.t2;

/**
 * @author: Jiang
 * @createTime: 2020-12-05 23:07
 * @description:
 */
public class ThreadB extends Thread {
    private HasSelfPrivateNum numRef;
    public ThreadB(HasSelfPrivateNum numRef){
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
