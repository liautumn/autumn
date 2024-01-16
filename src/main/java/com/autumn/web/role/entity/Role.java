package com.autumn.web.role.entity;

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
 * @date 2023-07-09 19:34:33
 * 角色信息表
 */
@TableName(value = "sys_role")
@Data
@Accessors
@ColumnWidth(30)
@HeadRowHeight(20)
public class Role extends PublicEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    @ExcelProperty(value = "角色名称")
    @TableField(value = "role_name")
    private String roleName;
    /**
     * 角色权限字符串
     */
    @ExcelProperty(value = "角色权限字符串")
    @TableField(value = "role_key")
    private String roleKey;
    /**
     * 显示顺序
     */
    @ExcelProperty(value = "显示顺序")
    @TableField(value = "role_sort")
    private Integer roleSort;
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    @ExcelProperty(value = "数据范围")
    @TableField(value = "data_scope")
    private String dataScope;
    /**
     * 菜单树选择项是否关联显示（0是 1否）
     */
    @ExcelProperty(value = "菜单树选择项是否关联显示")
    @TableField(value = "menu_check_strictly")
    private String menuCheckStrictly;
    /**
     * 部门树选择项是否关联显示（0是 1否）
     */
    @ExcelProperty(value = "部门树选择项是否关联显示")
    @TableField(value = "dept_check_strictly")
    private String deptCheckStrictly;
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
