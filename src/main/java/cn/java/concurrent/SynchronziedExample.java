package cn.java.concurrent;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-17 16:02
 * 描述:
 */
public class SynchronziedExample {
    public void mi(){
        synchronized (this){
            System.out.println("111");
        }
    }

    public static void main(String[] args) {

    }

}
