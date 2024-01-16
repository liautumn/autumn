package com.autumn.web.userPost.entity;

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
 * @date 2023-07-13 17:25:12
 * 用户与岗位关联表
 */
@TableName(value = "sys_user_post")
@Data
@Accessors
@ColumnWidth(30)
@HeadRowHeight(20)
public class UserPost extends PublicEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private String userId;
    /**
     * 岗位ID
     */
    @ExcelProperty(value = "岗位ID")
    @TableField(value = "post_id")
    private String postId;


}
