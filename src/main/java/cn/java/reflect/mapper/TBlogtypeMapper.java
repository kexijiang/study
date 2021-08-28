package cn.java.reflect.mapper;

import cn.java.reflect.entity.TBlogtype;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Mapper
public interface TBlogtypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBlogtype record);

    int insertSelective(TBlogtype record);

    TBlogtype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBlogtype record);

    int updateByPrimaryKey(TBlogtype record);
}