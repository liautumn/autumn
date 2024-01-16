package com.autumn.web.roleMenu.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.autumn.common.publicEntity.PublicEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lqz
 * @date 2023-07-10 13:57:24
 * 角色和菜单关联表
 */
@TableName(value = "sys_role_menu")
@Data
@Accessors
@ColumnWidth(30)
@HeadRowHeight(20)
public class RoleMenu extends PublicEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @ExcelProperty(value = "角色ID")
    @TableField(value = "role_id")
    private String roleId;
    /**
     * 菜单ID
     */
    @ExcelProperty(value = "菜单ID")
    @TableField(value = "menu_id")
    private String menuId;


}
