package cn.java.reflect.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.java.reflect.entity.TBlog;
import cn.java.reflect.mapper.TBlogMapper;
/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Service
public class TBlogService{

    @Resource
    private TBlogMapper tBlogMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return tBlogMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(TBlog record) {
        return tBlogMapper.insert(record);
    }

    
    public int insertSelective(TBlog record) {
        return tBlogMapper.insertSelective(record);
    }

    
    public TBlog selectByPrimaryKey(Integer id) {
        return tBlogMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(TBlog record) {
        return tBlogMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(TBlog record) {
        return tBlogMapper.updateByPrimaryKey(record);
    }

}
