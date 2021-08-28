package cn.java.reflect.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.java.reflect.mapper.TBlogtypeMapper;
import cn.java.reflect.entity.TBlogtype;
/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Service
public class TBlogtypeService{

    @Resource
    private TBlogtypeMapper tBlogtypeMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return tBlogtypeMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(TBlogtype record) {
        return tBlogtypeMapper.insert(record);
    }

    
    public int insertSelective(TBlogtype record) {
        return tBlogtypeMapper.insertSelective(record);
    }

    
    public TBlogtype selectByPrimaryKey(Integer id) {
        return tBlogtypeMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(TBlogtype record) {
        return tBlogtypeMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(TBlogtype record) {
        return tBlogtypeMapper.updateByPrimaryKey(record);
    }

}
