package cn.java.reflect.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.java.reflect.entity.TBloger;
import cn.java.reflect.mapper.TBlogerMapper;
/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Service
public class TBlogerService{

    @Resource
    private TBlogerMapper tBlogerMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return tBlogerMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(TBloger record) {
        return tBlogerMapper.insert(record);
    }

    
    public int insertSelective(TBloger record) {
        return tBlogerMapper.insertSelective(record);
    }

    
    public TBloger selectByPrimaryKey(Integer id) {
        return tBlogerMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(TBloger record) {
        return tBlogerMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(TBloger record) {
        return tBlogerMapper.updateByPrimaryKey(record);
    }

}
