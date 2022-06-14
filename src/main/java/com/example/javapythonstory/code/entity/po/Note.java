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
@TableName("tb_note")
@ApiModel(value = "Note对象", description = "")
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("笔记编号")
    @TableId("n_id")
    private Integer nId;

    @ApiModelProperty("笔记用户编号")
    @TableField("n_user")
    private Integer nUser;

    @ApiModelProperty("笔记对应模块编号")
    @TableField("n_model")
    private Integer nModel;

    @ApiModelProperty("笔记标题")
    @TableField("n_title")
    private String nTitle;

    @ApiModelProperty("笔记内容")
    @TableField("n_content")
    private String nContent;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("是否删除")
    @TableField("is_delete")
    private Boolean isDelete;


}
