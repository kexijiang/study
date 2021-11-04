package cn.java.spring.demo.annotation.injections.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * 作者: Jiang
 * 时间: 2021/9/1
 * 描述:
 */
public class MyTest {
    @Test
    public void test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("容器初始化完成");
        Object bird = app.getBean("bird");
        System.out.println(bird);
    }
}
