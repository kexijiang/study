package cn.java.reflect.mapper;

import cn.java.reflect.entity.TBlackip;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Mapper
public interface TBlackipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBlackip record);

    int insertSelective(TBlackip record);

    TBlackip selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBlackip record);

    int updateByPrimaryKey(TBlackip record);
}