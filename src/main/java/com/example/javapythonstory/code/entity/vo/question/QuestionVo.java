package com.example.javapythonstory.code.entity.vo.question;

import com.example.javapythonstory.code.entity.po.Select;
import lombok.Data;

import java.util.List;

@Data
public class QuestionVo {

    private Integer questionId;

    private String questionContent;

    private Integer modelId;

    private List<Select> select;

}
