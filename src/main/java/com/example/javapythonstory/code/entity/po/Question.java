package com.example.javapythonstory.code.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZCL
 * @since 2022-06-08
 */
@Getter
@Setter
@TableName("tb_question")
@ApiModel(value = "Question对象", description = "")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("题目编号")
    @TableId("q_id")
    private Integer qId;

    @ApiModelProperty("题目内容")
    @TableField("q_content")
    private String qContent;

    @ApiModelProperty("题目对应模块编号")
    @TableField("q_model")
    private Integer qModel;

    @ApiModelProperty("题目类型")
    @TableField("q_type")
    private String qType;

    @ApiModelProperty("题目答案")
    @TableField("q_answer")
    private String qAnswer;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("是否删除")
    @TableField("is_delete")
    private Boolean isDelete;


}
