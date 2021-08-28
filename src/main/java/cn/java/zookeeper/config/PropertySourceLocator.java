package cn.java.zookeeper.config;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 作者: Jiang
 * 时间: 2021/8/18
 * 描述:
 */
public interface PropertySourceLocator {

    PropertySource<?> locate(Environment environment, ConfigurableApplicationContext context);

    default Collection<PropertySource<?>> locateConllection(Environment environment, ConfigurableApplicationContext context){
        return locateConllections(this,environment,context);
    }
    static Collection<PropertySource<?>> locateConllections(PropertySourceLocator locator, Environment environment,ConfigurableApplicationContext context){
        PropertySource<?> propertySource = locator.locate(environment,context);
        if(propertySource==null){
            return Collections.emptyList();
        }
        return Arrays.asList(propertySource);
    }
}
