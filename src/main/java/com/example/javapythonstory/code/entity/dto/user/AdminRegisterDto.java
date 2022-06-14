package com.example.javapythonstory.code.entity.dto.user;

import lombok.Data;

@Data
public class AdminRegisterDto {

    /**
     * 管理员名
     */
    private String adminName;

    /**
     * 密码
     */
    private String password;

    /**
     * 再次输入密码
     */
    private String rwPassword;

}
