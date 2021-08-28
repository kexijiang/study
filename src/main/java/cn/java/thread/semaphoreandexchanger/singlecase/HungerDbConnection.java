package cn.java.thread.semaphoreandexchanger.singlecase;

/**
 * @author: Jiang
 * @createTime: 2021-06-27 9:49
 * @description: 饿汉单例模式
 */
public class HungerDbConnection{
    /*类被装载时就初始化实例*/
    private static final HungerDbConnection HUNGER_DB_CONNECTION = new HungerDbConnection();
    /*隐藏构造方法*/
    private HungerDbConnection() {
    }
    /*提供唯一的全局获取实例的方法*/
    public HungerDbConnection instance(){
        return HUNGER_DB_CONNECTION;
    }
}
