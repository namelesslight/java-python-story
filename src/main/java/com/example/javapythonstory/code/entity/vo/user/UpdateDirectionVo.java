package com.example.javapythonstory.code.entity.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDirectionVo {

    private Integer updateCode;

    private Integer directionId;

    private String directionName;
}
