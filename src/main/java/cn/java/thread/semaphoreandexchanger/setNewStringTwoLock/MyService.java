package cn.java.thread.semaphoreandexchanger.setNewStringTwoLock;

/**
 * @ClassName: MyService
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-07
 * @lastModificationTime:2020-12-07
 */
public class MyService {
    private String lock = "123";
    public void testMethod(){
        try{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
                lock = "456";
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" end "+System.currentTimeMillis());
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
class ThreadA implements Runnable{
    private MyService service;
    public ThreadA(MyService service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.testMethod();
    }
}
class ThreadB implements Runnable{
    private MyService service;
    public ThreadB(MyService service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.testMethod();
    }
}
class Run{
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();

        ThreadA threadA = new ThreadA(myService);
        ThreadB threadB = new ThreadB(myService);
        Thread t1 = new Thread(threadA,"A");
        Thread t2 = new Thread(threadB,"B");
        t1.start();
        Thread.sleep(50);
        t2.start();
    }
}
