package com.example.javapythonstory.code.controller;


import com.example.javapythonstory.code.entity.dto.model.AddModelDto;
import com.example.javapythonstory.code.entity.dto.model.DeleteModelDto;
import com.example.javapythonstory.code.entity.dto.model.UpdateModelDto;
import com.example.javapythonstory.code.entity.vo.model.ModelVo;
import com.example.javapythonstory.code.result.Result;
import com.example.javapythonstory.code.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZCL
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private ModelService modelService;

    /**
     * <p>
     *     添加模块
     * </p>
     * @param addModelDto 添加模块DTO
     * @return
     */
    @PostMapping("/super/addModel")
    public Result addModel(@RequestBody AddModelDto addModelDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = modelService.addModel(addModelDto.getDirectionId(), addModelDto.getModelName());
        message.put("addCode", addCode);
        return new Result().result200(message, "/super/addModel");
    }

    /**
     * <p>
     *     修改模块
     * </p>
     * @param updateModelDto 修改模块DTO
     * @return
     */
    @PostMapping("/super/updateModel")
    public Result updateModel(@RequestBody UpdateModelDto updateModelDto){
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = modelService.updateModel(updateModelDto.getModelId(), updateModelDto.getModelName());
        message.put("updateCode", updateCode);
        return new Result().result200(message, "/super/updateModel");
    }

    /**
     * <p>
     *     删除模块
     * </p>
     * @param deleteModelDto 删除模块DTO
     * @return
     */
    @PostMapping("/super/deleteModel")
    public Result deleteModel(@RequestBody DeleteModelDto deleteModelDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = modelService.deleteModel(deleteModelDto.getModelId());
        message.put("deleteCode", deleteCode);
        return new Result().result200(message, "/super/deleteModel");
    }

    /**
     * <p>
     *     根据学习方向删除模块
     * </p>
     * @param directionId 学习方向DTO
     * @return
     */
    @GetMapping("/common/listModelByDirection")
    public Result listModelByDirection(@RequestParam Integer directionId){
        Map<String, Object> message = new HashMap<>();
        List<ModelVo> data = modelService.listModelByDirection(directionId);
        message.put("data", data);
        return new Result().result200(message, "/super/deleteModel");
    }
}
