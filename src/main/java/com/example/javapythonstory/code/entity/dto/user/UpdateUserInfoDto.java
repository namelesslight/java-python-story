package com.example.javapythonstory.code.entity.dto.user;

import lombok.Data;

@Data
public class UpdateUserInfoDto {

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

}
