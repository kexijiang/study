package cn.java.zookeeper.config;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

/**
 * 作者: Jiang
 * 时间: 2021/8/18
 * 描述:
 */
public class ZookeeperPropertySourceLocator implements PropertySourceLocator{
    @Override
    public PropertySource<?> locate(Environment environment, ConfigurableApplicationContext context) {
        return null;
        //加载远程的配
    }
}
