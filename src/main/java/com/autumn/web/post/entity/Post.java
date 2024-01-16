package com.autumn.web.post.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.autumn.common.easyExcel.converter.DictConverter;
import com.autumn.common.publicEntity.PublicEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lqz
 * @date 2023-06-19 09:56:30
 * 岗位信息表
 */
@TableName(value = "sys_post")
@Data
@Accessors
@ColumnWidth(30)
@HeadRowHeight(20)
public class Post extends PublicEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 岗位编码
     */
    @ExcelProperty(value = "岗位编码")
    @TableField(value = "post_code")
    private String postCode;
    /**
     * 岗位名称
     */
    @ExcelProperty(value = "岗位名称")
    @TableField(value = "post_name")
    private String postName;
    /**
     * 显示顺序
     */
    @ExcelProperty(value = "显示顺序")
    @TableField(value = "post_sort")
    private Integer postSort;
    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;
    /**
     * 是否停用（0是 1否）
     */
    @ExcelProperty(value = "是否停用", converter = DictConverter.class, dictCode = "whether")
    @TableField(value = "status")
    private String status;

}
