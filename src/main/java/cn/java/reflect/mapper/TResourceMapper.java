package cn.java.reflect.mapper;

import cn.java.reflect.entity.TResource;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Mapper
public interface TResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TResource record);

    int insertSelective(TResource record);

    TResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TResource record);

    int updateByPrimaryKey(TResource record);
}