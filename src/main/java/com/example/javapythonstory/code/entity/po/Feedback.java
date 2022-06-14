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
 * @author ZCL
 * @since 2022-06-08
 */
@Getter
@Setter
@TableName("tb_feedback")
@ApiModel(value = "Feedback对象", description = "")
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("反馈编号")
    @TableId(value = "f_id", type = IdType.AUTO)
    private Integer fId;

    @ApiModelProperty("反馈标题")
    @TableField("f_title")
    private String fTitle;

    @ApiModelProperty("反馈内容")
    @TableField("f_content")
    private String fContent;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;


}
