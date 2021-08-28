package cn.java.reflect.mapper;

import cn.java.reflect.entity.TVisit;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Mapper
public interface TVisitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TVisit record);

    int insertSelective(TVisit record);

    TVisit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TVisit record);

    int updateByPrimaryKey(TVisit record);
}