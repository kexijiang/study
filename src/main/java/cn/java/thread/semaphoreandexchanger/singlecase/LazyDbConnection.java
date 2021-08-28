package cn.java.thread.semaphoreandexchanger.singlecase;

/**
 * @author: Jiang
 * @createTime: 2021-06-27 9:53
 * @description: 懒汉模式, 在需要的时候才创建实例
 */
public class LazyDbConnection {

    private volatile static LazyDbConnection lazyDbConnection;

//    private LazyDbConnection() {
//    }

    /*第一个版本,但是如果是多个线程,会出现实例创建多个问题*/
    public static LazyDbConnection instance() {
        if (lazyDbConnection == null) {
            lazyDbConnection = new LazyDbConnection();
        }
        return lazyDbConnection;
    }

    /*改进,加入synchronized,但是会导致性能差,线程会在进入方法等待,monitor状态*/
    /*public synchronized static LazyDbConnection getInstance(){
        if(lazyDbConnection==null){
            lazyDbConnection = new LazyDbConnection();
        }
        return lazyDbConnection;
    }*/
    /*改进,将synchronized放入判空之后,但是会导致线程先判空,第一个线程创建完实例,第二个线程不能实时同步知道该实例已经被创建*/
    /*public static LazyDbConnection getInstance() {
        if (lazyDbConnection == null) {
            synchronized (LazyDbConnection.class) {
                lazyDbConnection = new LazyDbConnection();
            }
        }
        return lazyDbConnection;
    }*/
    /*改进,继续改进,加入第二个非空判断,第一个空判断判断阻塞,第二个空判断判断对象是否为空,,有指令重排序的问题,在lazyDbConnection变量初始化时,加上volatile关键字*/
    /*双重检验*/
    /*public  static LazyDbConnection getInstance() {
        if (lazyDbConnection == null) {
            synchronized (LazyDbConnection.class) {
                if(lazyDbConnection==null){
                    lazyDbConnection = new LazyDbConnection();
                }
            }
        }
        return lazyDbConnection;
    }
*/

    /*第五个版本*/
    public  static LazyDbConnection getInstance() {
        return LazyHolder.INSTANCE;
    }
    private LazyDbConnection() {
        if (lazyDbConnection != null) {
            throw new RuntimeException("不允许非法访问！");
        }
    }
    private static class LazyHolder{
        private final static LazyDbConnection INSTANCE  = new  LazyDbConnection();
    }
}
