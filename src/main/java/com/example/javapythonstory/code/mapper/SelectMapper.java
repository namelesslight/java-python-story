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
 * @author 
 * @since 2022-06-14
 */
@Mapper
public interface SelectMapper extends BaseMapper<Select> {

    List<Select> listSelectByQuestionId(Integer questionId);

}
