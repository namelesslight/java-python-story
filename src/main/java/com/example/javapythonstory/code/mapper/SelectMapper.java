package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.Select;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZCL
 * @since 2022-06-14
 */
@Mapper
public interface SelectMapper extends BaseMapper<Select> {

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

    /**
     * <p>
     *     根据提目编号获取题目相关选项内容
     * </p>
     * @param questionId 题目编号
     * @return
     */
    List<Select> listSelectByQuestionId(Integer questionId);

}
