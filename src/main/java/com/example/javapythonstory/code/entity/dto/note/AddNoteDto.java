package com.example.javapythonstory.code.entity.dto.note;

import lombok.Data;

@Data
public class AddNoteDto {

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 模块编号
     */
    private Integer modelId;

    /**
     * 笔记标题
     */
    private String title;

    /**
     * 笔记内容
     */
    private String content;

}
