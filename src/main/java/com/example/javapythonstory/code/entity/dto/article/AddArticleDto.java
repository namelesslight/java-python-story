package com.example.javapythonstory.code.entity.dto.article;

import lombok.Data;

@Data
public class AddArticleDto {

    private Integer modelId;

    private String articleTitle;

    private String articleName;

    private String articleContent;

}
