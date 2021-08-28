package cn.java.thread.semaphoreandexchanger.innerTest2;

/**
 * @ClassName: OutClass
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-07
 * @lastModificationTime:2020-12-07
 */
public class OutClass {
    static class InnerClass1 {
        public void method1(InnerClass2 class2){
            String threadName = Thread.currentThread().getName();
            synchronized (class2){
                System.out.println(threadName +" 进入InnerClass1类中的method1方法");
                for(int i =1;i<10;i++){
                    System.out.println("i=" +i);
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println(threadName + " 离开InnerClass1类中的method1方法");
            }
        }
        public synchronized void method2(){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName +" 进入InnerClass1类中的method2方法");
            for (int i = 11; i <= 20 ; i++) {
                System.out.println("j=" +i);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " 离开InnerClass1类中的method2方法");
        }
    }
    static class InnerClass2{
        public synchronized void method1(){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName +" 进入InnerClass2类中的method1方法");
            for(int k=0;k<10;k++){
                System.out.println("k="+k);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " 离开InnerClass2类中的method1方法");
        }
    }
}

class Run{
    public static void main(String[] args) {
        final OutClass.InnerClass1 inner1 = new OutClass.InnerClass1();
        final OutClass.InnerClass2 inner2 = new OutClass.InnerClass2();
        Thread t1 = new Thread(() ->inner1.method1(inner2),"T1");
        Thread t2 = new Thread(inner1::method2,"T2");
        Thread t3 = new Thread(inner2::method1,"T3");
        t1.start();
        t2.start();
        t3.start();
    }
}
