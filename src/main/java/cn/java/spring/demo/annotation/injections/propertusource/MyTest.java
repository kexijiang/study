package cn.java.spring.demo.annotation.injections.propertusource;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
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
        Environment environment = app.getEnvironment();
        System.out.println(JSON.toJSONString(environment));
    }
}
