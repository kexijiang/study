package cn.java.spring.demo.annotation.injections.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author kxjiang
 * 时间: 2021/11/2
 * 描述:
 */
@Primary
@Service
public class TestServiceImpl1 implements TestService{
}
