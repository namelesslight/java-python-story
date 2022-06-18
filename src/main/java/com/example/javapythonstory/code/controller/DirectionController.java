package com.example.javapythonstory.code.controller;


import com.example.javapythonstory.code.entity.dto.direction.AddDirectionDto;
import com.example.javapythonstory.code.entity.dto.direction.DeleteDirectionDto;
import com.example.javapythonstory.code.entity.dto.direction.UpdateDirectionDto;
import com.example.javapythonstory.code.entity.po.Direction;
import com.example.javapythonstory.code.result.Result;
import com.example.javapythonstory.code.service.DirectionService;
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
@RequestMapping("/direction")
public class DirectionController {

    @Autowired
    private DirectionService directionService;

    /**
     * <p>
     *     添加学习方向
     * </p>
     * @param addDirectionDto 添加学习方向DTO
     * @return
     */
    @PostMapping("/super/addDirection")
    public Result addDirection(@RequestBody AddDirectionDto addDirectionDto) {
        Map<String, Object> message = new HashMap<>();
        Integer addCode = directionService.addDirection(addDirectionDto.getDirectionName());
        message.put("addCode",addCode);
        return new Result().result200(message, "/super/addDirection");
    }

    /**
     * <p>
     *     修改学习方向
     * </p>
     * @param updateDirectionDto 修改学习方向DTO
     * @return
     */
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

    /**
     * <p>
     *     删除学习方向
     * </p>
     * @param deleteDirectionDto 删除学习方向DTO
     * @return
     */
    @PostMapping("/super/deleteDirection")
    public Result deleteDirection(@RequestBody DeleteDirectionDto deleteDirectionDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = directionService.deleteDirection(deleteDirectionDto.getDirectionId());
        List<Direction> data = directionService.listDirection();
        message.put("deleteCode", deleteCode);
        message.put("data", data);
        return new Result().result200(message, "/super/deleteDirection");
    }

    /**
     * <p>
     *     获取全部学习方向
     * </p>
     * @return
     */
    @GetMapping("/common/listDirection")
    public Result listDirection(){
        Map<String, Object> message = new HashMap<>();
        List<Direction> data = directionService.listDirection();
        message.put("data", data);
        return new Result().result200(message, "/common/listDirection");
    }

    /**
     * <p>
     *      获取单个学习方向
     * </p>
     * @param directionId 学习路线编号
     * @return
     */
    @GetMapping("/common/queryOneDirectionById")
    public Result queryOneDirectionById(@RequestParam Integer directionId){
        Map<String, Object> message = new HashMap<>();
        Direction data = directionService.queryOneDirectionById(directionId);
        message.put("data", data);
        return new Result().result200(message, "/common/listDirection");
    }

}
