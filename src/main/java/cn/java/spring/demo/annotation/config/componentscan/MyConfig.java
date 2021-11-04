package cn.java.spring.demo.annotation.config.componentscan;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 作者: Jiang
 * 时间: 2021/9/1
 * 描述: ComponentScan注解案例类
 */
@Configuration
@ComponentScan(value = "cn.java.spring.project",
        //自定义扫描包规则
        includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM,value = {MyTypeFilter.class})},
        useDefaultFilters = false)
public class MyConfig {
}
