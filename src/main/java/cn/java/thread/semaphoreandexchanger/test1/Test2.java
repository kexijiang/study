package cn.java.thread.semaphoreandexchanger.test1;

/**
 * @ClassName: Test2
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-11
 * @lastModificationTime:2020-12-11
 */
public class Test2 {
    public static void main(String[] args) {
        try{
            String  lock = new String("");
            System.out.println("syn上面");
            synchronized (lock){
                System.out.println("syn第一行");
                lock.wait();
                System.out.println("wait下面的代码");
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
