package com.autumn.web.login.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LoginDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户账号
     */
    @NotBlank(message = "账号不能为空")
    private String userName;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 登录IP
     */
    private String loginIp;
    /**
     * 记住我标记（true记住 false不记住）
     */
    private Boolean isRemember = false;
    /**
     * 验证码参数
     */
    private String captchaVerification;
}
