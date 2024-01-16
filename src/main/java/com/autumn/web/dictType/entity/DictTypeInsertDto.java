package com.autumn.web.dictType.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 字典类型表
 */
@Data
public class DictTypeInsertDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 字典名称
     */
    private String dictName;
    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 是否停用（0是 1否）
     */
    private String status;
    /**
     * 备注
     */
    private String remark;
}
