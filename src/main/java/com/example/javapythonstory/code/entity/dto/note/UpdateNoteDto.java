package com.example.javapythonstory.code.entity.dto.note;

import lombok.Data;

@Data
public class UpdateNoteDto {

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 笔记编号
     */
    private Integer noteId;

    /**
     * 笔记标题
     */
    private String title;

    /**
     * 笔记内容
     */
    private String content;


}
