package cn.java.spring.demo.annotation.injections.primary;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

/**
 * 作者: Jiang
 * 时间: 2021/9/1
 * 描述:
 */
@Component
public class MyTest {
    @Autowired
    private TestService testService;
    @Test
    public void test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);
        Environment environment = app.getEnvironment();
        /*TestService bean = app.getBean(TestService.class);
        System.out.println(bean);*/
        System.out.println(testService);
        System.out.println(JSON.toJSONString(environment));
    }
}
