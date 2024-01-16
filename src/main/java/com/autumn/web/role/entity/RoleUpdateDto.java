package com.autumn.web.role.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author lqz
 * @date 2023-07-09 19:34:33
 * 角色信息 UpdateDto
 */
@Data
@Accessors
public class RoleUpdateDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private String id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色权限字符串
     */
    private String roleKey;
    /**
     * 显示顺序
     */
    private Integer roleSort;
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    private String dataScope;
    /**
     * 菜单树选择项是否关联显示（0是 1否）
     */
    private String menuCheckStrictly;
    /**
     * 部门树选择项是否关联显示（0是 1否）
     */
    private String deptCheckStrictly;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否停用（0是 1否）
     */
    private String status;
    /**
     * 关联的菜单权限
     */
    private List menuTreeList;


}
