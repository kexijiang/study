package cn.java.stream;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: Jiang
 * @createTime: 2021-04-05 16:58
 * @description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Config {
    String className();
    String methodName();
}
