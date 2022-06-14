package com.example.javapythonstory.code.entity.dto.resource;

import lombok.Data;

@Data
public class DeleteResourceByPathDto {

    /**
     * 要删除资源的路径
     */
    private String resourcePath;

}
