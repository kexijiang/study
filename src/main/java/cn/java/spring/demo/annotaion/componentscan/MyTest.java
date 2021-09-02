package cn.java.spring.demo.annotaion.componentscan;

import cn.java.spring.demo.annotaion.componentscan.Myconfig;
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
        ApplicationContext app = new AnnotationConfigApplicationContext(Myconfig.class);
        String[] beanNames = app.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanNames));
    }
}
