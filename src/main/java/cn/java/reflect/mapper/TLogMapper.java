package cn.java.reflect.mapper;

import cn.java.reflect.entity.TLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Mapper
public interface TLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TLog record);

    int insertSelective(TLog record);

    TLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TLog record);

    int updateByPrimaryKey(TLog record);
}