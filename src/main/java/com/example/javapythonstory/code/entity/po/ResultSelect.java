package com.example.javapythonstory.code.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
@Getter
@Setter
@TableName("tb_result_select")
@ApiModel(value = "ResultSelect对象", description = "")
public class ResultSelect implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("结果选项编号")
    @TableId(value = "rs_id", type = IdType.AUTO)
    private Integer rsId;

    @ApiModelProperty("对应结果编号")
    @TableField("rs_result")
    private Integer rsResult;

    @ApiModelProperty("对应题目编号")
    @TableField("rs_question")
    private Integer rsQuestion;

    @ApiModelProperty("用户回答内容")
    @TableField("rs_answer")
    private String rsAnswer;


}
