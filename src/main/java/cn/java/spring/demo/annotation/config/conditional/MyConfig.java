package cn.java.spring.demo.annotation.config.conditional;

import cn.java.spring.project.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 作者: Jiang
 * 时间: 2021/9/1
 * 描述: @Configuration案例类
 */
@Configuration
public class MyConfig {
    @Conditional({LinuxConditional.class})
    @Bean(value = "person1",initMethod = "start",destroyMethod = "destroy")
    public Person instancePerson(){
        System.out.println("加入IoC容器中。mic");
        return new Person("mic",18);
    }
    @Conditional({WindowsConditional.class})
    @Bean(value = "person2",initMethod = "start",destroyMethod = "destroy")
    public Person instancePerson1(){
        System.out.println("加入IoC容器中。tom");
        return new Person("tom",15);
    }
    @Conditional({LinuxConditional.class})
    @Bean(value = "person3",initMethod = "start",destroyMethod = "destroy")
    public Person instancePerson2(){
        System.out.println("加入IoC容器中。moj");
        return new Person("moj",13);
    }
    @Conditional({LinuxConditional.class})
    @Bean(value = "person4",initMethod = "start",destroyMethod = "destroy")
    public Person instancePerson3(){
        System.out.println("加入IoC容器中。jack");
        return new Person("jack",22);
    }
}
