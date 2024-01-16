package com.autumn.web.post.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lqz
 * @date 2023-06-19 09:56:30
 * 岗位信息 InsertDto
 */
@Data
@Accessors
public class PostInsertDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 岗位编码
     */
    private String postCode;
    /**
     * 岗位名称
     */
    private String postName;
    /**
     * 显示顺序
     */
    private Integer postSort;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否停用（0是 1否）
     */
    private String status;


}
