package cn.java.reflect.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.java.reflect.mapper.TBlackipMapper;
import cn.java.reflect.entity.TBlackip;
/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Service
public class TBlackipService{

    @Resource
    private TBlackipMapper tBlackipMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return tBlackipMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(TBlackip record) {
        return tBlackipMapper.insert(record);
    }

    
    public int insertSelective(TBlackip record) {
        return tBlackipMapper.insertSelective(record);
    }

    
    public TBlackip selectByPrimaryKey(Integer id) {
        return tBlackipMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(TBlackip record) {
        return tBlackipMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(TBlackip record) {
        return tBlackipMapper.updateByPrimaryKey(record);
    }

}
