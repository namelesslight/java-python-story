package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.Video;
import com.example.javapythonstory.code.entity.vo.video.UpdateVideoPictureInfo;
import com.example.javapythonstory.code.mapper.VideoMapper;
import com.example.javapythonstory.code.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.javapythonstory.code.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
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
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    /**
     * <p>
     *     在对应模块添加未编辑视频
     * </p>
     * @param modelId 模块编号
     * @return
     */
    @Override
    public Integer addVideo(Integer modelId) {
        Integer addCode = videoMapper.addVideo(modelId);
        return addCode;
    }

    /**
     * <p>
     *     取消编辑视频
     * </p>
     * @param videoId 视频编号
     * @return
     */
    @Override
    public Integer cancelCommit(Integer videoId) {
        Integer deleteCode = videoMapper.deleteUnCommitVideo(videoId);
        return deleteCode;
    }

    /**
     * <p>
     *     提交视频
     * </p>
     * @param videoId 视频编号
     * @return
     */
    @Override
    public Integer commitVideo(Integer videoId) {
        Video video = videoMapper.queryOneVideoById(videoId);
        Boolean nameJudge = "".equals(video.getVName());
        Boolean introduceJudge = "".equals(video.getVIntroduce());
        Boolean pathJudge = "".equals(video.getVPath());
        if (nameJudge && introduceJudge && pathJudge){
            return 0;
        }
        Integer commitCode = videoMapper.setVideoCommit(videoId);
        return commitCode;
    }

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
    @Override
    public Integer updateVideo(Integer videoId, String name, String path, String introduce) {
        Integer updateCode = videoMapper.updateVideo(videoId, name, path, introduce);
        return updateCode;
    }

    /**
     * <p>
     *     修改视频封面
     * </p>
     * @param videoId 视频编号
     * @param picture 图片文件
     * @return
     * @throws IOException
     */
    @Override
    public UpdateVideoPictureInfo updateVideoPicture(Integer videoId, MultipartFile picture) throws IOException {
        String path = "/usr/local/src/spring/file/image/video_header/" + videoId;
        String imagePath = FileUtil.addImg(picture, path);
        Integer updateCode = videoMapper.updateVideoPicture(videoId, imagePath);
        UpdateVideoPictureInfo updateVideoPictureInfo = new UpdateVideoPictureInfo(updateCode, imagePath);
        return updateVideoPictureInfo;
    }

    /**
     * <p>
     *     删除视频
     * </p>
     * @param videoId 视频编号
     * @return
     */
    @Override
    public Integer deleteVideo(Integer videoId) {
        Integer deleteCode = videoMapper.deleteVideo(videoId);
        return deleteCode;
    }

    /**
     * <p>
     *     通过模块获取视频
     * </p>
     * @param modelId 模块编号
     * @return
     */
    @Override
    public List<Video> listVideoByModel(Integer modelId) {
        List<Video> data = videoMapper.listVideoByModel(modelId);
        return data;
    }

    /**
     * <p>
     *     通过模块获取未提交的视频
     * </p>
     * @param modelId 模块编号
     * @return
     */
    @Override
    public List<Video> listUnCommitVideo(Integer modelId) {
        List<Video> data = videoMapper.listUnCommitVideo(modelId);
        return data;
    }

    /**
     * <p>
     *     通过视频编号获取单个视频信息
     * </p>
     * @param videoId 视频编号
     * @return
     */
    @Override
    public Video queryOneVideoById(Integer videoId) {
        Video data = videoMapper.queryOneVideoById(videoId);
        return data;
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
