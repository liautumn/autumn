package com.autumn.web.dictType.entity;

import com.autumn.common.page.Page;
import lombok.Data;

import java.io.Serializable;

/**
 * 字典类型表
 */
@Data
public class DictTypeSelectDto extends Page implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private String id;
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
    /**
     * 模板标记
     */
    private Boolean tempFlag = false;
}
