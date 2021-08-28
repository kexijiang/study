package cn.java.stream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: Jiang
 * @createTime: 2021-04-05 16:56
 * @description:
 */
@Config(className = "cn.java.stream.Demo1",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //获取该类的字节码对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //获取注解对象 在内存中生成了一个实现该注解接口的子类对象
        Config config = reflectTestClass.getAnnotation(Config.class);
        String className = config.className();
        String methodName = config.methodName();
        System.out.println(className);
        System.out.println(methodName);
        Class aclass = Class.forName(className);
        //获取该类对象
        Object object = aclass.getDeclaredConstructor().newInstance();//获取类的实例化对象
        /*getDeclatedConstructor().newInstance()*/
        //获取方法对象
        Method method = aclass.getMethod(methodName);
        //调用该方法，并将获取的类对象传给他
        method.invoke(object);
    }
}
