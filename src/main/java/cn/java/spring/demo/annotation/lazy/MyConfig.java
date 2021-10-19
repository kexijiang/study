package cn.java.spring.demo.annotation.lazy;

import cn.java.spring.project.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * 作者: Jiang
 * 时间: 2021/9/1
 * 描述: @Configuration案例类
 */
@Configuration
public class MyConfig {
    //如果@Bean注解中什么参数都不写,默认bean的key是方法名,如果写了value参数,key为value的值
    //还可以指定初始化执行的方法与销毁执行的方法
    @Lazy
    @Bean(value = "person1",initMethod = "start",destroyMethod = "destroy")
    public Person instancePerson(){
        System.out.println("加入IoC容器中。");
        return new Person("mic",18);
    }
}
