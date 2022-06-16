package com.example.javapythonstory.code.entity.vo.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceVo {

    /**
     * 添加返回码
     */
    private Integer addCode;

    /**
     * 文件路径
     */
    private String filePath;

}
