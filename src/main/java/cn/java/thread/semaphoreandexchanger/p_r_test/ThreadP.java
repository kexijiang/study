package cn.java.thread.semaphoreandexchanger.p_r_test;

/**
 * @ClassName: ThreadP
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-14
 * @lastModificationTime:2020-12-14
 */
public class ThreadP extends Thread {
    private P p;

    public ThreadP(P p){
        super();
        this.p = p;
    }

    @Override
    public void run() {
        while (true){
            p.setValue();
        }
    }
}
