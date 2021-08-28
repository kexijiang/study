package cn.java.thread.semaphoreandexchanger.joinTest1;

/**
 * @author: Jiang
 * @createTime: 2020-12-16 20:10
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        MyThread threadTest = new MyThread();
        threadTest.start();
        //Thread.sleep(?)
        System.out.println("main线程想实现当threadTest对象执行完毕后我在继续向下执行,");
        System.out.println("但上面的代码中的sleep()中的值应该写多少呢?");
        System.out.println("答案是:不能确定!");
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
