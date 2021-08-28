package cn.java.concurrent;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-17 15:42
 * 描述:
 */
public class StartDemo {
    public static void main(String[] args) {
        int x = 0;
        Thread a = new Thread(()->{
            //读取x的值;
        });
        x = 20;
        a.start();
    }
}
