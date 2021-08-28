package cn.java.reflect.controller;

import cn.hutool.log.Log;
import cn.java.reflect.entity.TBlog;
import cn.java.reflect.service.TBlogService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Jiang
 * @createTime: 2021-04-04 17:09
 * @description:
 */
@RestController
@RefreshScope
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    RedisTemplate redisTemplate;

    @Resource
    TBlogService tBlogService;
    static final Log logger = Log.get();


    @RequestMapping("/test")
    public List<TBlog> test(){
        logger.info("接收参数为:{}", (Object) null);
        int a = 100;
        List<TBlog> tBlogs = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            TBlog tBlog = tBlogService.selectByPrimaryKey(i);
            tBlogs.add(tBlog);
        }
        logger.info("返回参数为:{}", JSON.toJSONString(tBlogs));
        return tBlogs;
    }
}
