package com.autumn.web.dictType.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.autumn.common.easyExcel.converter.DictConverter;
import com.autumn.common.publicEntity.PublicEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 字典类型表
 *
 * @TableName sys_dict_type
 */
@TableName(value = "sys_dict_type")
@Data
public class DictType extends PublicEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 字典名称
     */
    @ExcelProperty(value = "字典名称")
    @TableField(value = "dict_name")
    private String dictName;
    /**
     * 字典类型
     */
    @ExcelProperty(value = "字典类型")
    @TableField(value = "dict_type")
    private String dictType;
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
