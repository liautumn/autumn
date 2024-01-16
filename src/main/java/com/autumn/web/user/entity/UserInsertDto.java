package com.autumn.web.user.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * @author lqz
 * @date 2023-07-10 15:27:07
 * 用户信息 InsertDto
 */
@Data
@Accessors
public class UserInsertDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    private String deptId;
    /**
     * 所属角色
     */
    private List roleList;
    /**
     * 所属岗位
     */
    private List postList;
    /**
     * 用户账号
     */
    @NotBlank(message = "用户账号不能为空")
    private String userName;
    /**
     * 用户昵称
     */
    @NotBlank(message = "用户昵称不能为空")
    private String nickName;
    /**
     * 用户类型（00系统用户）
     */
    private String userType;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String phonenumber;
    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 备注
     */
    private String remark;
    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;

}
