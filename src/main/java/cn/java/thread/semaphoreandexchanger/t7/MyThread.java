package cn.java.thread.semaphoreandexchanger.t7;

/**
 * @ClassName: MyThread
 * @Description: isAlive()方法：判断当前线程是否存活
 * @Author: kxjiang
 * @Date: 2020-11-15
 * @lastModificationTime:2020-11-15
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("run="+this.isAlive());
    }
}
class Run{
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("begin =="+myThread.isAlive());
        myThread.start();
        System.out.println("end =="+myThread.isAlive());
    }
}
