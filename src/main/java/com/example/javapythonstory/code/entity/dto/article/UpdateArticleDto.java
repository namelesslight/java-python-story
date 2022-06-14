package com.example.javapythonstory.code.entity.dto.article;

import lombok.Data;

@Data
public class UpdateArticleDto {

    /**
     * 文章编号
     */
    private Integer articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章内容
     */
    private String articleContent;

}
