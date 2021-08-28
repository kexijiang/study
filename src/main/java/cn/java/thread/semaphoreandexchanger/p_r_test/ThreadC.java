package cn.java.thread.semaphoreandexchanger.p_r_test;

/**
 * @ClassName: ThreadC
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-14
 * @lastModificationTime:2020-12-14
 */
public class ThreadC extends Thread {
    private  C r;
    public ThreadC(C r){
        super();
        this.r = r;
    }

    @Override
    public void run() {
        while (true){
            r.getValue();
        }
    }
}
