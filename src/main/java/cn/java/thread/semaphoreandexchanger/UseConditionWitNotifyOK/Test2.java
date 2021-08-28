package cn.java.thread.semaphoreandexchanger.UseConditionWitNotifyOK;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName: Test
 * @Description:
 * @Author: kxjiang
 * @Date: 2020-12-21
 * @lastModificationTime:2020-12-21
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        System.out.println("begin "+System.currentTimeMillis());
        System.currentTimeMillis();
        unsafe.park(true,System.currentTimeMillis()+3000);
        System.out.println("end "+System.currentTimeMillis());
    }
}
class Test3{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        System.out.println("begin "+System.currentTimeMillis());
        System.currentTimeMillis();
        //3秒的纳秒值为3000000000
        //3秒的微秒值为3000000
        //3秒的毫秒值为3000
        //如果传入false，则第二个参数的单位为纳秒
        unsafe.park(false,3000000000L);
        System.out.println("end "+System.currentTimeMillis());
    }
}
class Test4{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        System.out.println("begin "+System.currentTimeMillis());
        System.currentTimeMillis();
        //3秒的纳秒值为3000000000
        //3秒的微秒值为3000000
        //3秒的毫秒值为3000
        //如果传入false，则第二个参数的单位为纳秒
        unsafe.park(true,0L);
        System.out.println("end "+System.currentTimeMillis());
    }
}
class Test5{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        System.out.println("begin "+System.currentTimeMillis());
        System.currentTimeMillis();
        //3秒的纳秒值为3000000000
        //3秒的微秒值为3000000
        //3秒的毫秒值为3000
        //如果传入false，则第二个参数的单位为纳秒
        unsafe.park(false,0L);//当前线程呈暂停运行状态，即实现了wait等待的效果
        System.out.println("end "+System.currentTimeMillis());
    }
}