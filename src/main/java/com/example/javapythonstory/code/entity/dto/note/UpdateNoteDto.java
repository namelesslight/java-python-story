package com.example.javapythonstory.code.entity.dto.note;

import lombok.Data;

@Data
public class UpdateNoteDto {

    private Integer userId;

    private Integer noteId;

    private String title;

    private String content;


}
