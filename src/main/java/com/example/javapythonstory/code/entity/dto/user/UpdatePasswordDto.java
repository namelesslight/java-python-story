package com.example.javapythonstory.code.entity.dto.user;

import lombok.Data;

@Data
public class UpdatePasswordDto {

    private Integer id;

    private String oldPassword;

    private String newPassword;

    private String rwPassword;

}
