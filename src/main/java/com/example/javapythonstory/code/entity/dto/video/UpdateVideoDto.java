package com.example.javapythonstory.code.entity.dto.video;

import lombok.Data;

@Data
public class UpdateVideoDto {

    /**
     * 视频编号
     */
    private Integer videoId;

    /**
     * 视频名
     */
    private String name;

    /**
     * 视频路径
     */
    private String path;

    /**
     * 视频简介
     */
    private String introduce;

}
