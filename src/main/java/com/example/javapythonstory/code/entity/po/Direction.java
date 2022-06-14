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
@TableName("tb_direction")
@ApiModel(value = "Direction对象", description = "")
public class Direction implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("方向编号")
    @TableId("d_id")
    private Integer dId;

    @ApiModelProperty("方向名")
    @TableField("d_name")
    private String dName;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("是否删除")
    @TableField("is_delete")
    private Boolean isDelete;


}
