package cn.java.thread.semaphoreandexchanger.t6;

/**
 * @ClassName: CountOperate
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-11-15
 * @lastModificationTime:2020-11-15
 */
public class CountOperate extends Thread{
    public CountOperate(){
        System.out.println("CountOperate---begin");
        System.out.println("Thread.currentThread().getName() = "+Thread.currentThread().getName());
        System.out.println("this.getName()="+this.getName());
        System.out.println("CountOperate---end");
    }
    @Override
    public void run() {
        System.out.println("CountOperate---begin");
        System.out.println("Thread.currentThread().getName() = "+Thread.currentThread().getName());
        System.out.println("this.getName()="+this.getName());
        System.out.println("CountOperate---end");
    }
    static class Run{
        public static void main(String[] args) {
            CountOperate c = new CountOperate();
            Thread t1 = new Thread(c);
            t1.setName("A");
            t1.start();
        }
    }
}
