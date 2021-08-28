package cn.java.reflect.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.java.reflect.entity.TResource;
import cn.java.reflect.mapper.TResourceMapper;
/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Service
public class TResourceService{

    @Resource
    private TResourceMapper tResourceMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return tResourceMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(TResource record) {
        return tResourceMapper.insert(record);
    }

    
    public int insertSelective(TResource record) {
        return tResourceMapper.insertSelective(record);
    }

    
    public TResource selectByPrimaryKey(Integer id) {
        return tResourceMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(TResource record) {
        return tResourceMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(TResource record) {
        return tResourceMapper.updateByPrimaryKey(record);
    }

}
