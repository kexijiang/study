package cn.java.client;

import cn.java.proxy.KXClassLoader;
import cn.java.proxy.KXInvocationHandler;
import cn.java.proxy.KXProxy;

import java.lang.reflect.Method;

/**
 * @author: Jiang
 * @createTime: 2021-07-03 19:39
 * @description:
 */
public class KXMeipo implements KXInvocationHandler {
    private IPerson iPerson;

    public IPerson getInstance(IPerson iPerson){
        this.iPerson = iPerson;
        Class< ? > clazz = iPerson.getClass();
        return (IPerson) KXProxy.newProxyInstance(new KXClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.iPerson,args);
        after();
        return result;
    }

    private void after() {
        System.out.println("双方同意，办理入职！");
    }

    private void before() {
        System.out.println("我是代理，接到需求，开始物色！");
    }

}
