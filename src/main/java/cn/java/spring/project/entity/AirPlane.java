package cn.java.spring.project.entity;

import org.springframework.stereotype.Component;
import org.testng.annotations.AfterMethod;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author kxjiang
 * 时间: 2021/10/19
 * 描述:
 */
@Component
public class AirPlane {
    public AirPlane() {
        System.out.println("调用飞机的构造方法。");
    }
    @PostConstruct
    public void addOil(){
        System.out.println("飞机加油。");
    }
    @PreDestroy
    public void close(){
        System.out.println("飞机落地。");
    }
}
