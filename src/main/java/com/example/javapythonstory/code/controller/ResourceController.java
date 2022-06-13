package com.example.javapythonstory.code.controller;

import com.example.javapythonstory.code.entity.dto.resource.DeleteResourceByIdDto;
import com.example.javapythonstory.code.entity.dto.resource.DeleteResourceByPathDto;
import com.example.javapythonstory.code.entity.po.Resource;
import com.example.javapythonstory.code.result.WebResult;
import com.example.javapythonstory.code.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/common/addResource")
    public WebResult addResource(@RequestParam Integer userId,
                                 @RequestParam MultipartFile picture) throws IOException {
        Map<String, Object> message = new HashMap<>();
        Integer addCode = resourceService.addResource(userId,"image" , picture);
        message.put("addCode", addCode);
        return new WebResult().result200(message, "/common/addResource");
    }

    @PostMapping("/common/deleteResourceByPath")
    public WebResult deleteResourceByPath(@RequestBody DeleteResourceByPathDto deleteResourceByPathDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = resourceService.deleteResourceByPath(deleteResourceByPathDto.getResourcePath());
        message.put("deleteCode", deleteCode);
        return new WebResult().result200(message, "/common/deleteResourceByPath");
    }

    @PostMapping("/common/deleteResourceById")
    public WebResult deleteResourceById(@RequestBody DeleteResourceByIdDto deleteResourceByIdDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = resourceService.deleteResourceById(deleteResourceByIdDto.getResourceId());
        message.put("deleteCode", deleteCode);
        return new WebResult().result200(message, "/common/deleteResourceById");
    }

    @PostMapping("/common/listResourceByUser")
    public WebResult listResourceByUser(@RequestParam Integer userId){
        Map<String, Object> message = new HashMap<>();
        List<Resource> deleteCode = resourceService.listResourceByUser(userId);
        message.put("deleteCode", deleteCode);
        return new WebResult().result200(message, "/common/listResourceByUser");
    }

}
