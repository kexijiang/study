package cn.java.spring.demo.annotation.imports;

import cn.java.spring.project.entity.MonKey;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author kxjiang
 * 时间: 2021/10/19
 * 描述:
 */
public class MyFactoryBean implements FactoryBean<MonKey> {
    @Override
    public MonKey getObject() throws Exception {
        return new MonKey();
    }

    @Override
    public Class<?> getObjectType() {
        return MonKey.class;
    }
    //是否单例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
