package com.example.javapythonstory.code.controller;


import com.example.javapythonstory.code.entity.dto.direction.AddDirectionDto;
import com.example.javapythonstory.code.entity.dto.direction.DeleteDirectionDto;
import com.example.javapythonstory.code.entity.dto.direction.UpdateDirectionDto;
import com.example.javapythonstory.code.entity.po.Direction;
import com.example.javapythonstory.code.result.WebResult;
import com.example.javapythonstory.code.service.DirectionService;
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
 * @author 
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/direction")
public class DirectionController {

    @Autowired
    private DirectionService directionService;

    @PostMapping("/super/addDirection")
    public WebResult addDirection(@RequestBody AddDirectionDto addDirectionDto) {
        Map<String, Object> message = new HashMap<>();
        Integer addCode = directionService.addDirection(addDirectionDto.getDirectionName());
        message.put("addCode",addCode);
        return new WebResult().result200(message, "/super/addDirection");
    }

    @PostMapping("/super/updateDirection")
    public WebResult updateDirection(@RequestBody UpdateDirectionDto updateDirectionDto) {
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = directionService.updateDirection(
                updateDirectionDto.getDirectionId(),
                updateDirectionDto.getDirectionName());
        List<Direction> data = directionService.listDirection();
        message.put("updateCode", updateCode);
        message.put("data", data);
        return new WebResult().result200(message, "/super/updateDirection");
    }

    @PostMapping("/super/deleteDirection")
    public WebResult deleteDirection(@RequestBody DeleteDirectionDto deleteDirectionDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = directionService.deleteDirection(deleteDirectionDto.getDirectionId());
        List<Direction> data = directionService.listDirection();
        message.put("deleteCode", deleteCode);
        message.put("data", data);
        return new WebResult().result200(message, "/super/deleteDirection");
    }

    @GetMapping("/common/listDirection")
    public WebResult listDirection(){
        Map<String, Object> message = new HashMap<>();
        List<Direction> data = directionService.listDirection();
        message.put("data", data);
        return new WebResult().result200(message, "/common/listDirection");
    }

    @GetMapping("/common/queryOneDirectionById")
    public WebResult queryOneDirectionById(@RequestParam Integer directionId){
        Map<String, Object> message = new HashMap<>();
        Direction data = directionService.queryOneDirectionById(directionId);
        message.put("data", data);
        return new WebResult().result200(message, "/common/listDirection");
    }
}
