package com.autumn.web.login.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LoginUserInsertDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户账号
     */
    @NotBlank(message = "用户账号不能为空")
    private String userName;
    /**
     * 用户密码
     */
    @NotBlank(message = "用户密码不能为空")
    private String password;
    /**
     * 用户昵称
     */
    @NotBlank(message = "用户ID不能为空")
    private String nickName;
}
