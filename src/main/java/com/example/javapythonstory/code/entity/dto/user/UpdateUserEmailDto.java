package com.example.javapythonstory.code.entity.dto.user;

import lombok.Data;

@Data
public class UpdateUserEmailDto {

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 新邮箱
     */
    private String newEmail;

}
