package cn.java.thread.semaphoreandexchanger.singlecase;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Jiang
 * @createTime: 2021-06-27 16:42
 * @description:
 */
public class ContainerSingleton implements Cloneable{
    private ContainerSingleton(){}
    private static final Map<String,Object> ioc = new ConcurrentHashMap<>();
    public static Object getInstance(String className){
        Object instance = null;
        try {
            if(!ioc.containsKey(className)){
                instance = Class.forName(className).newInstance();
                ioc.put(className, instance);
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
