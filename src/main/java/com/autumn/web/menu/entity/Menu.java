package com.autumn.web.menu.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.autumn.common.easyExcel.converter.DictConverter;
import com.autumn.common.tree.TreePublic;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 菜单权限表
 *
 * @TableName sys_menu
 */
@Data
@TableName(value = "sys_menu")
public class Menu extends TreePublic implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 路由地址
     */
    @ExcelProperty(value = "路由地址")
    @TableField(value = "path")
    private String path;
    /**
     * 路由 name (对应页面组件 name, 可用作 KeepAlive 缓存标识 && 按钮权限筛选)
     */
    @ExcelProperty(value = "路由 name")
    @TableField(value = "name")
    private String name;
    /**
     * 重定向地址
     */
    @ExcelProperty(value = "重定向地址")
    @TableField(value = "redirect")
    private String redirect;
    /**
     * 组件路径
     */
    @ExcelProperty(value = "组件路径")
    @TableField(value = "component")
    private String component;
    /**
     * 菜单图标
     */
    @ExcelProperty(value = "菜单图标")
    @TableField(value = "icon")
    private String icon;
    /**
     * 菜单名称
     */
    @ExcelProperty(value = "菜单名称")
    @TableField(value = "title")
    private String title;
    /**
     * 当前路由为详情页时，需要高亮的菜单
     */
    @ExcelProperty(value = "高亮菜单")
    @TableField(value = "active_menu")
    private String activeMenu;
    /**
     * 是否为外链（0是 1否）
     */
    @ExcelProperty(value = "是否为外链", converter = DictConverter.class, dictCode = "whether")
    @TableField(value = "is_link")
    private String isLink;
    /**
     * 是否隐藏（0是 1否）
     */
    @ExcelProperty(value = "是否隐藏", converter = DictConverter.class, dictCode = "whether")
    @TableField(value = "is_hide")
    private String isHide;
    /**
     * 是否全屏显示（0是 1否）
     */
    @ExcelProperty(value = "是否全屏显示", converter = DictConverter.class, dictCode = "whether")
    @TableField(value = "is_full")
    private String isFull;
    /**
     * 是否固定页（0是 1否）
     */
    @ExcelProperty(value = "是否固定页", converter = DictConverter.class, dictCode = "whether")
    @TableField(value = "is_affix")
    private String isAffix;
    /**
     * 是否缓存（0是 1否）
     */
    @ExcelProperty(value = "是否缓存", converter = DictConverter.class, dictCode = "whether")
    @TableField(value = "is_keep_alive")
    private String isKeepAlive;
    /**
     * 显示顺序
     */
    @ExcelProperty(value = "显示顺序")
    @TableField(value = "order_num")
    private Integer orderNum;
    /**
     * 菜单类型（0目录 1菜单 2按钮）
     */
    @ExcelProperty(value = "菜单类型", converter = DictConverter.class, dictCode = "menuType")
    @TableField(value = "menu_type")
    private String menuType;
    /**
     * 是否停用（0是 1否）
     */
    @ExcelProperty(value = "是否停用", converter = DictConverter.class, dictCode = "whether")
    @TableField(value = "status")
    private String status;
    /**
     * 权限标识
     */
    @ExcelProperty(value = "权限标识")
    @TableField(value = "perms")
    private String perms;
    /**
     * 路由参数
     */
    @ExcelProperty(value = "路由参数")
    @TableField(value = "query")
    private String query;
    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;
}
