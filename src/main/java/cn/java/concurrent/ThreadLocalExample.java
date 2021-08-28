package cn.java.concurrent;

/**
 * 作者: Jiang
 * 时间: 2021/8/1
 * 描述:
 */
public class ThreadLocalExample {
    //如果需要每个线程都拿到的是初始值0,使用ThreadLocal来进行线程隔离
    private static int num = 0;

    static ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 0;
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                int num  = local.get();
                local.set(num+=5);
                System.out.println(Thread.currentThread().getName()+"     "+local.get());
            }).start();
        }
    }
}
