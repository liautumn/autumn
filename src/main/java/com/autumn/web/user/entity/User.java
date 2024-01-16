package com.autumn.web.user.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.autumn.common.easyExcel.converter.DictConverter;
import com.autumn.common.publicEntity.PublicEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lqz
 * @date 2023-07-10 15:27:07
 * 用户信息表
 */
@TableName(value = "sys_user")
@Data
@Accessors
@ColumnWidth(30)
@HeadRowHeight(20)
public class User extends PublicEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @ExcelProperty(value = "部门ID")
    @TableField(value = "dept_id")
    private String deptId;
    /**
     * 用户账号
     */
    @ExcelProperty(value = "用户账号")
    @TableField(value = "user_name")
    private String userName;
    /**
     * 用户昵称
     */
    @ExcelProperty(value = "用户昵称")
    @TableField(value = "nick_name")
    private String nickName;
    /**
     * 用户类型（00系统用户）
     */
    @ExcelIgnore
    @TableField(value = "user_type")
    private String userType;
    /**
     * 用户邮箱
     */
    @ExcelProperty(value = "用户邮箱")
    @TableField(value = "email")
    private String email;
    /**
     * 手机号码
     */
    @ExcelProperty(value = "手机号码")
    @TableField(value = "phonenumber")
    private String phonenumber;
    /**
     * 用户性别（0男 1女 2未知）
     */
    @ExcelProperty(value = "用户性别", converter = DictConverter.class, dictCode = "sex")
    @TableField(value = "sex")
    private String sex;
    /**
     * 头像地址
     */
    @ExcelProperty(value = "头像地址")
    @TableField(value = "avatar")
    private String avatar;
    /**
     * 密码
     */
    @ExcelProperty(value = "密码")
    @TableField(value = "password")
    private String password;
    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;
    /**
     * 帐号状态（0正常 1停用）
     */
    @ExcelProperty(value = "是否停用", converter = DictConverter.class, dictCode = "whether")
    @TableField(value = "status")
    private String status;
    /**
     * 最后登录IP
     */
    @ExcelProperty(value = "最后登录IP")
    @TableField(value = "login_ip")
    private String loginIp;
    /**
     * 最后登录时间
     */
    @ExcelProperty(value = "最后登录时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "login_date")
    private LocalDateTime loginDate;


}
