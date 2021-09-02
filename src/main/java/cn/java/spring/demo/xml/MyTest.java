package cn.java.spring.demo.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * 作者: Jiang
 * 时间: 2021/9/1
 * 描述:
 */
public class MyTest {

    @Test
    public void test(){
        ApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
        Object object = app.getBean("person");
        System.out.println(object);
    }
}
