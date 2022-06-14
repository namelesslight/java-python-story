package com.example.javapythonstory.code.entity.dto.select;

import lombok.Data;

@Data
public class UpdateSelectDto {

    /**
     * 选项编号
     */
    private Integer selectId;

    /**
     * 选项内容
     */
    private String content;

    /**
     * 选项号
     */
    private String code;

}
