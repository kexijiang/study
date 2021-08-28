package cn.java.reflect.mapper;

import cn.java.reflect.entity.TBloger;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Mapper
public interface TBlogerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBloger record);

    int insertSelective(TBloger record);

    TBloger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBloger record);

    int updateByPrimaryKey(TBloger record);
}