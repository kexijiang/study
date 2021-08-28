package cn.java.reflect.mapper;

import cn.java.reflect.entity.TLinks;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Mapper
public interface TLinksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TLinks record);

    int insertSelective(TLinks record);

    TLinks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TLinks record);

    int updateByPrimaryKey(TLinks record);
}