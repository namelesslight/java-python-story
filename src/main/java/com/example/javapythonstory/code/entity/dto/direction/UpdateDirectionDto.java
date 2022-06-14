package com.example.javapythonstory.code.entity.dto.direction;

import lombok.Data;

@Data
public class UpdateDirectionDto {

    /**
     * 学习方向编号
     */
    private Integer directionId;

    /**
     * 学习方向名
     */
    private String directionName;

}
