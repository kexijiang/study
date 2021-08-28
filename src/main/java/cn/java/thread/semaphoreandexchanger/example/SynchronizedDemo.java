package cn.java.thread.semaphoreandexchanger.example;

/**
 * @author: Jiang
 * @createTime: 2021-07-08 22:13
 * @description:
 */
public class SynchronizedDemo {
    /*修饰实例方法*/
    public synchronized void m1(){
        while (true){

        }
    }
    /*修饰代码块*/
    public void m2() {
        synchronized (SynchronizedDemo.class){

        }
    }

    public static void main(String[] args) {
        /*synchronized的枷锁范围*/
        SynchronizedDemo demo1 = new SynchronizedDemo();
        SynchronizedDemo demo2 = new SynchronizedDemo();
        new Thread(demo1::m1).start();
        new Thread(demo2::m1).start();
    }

    public static synchronized  void m3(){

    }

}
