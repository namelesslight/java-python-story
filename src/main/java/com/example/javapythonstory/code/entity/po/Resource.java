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
@TableName("tb_resource")
@ApiModel(value = "Resource对象", description = "")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("资源编号")
    @TableId("r_id")
    private Integer rId;

    @ApiModelProperty("资源路径")
    @TableField("r_path")
    private String rPath;

    @ApiModelProperty("资源类型")
    @TableField("r_type")
    private String rType;

    @ApiModelProperty("添加资源的用户")
    @TableField("r_user")
    private Integer rUser;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("是否删除")
    @TableField("is_delete")
    private Boolean isDelete;


}
