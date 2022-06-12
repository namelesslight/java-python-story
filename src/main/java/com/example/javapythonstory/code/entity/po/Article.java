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
 * @author 
 * @since 2022-06-08
 */
@Getter
@Setter
@TableName("tb_article")
@ApiModel(value = "Article对象", description = "")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章编号")
    @TableId("a_id")
    private Integer aId;

    @ApiModelProperty("文章名")
    @TableField("a_name")
    private String aName;

    @ApiModelProperty("文章模块")
    @TableField("a_model")
    private Integer aModel;

    @ApiModelProperty("文章标题")
    @TableField("a_title")
    private String aTitle;

    @ApiModelProperty("文章内容")
    @TableField("a_content")
    private String aContent;

    @ApiModelProperty("用户创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("用户是否删除")
    @TableField("is_delete")
    private Boolean isDelete;


}
