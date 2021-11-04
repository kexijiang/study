package cn.java.spring.demo.annotation.injections.primary;

import cn.java.spring.project.entity.Brid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 作者: Jiang
 * 时间: 2021/9/1
 * 描述: @Configuration案例类
 */
@Configuration
@ComponentScan(value = "cn.java.spring.demo")
public class MyConfig {
}
