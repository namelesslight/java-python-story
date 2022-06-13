package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

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

    Integer addResource(Integer articleId, String type, String picture);

    Integer deleteResourceByPath(String resourcePath);

    Integer deleteResourceById(Integer resourceId);

}
