package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.Video;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.javapythonstory.code.entity.vo.video.UpdateVideoPictureInfo;
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

    Integer addVideo(Integer modelId);

    Integer cancelCommit(Integer videoId);

    Integer commitVideo(Integer videoId);

    Integer updateVideo(Integer videoId, String name, String path, String introduce);

    UpdateVideoPictureInfo updateVideoPicture(Integer videoId, MultipartFile picture) throws IOException;

    Integer deleteVideo(Integer videoId);

    List<Video> listVideoByModel(Integer modelId);

    List<Video> listUnCommitVideo(Integer modelId);

    Video queryOneVideoById(Integer videoId);

}
