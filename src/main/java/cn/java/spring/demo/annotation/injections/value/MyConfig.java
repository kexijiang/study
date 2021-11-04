package cn.java.spring.demo.annotation.injections.value;

import cn.java.spring.project.entity.Brid;
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
    @Bean
    public Brid bird(){
        return new Brid();
    };
}
