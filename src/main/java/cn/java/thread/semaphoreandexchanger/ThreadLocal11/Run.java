package cn.java.thread.semaphoreandexchanger.ThreadLocal11;

/**
 * @author: Jiang
 * @createTime: 2020-12-16 20:58
 * @description:
 */
public class Run {
    public static ThreadLocal<String> t1 = new ThreadLocal<>();

    public static void main(String[] args) {
        if(t1.get() == null){
            System.out.println("从未放过值");
            t1.set("我的值");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
        t1.remove();
    }
}
