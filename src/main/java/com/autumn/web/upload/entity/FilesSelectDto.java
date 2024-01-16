package com.autumn.web.upload.entity;

import com.autumn.common.page.Page;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author autumn
 * @date 2023-06-12 09:18:53
 * 测试生成表 SelectDto
 */
@Data
@Accessors
public class FilesSelectDto extends Page implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;
    /**
     * 上传前文件名称
     */
    private String fileNameBefore;
    /**
     * 上传后文件名称
     */
    private String fileNameAfter;
    /**
     * 文件大小
     */
    private String fileSize;
    /**
     * 上传者
     */
    private String uploadBy;


}
