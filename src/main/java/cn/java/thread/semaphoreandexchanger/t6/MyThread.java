package cn.java.thread.semaphoreandexchanger.t6;

/**
 * @ClassName: MyThread
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-11-15
 * @lastModificationTime: 2020-11-15
 */
public class MyThread  extends Thread{
    public MyThread(){
        System.out.println("构造方法的打印:"+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法的打印:"+Thread.currentThread().getName());
    }
}
class Run2{
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //调用run方法时机不确定，启动新的线程
        //myThread.start();
        /**调用run方法，立即执行方法，不启动新的线程**/
        myThread.run();
    }
}
