package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.Video;
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
public interface VideoService extends IService<Video> {

    Integer addVideo(Integer modelId, String name, String path, MultipartFile picture, String introduce) throws IOException;

    Integer updateVideo(Integer videoId, String name, String path, String introduce);

    Integer updateVideoPicture(Integer videoId,MultipartFile picture);

    Integer deleteVideo(Integer videoId);

    List<Video> listVideoByModel(Integer modelId);

    Video queryOneVideoById(Integer videoId);

}
