package cn.java.reflect.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.java.reflect.entity.TLinks;
import cn.java.reflect.mapper.TLinksMapper;
/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@Service
public class TLinksService{

    @Resource
    private TLinksMapper tLinksMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return tLinksMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(TLinks record) {
        return tLinksMapper.insert(record);
    }

    
    public int insertSelective(TLinks record) {
        return tLinksMapper.insertSelective(record);
    }

    
    public TLinks selectByPrimaryKey(Integer id) {
        return tLinksMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(TLinks record) {
        return tLinksMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(TLinks record) {
        return tLinksMapper.updateByPrimaryKey(record);
    }

}
