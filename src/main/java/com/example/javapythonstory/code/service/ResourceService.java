package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.Resource;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
public interface ResourceService extends IService<Resource> {

    Integer addResource(Integer userId, String type, MultipartFile picture) throws IOException;

    Integer deleteResourceByPath(String resourcePath);

    Integer deleteResourceById(Integer resourceId);

    List<Resource> listResourceByUser(Integer userId);

}
