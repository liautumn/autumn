package com.autumn.web.userRole.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.autumn.common.publicEntity.PublicEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lqz
 * @date 2023-07-10 18:33:05
 * 用户和角色关联表
 */
@TableName(value = "sys_user_role")
@Data
@Accessors
@ColumnWidth(30)
@HeadRowHeight(20)
public class UserRole extends PublicEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private String userId;
    /**
     * 角色ID
     */
    @ExcelProperty(value = "角色ID")
    @TableField(value = "role_id")
    private String roleId;


}
