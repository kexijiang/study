package cn.java.zookeeper.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 作者: Jiang
 * 时间: 2021/8/18
 * 描述: ApplicationContextInitializer
 * ConfigurableApplicationContext:初始化容器之前，会执行回调的一个扩展方法
 */
public class ZookeeperApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private final List<PropertySourceLocator> propertySourceLocators;

    public ZookeeperApplicationContextInitializer() {
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        propertySourceLocators=new ArrayList<>(SpringFactoriesLoader.loadFactories(PropertySourceLocator.class,classLoader));
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        //动态加载扩展的配置到Environment中
        ConfigurableEnvironment configurableEnvironment = applicationContext.getEnvironment();
        MutablePropertySources mutablePropertySources = configurableEnvironment.getPropertySources();

        for (PropertySourceLocator locator : this.propertySourceLocators) {
            Collection<PropertySource<?>> sources = locator.locateConllection(configurableEnvironment,applicationContext);
            if(sources==null||sources.size()==0){
                continue;
            }
            sources.forEach(mutablePropertySources::addLast);
        }
    }
}
