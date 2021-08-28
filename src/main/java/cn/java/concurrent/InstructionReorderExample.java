package cn.java.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-16 22:22
 * 描述: 指令重排序的演示
 */
public class InstructionReorderExample {

    public static int a,b = 0;
    public static int x,y = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (;;){
            i++;
            x = 0;y = 0;
            a = 0;b = 0;
            Thread thread1 = new Thread(()->{
                a = 1;
                x = b;
            });
            Thread thread2 = new Thread(()->{
                b = 1;
                y = a;
            });
            /*可能的结果
            * 0,0
            * 1,0
            * 0,1
            * 0,0  指令重排序的结果,在thread1线程中x=b在a=1的上面,并且threads2线程中,y=a在b=1的上面时
            * */
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            String result = "第" +i+ "次("+x+","+y+")";
            if(x==0&&y==0){

                System.out.println(result);
                break;
            }

        }

    }

}
