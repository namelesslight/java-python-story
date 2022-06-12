package com.example.javapythonstory.code.entity.dto.user;

import lombok.Data;

@Data
public class UserRegisterDto {

    private String email;

    private String username;

    private String code;

    private String password;

    private String rwPassword;

}
