package com.autumn.web.login.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LoginUserUpdateDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    @NotBlank(message = "用户ID不能为空")
    private String id;
    /**
     * 部门ID
     */
    private String deptId;
    /**
     * 用户账号
     */
    @NotBlank(message = "用户昵称不能为空")
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
     * 帐号状态（0正常 1停用）
     */
    private String status;
    /**
     * 备注
     */
    private String remark;
}
