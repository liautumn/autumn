package com.autumn.web.upload.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author autumn
 * @date 2023-06-12 09:18:53
 * 文件上传记录表
 */
@TableName(value = "sys_files")
@Data
@Accessors
public class Files implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 上传前文件名称
     */
    @TableField(value = "file_name_before")
    private String fileNameBefore;
    /**
     * 上传后文件名称
     */
    @TableField(value = "file_name_after")
    private String fileNameAfter;
    /**
     * 文件大小
     */
    @TableField(value = "file_size")
    private String fileSize;
    /**
     * 上传者
     */
    @TableField(value = "upload_by")
    private String uploadBy;
    /**
     * 删除标志（0代表删除 1代表存在）
     */
    @TableField(value = "del_flag")
    private String delFlag;
    /**
     * 创建者
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 更新者
     */
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy;
    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}
