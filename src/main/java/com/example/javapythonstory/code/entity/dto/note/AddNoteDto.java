package com.example.javapythonstory.code.entity.dto.note;

import lombok.Data;

@Data
public class AddNoteDto {

    private Integer userId;

    private Integer modelId;

    private String title;

    private String content;

}
