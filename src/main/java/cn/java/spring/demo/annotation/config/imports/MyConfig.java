package cn.java.spring.demo.annotation.config.imports;

import cn.java.spring.project.entity.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 作者: Jiang
 * 时间: 2021/9/1
 * 描述: @Import案例类
 */
@Configuration
@Import(value = {Cat.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MyConfig {
    @Bean
    public MyFactoryBean getMonkey(){
        return new MyFactoryBean();
    }
}
