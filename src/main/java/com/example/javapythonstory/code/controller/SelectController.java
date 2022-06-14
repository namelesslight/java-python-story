package com.example.javapythonstory.code.controller;

import com.example.javapythonstory.code.entity.dto.select.AddSelectDto;
import com.example.javapythonstory.code.entity.dto.select.DeleteSelectDto;
import com.example.javapythonstory.code.entity.dto.select.UpdateSelectDto;
import com.example.javapythonstory.code.result.WebResult;
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
 * @author 
 * @since 2022-06-14
 */
@RestController
@RequestMapping("/select")
public class SelectController {

    @Autowired
    private SelectService selectService;

    @PostMapping("/super/addSelect")
    public WebResult addSelect(@RequestBody AddSelectDto addSelectDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = selectService.addSelect(
                addSelectDto.getQuestionId(),
                addSelectDto.getContent(),
                addSelectDto.getCode());
        message.put("addCode", addCode);
        return new WebResult().result200(message, "/super/addSelect");
    }

    @PostMapping("/super/updateSelect")
    public WebResult updateSelect(@RequestBody UpdateSelectDto updateSelectDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = selectService.updateSelect(
                updateSelectDto.getSelectId(),
                updateSelectDto.getContent(),
                updateSelectDto.getCode());
        message.put("addCode", addCode);
        return new WebResult().result200(message, "/super/updateSelect");
    }

    @PostMapping("/super/deleteSelect")
    public WebResult deleteSelect(@RequestBody DeleteSelectDto deleteSelectDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = selectService.deleteSelect(deleteSelectDto.getSelectId());
        message.put("addCode", addCode);
        return new WebResult().result200(message, "/super/deleteSelect");
    }

}
