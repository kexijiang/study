package cn.java.concurrent;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-15 21:55
 * 描述:
 */
public class VolatileExample {

    public static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(VolatileExample::run);
        t1.start();
        System.out.println("begin start thread");
        Thread.sleep(1000);
        stop = true;
    }
    private static void run() {
        int i = 0;
        //while(true) 活性失败
        while (!stop) {
            i++;
            System.out.println(i);
            /*try{
                Thread.sleep(0);
            }catch (Exception e){
                e.printStackTrace();
            }*/

        }
    }
}
