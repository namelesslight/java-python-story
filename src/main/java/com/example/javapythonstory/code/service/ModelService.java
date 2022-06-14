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
 * @author ZCL
 * @since 2022-06-08
 */
public interface ModelService extends IService<Model> {

    /**
     * <p>
     *     添加模块
     * </p>
     * @param directionId 学习方向编号
     * @param modelName 模块名
     * @return
     */
    Integer addModel(Integer directionId, String modelName);

    /**
     * <p>
     *     修改模块
     * </p>
     * @param modelId 模块编号
     * @param modelName 模块名
     * @return
     */
    Integer updateModel(Integer modelId, String modelName);

    /**
     * <p>
     *     删除模块
     * </p>
     * @param modelId 模块编号
     * @return
     */
    Integer deleteModel(Integer modelId);

    /**
     * <p>
     *     根据路径修改模块
     * </p>
     * @param directionId 学习方向编号
     * @return
     */
    List<ModelVo> listModelByDirection(Integer directionId);

}
