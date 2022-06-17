package com.example.javapythonstory.code.entity.dto.article;

import lombok.Data;

@Data
public class AddProblemDto {

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章名
     */
    private String articleName;

    /**
     * 文章内容
     */
    private String articleContent;

}
