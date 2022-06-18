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
 * @since 2022-06-18
 */
@Getter
@Setter
@TableName("tb_news")
@ApiModel(value = "News对象", description = "")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("新闻编号")
    @TableId(value = "n_id", type = IdType.AUTO)
    private Integer nId;

    @ApiModelProperty("新闻标题")
    @TableField("n_title")
    private String nTitle;

    @ApiModelProperty("新闻内容")
    @TableField("n_content")
    private String nContent;

    @ApiModelProperty("用户创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("用户是否删除")
    @TableField("is_delete")
    private Boolean isDelete;


}
