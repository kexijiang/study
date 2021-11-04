package cn.java.spring.demo.annotation.config.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author kxjiang
 * 时间: 2021/10/19
 * 描述: 自定义Import注解的筛选规则类
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        return new String[]{"cn.java.spring.project.entity.Company","cn.java.spring.project.entity.Member"};
    }
}
