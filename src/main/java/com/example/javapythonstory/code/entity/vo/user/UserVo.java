package com.example.javapythonstory.code.entity.vo.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVo {

    private String id;

    private String email;

    private String name;

    private String header;

    private String direction;

    private LocalDateTime createTime;

    private Boolean isDelete;

}
