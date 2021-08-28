package cn.java.thread.semaphoreandexchanger.joinTest2;

/**
 * @author: Jiang
 * @createTime: 2020-12-16 20:10
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        try{
            MyThread threadTest = new MyThread();
            threadTest.start();
            //Thread.sleep(?)
            threadTest.join();
            System.out.println("我想当threadTest对象执行完毕后我在执行,我做到了");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        try{
            int secondValue = (int) (Math.random()*10000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        super.run();
    }
}