package cn.java.thread.semaphoreandexchanger.twoObjectTwoLock;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author: Jiang
 * @createTime: 2020-12-05 23:02
 * @description:
 */
public class HasSelfPrivateNum {
    private int num = 0;
    synchronized public void addI(String username){
        int[] a = {1,4,5,2,3,7,9};
        Arrays.sort(a);
        try {
            if (Objects.equals("a",username)){
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            }else{
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username+" num="+num);
        }catch(InterruptedException e){
            /* TODO Auto-generated catch block */
            e.printStackTrace();
        }
    }
}
