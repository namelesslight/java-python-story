package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.Model;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.javapythonstory.code.entity.vo.model.ModelVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
public interface ModelService extends IService<Model> {

    Integer addModel(Integer directionId, String modelName);

    Integer updateModel(Integer modelId, String modelName);

    Integer deleteModel(Integer modelId);

    List<ModelVo> listModelByDirection(Integer directionId);

}
