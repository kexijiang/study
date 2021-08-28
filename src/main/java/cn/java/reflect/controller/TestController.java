package cn.java.reflect.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Jiang
 * @createTime: 2021-04-04 18:01
 * @description:
 */
@RefreshScope
@RestController
public class TestController {


    @Value("${test.name}")
    private String name;
    @Value("${test.age}")
    private int age;

    @RequestMapping("/test")
    public String test() {
        return "name:" + name + " / " + "age" + age;
    }

}
