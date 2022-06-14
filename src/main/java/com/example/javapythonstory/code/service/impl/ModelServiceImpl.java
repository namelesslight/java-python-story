package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.Model;
import com.example.javapythonstory.code.entity.vo.model.ModelVo;
import com.example.javapythonstory.code.mapper.ModelMapper;
import com.example.javapythonstory.code.service.ModelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZCL
 * @since 2022-06-08
 */
@Service
public class ModelServiceImpl extends ServiceImpl<ModelMapper, Model> implements ModelService {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * <p>
     *     添加模块
     * </p>
     * @param directionId 学习方向编号
     * @param modelName 模块名
     * @return
     */
    @Override
    public Integer addModel(Integer directionId, String modelName) {
        Integer addCode = modelMapper.addModel(modelName, directionId);
        return addCode;
    }

    /**
     * <p>
     *     修改模块
     * </p>
     * @param modelId 模块编号
     * @param modelName 模块名
     * @return
     */
    @Override
    public Integer updateModel(Integer modelId, String modelName) {
        Integer updateCode = modelMapper.updateModel(modelId, modelName);
        return updateCode;
    }

    /**
     * <p>
     *     删除模块
     * </p>
     * @param modelId 模块编号
     * @return
     */
    @Override
    public Integer deleteModel(Integer modelId) {
        Integer deleteCode = modelMapper.deleteModel(modelId);
        return deleteCode;
    }

    /**
     * <p>
     *     根据路径修改模块
     * </p>
     * @param directionId 学习方向编号
     * @return
     */
    @Override
    public List<ModelVo> listModelByDirection(Integer directionId) {
        List<ModelVo> data = modelMapper.listModelByDirection(directionId);
        return data;
    }

}
