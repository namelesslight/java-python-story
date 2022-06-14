package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZCL
 * @since 2022-06-08
 */
@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

    /**
     * <p>
     *     添加资源
     * </p>
     * @param userId 用户编号
     * @param type 资源类型
     * @param picture 资源
     * @return
     */
    Integer addResource(Integer userId, String type, String picture);

    /**
     * <p>
     *     通过资源路径删除资源
     * </p>
     * @param resourcePath 资源路径
     * @return
     */
    Integer deleteResourceByPath(String resourcePath);

    /**
     * <p>
     *     通过资源路径编号资源
     * </p>
     * @param resourceId 资源编号
     * @return
     */
    Integer deleteResourceById(Integer resourceId);

    /**
     * <p>
     *     通过资源编号获取资源
     * </p>
     * @param resourceId 资源编号
     * @return
     */
    String querypathById(Integer resourceId);
    /**
     * <p>
     *     通过用户编号获取资源
     * </p>
     * @param userId 用户编号
     * @return
     */
    List<Resource> listResourceByUser(Integer userId);

}
