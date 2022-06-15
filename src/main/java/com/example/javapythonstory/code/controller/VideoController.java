package com.example.javapythonstory.code.controller;

import com.example.javapythonstory.code.entity.dto.video.AddVideoDto;
import com.example.javapythonstory.code.entity.dto.video.CommitDto;
import com.example.javapythonstory.code.entity.dto.video.DeleteVideoDto;
import com.example.javapythonstory.code.entity.dto.video.UpdateVideoDto;
import com.example.javapythonstory.code.entity.po.Video;
import com.example.javapythonstory.code.entity.vo.video.UpdateVideoPictureInfo;
import com.example.javapythonstory.code.result.WebResult;
import com.example.javapythonstory.code.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZCL
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/video")
@CrossOrigin("*")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * <p>
     *     在对应模块添加未编辑视频
     * </p>
     * @param addVideoDto 添加未编辑视频DTO
     * @return
     */
    @PostMapping("/super/addVideo")
    public WebResult addVideo(@RequestBody AddVideoDto addVideoDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = videoService.addVideo(addVideoDto.getModelId());
        message.put("addCode", addCode);
        return new WebResult().result200(message, "/super/addVideo");
    }

    /**
     * <p>
     *     取消编辑视频
     * </p>
     * @param commitDto 取消编辑视频DTO
     * @return
     */
    @PostMapping("/super/cancelCommit")
    public WebResult cancelCommit(@RequestBody CommitDto commitDto){
        Map<String, Object> message = new HashMap<>();
        Integer cancelCode = videoService.cancelCommit(commitDto.getVideoId());
        message.put("cancelCode", cancelCode);
        return new WebResult().result200(message, "/super/cancelCommit");
    }

    /**
     * <p>
     *     提交视频
     * </p>
     * @param commitDto 提交视频DTO
     * @return
     */
    @PostMapping("/super/commitVideo")
    public WebResult commitVideo(@RequestBody CommitDto commitDto){
        Map<String, Object> message = new HashMap<>();
        Integer commitCode = videoService.commitVideo(commitDto.getVideoId());
        message.put("commitCode", commitCode);
        return new WebResult().result200(message, "/super/commitVideo");
    }

    /**
     * <p>
     *     修改视频信息
     * </p>
     * @param updateVideoDto 修改视频信息DTO
     * @return
     */
    @PostMapping("/super/updateVideo")
    public WebResult updateVideo(@RequestBody UpdateVideoDto updateVideoDto){
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = videoService.updateVideo(
                updateVideoDto.getVideoId(),
                updateVideoDto.getName(),
                updateVideoDto.getPath(),
                updateVideoDto.getIntroduce());
        message.put("updateCode", updateCode);
        return new WebResult().result200(message, "/super/updateVideo");
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
    @PostMapping("/super/updateVideoPicture")
    public WebResult updateVideoPicture(@RequestParam Integer videoId,
                                        @RequestParam MultipartFile picture) throws IOException {
        Map<String, Object> message = new HashMap<>();
        UpdateVideoPictureInfo updateCode = videoService.updateVideoPicture(videoId, picture);
        message.put("updateCode", updateCode);
        return new WebResult().result200(message, "/super/updateVideoPicture");
    }

    /**
     * <p>
     *    删除视频
     * </p>
     * @param deleteVideoDto 删除视频
     * @return
     */
    @PostMapping("/super/deleteVideo")
    public WebResult deleteVideo(@RequestBody DeleteVideoDto deleteVideoDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = videoService.deleteVideo(deleteVideoDto.getVideoId());
        message.put("deleteCode", deleteCode);
        return new WebResult().result200(message, "/super/deleteVideo");
    }

    /**
     * <p>
     *     通过模块获取视频
     * </p>
     * @param modelId 模块编号
     * @return
     */
    @GetMapping("/common/listVideoByModel")
    public WebResult listVideoByModel(@RequestParam Integer modelId){
        Map<String, Object> message = new HashMap<>();
        List<Video> data = videoService.listVideoByModel(modelId);
        message.put("data", data);
        return new WebResult().result200(message, "/common/listVideoByModel");
    }

    /**
     * <p>
     *     通过模块获取未提交的视频
     * </p>
     * @param modelId 模块编号
     * @return
     */
    @GetMapping("/super/listUnCommitVideo")
    public WebResult listUnCommitVideo(@RequestParam Integer modelId){
        Map<String, Object> message = new HashMap<>();
        List<Video> data = videoService.listUnCommitVideo(modelId);
        message.put("data", data);
        return new WebResult().result200(message, "/super/listUnCommitVideo");
    }

    /**
     * <p>
     *     通过视频编号获取单个视频信息
     * </p>
     * @param videoId 视频编号
     * @return
     */
    @GetMapping("/common/queryOneVideoById")
    public WebResult queryOneVideoById(@RequestParam Integer videoId){
        Map<String, Object> message = new HashMap<>();
        Video data = videoService.queryOneVideoById(videoId);
        message.put("data", data);
        return new WebResult().result200(message, "/common/queryOneVideoById");
    }

}
