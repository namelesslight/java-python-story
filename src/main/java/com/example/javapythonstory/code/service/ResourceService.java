package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.Resource;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.javapythonstory.code.entity.vo.resource.ResourceVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZCL
 * @since 2022-06-08
 */
public interface ResourceService extends IService<Resource> {

    /**
     * <p>
     *     添加资源
     * </p>
     * @param userId 用户编号
     * @param type 资源类型
     * @param picture 资源
     * @return
     * @throws IOException
     */
    ResourceVo addResource(Integer userId, String type, MultipartFile picture) throws IOException;

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
     *     通过用户编号获取资源
     * </p>
     * @param userId 用户编号
     * @return
     */
    List<Resource> listResourceByUser(Integer userId);

}
