package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.Resource;
import com.example.javapythonstory.code.entity.vo.resource.ResourceVo;
import com.example.javapythonstory.code.mapper.ResourceMapper;
import com.example.javapythonstory.code.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.javapythonstory.code.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZCL
 * @since 2022-06-08
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

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
    @Override
    public ResourceVo addResource(Integer userId, String type, MultipartFile picture) throws IOException {
        String path = "/usr/local/src/spring/file/image/article_resource/" + new Date().getTime();
        String resourcePath = FileUtil.addImg(picture, path);
        Integer addCode = resourceMapper.addResource(userId, type, resourcePath);
        ResourceVo resourceVo = new ResourceVo(addCode, resourcePath);
        return resourceVo;
    }

    /**
     * <p>
     *     通过资源路径删除资源
     * </p>
     * @param resourcePath 资源路径
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteResourceByPath(String resourcePath) {
        String imagePath = "/usr/local/src/spring" + resourcePath;
        String imageDir = "/usr/local/src/spring" + resourcePath.replace("picture.jpg", "");
        FileUtil.deleteFile(imagePath);
        FileUtil.deleteFile(imageDir);
        Integer deleteCode = resourceMapper.deleteResourceByPath(resourcePath);
        return deleteCode;
    }

    /**
     * <p>
     *     通过资源路径编号资源
     * </p>
     * @param resourceId 资源编号
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteResourceById(Integer resourceId) {
        String path = resourceMapper.querypathById(resourceId);
        String imagePath = "/usr/local/src/spring" + path;
        String imageDir = "/usr/local/src/spring" + path.replace("picture.jpg", "");
        FileUtil.deleteFile(imagePath);
        FileUtil.deleteFile(imageDir);
        Integer deleteCode = resourceMapper.deleteResourceById(resourceId);
        return deleteCode;
    }

    /**
     * <p>
     *     通过用户编号获取资源
     * </p>
     * @param userId 用户编号
     * @return
     */
    @Override
    public List<Resource> listResourceByUser(Integer userId) {
        List<Resource> data = resourceMapper.listResourceByUser(userId);
        return data;
    }

    private String createDirName(){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++){
            Integer num = random.nextInt(10);
            sb.append(num);
        }
        return sb.toString();
    }

}
