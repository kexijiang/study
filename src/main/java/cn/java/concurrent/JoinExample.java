package cn.java.concurrent;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-173 15:45
 * 描述:
 */
public class JoinExample extends Thread{
    private static int x = 0;
    @Override
    public void run() {
        x = 100;
    }
    public static void main(String[] args) throws InterruptedException {
        JoinExample j1 = new JoinExample();
        j1.start();
        j1.join();//等待j1线程运行结束，如果j1线程没有执行结束，main线程会阻塞
        if(x==100){//一定成立

        }
    }
}
