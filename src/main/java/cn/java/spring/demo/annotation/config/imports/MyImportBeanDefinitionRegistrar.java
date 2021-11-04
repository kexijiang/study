package cn.java.spring.demo.annotation.config.imports;

import cn.java.spring.project.entity.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author kxjiang
 * 时间: 2021/10/19
 * 描述: 自定义Import注解的筛选规则类
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * 如果包中声明了Company与Member类，则注入User类
     *
     * @param importingClassMetadata 注解信息
     * @param registry 注册Bean工具
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean companyIsExist = registry.containsBeanDefinition("cn.java.spring.project.entity.Company");
        boolean memberIsExist = registry.containsBeanDefinition("cn.java.spring.project.entity.Member");
        if(companyIsExist&&memberIsExist){
            //创建一个类型BeanDefinition的实例
            BeanDefinition beanDefinition = new RootBeanDefinition(User.class);
            //注入一个bean，名称为user
            registry.registerBeanDefinition("user",beanDefinition);
        }
        ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry);
    }
}
