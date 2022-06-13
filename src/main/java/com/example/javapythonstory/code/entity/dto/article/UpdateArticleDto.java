package com.example.javapythonstory.code.entity.dto.article;

import lombok.Data;

@Data
public class UpdateArticleDto {

    private Integer articleId;

    private String articleTitle;

    private String articleContent;

}
