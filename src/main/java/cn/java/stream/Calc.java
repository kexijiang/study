package cn.java.stream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: Jiang
 * @createTime: 2021-04-05 17:40
 * @description:
 */
public class Calc {
    @Check
    public void add(){
        int a = 10;
        int b = 20;
        System.out.println("10+20="+(a+b));
    }
    @Check
    public void div(){
        int a = 0;
        int b = 20;
        String a1 = null;
        System.out.println(a1.toString());
        System.out.println("20/0="+(a/b));
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {


        Class calcClass =  Class.forName("cn.java.stream.Calc");
        Object object = calcClass.getDeclaredConstructor().newInstance();
        Method[] calcClassMethods = calcClass.getMethods();
        for (Method calcClassMethod : calcClassMethods) {
            //如果方法上有Check注解
            if(calcClassMethod.isAnnotationPresent(Check.class)){
                try{
                    calcClassMethod.invoke(object);
                }catch(Exception e){
                    System.out.println("出现异常："+e.getClass().getSimpleName()+"");
                    System.out.println("方法："+calcClassMethod.getName());
                    System.out.println("异常信息："+e.getCause().getMessage());
                }
            }
        }
    }
}
