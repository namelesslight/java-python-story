package com.example.javapythonstory.code.entity.dto.question;

import lombok.Data;

@Data
public class UpdateQuestionDto {

    private Integer questionId;

    private String content;

    private String answer;

}
