package com.example.javapythonstory.code.entity.dto.user;

import lombok.Data;

@Data
public class UpdateUserEmailDto {

    private Integer userId;

    private String newEmail;

}
