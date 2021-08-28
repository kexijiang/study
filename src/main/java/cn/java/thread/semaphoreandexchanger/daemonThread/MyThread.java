package cn.java.thread.semaphoreandexchanger.daemonThread;

/**
 * @author: Jiang
 * @createTime: 2020-12-04 23:26
 * @description:
 */
public class MyThread extends Thread{
    private int i = 0;
    @Override
    public void run() {
        try {
            while(true){
                i++;
                System.out.println("i="+(i));
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
