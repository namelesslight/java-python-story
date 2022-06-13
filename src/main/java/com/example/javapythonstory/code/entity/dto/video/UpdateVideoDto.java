package com.example.javapythonstory.code.entity.dto.video;

import lombok.Data;

@Data
public class UpdateVideoDto {

    private Integer videoId;

    private String name;

    private String path;

    private String introduce;

}
