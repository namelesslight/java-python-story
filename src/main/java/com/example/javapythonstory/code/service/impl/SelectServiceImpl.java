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
 * @author ZCL
 * @since 2022-06-14
 */
@Service
public class SelectServiceImpl extends ServiceImpl<SelectMapper, Select> implements SelectService {

    @Autowired
    private SelectMapper selectMapper;

    /**
     * <p>
     *     添加选项
     * </p>
     * @param questionId 问题编号
     * @param content 选项内容
     * @param code 选项号
     * @return
     */
    @Override
    public Integer addSelect(Integer questionId, String content, String code) {
        Integer addCode = selectMapper.addSelect(questionId, content, code);
        return addCode;
    }

    /**
     * <p>
     *     修改选项
     * </p>
     * @param selectId 选项编号
     * @param content 选项内容
     * @param code 选项号
     * @return
     */
    @Override
    public Integer updateSelect(Integer selectId, String content, String code) {
        Integer updateCode = selectMapper.updateSelect(selectId, content, code);
        return updateCode;
    }

    /**
     * <p>
     *     删除选项
     * </p>
     * @param selectId 选项编号
     * @return
     */
    @Override
    public Integer deleteSelect(Integer selectId) {
        Integer deleteCode = selectMapper.deleteSelect(selectId);
        return deleteCode;
    }
}
