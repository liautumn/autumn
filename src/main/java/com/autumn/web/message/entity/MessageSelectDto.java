package com.autumn.web.message.entity;


import com.autumn.common.page.Page;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lqz
 * @date 2023-07-31 20:57:25
 * 消息记录表 SelectDto
 */
@Data
@Accessors
public class MessageSelectDto extends Page implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 页面路径
     */
    private String path;
    /**
     * 类型（1通知 2消息 3代办）
     */
    private String type;
    /**
     * 状态（1未读 2已读）
     */
    private String status;
    /**
     * 模板标记
     */
    private Boolean tempFlag = false;


}
