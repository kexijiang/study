package cn.java.reflect.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.java.reflect.entity.TVisit;
import cn.java.reflect.mapper.TVisitMapper;
/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Service
public class TVisitService{

    @Resource
    private TVisitMapper tVisitMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return tVisitMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(TVisit record) {
        return tVisitMapper.insert(record);
    }

    
    public int insertSelective(TVisit record) {
        return tVisitMapper.insertSelective(record);
    }

    
    public TVisit selectByPrimaryKey(Integer id) {
        return tVisitMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(TVisit record) {
        return tVisitMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(TVisit record) {
        return tVisitMapper.updateByPrimaryKey(record);
    }

}
