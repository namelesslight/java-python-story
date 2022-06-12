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
@TableName("tb_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户编号")
    @TableId("u_id")
    private Integer uId;

    @ApiModelProperty("用户名")
    @TableField("u_name")
    private String uName;

    @ApiModelProperty("用户密码")
    @TableField("u_password")
    private String uPassword;

    @ApiModelProperty("用户头像路径")
    @TableField("u_header")
    private String uHeader;

    @ApiModelProperty("用户邮箱")
    @TableField("u_email")
    private String uEmail;

    @ApiModelProperty("用户权限")
    @TableField("u_role")
    private String uRole;

    @ApiModelProperty("用户选择方向编号")
    @TableField("u_direction")
    private Integer uDirection;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("是否删除")
    @TableField("is_delete")
    private Boolean isDelete;


}
