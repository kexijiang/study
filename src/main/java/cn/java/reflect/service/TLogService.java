package cn.java.reflect.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.java.reflect.entity.TLog;
import cn.java.reflect.mapper.TLogMapper;
/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Service
public class TLogService{

    @Resource
    private TLogMapper tLogMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return tLogMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(TLog record) {
        return tLogMapper.insert(record);
    }

    
    public int insertSelective(TLog record) {
        return tLogMapper.insertSelective(record);
    }

    
    public TLog selectByPrimaryKey(Integer id) {
        return tLogMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(TLog record) {
        return tLogMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(TLog record) {
        return tLogMapper.updateByPrimaryKey(record);
    }

}
