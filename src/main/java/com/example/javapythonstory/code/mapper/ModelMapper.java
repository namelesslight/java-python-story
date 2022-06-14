package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.Model;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.javapythonstory.code.entity.vo.model.ModelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZCL
 * @since 2022-06-08
 */
@Mapper
public interface ModelMapper extends BaseMapper<Model> {

    Integer addModel(String modelName, Integer directId);

    Integer updateModel(Integer modelId, String modelName);

    Integer deleteModel(Integer modelId);

    List<ModelVo> listModelByDirection(Integer directionId);

}
