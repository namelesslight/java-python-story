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
@TableName("tb_video")
@ApiModel(value = "Video对象", description = "")
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("视频编号")
    @TableId("v_id")
    private Integer vId;

    @ApiModelProperty("视频名")
    @TableField("v_name")
    private String vName;

    @ApiModelProperty("视频路径")
    @TableField("v_path")
    private String vPath;

    @ApiModelProperty("视频对应模块")
    @TableField("v_model")
    private Integer vModel;

    @ApiModelProperty("封面图片路径")
    @TableField("v_picture")
    private String vPicture;

    @ApiModelProperty("视频介绍")
    @TableField("v_introduce")
    private String vIntroduce;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("是否删除")
    @TableField("is_delete")
    private Boolean isDelete;


}
