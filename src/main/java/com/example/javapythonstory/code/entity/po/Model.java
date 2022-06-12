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
@TableName("tb_model")
@ApiModel(value = "Model对象", description = "")
public class Model implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("模块编号")
    @TableId("m_id")
    private String mId;

    @ApiModelProperty("模块名")
    @TableField("m_name")
    private String mName;

    @ApiModelProperty("用户所选模块方向")
    @TableField("m_direction")
    private Integer mDirection;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("是否删除")
    @TableField("is_delete")
    private Boolean isDelete;


}
