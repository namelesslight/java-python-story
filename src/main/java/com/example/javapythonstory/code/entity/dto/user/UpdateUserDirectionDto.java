package com.example.javapythonstory.code.entity.dto.user;

import lombok.Data;

@Data
public class UpdateUserDirectionDto {

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 学习方向编号
     */
    private Integer userDirection;

}
