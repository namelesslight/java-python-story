package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.Select;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZCL
 * @since 2022-06-14
 */
public interface SelectService extends IService<Select> {

    /**
     * <p>
     *     添加选项
     * </p>
     * @param questionId 问题编号
     * @param content 选项内容
     * @param code 选项号
     * @return
     */
    Integer addSelect(Integer questionId, String content, String code);

    /**
     * <p>
     *     修改选项
     * </p>
     * @param selectId 选项编号
     * @param content 选项内容
     * @param code 选项号
     * @return
     */
    Integer updateSelect(Integer selectId, String content, String code);

    /**
     * <p>
     *     删除选项
     * </p>
     * @param selectId 选项编号
     * @return
     */
    Integer deleteSelect(Integer selectId);

}
