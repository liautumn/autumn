package com.autumn.web.upload.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors
public class FilesVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileId;

    private String name;

    private String url;

}
