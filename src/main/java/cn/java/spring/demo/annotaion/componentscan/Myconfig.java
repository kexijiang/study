package cn.java.spring.demo.annotaion.componentscan;


import cn.java.spring.project.controller.MyController;
import cn.java.spring.project.service.MyService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 作者: Jiang
 * 时间: 2021/9/1
 * 描述:
 */
@Configuration
@ComponentScan(value = "cn.java.spring.project",
//        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class})},
        includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM,value = {MyController.class})},
        useDefaultFilters = false)
//不使用默认的 Filter 进行扫描
public class Myconfig {

}
