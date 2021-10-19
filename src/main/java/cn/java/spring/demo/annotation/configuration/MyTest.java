package cn.java.spring.demo.annotation.configuration;

import cn.java.spring.project.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * 作者: Jiang
 * 时间: 2021/9/1
 * 描述:
 */
public class MyTest {
    @Test
    public void test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);
        Object object1 = app.getBean("person1");
        Object object2 = app.getBean("person1");
        Object object3 = app.getBean(Person.class);

        System.out.println(object1==object2);
        System.out.println(object2==object3);
        System.out.println(object1==object3);
        String[] beanNames = app.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanNames));
    }
}
