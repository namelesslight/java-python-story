package com.example.javapythonstory.code.controller;

import com.example.javapythonstory.code.entity.dto.select.AddSelectDto;
import com.example.javapythonstory.code.entity.dto.select.DeleteSelectDto;
import com.example.javapythonstory.code.entity.dto.select.UpdateSelectDto;
import com.example.javapythonstory.code.result.Result;
import com.example.javapythonstory.code.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZCL
 * @since 2022-06-14
 */
@RestController
@RequestMapping("/select")
public class SelectController {

    @Autowired
    private SelectService selectService;

    /**
     * <p>
     *     添加选项
     * </p>
     * @param addSelectDto 添加选项DTO
     * @return
     */
    @PostMapping("/super/addSelect")
    public Result addSelect(@RequestBody AddSelectDto addSelectDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = selectService.addSelect(
                addSelectDto.getQuestionId(),
                addSelectDto.getContent(),
                addSelectDto.getCode());
        message.put("addCode", addCode);
        return new Result().result200(message, "/super/addSelect");
    }

    /**
     * <p>
     *     修改选项
     * </p>
     * @param updateSelectDto 修改选项DTO
     * @return
     */
    @PostMapping("/super/updateSelect")
    public Result updateSelect(@RequestBody UpdateSelectDto updateSelectDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = selectService.updateSelect(
                updateSelectDto.getSelectId(),
                updateSelectDto.getContent(),
                updateSelectDto.getCode());
        message.put("addCode", addCode);
        return new Result().result200(message, "/super/updateSelect");
    }

    /**
     * <p>
     *     删除选项
     * </p>
     * @param deleteSelectDto 删除选项DTO
     * @return
     */
    @PostMapping("/super/deleteSelect")
    public Result deleteSelect(@RequestBody DeleteSelectDto deleteSelectDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = selectService.deleteSelect(deleteSelectDto.getSelectId());
        message.put("addCode", addCode);
        return new Result().result200(message, "/super/deleteSelect");
    }

}
