package cn.java.spring.project.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author kxjiang
 * 时间: 2021/10/19
 * 描述: 火车类
 */
@Component
public class Train implements InitializingBean, DisposableBean {
    public Train() {
        System.out.println("正在调用火车的构造方法！");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁火车！");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("火车加油！");
    }
}
