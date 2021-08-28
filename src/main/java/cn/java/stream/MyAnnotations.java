package cn.java.stream;

import java.lang.annotation.*;

/**
 * @author: Jiang
 * @createTime: 2021-04-05 12:07
 * @description: 元注解: 用来描述注解的注解
 * Target: 描述注解能够做用的位置
 * Retention: 描述注解被保留的阶段
 * Documented: 描述注解是否被抽取到javaapi文档中
 * Inherited: 描述注解是否被子类继承
 */
@Target(value = {ElementType.TYPE,ElementType.METHOD}) //作用于类上 与方法上
@Retention(RetentionPolicy.RUNTIME) //注解被保留的时候
@Documented //描述是否可以被抽取到api中
@Inherited //会不会被继承
public @interface MyAnnotations {
    String show();
}
