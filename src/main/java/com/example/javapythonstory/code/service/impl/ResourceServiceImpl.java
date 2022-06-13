package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.Resource;
import com.example.javapythonstory.code.mapper.ResourceMapper;
import com.example.javapythonstory.code.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.javapythonstory.code.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Integer addResource(Integer userId, String type, MultipartFile picture) throws IOException {
        String path = "/usr/local/src/spring/file/image/article_resource/" + createDirName();
        String resourcePath = FileUtil.addImg(picture, path);
        Integer addCode = resourceMapper.addResource(userId, type, resourcePath);
        return addCode;
    }

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
