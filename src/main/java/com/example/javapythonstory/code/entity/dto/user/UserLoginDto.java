package com.example.javapythonstory.code.entity.dto.user;

import lombok.Data;

@Data
public class UserLoginDto {

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户密码
     */
    private String password;

}
