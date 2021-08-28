package cn.java.proxy;

import java.lang.reflect.Method;

/**
 * @author: Jiang
 * @createTime: 2021-07-03 19:34
 * @description:
 */
public interface KXInvocationHandler {
    /*反射方法*/
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
