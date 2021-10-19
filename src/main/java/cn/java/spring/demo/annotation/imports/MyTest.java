package cn.java.spring.demo.annotation.imports;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * 作者: Jiang
 * 时间: 2021/9/1
 * 描述: Import注解测试类
 */
public class MyTest {
    @Test
    public void test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("容器初始化完成");
        System.out.println(app.getBean("&getMonkey"));
    }
}
