package com.autumn.web.dictData.entity;

import com.autumn.common.page.Page;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author autumn
 * @date 2023-06-13 09:00:38
 * 测试生成表 SelectDto
 */
@Data
@Accessors
public class DictDataSelectDto extends Page implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字典数据表ID
     */
    private String id;
    /**
     * 父节点ID
     */
    private String parentId;
    /**
     * 字典类型表ID
     */
    private String dictTypeId;
    /**
     * 数据标签
     */
    private String dictLabel;
    /**
     * 数据键值
     */
    private String dictValue;
    /**
     * 显示排序
     */
    private Integer dictSort;
    /**
     * 数据类型
     */
    private String dictType;
    /**
     * 样式属性
     */
    private String cssClass;
    /**
     * 回显样式
     */
    private String echoClass;
    /**
     * 是否默认（0是 1否）
     */
    private String isDefault;
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
