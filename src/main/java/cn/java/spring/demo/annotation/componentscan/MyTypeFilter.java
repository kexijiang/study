package cn.java.spring.demo.annotation.componentscan;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * @author kxjiang
 * 时间: 2021/10/19
 * 描述: 自定义扫描包的筛选条件类
 */
@Repository
public class MyTypeFilter implements TypeFilter {
    /**
     * 扫描包时的筛选方法
     *
     * @param metadataReader 扫描到的所有类的信息,当前正在操作的类的信息
     * @param metadataReaderFactory  获取上下文中所有信息
     * @return 返回筛选结果
     * @throws IOException 抛出io异常
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类的所有注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前类的所有资源
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        String className = classMetadata.getClassName();

        System.out.println("当前扫描类:"+className);
        return className.contains("er");
    }
}
