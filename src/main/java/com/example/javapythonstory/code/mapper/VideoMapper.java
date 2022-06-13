package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.Video;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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
public interface VideoMapper extends BaseMapper<Video> {

    Integer addVideo(Integer modelId);

    Integer deleteUnCommitVideo(Integer videoId);

    Integer setVideoCommit(Integer videoId);

    Integer updateVideo(Integer videoId, String name, String path, String introduce);

    Integer updateVideoPicture(Integer videoId, String picture);

    Integer deleteVideo(Integer videoId);

    List<Video> listVideoByModel(Integer modelId);

    List<Video> listUnCommitVideo(Integer modelId);

    Video queryOneVideoById(Integer videoId);

}
