package com.autumn.web.dept.entity;

import com.github.pagehelper.Page;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lqz
 * @date 2023-07-09 16:13:26
 * 部门信息 SelectDto
 */
@Data
@Accessors
public class DeptSelectDto extends Page implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    private String id;
    /**
     * 父部门id
     */
    private String parentId;
    /**
     * 祖级列表
     */
    private String ancestors;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 显示顺序
     */
    private Integer orderNum;
    /**
     * 负责人
     */
    private String leader;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 是否停用（0是 1否）
     */
    private String status;
    /**
     * 模板标记
     */
    private Boolean tempFlag = false;
    /**
     * 是否要根节点
     */
    private Boolean isGetRoot = false;

}
