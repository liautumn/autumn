package com.autumn.common.tree;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.autumn.common.publicEntity.PublicEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public class TreePublic extends PublicEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父节点ID
     */
    @ExcelProperty(value = "父节点ID")
    @TableField(value = "parent_id")
    private String parentId;
    /**
     * 子数据
     */
    @ExcelIgnore
    @TableField(exist = false)
    private List children;
    /**
     * 子节点数量
     */
    @ExcelIgnore
    @TableField(exist = false)
    private Integer childrenNum;

}
