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
@TableName("tb_result")
@ApiModel(value = "Result对象", description = "")
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("结果编号")
    @TableId(value = "r_id", type = IdType.AUTO)
    private Integer rId;

    @ApiModelProperty("结果对应用户编号")
    @TableField("r_user")
    private Integer rUser;

    @ApiModelProperty("结果内容")
    @TableField("r_content")
    private String rContent;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("是否删除")
    @TableField("is_delete")
    private Boolean isDelete;


}
