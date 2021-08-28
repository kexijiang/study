import cn.hutool.log.Log;
import cn.java.reflect.entity.TBlackip;
import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author: Jiang
 * @createTime: 2021-04-04 11:47
 * @description:
 */
public class TBlackipTest {
    static final Log logger = Log.get();
    @Test
    public void reflectTest(){
        try {
            Class<?> aClass = Class.forName("cn.java.reflect.entity.TBlackip");
            logger.info("第一种方式:Class.forName:{}",aClass);
            Class<?> bClass = TBlackip.class;
            logger.info("第二种方式:类名.class属性:{}",bClass);
//            TBlackip tBlackip = new TBlackip();
//            Class<?> cClass = tBlackip.getClass();
//            logger.info("第三种方式:实例名.getClass()方法:{}",cClass);

//            Class<?> dClass = TBlackip.builder().getClass();
//            logger.info("第四种方式:builder方式.getClass()方法:{}",dClass);
//            Assert.assertEquals(aClass,bClass);
//            //Assert.assertEquals(bClass,dClass);
//            logger.info("a==b:{},a==d:{},b==d:{}",aClass==bClass,aClass==dClass,bClass==dClass);
            //logger.info("第一种加载方式的所有属性:{}", JSON.toJSONString(aClass.getDeclaredFields()));
            //logger.info("第四种加载方式的所有属性:{}", JSON.toJSONString(dClass.getDeclaredFields()));
            Field[] fields = aClass.getDeclaredFields();
            Arrays.asList(fields).forEach(field->{
                logger.info(String.valueOf(field));
            });
        }catch (ClassNotFoundException e){
            logger.info(e.getException());
        }
    }
}
