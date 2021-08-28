package cn.java.thread.semaphoreandexchanger.innerTest1;

/**
 * @ClassName: OutClass
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-07
 * @lastModificationTime: 2020-12-07
 */
public class OutClass {
    static class Inner {
        public void method1(){
            synchronized ("其他的锁"){
                for(int i =1;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+" i="+i);
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        public synchronized void method2(){
            for (int i = 11; i <= 20 ; i++) {
                System.out.println(Thread.currentThread().getName()+" i="+i);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
class Run{
    public static void main(String[] args) {
        final OutClass.Inner inner = new OutClass.Inner();
        Thread t1 = new Thread(inner::method1,"A");
        Thread t2 = new Thread(inner::method2,"B");
        t1.start();
        t2.start();
    }
}
