package com.autumn.web.message.entity;

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
 * @date 2023-07-31 20:57:25
 * 消息记录表
 */
@TableName(value = "sys_message")
@Data
@Accessors
@ColumnWidth(30)
@HeadRowHeight(20)
public class Message extends PublicEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private String userId;
    /**
     * 标题
     */
    @ExcelProperty(value = "标题")
    @TableField(value = "title")
    private String title;
    /**
     * 内容
     */
    @ExcelProperty(value = "内容")
    @TableField(value = "content")
    private String content;
    /**
     * 页面路径
     */
    @ExcelProperty(value = "页面路径")
    @TableField(value = "path")
    private String path;
    /**
     * 类型（1通知 2消息 3代办）
     */
    @ExcelProperty(value = "类型（1通知 2消息 3代办）")
    @TableField(value = "type")
    private String type;
    /**
     * 状态（1未读 2已读）
     */
    @ExcelProperty(value = "状态（1未读 2已读）")
    @TableField(value = "status")
    private String status;


}
