package com.example.javapythonstory.code.entity.dto.question;

import lombok.Data;

@Data
public class AddTrainingQuestionDto {

    private Integer modelId;

    private String content;

    private String answer;
}
