package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

    Integer addResource(Integer userId, String type, String picture);

    Integer deleteResourceByPath(String resourcePath);

    Integer deleteResourceById(Integer resourceId);

    String querypathById(Integer resourceId);

    List<Resource> listResourceByUser(Integer userId);

}
