package com.example.javapythonstory.code.entity.vo.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVo {

    private Integer id;

    private String email;

    private String name;

    private String header;

    private String directionName;

    private Integer directionId;

    private String role;

    private LocalDateTime createTime;

    private Boolean isDelete;

}
