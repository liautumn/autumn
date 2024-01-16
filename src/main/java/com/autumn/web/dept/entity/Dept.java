package com.autumn.web.dept.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.autumn.common.easyExcel.converter.DictConverter;
import com.autumn.common.tree.TreePublic;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lqz
 * @date 2023-07-09 16:13:26
 * 部门表
 */
@TableName(value = "sys_dept")
@Data
@Accessors
@ColumnWidth(30)
@HeadRowHeight(20)
public class Dept extends TreePublic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 祖级列表
     */
    @ExcelProperty(value = "祖级列表")
    @TableField(value = "ancestors")
    private String ancestors;
    /**
     * 部门名称
     */
    @ExcelProperty(value = "部门名称")
    @TableField(value = "dept_name")
    private String deptName;
    /**
     * 显示顺序
     */
    @ExcelProperty(value = "显示顺序")
    @TableField(value = "order_num")
    private Integer orderNum;
    /**
     * 负责人
     */
    @ExcelProperty(value = "负责人")
    @TableField(value = "leader")
    private String leader;
    /**
     * 联系电话
     */
    @ExcelProperty(value = "联系电话")
    @TableField(value = "phone")
    private String phone;
    /**
     * 邮箱
     */
    @ExcelProperty(value = "邮箱")
    @TableField(value = "email")
    private String email;
    /**
     * 是否停用（0是 1否）
     */
    @ExcelProperty(value = "是否停用", converter = DictConverter.class, dictCode = "whether")
    @TableField(value = "status")
    private String status;


}
