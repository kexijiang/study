package cn.java.spring.demo.annotation.config.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author kxjiang
 * 时间: 2021/10/19
 * 描述: 实例化bean的条件类
 */
public class LinuxConditional implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println(osName);
        return osName.startsWith("Linux");
    }
}
