package cn.java.spring.demo.annotation.config.lifecycle;

import cn.java.spring.project.entity.Train;
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
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("容器初始化完成");
//        app.getBean("car");
        app.getBean(Train.class);
        app.close();
    }
}
