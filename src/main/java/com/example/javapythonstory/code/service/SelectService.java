package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.Select;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-06-14
 */
public interface SelectService extends IService<Select> {

    Integer addSelect(Integer questionId, String content, String code);

    Integer updateSelect(Integer selectId, String content, String code);

    Integer deleteSelect(Integer selectId);

}
