package com.autumn.web.message.service;

import com.autumn.common.result.Result;
import com.autumn.web.message.entity.Message;
import com.autumn.web.message.entity.MessageInsertDto;
import com.autumn.web.message.entity.MessageSelectDto;
import com.autumn.web.message.entity.MessageUpdateDto;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lqz
 * @date 2023-07-31 20:57:25
 * 消息记录表 Service
 */
public interface MessageService extends IService<Message> {

    /**
     * 消息记录表查询
     */
    Result selectMessage(MessageSelectDto messageSelectDto);

    /**
     * 消息记录表新增
     */
    Result insertMessage(MessageInsertDto messageInsertDto);

    /**
     * 消息记录表修改
     */
    Result updateMessage(MessageUpdateDto messageUpdateDto);

    /**
     * 消息记录表删除
     */
    Result deleteMessage(String ids);

    /**
     * 消息记录表excel导出
     */
    void exportMessage(MessageSelectDto messageSelectDto, HttpServletResponse response);

    /**
     * 消息记录表excel导入
     */
    Result importMessage(MultipartFile file);

    /**
     * 获取未读数量
     *
     * @return
     */
    Result getUnreadNum();

}
