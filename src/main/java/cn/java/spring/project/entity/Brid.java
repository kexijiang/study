package cn.java.spring.project.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author kxjiang
 * 时间: 2021/11/2
 * 描述:
 */
@Data
public class Brid {
    // 支持的数据类型
    @Value("鹦鹉")
    private String name;
    @Value("#{8-5}")
    private int age;
    @Value("${color}")
    private String color;
}
