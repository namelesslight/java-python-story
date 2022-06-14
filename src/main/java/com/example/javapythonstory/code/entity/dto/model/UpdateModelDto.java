package com.example.javapythonstory.code.entity.dto.model;

import lombok.Data;

@Data
public class UpdateModelDto {

    /**
     * 模块编号
     */
    private Integer modelId;

    /**
     * 模块名
     */
    private String modelName;

}
