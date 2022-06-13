package com.example.javapythonstory.code.controller;

import com.example.javapythonstory.code.entity.dto.resource.DeleteResourceByIdDto;
import com.example.javapythonstory.code.entity.dto.resource.DeleteResourceByPathDto;
import com.example.javapythonstory.code.result.WebResult;
import com.example.javapythonstory.code.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
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
    public WebResult addResource(@RequestParam Integer articleId,
                                 @RequestParam MultipartFile picture){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = resourceService.addResource(articleId,"image" , picture);
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

}
