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
 * @since 2022-06-15
 */
@Getter
@Setter
@TableName("tb_book")
@ApiModel(value = "Book对象", description = "")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("书籍编号")
    @TableId(value = "b_id", type = IdType.AUTO)
    private Integer bId;

    @ApiModelProperty("书籍名")
    @TableField("b_name")
    private String bName;

    @ApiModelProperty("书籍对应模块")
    @TableField("b_model")
    private Integer bModel;

    @ApiModelProperty("封面图片路径")
    @TableField("b_file")
    private String bFile;

    @ApiModelProperty("书籍文件路径")
    @TableField("b_header")
    private String bHeader;

    @ApiModelProperty("书籍简介")
    @TableField("b_introduce")
    private String bIntroduce;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("是否删除")
    @TableField("is_delete")
    private Boolean isDelete;

    @ApiModelProperty("是否提交")
    @TableField("is_commit")
    private Boolean isCommit;
}
