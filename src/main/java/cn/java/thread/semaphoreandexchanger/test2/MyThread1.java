package cn.java.thread.semaphoreandexchanger.test2;

/**
 * @ClassName: MyThread1
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-11
 * @lastModificationTime:2020-12-11
 */
public class MyThread1 extends Thread{
    private Object lock;
    public MyThread1(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            synchronized (lock){
                System.out.println("开始 wait time="+System.currentTimeMillis());
                lock.wait();
                System.out.println("结束 wait time="+System.currentTimeMillis());
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
