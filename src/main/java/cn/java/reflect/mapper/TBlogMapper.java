package cn.java.reflect.mapper;

import cn.java.reflect.entity.TBlog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Mapper
public interface TBlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBlog record);

    int insertSelective(TBlog record);

    TBlog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBlog record);

    int updateByPrimaryKey(TBlog record);
}