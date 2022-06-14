package com.example.javapythonstory.code.entity.dto.user;

import lombok.Data;

@Data
public class UpdatePasswordDto {

    /**
     * 用户编号
     */
    private Integer id;

    /**
     * 旧密码
     */
    private String oldPassword;

    /**
     * 新密码
     */
    private String newPassword;

    /**
     * 重复密码
     */
    private String rwPassword;

}
