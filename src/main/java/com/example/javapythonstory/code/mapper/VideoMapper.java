package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.Video;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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
public interface VideoMapper extends BaseMapper<Video> {

    /**
     * <p>
     *     在对应模块添加未编辑视频
     * </p>
     * @param modelId 模块编号
     * @return
     */
    Integer addVideo(Integer modelId);

    /**
     * <p>
     *     取消编辑视频
     * </p>
     * @param videoId 视频编号
     * @return
     */
    Integer deleteUnCommitVideo(Integer videoId);

    /**
     * <p>
     *     提交视频
     * </p>
     * @param videoId 视频编号
     * @return
     */
    Integer setVideoCommit(Integer videoId);

    /**
     * <p>
     *     修改视频信息
     * </p>
     * @param videoId 视频编号
     * @param name 视频名
     * @param path 视频路径
     * @param introduce 视频简介
     * @return
     */
    Integer updateVideo(Integer videoId, String name, String path, String introduce);

    /**
     * <p>
     *     修改视频封面
     * </p>
     * @param videoId 视频编号
     * @param picture 图片文件
     * @return
     * @throws IOException
     */
    Integer updateVideoPicture(Integer videoId, String picture);

    /**
     * <p>
     *     删除视频
     * </p>
     * @param videoId 视频编号
     * @return
     */
    Integer deleteVideo(Integer videoId);

    /**
     * <p>
     *     通过模块获取视频
     * </p>
     * @param modelId 模块编号
     * @return
     */
    List<Video> listVideoByModel(Integer modelId);

    /**
     * <p>
     *     通过模块获取未提交的视频
     * </p>
     * @param modelId 模块编号
     * @return
     */
    List<Video> listUnCommitVideo(Integer modelId);

    /**
     * <p>
     *     通过视频编号获取单个视频信息
     * </p>
     * @param videoId 视频编号
     * @return
     */
    Video queryOneVideoById(Integer videoId);

}
