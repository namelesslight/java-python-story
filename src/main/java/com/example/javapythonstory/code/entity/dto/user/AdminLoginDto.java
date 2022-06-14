package com.example.javapythonstory.code.entity.dto.user;

import lombok.Data;

@Data
public class AdminLoginDto {

    /**
     * 管理员名
     */
    private String adminName;

    /**
     * 管理员密码
     */
    private String password;

}
