package cn.java.thread.semaphoreandexchanger.setNewPropertiesLockOne;

/**
 * @ClassName: MyService
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-07
 * @lastModificationTime:2020-12-07
 */
public class MyService {
    synchronized public static void testMethod1(){}
    public void testMethod2(){
        synchronized (MyService.class){
        }
    }
    synchronized public void testMethod3(){}
    public void testMethod4(){
        synchronized (this){}
    }
    public void testMethod5(){
        synchronized ("abc"){}
    }
}
