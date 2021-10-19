package cn.java.spring.demo.annotation.lifecycle;

import org.springframework.context.annotation.*;

/**
 * 作者: Jiang
 * 时间: 2021/9/1
 * 描述: @Configuration案例类
 */
@Configuration
@ComponentScans({
        @ComponentScan("cn.java.spring.project.entity"),
        @ComponentScan("cn.java.spring.demo.annotation")}
)
public class MyConfig{
    /*@Bean(value = "car",initMethod = "addOil",destroyMethod = "close")
    public Car car(){
        return new Car();
    }*/
}
