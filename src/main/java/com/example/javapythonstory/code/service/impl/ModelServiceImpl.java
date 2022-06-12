package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.Model;
import com.example.javapythonstory.code.entity.vo.model.ModelVo;
import com.example.javapythonstory.code.mapper.ModelMapper;
import com.example.javapythonstory.code.service.ModelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
@Service
public class ModelServiceImpl extends ServiceImpl<ModelMapper, Model> implements ModelService {

    @Resource
    private ModelMapper modelMapper;

    @Override
    public Integer addModel(Integer directionId, String modelName) {
        Integer addCode = modelMapper.addModel(modelName, directionId);
        return addCode;
    }

    @Override
    public Integer updateModel(Integer modelId, String modelName) {
        Integer updateCode = modelMapper.updateModel(modelId, modelName);
        return updateCode;
    }

    @Override
    public Integer deleteModel(Integer modelId) {
        Integer deleteCode = modelMapper.deleteModel(modelId);
        return deleteCode;
    }

    @Override
    public List<ModelVo> listModelByDirection(Integer directionId) {
        List<ModelVo> data = modelMapper.listModelByDirection(directionId);
        return data;
    }

}
