package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.Video;
import com.example.javapythonstory.code.mapper.VideoMapper;
import com.example.javapythonstory.code.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.javapythonstory.code.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Integer addVideo(Integer modelId, String name, String path, MultipartFile picture, String introduce) throws IOException {
        String imagePath = "/usr/local/src/spring/file/image/video/" + getRandomCode() + "/";
        FileUtil.addImg(picture, imagePath);
        Integer addCode = videoMapper.addVideo(modelId, name, path, imagePath, introduce);
        return addCode;
    }

    @Override
    public Integer updateVideo(Integer videoId, String name, String path, String introduce) {
        Integer updateCode = videoMapper.updateVideo(videoId, name, path, introduce);
        return  updateCode;
    }

    @Override
    public Integer updateVideoPicture(Integer videoId, MultipartFile picture) {
        return null;
    }

    @Override
    public Integer deleteVideo(Integer videoId) {
        return null;
    }

    @Override
    public List<Video> listVideoByModel(Integer modelId) {
        return null;
    }

    @Override
    public Video queryOneVideoById(Integer videoId) {
        return null;
    }

    private static String getRandomCode(){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++){
            Integer num = random.nextInt(10);
            sb.append(num);
        }
        return sb.toString();
    }
}
