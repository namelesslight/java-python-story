package com.example.javapythonstory.code.entity.dto.user;

import lombok.Data;

@Data
public class UserRegisterDto {

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户名
     */
    private String username;

    /**
     * 验证码
     */
    private String code;

    /**
     * 密码
     */
    private String password;

    /**
     * 再次输入密码
     */
    private String rwPassword;

}
