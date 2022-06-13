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
 * @author 
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/super/addVideo")
    public WebResult addVideo(@RequestBody AddVideoDto addVideoDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = videoService.addVideo(addVideoDto.getModelId());
        message.put("addCode", addCode);
        return new WebResult().result200(message, "/super/addVideo");
    }

    @PostMapping("/super/cancelCommit")
    public WebResult cancelCommit(@RequestBody CommitDto commitDto){
        Map<String, Object> message = new HashMap<>();
        Integer cancelCode = videoService.cancelCommit(commitDto.getVideoId());
        message.put("cancelCode", cancelCode);
        return new WebResult().result200(message, "/super/cancelCommit");
    }

    @PostMapping("/super/commitVideo")
    public WebResult commitVideo(@RequestBody CommitDto commitDto){
        Map<String, Object> message = new HashMap<>();
        Integer commitCode = videoService.commitVideo(commitDto.getVideoId());
        message.put("commitCode", commitCode);
        return new WebResult().result200(message, "/super/commitVideo");
    }

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

    @PostMapping("/super/updateVideoPicture")
    public WebResult updateVideoPicture(@RequestParam Integer videoId,
                                        @RequestParam MultipartFile picture) throws IOException {
        Map<String, Object> message = new HashMap<>();
        UpdateVideoPictureInfo updateCode = videoService.updateVideoPicture(videoId, picture);
        message.put("updateCode", updateCode);
        return new WebResult().result200(message, "/super/updateVideoPicture");
    }

    @PostMapping("/super/deleteVideo")
    public WebResult deleteVideo(@RequestBody DeleteVideoDto deleteVideoDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = videoService.deleteVideo(deleteVideoDto.getVideoId());
        message.put("deleteCode", deleteCode);
        return new WebResult().result200(message, "/super/deleteVideo");
    }

    @GetMapping("/common/listVideoByModel")
    public WebResult listVideoByModel(@RequestParam Integer modelId){
        Map<String, Object> message = new HashMap<>();
        List<Video> data = videoService.listVideoByModel(modelId);
        message.put("data", data);
        return new WebResult().result200(message, "/common/listVideoByModel");
    }

    @GetMapping("/super/listUnCommitVideo")
    public WebResult listUnCommitVideo(@RequestParam Integer modelId){
        Map<String, Object> message = new HashMap<>();
        List<Video> data = videoService.listUnCommitVideo(modelId);
        message.put("data", data);
        return new WebResult().result200(message, "/super/listUnCommitVideo");
    }

    @GetMapping("/common/queryOneVideoById")
    public WebResult queryOneVideoById(@RequestParam Integer videoId){
        Map<String, Object> message = new HashMap<>();
        Video data = videoService.queryOneVideoById(videoId);
        message.put("data", data);
        return new WebResult().result200(message, "/common/queryOneVideoById");
    }

}
