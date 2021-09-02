package cn.java.spring.demo.annotaion.configuration;

import cn.java.spring.project.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作者: Jiang
 * 时间: 2021/9/1
 * 描述:
 */
@Configuration
public class Myconfig {
    @Bean("person1")
    public Person instancePerson(){
        return new Person("mic",18);
    }
}
