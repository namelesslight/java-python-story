package com.example.javapythonstory.code.controller;


import com.example.javapythonstory.code.entity.dto.model.AddModelDto;
import com.example.javapythonstory.code.entity.dto.model.DeleteModelDto;
import com.example.javapythonstory.code.entity.dto.model.UpdateModelDto;
import com.example.javapythonstory.code.entity.vo.model.ModelVo;
import com.example.javapythonstory.code.result.WebResult;
import com.example.javapythonstory.code.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @PostMapping("/super/addModel")
    public WebResult addModel(@RequestBody AddModelDto addModelDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = modelService.addModel(addModelDto.getDirectionId(), addModelDto.getModelName());
        message.put("addCode", addCode);
        return new WebResult().result200(message, "/super/addModel");
    }

    @PostMapping("/super/updateModel")
    public WebResult updateModel(@RequestBody UpdateModelDto updateModelDto){
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = modelService.updateModel(updateModelDto.getModelId(), updateModelDto.getModelName());
        message.put("updateCode", updateCode);
        return new WebResult().result200(message, "/super/updateModel");
    }

    @PostMapping("/super/deleteModel")
    public WebResult deleteModel(@RequestBody DeleteModelDto deleteModelDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = modelService.deleteModel(deleteModelDto.getModelId());
        message.put("deleteCode", deleteCode);
        return new WebResult().result200(message, "/super/deleteModel");
    }

    @GetMapping("/common/listModelByDirection")
    public WebResult listModelByDirection(@RequestParam Integer directionId){
        Map<String, Object> message = new HashMap<>();
        List<ModelVo> data = modelService.listModelByDirection(directionId);
        message.put("data", data);
        return new WebResult().result200(message, "/super/deleteModel");
    }
}
