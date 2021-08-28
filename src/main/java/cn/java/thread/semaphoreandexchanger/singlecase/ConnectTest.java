package cn.java.thread.semaphoreandexchanger.singlecase;

/**
 * @author: Jiang
 * @createTime: 2021-06-27 9:59
 * @description:
 */
public class ConnectTest {

    public static void main(String[] args) {
        Runnable runnableA = () -> {
            LazyDbConnection lazyDbConnection = LazyDbConnection.getInstance();
            System.out.println(Thread.currentThread().getName()+":"+lazyDbConnection);
        };
        Runnable runnableB = () -> {
            LazyDbConnection lazyDbConnection = LazyDbConnection.getInstance();
            System.out.println(Thread.currentThread().getName()+":"+lazyDbConnection);
        };
        Thread A = new Thread(runnableA);
        Thread B = new Thread(runnableB);
        A.setName("A");
        B.setName("B");
        A.start();
        B.start();
    }
}
