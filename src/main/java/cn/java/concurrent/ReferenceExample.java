package cn.java.concurrent;

import java.lang.ref.WeakReference;

/**
 * 作者: Jiang
 * 时间: 2021/8/1
 * 描述: 引用关系的案例类
 */
public class ReferenceExample {

    public static Object object = new Object();

    public static void main(String[] args) {
        //强引用
        Object obj = object;
        object = null;
        System.gc();
        System.out.println(obj);
        //弱引用
        WeakReference<Object> weakReference = new WeakReference<>(object);
        object = null;
        System.gc();
        System.out.println(weakReference.get());
    }
}
