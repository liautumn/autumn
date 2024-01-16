package com.autumn.web.dictData.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.autumn.common.easyExcel.converter.DictConverter;
import com.autumn.common.tree.TreePublic;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author autumn
 * @date 2023-06-13 09:00:38
 * 字典数据表
 */
@TableName(value = "sys_dict_data")
@Data
@Accessors
public class DictData extends TreePublic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 父节点ID
     */
    @ExcelProperty(value = "父节点ID")
    @TableField(value = "parent_id")
    private String parentId;
    /**
     * 字典类型表ID
     */
    @ExcelProperty(value = "字典类型表ID")
    @TableField(value = "dict_type_id")
    private String dictTypeId;
    /**
     * 数据标签
     */
    @ExcelProperty(value = "数据标签")
    @TableField(value = "dict_label")
    private String dictLabel;
    /**
     * 数据键值
     */
    @ExcelProperty(value = "数据键值")
    @TableField(value = "dict_value")
    private String dictValue;
    /**
     * 显示排序
     */
    @ExcelProperty(value = "显示排序")
    @TableField(value = "dict_sort")
    private Integer dictSort;
    /**
     * 数据类型
     */
    @ExcelProperty("数据类型")
    @TableField(value = "dict_type")
    private String dictType;
    /**
     * 样式属性
     */
    @ExcelProperty(value = "样式属性")
    @TableField(value = "css_class")
    private String cssClass;
    /**
     * 回显样式
     */
    @ExcelProperty(value = "回显样式")
    @TableField(value = "echo_class")
    private String echoClass;
    /**
     * 是否默认（0是 1否）
     */
    @ExcelProperty(value = "是否默认", converter = DictConverter.class, dictCode = "whether")
    @TableField(value = "is_default")
    private String isDefault;
    /**
     * 是否停用（0是 1否）
     */
    @ExcelProperty(value = "是否停用", converter = DictConverter.class, dictCode = "whether")
    @TableField(value = "status")
    private String status;
    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;


}
