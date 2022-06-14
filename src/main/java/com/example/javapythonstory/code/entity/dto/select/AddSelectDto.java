package com.example.javapythonstory.code.entity.dto.select;

import lombok.Data;

@Data
public class AddSelectDto {

    /**
     * 问题编号
     */
    private Integer questionId;

    /**
     * 选项内容
     */
    private String content;

    /**
     * 选项号
     */
    private String code;

}
