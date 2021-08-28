package cn.java.thread.semaphoreandexchanger.p_r_test;

/**
 * @ClassName: Run
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-14
 * @lastModificationTime:2020-12-14
 */
public class Run {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C r = new C(lock);
        ThreadP threadP = new ThreadP(p);
        ThreadC threadC = new ThreadC(r);
        threadP.start();
        threadC.start();
    }
}
