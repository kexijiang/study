package cn.java.zookeeper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者: Jiang
 * 时间: 2021/8/18
 * 描述:
 */
@RestController
public class ConfigController {
    @Autowired
    Environment environment;

    public String getEnv(){
        return environment.getProperty("env");
    }
}
