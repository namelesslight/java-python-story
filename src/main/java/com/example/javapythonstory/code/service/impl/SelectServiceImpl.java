package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.Select;
import com.example.javapythonstory.code.mapper.SelectMapper;
import com.example.javapythonstory.code.service.SelectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2022-06-14
 */
@Service
public class SelectServiceImpl extends ServiceImpl<SelectMapper, Select> implements SelectService {

    @Autowired
    private SelectMapper selectMapper;

    @Override
    public Integer addSelect(Integer questionId, String content, String code) {
        Integer addCode = selectMapper.addSelect(questionId, content, code);
        return addCode;
    }

    @Override
    public Integer updateSelect(Integer selectId, String content, String code) {
        Integer updateCode = selectMapper.updateSelect(selectId, content, code);
        return updateCode;
    }

    @Override
    public Integer deleteSelect(Integer selectId) {
        Integer deleteCode = selectMapper.deleteSelect(selectId);
        return deleteCode;
    }
}
