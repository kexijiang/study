package cn.java.thread.semaphoreandexchanger.synchronizedMethodLockObject2;

/**
 * @author: Jiang
 * @createTime: 2020-12-05 23:23
 * @description:
 */
public class MyObject {
    synchronized public void methodA(){
        try {
            System.out.println("begin methodA threadName="+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
     public void methodB(){
        try {
            System.out.println("begin methodB threadName="+Thread.currentThread().getName()+
                    " begin Time="+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("end");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
