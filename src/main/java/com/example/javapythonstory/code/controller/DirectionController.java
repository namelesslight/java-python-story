package com.example.javapythonstory.code.controller;


import com.example.javapythonstory.code.entity.dto.direction.AddDirectionDto;
import com.example.javapythonstory.code.entity.dto.direction.DeleteDirectionDto;
import com.example.javapythonstory.code.entity.dto.direction.UpdateDirectionDto;
import com.example.javapythonstory.code.entity.po.Direction;
import com.example.javapythonstory.code.result.Result;
import com.example.javapythonstory.code.service.DirectionService;
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

    @Resource
    private DirectionService directionService;

    @PostMapping("/super/addDirection")
    public Result addDirection(@RequestBody AddDirectionDto addDirectionDto) {
        Map<String, Object> message = new HashMap<>();
        Integer addCode = directionService.addDirection(addDirectionDto.getDirectionName());
        message.put("addCode",addCode);
        return new Result().result200(message, "/super/addDirection");
    }

    @PostMapping("/super/updateDirection")
    public Result updateDirection(@RequestBody UpdateDirectionDto updateDirectionDto) {
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = directionService.updateDirection(
                updateDirectionDto.getDirectionId(),
                updateDirectionDto.getDirectionName());
        List<Direction> data = directionService.listDirection();
        message.put("updateCode", updateCode);
        message.put("data", data);
        return new Result().result200(message, "/super/updateDirection");
    }

    @PostMapping("/super/deleteDirection")
    public Result deleteDirection(@RequestBody DeleteDirectionDto deleteDirectionDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = directionService.deleteDirection(deleteDirectionDto.getDirectionId());
        List<Direction> data = directionService.listDirection();
        message.put("deleteCode", deleteCode);
        message.put("data", data);
        return new Result().result200(message, "/super/deleteDirection");
    }

    @GetMapping("/common/listDirection")
    public Result listDirection(){
        Map<String, Object> message = new HashMap<>();
        List<Direction> data = directionService.listDirection();
        message.put("data", data);
        return new Result().result200(message, "/common/listDirection");
    }

    @GetMapping("/common/listDirection")
    public Result queryOneDirectionById(@RequestParam String directionId){
        Map<String, Object> message = new HashMap<>();
        Direction data = directionService.queryOneDirectionById(directionId);
        message.put("data", data);
        return new Result().result200(message, "/common/listDirection");
    }
}
