package com.example.javapythonstory.code.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @author 
 * @since 2022-06-14
 */
@Getter
@Setter
@TableName("tb_select")
@ApiModel(value = "Select对象", description = "")
public class Select implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("选项编号")
    @TableId(value = "s_id", type = IdType.AUTO)
    private Integer sId;

    @ApiModelProperty("选项对应题目编号")
    @TableField("s_question")
    private Integer sQuestion;

    @ApiModelProperty("选项内容")
    @TableField("s_content")
    private String sContent;

    @ApiModelProperty("选项码")
    @TableField("s_code")
    private String sCode;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("是否删除")
    @TableField("is_delete")
    private Boolean isDelete;


}
